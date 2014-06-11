package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import eu.socialsensor.framework.common.domain.StreamUser.Category;
import eu.socialsensor.framework.common.domain.dysco.Entity;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a single stream update and acts as an envelop for the native
 * stream update object.
 *
 * @_author etzoannos
 */
public class Item implements JSONable {

    /**
     *
     */
    private static final long serialVersionUID = -7934442049449016087L;

    public enum Operation {

        NEW("New"),
        UPDATE("Update"),
        DELETED("Deleted");
        private final String label;

        private Operation(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public Item() {
    }

    public Item(String streamId, Operation operation) {
        this.streamId = streamId;
        this.operation = operation;
    }
    // Unique id of an instance with the following structure: StreamName#internalId
    @Expose
    @SerializedName(value = "id")
    protected String id;
    // The id of the original Item
    @Expose
    @SerializedName(value = "reference")
    protected String reference;
    // The name of the stream that an Item comes from
    @Expose
    @SerializedName(value = "streamId")
    protected String streamId;
    // The title of an Item
    @Expose
    @SerializedName(value = "title")
    protected String title;
    // A short description of an Item
    @Expose
    @SerializedName(value = "description")
    protected String description;
    // A set of tags associated with an Item
    @Expose
    @SerializedName(value = "tags")
    protected String[] tags;
    // The SocialSensor internal id of the user 
    // StreamName#userInternalId
    @Expose
    @SerializedName(value = "uid")
    protected String uid;
    // A set of identifiers that indicate the news hounds list
    @Expose
    @SerializedName(value = "list")
    protected String[] lists;
    // A detailed instance of the user of an Item
    // This is not exposed in mongodb
    protected StreamUser streamUser;
    // A set of user ids for the mentioned users
    @Expose
    @SerializedName(value = "mentions")
    protected String[] mentions;
    // If an Item is a reply to another Item this field
    // keeps the id of the user of the first Item
    @Expose
    @SerializedName(value = "inReply")
    protected String inReply;
    // The user id of the original Item
    @Expose
    @SerializedName(value = "referencedUserId")
    protected String referencedUserId;
    // A list of URLs contained in the Item
    @Expose
    @SerializedName(value = "links")
    protected URL[] links;
    // The id of the original Item
    @Expose
    @SerializedName(value = "pageUrl")
    protected String url;
    // A set of WebPages contained in the Item
    // WebPage is a more detailed representation of URLs
    @SerializedName(value = "webPages")
    protected List<WebPage> webPages;
    // The publication time of an Item
    @Expose
    @SerializedName(value = "publicationTime")
    protected long publicationTime;
    // The last time this Item has been updated
    //@Expose
    //@SerializedName(value = "lastUpdated")
    //protected Date lastUpdated;
    // The last time this Item has been updated
    @Expose
    @SerializedName(value = "insertionTime")
    protected long insertionTime;
    // The operation associated with Item : NEW, UPDATE, DELETE
    @SerializedName(value = "operation")
    protected Operation operation;
    // The location associated with an Item
    // Usually this field indicated the origin of the Item
    @Expose
    @SerializedName(value = "location")
    protected Location location;
    // The text associated with an Item
    @Expose
    @SerializedName(value = "text")
    protected String text;
    // A list of media items contained in an Item
    // This is not exposed in mongodb 
    @SerializedName(value = "mediaItems")
    protected List<MediaItem> mediaItems = new ArrayList<MediaItem>();
    // A list of ids of the contained media items 
    @Expose
    @SerializedName(value = "mediaIds")
    protected List<String> mediaIds = new ArrayList<String>();
    // The sentiment of an Item
    @Expose
    @SerializedName(value = "sentiment")
    protected String sentiment;
    // A list of representative keywords extracted from an Item
    @Expose
    @SerializedName(value = "keywords")
    protected List<String> keywords = new ArrayList<String>();
    // A list of named entities extracted from an Item
    @Expose
    @SerializedName(value = "entities")
    protected List<Entity> entities;
    // The language of an Item
    @Expose
    @SerializedName(value = "lang")
    protected String lang;
    // The category of the user that posted the Item
    @Expose
    @SerializedName(value = "category")
    protected Category category;
    // An indicator whether an Item id original or a shared instance of a previous Item
    @Expose
    @SerializedName(value = "original")
    protected boolean original = true;
    // Popularity values 
    // Number of likes
    @Expose
    @SerializedName(value = "likes")
    protected Long likes = 0L;
    // NUmber of the times an Item has been shared
    @Expose
    @SerializedName(value = "shares")
    protected Long shares = 0L;
    // The Comments associated with an Item
    @Expose
    @SerializedName(value = "comments")
    protected String[] comments;
    @Expose
    @SerializedName(value = "numOfComments")
    protected Long numOfComments = 0L;
    @Expose
    @SerializedName(value = "isSearched")
    protected boolean isSearched;
    @Expose
    @SerializedName(value = "indexed")
    protected boolean indexed;
    // the following fields are added for the UI purposes (after retrieval from Solr)
    // no need to be populated at crawling time
    protected int alethiometerScore;
    @Expose
    @SerializedName(value = "alethiometerUserScore")
    protected int alethiometerUserScore;
    @Expose
    @SerializedName(value = "authorFullName")
    protected String authorFullName;
    @Expose
    @SerializedName(value = "authorScreenName")
    protected String authorScreenName;
    @Expose
    @SerializedName(value = "userRole")
    protected String userRole;
    protected int followersCount;
    protected int friendsCount;
    @Expose
    @SerializedName(value = "avatarImage")
    protected String avatarImage;
    @Expose
    @SerializedName(value = "avatarImageSmall")
    protected String avatarImageSmall;
    @Expose
    @SerializedName(value = "alethiometerUserStatus")
    protected String alethiometerUserStatus;
    @Expose
    @SerializedName(value = "positiveVotes")
    protected int positiveVotes = 0;
    @Expose
    @SerializedName(value = "negativeVotes")
    protected int negativeVotes = 0;
    @Expose
    @SerializedName(value = "votes")
    protected List<Vote> votes = new ArrayList<Vote>();
    protected int validityScore;
    protected String validityVotes;
    protected static final long HOUR = 1000L * 60L * 60;
    protected static final long DAY = 1000L * 60L * 60L * 24L;
    protected static final long MINUTE = 1000L * 60L;

    // Getters  & Setters for the fields of this class
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getUserId() {
        return uid;
    }

    public void setUserId(String uid) {
        this.uid = uid;
    }

    public String[] getList() {
        return lists;
    }

    public void setList(String[] lists) {
        this.lists = lists;
    }

    public StreamUser getStreamUser() {
        return streamUser;
    }

    public void setStreamUser(StreamUser streamUser) {
        this.streamUser = streamUser;
    }

    public String[] getMentions() {
        return mentions;
    }

    public void setMentions(String[] mentions) {
        this.mentions = mentions;
    }

    public String getInReply() {
        return inReply;
    }

    public void setInReply(String inReply) {
        this.inReply = inReply;
    }

    public String getReferencedUserId() {
        return referencedUserId;
    }

    public void setReferencedUserId(String referencedUserId) {
        this.referencedUserId = referencedUserId;
    }

    public URL[] getLinks() {
        return links;
    }

    public void setLinks(URL[] links) {
        this.links = links;
    }

    public List<WebPage> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<WebPage> webPages) {
        this.webPages = webPages;
    }

