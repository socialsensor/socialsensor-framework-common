package eu.socialsensor.framework.common.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemFeed implements JSONable{
	
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
	 
	 public ItemFeed(String id,Feed feed){
		 this.id = id;
		 this.feed = feed;
		 feeds.add(feed);
		 this.feedType = feed.getFeedtype().toString();
	 }
	 
	 @Expose
     @SerializedName(value = "id")
     protected String id;
	 @Expose
     @SerializedName(value = "feeds")
	 protected List<Feed> feeds = new ArrayList<Feed>();
	 
	 protected Feed feed;
     
	 protected String feedType;
     
     public Feed getFeed(){
     	return feed;
     }
     public void setFeed(Feed feed){
     	this.feed=feed;
     }
     
     public String getFeedType(){
     	return feedType;
     }
     public void setFeed(String feedType){
     	this.feedType=feedType;
     }
     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }
	 
     
     @Override
     public String toJSONString() {
         Gson gson = new GsonBuilder()
                 .excludeFieldsWithoutExposeAnnotation()
                 .create();
         return gson.toJson(this);
     }

}
