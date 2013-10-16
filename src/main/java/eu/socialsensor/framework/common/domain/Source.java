package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source implements JSONable {
	
	public  enum Type {
		All, Facebook, Twitter, Flickr, Web, Youtube, WebFeeds, GooglePlus, Tumblr, Instagram, Google   
	}
	
	@Expose
	@SerializedName(value = "id")
	private String id;
	
	@Expose
	@SerializedName(value = "name")
	private String name;
	 
	@Expose
	@SerializedName(value = "score")
	private float score;
	 
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
	
	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
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