    public long getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(long publicationTime) {
        this.publicationTime = publicationTime;
    }

    //public Date getLastUpdated() {
    //    return lastUpdated;
    //}

    //public void setLastUpdated(Date lastUpdated) {
    //    this.lastUpdated = lastUpdated;
    //}

    public long getInsertionTime() {
        return insertionTime;
    }

    public void setInsertionTime(long insertionTime) {
        this.insertionTime = insertionTime;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public void setMediaItems(List<MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

    public List<String> getMediaIds() {
        return mediaIds;
    }

    public void setMediaIds(List<String> mediaIds) {
        this.mediaIds = mediaIds;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getShares() {
        return shares;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(long numOfComments) {
        this.numOfComments = numOfComments;
    }

    public Long getNumOfComments() {
        return numOfComments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
    
    public boolean getIsSearched() {
        return isSearched;
    }

    public void setIsSearched(boolean isSearched) {
        this.isSearched = isSearched;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public int getValidityScore() {
        return validityScore;
    }

    public void setValidityScore(int validityScore) {
        this.validityScore = validityScore;
    }

    public int getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(int positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public int getNegativeVotes() {
        return negativeVotes;
    }

    public void setNegativeVotes(int negativeVotes) {
        this.negativeVotes = negativeVotes;
    }

    public String getValidityVotes() {
        return validityVotes;
    }

    public void setValidityVotes(String validityVotes) {
        this.validityVotes = validityVotes;
    }

    public String getAlethiometerUserStatus() {
        return alethiometerUserStatus;
    }

    public void setAlethiometerUserStatus(String alethiometerUserStatus) {
        this.alethiometerUserStatus = alethiometerUserStatus;
    }

    public String getAuthorScreenName() {
        return authorScreenName;
    }

    public void setAuthorScreenName(String authorScreenName) {
        this.authorScreenName = authorScreenName;
    }

    public int getAlethiometerScore() {
        return alethiometerScore;
    }

    public void setAlethiometerScore(int alethiometerScore) {
        this.alethiometerScore = alethiometerScore;
    }

    public int getAlethiometerUserScore() {
        return alethiometerUserScore;
    }

    public void setAlethiometerUserScore(int alethiometerUserScore) {
        this.alethiometerUserScore = alethiometerUserScore;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getAvatarImageSmall() {
        return avatarImageSmall;
    }

    public void setAvatarImageSmall(String avatarImageSmall) {
        this.avatarImageSmall = avatarImageSmall;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Double getLatitude() {
        if (location == null) {
            return null;
        }
        return location.getLatitude();
    }

    public Double getLongitude() {
        if (location == null) {
            return null;
        }
        return location.getLongitude();
    }

    public String getLocationName() {
        if (location == null) {
            return null;
        }
        return location.getName();
    }

    public String getCountryName() {
        if (location == null) {
            return null;
        }
        return location.getCountryName();
    }
    
    // Creates the JSON representation of an Item
    @Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                //.registerTypeAdapter(Date.class, new DateSerializer())
                //.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
        return gson.toJson(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String _streamId = getStreamId();
        if (_streamId != null) {
            sb.append("streamId=").append(_streamId).append("\t");
        }

        String _description = getDescription();
        if (_description != null) {
            sb.append("description=").append("\"").append(_description.replaceAll("\\r", " ")
                    .replaceAll("\\t", " ").replaceAll("\\n", " ").trim()).append("\"").append("\t");
        }
        String _title = getTitle();
        if (_title != null) {
            sb.append("title=").append("\"").append(_title.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\"").append("\t");
        }
        String[] _tags = getTags();
        if (_tags != null && _tags.length > 0) {
            sb.append("tags=").append("\"");
            for (int i = 0; i < _tags.length; i++) {
                sb.append(_tags[i].replaceAll("\\r", " ").replaceAll("\\t", " ").replaceAll("\\n", " ")
                        .trim()).append(i < _tags.length - 1 ? "," : "");
            }
            sb.append("\"\t");
        }

        long pubTime = getPublicationTime();
        if (pubTime != -1) {
            sb.append("pubTime=").append(pubTime).append("\t");
        }

        Double _latitude = getLatitude();
        Double _longitude = getLongitude();
        if (_latitude != null && _longitude != null) {
            sb.append("latitude=").append(_latitude).append("\t");
            sb.append("longitude=").append(_longitude).append("\t");
        }

        String _location = getLocationName();
        if (_location != null) {
            sb.append("location=").append(_location).append("\t");
        }
        return sb.toString();
    }

    public Long getLifeDuration() {
        Long now = new Date().getTime();
        Long difference = now - getPublicationTime();

        return difference / (60L * 1000L);
    }

    public String getLifeDurationText() {

        Long now = new Date().getTime();
        Long difference = now - getPublicationTime();

        if (difference > DAY) {

            long difInDays = (difference / DAY);
            if (difInDays == 1) {
                return difInDays + " day";
            } else {
                return difInDays + " days";
            }
        } else if (difference > (2L * HOUR)) {
            long difInHours = (difference / HOUR);
            return difInHours + "h";
        } else {
            long difInMinutes = (difference / MINUTE);
            return difInMinutes + "m";
        }

    }

    /*
    public static class DateSerializer extends TypeAdapter<Date> {

        private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        @Override
        public void write(JsonWriter out, Date date) throws IOException {
            out.beginObject();
            String d = df.format(date);

            out.name("$date");
            out.value(d);

            out.endObject();
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            return null;
        }
    }
    */
}