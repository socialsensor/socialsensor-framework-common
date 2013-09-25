
package eu.socialsensor.framework.common.repositories;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class StatusRepresentation implements Comparable<StatusRepresentation> {

  /** types of errors that can be found when processing a status */
  public enum Errors {
    /** the line could not be parsed from a JSON string to JsonObject */
    JsonParse
  }

  /** a string describing where the tweet came from */
  private String _source;

  /** the id (only) of the tweet */
  private Long _id;

  /** the Twitter4J status representation of the tweet, if any */
  private /*Status*/ Object _status;

  /** a string representing the Twitter status in JSON format, if any */
  private String _jsonString;

  /** a JSON object representing the tweet, if any */
  private JsonObject _jsonObj;

  /**
   * Creates a StatusRepresentation object completely empty and ready to be
   * initialized with one of the {@link #init()} methods.
   */
  public StatusRepresentation() {
  }

  /**
   * Creates a StatusRepresentation object copied from the value passed in.
   * 
   * @param s
   *          an object to copy.
   */
  public StatusRepresentation(StatusRepresentation s) {
    init(s);
  }

  /**
   * Initializes the object to contain the given status
   * 
   * @param s
   *          an object to copy.
   */
  public StatusRepresentation init(StatusRepresentation s) {
    _source = s._source;
    _status = s._status;
    _jsonString = s._jsonString;
    _jsonObj = s._jsonObj;
    _id = s._id;
    return this;
  }

  /**
   * Initializes the object to contain the given status
   * 
   * @param source
   *          a string describing where the tweet came from
   * @param status
   *          the Twitter4J status representation of the tweet
   * @return this object
   */
//  public StatusRepresentation init(String source, Status status) {
//    return init(source, status, DataObjectFactory.getRawJSON(status), null);
//  }

  /**
   * Initializes the object to contain the given status.
   * 
   * @param source
   *          a string describing where the tweet came from
   * @param jsonString
   *          a string representing the Twitter status in JSON format
   * @return this object
   */
  public StatusRepresentation init(String source, String jsonString) {
    if (jsonString == null || jsonString.contains("{"))
      return init(source, null, jsonString, null);
    // if the input doesn't look like a JSON string, it might be a simple
    // status ID
    init(source, null, null, null);
    _id = Long.valueOf(jsonString.trim());
    return this;
  }

  /**
   * Initializes the object to contain the given status, from multiple
   * representations of the object.
   * 
   * @param source
   *          a string describing where the tweet came from
   * @param status
   *          the Twitter4J status representation of the tweet
   * @param jsonString
   *          a string representing the Twitter status in JSON format
   * @param jsonObj
   *          a JSON object representing the tweet
   * @return this object
   */
  public StatusRepresentation init(String source, /*Status*/ Object status,
      String jsonString, JsonObject jsonObj) {
    _source = source;
    _status = status;
    _jsonString = jsonString;
    _jsonObj = jsonObj;
    _id = null;
    return this;
  }

  /**
   * @return a string describing where the tweet came from
   */
  public String getSource() {
    return _source;
  }

  /**
   * @return a string representing the Twitter status in JSON format
   */
  public String getJsonString() {
    // if this representation is known, then return it immediately
    if (_jsonString != null)
      return _jsonString;
    // otherwise, try and convert it from the status and/or JsonObject
//    if (_status != null)
//      _jsonString = DataObjectFactory.getRawJSON(_status);
    if (_jsonString == null && _jsonObj != null)
      _jsonString = _jsonObj.toString();
    if (_jsonString == null && _id != null)
      _jsonString = "{\"id\": +" + _id + "}";
    // return the string or null if it can't be created
    return _jsonString;
  }

  /**
   * @return a JSON object representing the tweet
   */
  public JsonObject getJsonObject() {
    // if this representation is known, then return it immediately
    if (_jsonObj != null)
      return _jsonObj;
    // otherwise, try and convert it from the Json string representation
    String json = getJsonString();
    if (json != null)
      _jsonObj = new JsonParser().parse(json).getAsJsonObject();
    // return the object or null if it can't be created
    return _jsonObj;
  }

  /**
   * @return the status ID for the tweet
   */
  public Long getStatusId() {
    if (_id != null)
      return _id;
    // if the status representation is known, use it immediately
//    if (_status != null)
//      _id = _status.getId();
    // otherwise, try and get it from the JsonObject representation
    else {
      JsonObject json = getJsonObject();
      if (json != null)
        _id = json.get("id").getAsLong();
    }
    return _id;
  }

  /**
   * @return true if the line represents a track limitation instead of a status
   */
  public boolean isTrackLimitation() {
    // the line matches something like {"limit":{"track":2}}
    return getJsonObject().get("limit") != null;
  }

  /**
   * Determines whether the Twitter status is related to one of the users in the
   * set of given ids.
   * 
   * @param infs
   *          a set of influential contributors 
   * @param sender
   *          if the person who created the status is in the ids set, return
   *          true
   * @param userMentions
   *          if the status contains a user mention that is contained in the ids
   *          set, return true
   * @param retweetOrigin
   *          if the status is a retweet that was originated by a user in the
   *          ids set, return true
   * @returns true if one of the ids in the input parameter matches an id found
   *          in the tweet
   */
  public boolean isRelatedTo(InfluentialContributorSet infs, boolean sender,
      boolean userMentions, boolean retweetOrigin) {
    if (sender) {
      // check for the presence of the id in the path:
      // { "user": { "id": USER_ID
      JsonElement js = getJsonObject().get("user");
      if (js != null) {
        js = js.getAsJsonObject().get("id");
        if (js != null) {
//          long userId = js.getAsLong();
          String userId = js.getAsString();
          if (infs.contains(userId))
            return true;
        }
      }
    }

    // check for the presence of the id in the path:
    // { "retweeted_status": { "user": { "id" : USER_ID
    if (retweetOrigin) {
      JsonElement js = getJsonObject().get("retweeted_status");
      if (js != null) {
        js = js.getAsJsonObject().get("user");
        if (js != null) {
          js = js.getAsJsonObject().get("id");
          if (js != null) {
//            long userId = js.getAsLong();
            String userId = js.getAsString();
            if (infs.contains(userId))
              return true;
          }
        }
      }
    }

    // check for the presence of the id in the path:
    // { "entities": { "user_mentions": [ { "id": USER_ID
    if (userMentions) {
      JsonElement js = getJsonObject().get("entities");
      if (js != null) {
        js = js.getAsJsonObject().get("user_mentions");
        if (js != null) {
          JsonArray jsa = js.getAsJsonArray();
          for (int j = 0; j < jsa.size(); j++) {
            js = jsa.get(j).getAsJsonObject().get("id");
            if (js != null) {
//              long userId = js.getAsLong();
              String userId = js.getAsString();
              if (infs.contains(userId))
                return true;
            }
          }
        }
      }
    }
    
    // otherwise the tweet isn't relevant
    return false;
  }

  /*
   * Sorts statuses according to status ID by default.
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(StatusRepresentation o) {
    Long mine = getStatusId();
    Long other = o.getStatusId();
    return mine != null ? (other != null ? mine.compareTo(other) : 1)
        : (mine == other ? 0 : -1);
  }

  /**
   * @param in
   *          a string containing long values separated by whitespace or commas
   * @return a set containing all of the long values
   * @throws NumberFormatException
   *           if any of the tokens in the input are not valid numbers
   */
  public static Set<Long> parseLongs(String in) throws NumberFormatException {
    StringTokenizer tk = new StringTokenizer(in, ", \t\n\r\f");
    Set<Long> out = new HashSet<Long>();
    while (tk.hasMoreTokens())
      out.add(Long.valueOf(tk.nextToken()));
    return out;
  }
}

