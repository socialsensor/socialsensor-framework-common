package eu.socialsensor.framework.common.domain.dysco;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializer;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.JSONable;

/**
*
* @author cmartin - email: c.j.martin-dancausa@rgu.ac.uk
*/
public class SlotInformation implements JSONable {

	@SerializedName(value = "timeslotId")
	private String timeslotId;
    @SerializedName(value = "totalTweets")
    private int totalTweets;
    @SerializedName(value = "representativeNgrams")
    private List<Ngram> representativeNgrams;
    @SerializedName(value = "ngramTweets")
    private Map<String, List<String>> ngramTweets;

    public SlotInformation() {
    	timeslotId = null;
        totalTweets = 0;
        representativeNgrams = new ArrayList<Ngram>();
        ngramTweets = new HashMap<String, List<String>>();
    }

    /**
	 * @return the timeslotId
	 */
	public String getTimeslotId() {
		return timeslotId;
	}

	/**
	 * @param timeslotId the timeslotId to set
	 */
	public void setTimeslotId(String timeslotId) {
		this.timeslotId = timeslotId;
	}

	/**
     * @return the totalTweets
     */
    public int getTotalTweets() {
        return totalTweets;
    }

    /**
     * @param totalTweets the totalTweets to set
     */
    public void setTotalTweets(int totalTweets) {
        this.totalTweets = totalTweets;
    }

    /**
     * @return the ngrams
     */
    public List<Ngram> getRepresentativeNgrams() {
        return representativeNgrams;
    }

    /**
     * @param ngrams the ngrams to set
     */
    public void setRepresentativeNgrams(List<Ngram> ngrams) {
        this.representativeNgrams = ngrams;
    }

    /**
     * @return the ngramTweets
     */
    public Map<String, List<String>> getNgramTweets() {
        return ngramTweets;
    }

    /**
     * @param ngramTweets the ngramTweets to set
     */
    public void setNgramTweets(Map<String, List<String>> ngramTweets) {
        this.ngramTweets = ngramTweets;
    }

    public void AddNgramTweet(String ngram) {
        if (ngramTweets.containsKey(ngram)) {
            return;
        }

        ngramTweets.put(ngram, new ArrayList<String>());
    }

    public void AddNgramTweet(String ngram, String tweet) {
        if (!ngramTweets.containsKey(ngram)) {
            AddNgramTweet(ngram);
        }

        ngramTweets.get(ngram).add(tweet);
    }

    public List<String> GetTweets(String ngram) {
        return ngramTweets.get(ngram);
    }

    public void AddRepresentativeNgram(Ngram ngram) {
        representativeNgrams.add(ngram);
    }

    @Override
    public String toJSONString() {
    	
		Gson gson = new GsonBuilder()
		.registerTypeAdapter(Map.class, new CustomAdapter())
			.enableComplexMapKeySerialization()
			.create();
        return gson.toJson(this);
    }
  
	public static void main(String...args) {
		SlotInformation slot = new SlotInformation();
		
		slot.AddRepresentativeNgram(new Ngram("http://t1.s", 0.2f));
		slot.AddRepresentativeNgram(new Ngram("t2", 0.2f));
		slot.AddRepresentativeNgram(new Ngram("t3", 0.2f));
		
		slot.AddNgramTweet("http://t1.s t1", "id1");
		slot.AddNgramTweet("http://t1.s", "id2");
		slot.AddNgramTweet("t2", "id3");
		slot.AddNgramTweet("t3", "id4");
		slot.AddNgramTweet("t3", "id5");
		slot.AddNgramTweet("t3", "id6");
		
		System.out.println(slot.toJSONString());
	}
	
	public static class CustomAdapter implements JsonSerializer<Map<String, List<String>>>,
		JsonDeserializer<Map<String, List<String>>> {

		@Override
		public JsonElement serialize(Map<String, List<String>> map,
				Type typeOfSrc, JsonSerializationContext context) {
			
			JsonArray array = new JsonArray();
			for(Entry<String, List<String>> entry : map.entrySet()) {
				JsonObject obj = new JsonObject();
				obj.addProperty("ngram", entry.getKey());
				JsonArray jsArray = new JsonArray();
				
				for(String id : entry.getValue()) {
					jsArray.add(new JsonPrimitive(id));
				}
				obj.add("ids", jsArray);
				
				array.add(obj);
			}
			return array;
		}

		@Override
		public Map<String, List<String>> deserialize(JsonElement json, Type type,
				JsonDeserializationContext context) throws JsonParseException {

			Map<String, List<String>> map = new HashMap<String, List<String>>();
			JsonArray array = json.getAsJsonArray();
			for(JsonElement element : array) {
				JsonObject obj = element.getAsJsonObject();
				
				String key = obj.get("ngram").getAsString();
				JsonArray jsArray = obj.get("ids").getAsJsonArray();
				
				List<String> ids = new ArrayList<String>();
				for(JsonElement id : jsArray)
					ids.add(id.getAsString());
				
				map.put(key, ids);
			}
			return map;
		}
	}
}
