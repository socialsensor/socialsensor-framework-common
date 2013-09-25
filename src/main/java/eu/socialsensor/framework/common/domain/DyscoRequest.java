package eu.socialsensor.framework.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed.FeedType;

/**
 * Class for dysco request
 * @author ailiakop
 * @email : ailiakop@iti.gr
 */

public class DyscoRequest implements JSONable{
	public enum Operation {
        NEW_UPDATE("New"),
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
	
	public DyscoRequest(){
		
	}
	
	public DyscoRequest(String id,Date timestamp){
		this.id = id;
		this.timestamp = timestamp;
	
	}
	
	public DyscoRequest(String id,Date timestamp,DyscoType dyscoType){
		this.id = id;
		this.timestamp = timestamp;
		this.dyscoType = dyscoType;
		
		
	}
	
	@Expose
    @SerializedName(value = "id")
	protected String id = null;
	
	@Expose
    @SerializedName(value = "timestamp")
	protected Date timestamp = null;
	
	@Expose
    @SerializedName(value = "status")
	protected boolean status = false;
	
	@Expose
    @SerializedName(value = "keywords")
	protected List<String> keywords = new ArrayList<String>();
	
	@Expose
    @SerializedName(value = "feeds")
	protected List<Feed> feeds = new ArrayList<Feed>();
	
	@Expose
    @SerializedName(value = "user")
	protected String user;
	
	@Expose
    @SerializedName(value = "totalItems")
	protected Integer totalItems;
	
	@Expose
    @SerializedName(value = "dyscoType")
	protected DyscoType dyscoType;
	
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public Date getTimestamp(){
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp){
		this.timestamp = timestamp;
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public void setStatus(boolean status){
		this.status = status;
	}
	
	public void setKeywords(List<String> keywords){
		this.keywords = keywords;
	}
	
	public List<String> getKeywords(){
		return keywords;
	}
	
	public void setFeeds(List<Feed> feeds){
		this.feeds = feeds;
	}
	
	public List<Feed> getFeeds(){
		return feeds;
	}

	public void setUser(String user){
		this.user = user;
	}
	
	public String getUser(){
		return user;
	}
	
	public void setTotalItems(Integer totalItems){
		this.totalItems = totalItems;
	}
	
	public Integer getTotalItems(){
		return totalItems;
	}
	
	public  DyscoType getDyscoType() {
		return dyscoType;
	}
	
	public  void setDyscoType(DyscoType dyscoType) {
		this.dyscoType = dyscoType;
	}
	
	
	@Override
	public String toJSONString() {
        Gson gson = new GsonBuilder()
        	.excludeFieldsWithoutExposeAnnotation()
        	.create();
        return gson.toJson(this);
	}
	
	public enum DyscoType {
		TRENDING, DYNAMIC
	}
	
}
