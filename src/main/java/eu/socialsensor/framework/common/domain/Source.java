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
	@SerializedName(value = "network")
	private String network;
	
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
	
	public String getNetwork() {
		return network;
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
