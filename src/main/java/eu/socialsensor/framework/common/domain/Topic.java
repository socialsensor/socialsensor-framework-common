package eu.socialsensor.framework.common.domain;

import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * \class Topic
 * Represents a topic that is extracted from clustering feeds
 * @author ailiakop
 * @email : ailiakop@iti.gr
 */


public class Topic implements JSONable{
	
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
	
	private List<Item> items = new ArrayList<Item>();
	
	protected Operation operation;
	protected Integer topicID;
	@Expose
	@SerializedName(value = "id")
	protected String id;
	@Expose
	@SerializedName(value = "featuredTitle")
	protected String featuredTitle = null;
	@Expose
	@SerializedName(value = "numberOfFeeds")
	private int numberOfFeeds;
	@Expose
	@SerializedName(value = "keywords")
	protected List<String> keywords = new ArrayList<String>();
	@Expose
	@SerializedName(value = "entities")
	protected List<String> entities = new ArrayList<String>();
	@Expose
	@SerializedName(value = "urls")
	private List<String> urls = new ArrayList<String>();
	
	/**
 	 * @brief Constructor
 	 * @param id
 	 * 
 	 */
	public Topic(String id){
		this.id = id;
		this.operation = Operation.NEW_UPDATE;
		
	}
	 /**
 	 * @brief sets item's id in program
 	 * @param itemID
 	 * @return void
 	 */
     public void setTopicID(Integer topicID) {
         this.topicID = topicID;
     }
	/**
 	 * @brief sets topic's contained number of feeds
 	 */
	public void setNumberOfFeeds(){
		numberOfFeeds = items.size();
	}
	/**
 	 * @brief returns topic's contained number of feeds
 	 * @param void
 	 * @return Integer
 	 */
	public int getNumberOfFeeds(){
		return numberOfFeeds;
	}
	/**
 	 * @brief returns topic's id
 	 * @param void
 	 * @return String
 	 */
	public String getId(){
		return id;
	}
	/**
 	 * @brief sets topic's id
 	 * @param String
 	 * @return void
 	 */
	public void setId(String id){
		this.id = id;
	}
	/**
 	 * @brief set topic's featured title
 	 * @param String
 	 * @return void
 	 */
	public void setFeaturedTitle(String featuredTitle){
		this.featuredTitle = featuredTitle;
	}
	/**
 	 * @brief get topic's featured title
 	 * @param void
 	 * @return String
 	 */
	public String getFeaturedTitle(){
		return featuredTitle;
	}
	
	/**
 	 * @brief get topic's featured entities
 	 * @param void
 	 * @return List of Strings
 	 */
	public List<String> getEntities(){
		
		return entities;
	}
	
	/**
 	 * @brief sets topic's featured entities
 	 * @param List of Strings
 	 * @return void
 	 */
	public void setEntities(List<String> entities){
		
		this.entities = entities;
	}
	
	/**
 	 * @brief get topic's extracted keywords
 	 * @param void
 	 * @return List of Strings
 	 */
	public List<String> getKeywords(){
		return keywords;
	}
	  
	/**
 	 * @brief sets topic's extracted keywords
 	 * @param List of Strings
 	 * @return void
 	 */
	public void setKeywords(List<String> keywords){
		this.keywords = keywords;
	}
	  
	/**
	 * @brief get topic's contained urls
	 * @param void
	 * @return List of Strings
	 */
	public List<String> getUrls(){
		return urls;
	}
	
	/**
	 * @brief set topic's contained urls
	 * @param List of Strings
	 * @return void
	 */
	public void setUrls(List<String> urls){
		this.urls = urls;
	}
	
	 /**
   	 * @brief returns topic's operation
   	 * @param void
   	 * @return operation
   	 */
     public Operation getOperation() {
         return operation;
     }
     
	 @Override
	 public String toJSONString() {
         Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
         return gson.toJson(this);
	 }
}
