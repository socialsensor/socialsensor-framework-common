package eu.socialsensor.framework.common.domain.dysco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Item;
import eu.socialsensor.framework.common.domain.Query;

/**
 * This class specifies a representation of the DySCO model, as defined by
 * SocialSensor consortium. The main content of a DySCO object is a set of
 * social network items (tweets, facebook status updates etc) It can also
 * contain several dimensions (Semantic, Social, Authority etc). A DySCO object
 * can be associated with other DySCOs based on community or content.
 *
 * @author etzoannos - e.tzoannos@atc.gr
 *
 */
public class Dysco implements Serializable {
	
	//The id of the dysco
    @Expose
    @SerializedName(value = "id")
    private String id;
    //The creation date of the dysco
    @Expose
    @SerializedName(value = "creationDate")
    private Date creationDate;
    //The title of the dysco
    @Expose
    @SerializedName(value = "title")
    private String title;
    //The score that shows how trending the dysco is
    @Expose
    @SerializedName(value = "score")
    private Double score;
    //The type of the dysco (CUSTOM/TRENDING)
    @Expose
    @SerializedName(value = "dyscoType")
    private DyscoType dyscoType;
    
    //Fields holding the information about the main context 
    //of the items that constitute the dysco
    
    //The extracted entities from items' content
    @Expose
    @SerializedName(value = "entities")
    private List<Entity> entities = new ArrayList<Entity>();
    //The users that contribute in social networks to dysco's topic
    @Expose
    @SerializedName(value = "contributors")
    private List<String> contributors = new ArrayList<String>();
    //The extracted keywords from items' content with their assigned weights
    @Expose
    @SerializedName(value = "keywords")
    private Map<String,Double> keywords = new HashMap<String,Double>();
    //The extracted hashtags from items' content with their assigned weights
    @Expose
    @SerializedName(value = "hashtags")
    private Map<String,Double> hashtags = new HashMap<String,Double>();
    
    //The query that will be used for retrieving relevant content to the Dysco from Solr
    @Expose
    @SerializedName(value = "solrQueryString")
    private String solrQueryString = null;
   //The query that will be used for retrieving relevant author content to the Dysco from Solr
    @Expose
    @SerializedName(value = "solrQueryAuthorString")
    private String solrQueryAuthorString = null;
    
    @Expose
    @SerializedName(value = "solrQueries")
    private List<Query> solrQueries = new ArrayList<Query>();
    
    //The variable can get values 0,1,2 and shows dysco's trending evolution. 
    @Expose
    @SerializedName(value = "trending")
    private int trending = 0;
    //The date that the dysco was last created (updated because similar dyscos existed in the past)
    @Expose
    @SerializedName(value = "updateDate")
    private Date updateDate;
    
    //List of the items that compose the Dysco - serve for dysco's formulation, 
    //therefore they are stored temporarily in memory
    private List<Item> items = new ArrayList<Item>();
    
    
    private String listId = "";
    

    public enum DyscoType{
    	CUSTOM, TRENDING
    }
    
    /**
     * Returns the id of the dysco
     * @return String
     */
    public String getId() {
        return id;
    }
    /**
     * Sets the id of the dysco
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Returns the creation date of the dysco
     * @return Date
     */
    public Date getCreationDate() {
        return creationDate;
    }
    
    /**
     * Sets the creation date of the dysco
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    /**
     * Returns the title of the dysco
     * @return String
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the title of the dysco
     * @param Title
     */
    public void setTitle(String Title) {
        this.title = Title;
    }
    
    /**
     * Returns the score of the dysco 
     * @return Double
     */
    public Double getScore() {
        return score;
    }
    
    /**
     * Sets the score of the dysco
     * @param score
     */
    public void setScore(Double score) {
        this.score = score;
    }
    /**
     * Returns the list of the dysco's entities
     * @return List of Entity
     */
    public List<Entity> getEntities() {
        return entities;
    }
    /**
     * Sets the entities of the dysco
     * @param entities
     */
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
    /**
     * Adds an entity to the dysco's list of entities
     * @param entity
     */
    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    /**
     * Returns the list of contributors for the dysco
     * @return List of String
     */
    public List<String> getContributors() {
        return contributors;
    }
    /**
     * Sets the contributors for the dysco
     * @param contributors
     */
    public void setContributors(List<String> contributors) {
        this.contributors = contributors;
    }
    /**
     * Returns the dysco's keywords with their assigned weights
     * @return Map of String to Double
     */
    public Map<String,Double> getKeywords(){
    	return keywords;
    }
    /**
     * Sets the keywords of the dysco with their assigned weights
     * @param keywords
     */
    public void setKeywords(Map<String,Double> keywords){
    	this.keywords = keywords;
    }
    /**
     * Adds a keyword and its corresponding weight to the list of keywords of the dysco
     * @param keyword
     * @param weight
     */
    public void addKeyword(String keyword, Double weight){
    	this.keywords.put(keyword, weight);
    }
    /**
     * Return the dysco's hashtags with their assigned weights
     * @return Map of String to Double
     */
    public Map<String,Double> getHashtags(){
    	return hashtags;
    }
    /**
     * Sets the hashtags of the dysco with their assigned weights
     * @param hashtags
     */
    public void setHashtags(Map<String,Double> hashtags){
    	this.hashtags = hashtags;
    }
    /**
     * Adds a hashtag and its corresponding weight to the list of hashtags of the dysco
     * @param hashtag
     * @param weight
     */
    public void addHashtag(String hashtag, Double weight){
    	this.hashtags.put(hashtag, weight);
    }
    
