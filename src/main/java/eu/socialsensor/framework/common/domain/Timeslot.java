package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timeslot implements JSONable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1365145603400903535L;

	@Expose
	@SerializedName(value = "timeslotId")
	protected String timeslotId;
	 
	@Expose
	@SerializedName(value = "timestamp")
	protected long timestamp;
	
	public Timeslot(String timeslotId) {
		this.timeslotId = timeslotId;
		this.timestamp = System.currentTimeMillis();
	}
	
	public Timeslot(String timeslotId, long timestamp) {
		this.timeslotId = timeslotId;
		this.timestamp = timestamp;
	}
	
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
				.create();
        return gson.toJson(this);
	}

    public String getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(String timeslotId) {
        this.timeslotId = timeslotId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
        
        
}
