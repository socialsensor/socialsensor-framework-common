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
	
	@Expose
    @SerializedName(value = "dateToRetrieve")
	Date dateToRetrieve = null;
	
	@Expose
    @SerializedName(value = "totalNumberOfItems")
	Integer totalNumberOfItems = 0;
	
	@Expose
    @SerializedName(value = "feedType")
	FeedType feedType;
	
	// TODO
	// Add Feed Profile Variables
	
	public Feed(Date date, FeedType feedType) {
		this.dateToRetrieve = date;
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
	
	public Date getDateToRetrieve() {
		return dateToRetrieve;
	}
	
	public void setDateToRetrieve(Date dateToRetrieve) {
		this.dateToRetrieve = dateToRetrieve;
	}
	
	public  Integer getTotalNumberOfItems() {
		return this.totalNumberOfItems;
	}
	
	public  void setTotalNumberOfItems(Integer totalNumberOfItems) {
		this.totalNumberOfItems += totalNumberOfItems;
	}
	
	@Override
	public String toJSONString() {
        Gson gson = new GsonBuilder()
        	.excludeFieldsWithoutExposeAnnotation()
        	.create();
        return gson.toJson(this);
	}
	
	public enum FeedType {
		LOCATION, KEYWORDS, SOURCE, URL, LIST
	}
}
