package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class URL implements JSONable{
	
	public URL(String name,Float score){
		this.name = name;
		this.score = score;
	}
	
	@Expose
	@SerializedName(value = "id")
	private String id;
	
	@Expose
	@SerializedName(value = "name")
	private String name;
	
	@Expose
    @SerializedName(value = "network")
	private String network = null;
	
	@Expose
	@SerializedName(value = "score")
	private float score;
	
	
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
	
	
	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	 
	public String getNetwork() {
		return this.network;
	}
	
	public void setNetwork(String network) {
		this.network = network;
	}
	
	
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
	    	.excludeFieldsWithoutExposeAnnotation()
	    	.create();
		return gson.toJson(this);
	}
}
