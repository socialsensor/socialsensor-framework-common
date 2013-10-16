package eu.socialsensor.framework.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.feeds.KeywordsFeed;

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
	
	public DyscoRequest(String id,Date timestamp,String dyscoType){
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
    @SerializedName(value = "searched")
	protected boolean searched = false;
	
	@Expose
    @SerializedName(value = "keywords")
	protected List<String> keywords = new ArrayList<String>();
	
	@Expose
    @SerializedName(value = "feeds")
	protected List<Feed> feeds = new ArrayList<Feed>();
	
	@Expose
    @SerializedName(value = "keywordsFeeds")
	protected List<KeywordsFeed> keywordsFeeds = new ArrayList<KeywordsFeed>();
	
	@Expose
    @SerializedName(value = "user")
	protected String user;
	
	@Expose
    @SerializedName(value = "totalItems")
	protected Integer totalItems;
	
	@Expose
    @SerializedName(value = "dyscoType")
	protected String dyscoType;
	
	
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
	
	public boolean getIsSearched(){
		return searched;
	}
	
	public void setIsSearched(boolean searched){
		this.searched = searched;
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
	
	public void setKeywordsFeeds(List<KeywordsFeed> feeds){
		this.keywordsFeeds = feeds;
	}
	
	public List<KeywordsFeed> getKeywordsFeeds(){
		return keywordsFeeds;
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
	
	public  String getDyscoType() {
		return dyscoType;
	}
	
	public  void setDyscoType(String dyscoType) {
		this.dyscoType = dyscoType;
	}
	
	
	@Override
	public String toJSONString() {
        Gson gson = new GsonBuilder()
        	.excludeFieldsWithoutExposeAnnotation()
        	.create();
        return gson.toJson(this);
	}
	
	
}
