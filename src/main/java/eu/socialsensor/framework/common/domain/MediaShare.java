package eu.socialsensor.framework.common.domain;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MediaShare implements JSONable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7926531925761955502L;


	public MediaShare(String id, String reference, long publicationTime, String userid) {
		this.id = id;
		this.reference = reference;
		this.publicationTime = publicationTime;
		this.userid = userid;
	}
	
	// Unique id of a Media
	@Expose
	@SerializedName(value = "id")
	private String id;
		
	@Expose
	@SerializedName(value = "reference")
	private String reference;
	
	@Expose
	@SerializedName(value = "publicationTime")
	private long publicationTime = 0;
	
	@Expose
	@SerializedName(value = "userid")
	private String userid;
	
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
    
    public long getPublicationTime() {
        return publicationTime;
    }
    
    public void setPublicationTime(long publicationTime) {
        this.publicationTime = publicationTime;
    }
    
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
			.create();
    	return gson.toJson(this);
	}
	
}
