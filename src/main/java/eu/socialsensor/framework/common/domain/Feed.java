package eu.socialsensor.framework.common.domain;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.JSONable;

public class Feed implements JSONable {
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
	
	@Expose
    @SerializedName(value = "id")
	protected
	String id = null;
	@SerializedName(value = "dyscoId")
	protected String dyscoId;
	
	@Expose
    @SerializedName(value = "lastItemDate")
	Date lastItemDate = null;
	
	@Expose
    @SerializedName(value = "totalNumberOfItems")
	Long totalNumberOfItems = 0L;
	
	@Expose
    @SerializedName(value = "feedType")
	FeedType feedType;
	
	// TODO
	// Add Feed Profile Variables
	
	public Feed(Date lastItemDate, FeedType feedType) {
		this.lastItemDate = lastItemDate;
		this.feedType = feedType;
		
	}
	
	public  FeedType getFeedtype() {
		return feedType;
	}
	
	public  void setFeedType(FeedType feedType) {
		this.feedType = feedType;
	}
	
	public  String getId() {
		return id;
	}
	
	public  void setId(String id) {
		this.id = id;
	}
	
	public void setDyscoId(String dyscoId){
		this.dyscoId = dyscoId;
	}
	public String getDyscoId(){
		return dyscoId;
	}
	
	public  Date getLastItemDate() {
		return lastItemDate;
	}
	
	public  void setLastItemDate(Date lastItemDate) {
		this.lastItemDate = lastItemDate;
	}
	
	public  void setLastItemDate(long lastItemDate) {
		this.lastItemDate = new Date(lastItemDate);
	}

	public  Long getTotalNumberOfItems() {
		return this.totalNumberOfItems;
	}
	
	public  void setTotalNumberOfItems(Long totalNumberOfItems) {
		this.totalNumberOfItems = totalNumberOfItems;
	}
	
	@Override
	public String toJSONString() {
        Gson gson = new GsonBuilder()
        	.excludeFieldsWithoutExposeAnnotation()
        	.create();
        return gson.toJson(this);
	}
	
	public enum FeedType {
		LOCATION, KEYWORDS, SOURCE
	}
}