    /**
     * Returns the query as a string for the retrieval of relevant content to the dysco from solr
     * @return String
     */
    public String getSolrQuery(){
    	return solrQueryString;
    }
    /**
     * Sets the solr query as a string for the retrieval of relevant content
     * @param solrQuery
     */
    public void setSolrQuery(String solrQueryString){
    	this.solrQueryString = solrQueryString;
    	
    }
    
    /**
     * Returns the solr queries for the retrieval of relevant content to the dysco from solr
     * @return String
     */
    public List<Query> getSolrQueries(){
    	return solrQueries;
    }
    /**
     * Sets the solr query for the retrieval of relevant content
     * @param solrQuery
     */
    public void setSolrQueries(List<Query> solrQueries){
    	this.solrQueries = solrQueries;
    	
    }
    
    /**
     * Returns the query as a string for the retrieval of relevant author content to the dysco from solr
     * @return String
     */
    public String getSolrQueryAuthorString(){
    	return solrQueryAuthorString;
    }
    /**
     * Sets the solr query as a string for the retrieval of relevant author content
     * @param solrQuery
     */
    public void setSolrAuthorQuery(String solrQueryAuthorString){
    	this.solrQueryAuthorString = solrQueryAuthorString;
    	
    }
    /**
     * Return the list of items that compose the dysco
     * @return
     */
    public List<Item> getItems() {
        return items;
    }
    /**
     * Sets the items that compose the dysco
     * @param items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }
    /**
     * Adds an item to the list of items that compose the dysco
     * @param item
     */
    public void addItem(Item item){
    	this.items.add(item);
    }
    
    /**
     * Returns the trending value that shows dysco's trending evolution (can be 0,1,2)
     * @return
     */
    public int getTrending() {
        return trending;
    }
    
    /**
     * Sets the trending value that shows dysco's trending evolution (can be 0,1,2)
     * @param trending
     */
    public void setTrending(int trending) {
        this.trending = trending;
    }
    
    /**
     * Returns the date that dysco was last updated.
     * @return
     */
    public Date getUpdateDate() {
        return updateDate;
    }
    
    /**
     * Sets the date that dysco was last updated.
     * @return
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    /**
     * Returns the type of the dysco 
     * @return dyscoType
     */
    public DyscoType getDyscoType(){
    	return dyscoType;
    }
    
    /**
     * Sets the type of the dysco (CUSTOM/TRENDING)
     * @param dyscoType
     */
    public void setDyscoType(DyscoType dyscoType){
    	this.dyscoType = dyscoType;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

   
   
    

    public String toString() {
    	String dyscoString = "Id: "+id+"\n";
    	dyscoString += "Creation date: "+creationDate+"\n";
    	dyscoString += "Score: "+score+"\n";
    	dyscoString += "Items: \n";
    	for (Item item:items) {
    		dyscoString+=item.getId()+":"+item.getTitle()+"\n";
    	}
    	dyscoString += "Entities: \n";
    	for (Entity entity:entities) {
    		dyscoString+=entity.getName()+"@@@"+entity.getType().toString()+":"+entity.getCont()+"\n";
    	}
    	dyscoString += "Tags: \n";
    	Iterator<Entry<String,Double>> iteratorHashtags=hashtags.entrySet().iterator();
    	while (iteratorHashtags.hasNext()) {
    		Entry<String,Double> hashtag=iteratorHashtags.next();
    		dyscoString+=hashtag.getKey()+":"+hashtag.getValue()+"\n";
    	}
    	dyscoString += "Keywords: \n";
    	Iterator<Entry<String,Double>> iteratorKeywords=keywords.entrySet().iterator();
    	while (iteratorKeywords.hasNext()) {
    		Entry<String,Double> keyword=iteratorKeywords.next();
    		dyscoString+=keyword.getKey()+":"+keyword.getValue()+"\n";
    	}
    	dyscoString += "SolrQuery : "+solrQueryString+"\n";
    	dyscoString += "Trending : "+trending+"\n";
    	dyscoString += "DyscoType : "+dyscoType.toString()+"\n";
    	return dyscoString;
    }
}
