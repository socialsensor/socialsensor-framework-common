package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source implements JSONable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 673802988788312082L;

	@Expose
	@SerializedName(value = "id")
	private String id;
	
	@Expose
	@SerializedName(value = "name")
	private String name;
	 
	@Expose
	@SerializedName(value = "list")
	private String list;
	
	@Expose
	@SerializedName(value = "score")
	private float score;
	 
	@Expose
	@SerializedName(value = "isMentioned")
	private boolean isMentioned = false;
	
	@Expose
	@SerializedName(value = "source")
	private String streamId;
	
	public Source(String name, float score) {
		this.name = name;
		this.score = score;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}
	
	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public void setIsMentioned(boolean isMentioned){
		this.isMentioned = isMentioned;
	}
	
	public boolean getIsMentioned(){
		return this.isMentioned;
	}
	
	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}
	
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
	    	.excludeFieldsWithoutExposeAnnotation()
	    	.create();
		return gson.toJson(this);
	}

	public static void main() {
		
	}
}
