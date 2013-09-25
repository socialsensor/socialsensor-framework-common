package eu.socialsensor.framework.common.domain.dysco;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Item;
import eu.socialsensor.framework.common.domain.dimension.EnvironmentDimension;
import eu.socialsensor.framework.common.domain.dimension.PresentationDimension;
import eu.socialsensor.framework.common.domain.dimension.SentimentDimension;
import eu.socialsensor.framework.common.domain.dimension.SocialDimension;
import eu.socialsensor.framework.common.domain.dimension.SpatialDimension;
import eu.socialsensor.framework.common.domain.dimension.TopicDimension;
import eu.socialsensor.framework.common.repositories.PostCollection;
import java.util.HashMap;
import java.util.Map;

//TODO: make it as class instead of interface
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

    @Expose
    @SerializedName(value = "id")
    private String id;
    private List<Item> items = new ArrayList<Item>();
    private List<Item> uniqueItems = new ArrayList<Item>();
    private PostCollection content;
    @Expose
    @SerializedName(value = "creationDate")
    private Date creationDate;
    private String timeslotId;
    @Expose
    @SerializedName(value = "expiryDate")
    private Date expiryDate;
    @Expose
    @SerializedName(value = "thumb")
    private URL thumb;
    @Expose
    @SerializedName(value = "title")
    private String title;
    @Expose
    @SerializedName(value = "updateDate")
    private Date updateDate;
    private List<Ngram> ngrams = new ArrayList<Ngram>();
    private List<Entity> entities = new ArrayList<Entity>();
    private Float score;
    private PresentationDimension presentationDimension;
    private SentimentDimension sentimentDimension;
    private SocialDimension socialDimension;
    private SpatialDimension spatialDimension;
    private TopicDimension topicDimension;
    private EnvironmentDimension environmentDimension;
    private List<String> tags = new ArrayList<String>();
    //added 29.3.2013 for visualization purposes
    @Expose
    @SerializedName(value = "thumbs")
    private List<String> thumbs = new ArrayList<String>();
    @Expose
    @SerializedName(value = "thumbsLess")
    private List<String> thumbsLess = new ArrayList<String>();
    @Expose
    @SerializedName(value = "hasThumbs")
    private boolean hasThumbs;
    private List<String> keywords = new ArrayList<String>();
    private String evolution = "latest";
    @Expose
    @SerializedName(value = "itemsCount")
    private int itemsCount = 0;
    private String dyscoGroup = "";
    @Expose
    @SerializedName(value = "trending")
    private int trending = 0;
    @Expose
    @SerializedName(value = "trendingArrow")
    private String trendingArrow;
    @Expose
    @SerializedName(value = "dynamic")
    private boolean dynamic = false;
    private int alethiometerStatus = 0;
    private List<String> people = new ArrayList<String>();
    //to be used for merging Dyscos with similar hashtags and urls
    private Map<String, Integer> hashtags = new HashMap<String, Integer>();
    private Map<URL, Integer> links = new HashMap<URL, Integer>();

    public String getTrendingArrow() {

        switch (getTrending()) {
            case 0:
                return "icon-minus";
            case 1:
                return "icon-arrow-up";
            case 2:
                return "icon-arrow-down";
            default:
                return "icon-minus";
        }
    }

    public Map<String, Integer> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Map<String, Integer> hashtags) {
        this.hashtags = hashtags;
    }

    public Map<URL, Integer> getLinks() {
        return links;
    }

    public void setLinks(Map<URL, Integer> links) {
        this.links = links;
    }
    
    
    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public int getAlethiometerStatus() {
        return alethiometerStatus;
    }

    public void setAlethiometerStatus(int alethiometerStatus) {
        this.alethiometerStatus = alethiometerStatus;
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    public boolean isHasThumbs() {
        hasThumbs = false;
        if (getThumbsLess().size() > 0) {
            hasThumbs = true;
        }
        return hasThumbs;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public String getDyscoGroup() {
        return dyscoGroup;
    }

    public void setDyscoGroup(String dyscoGroup) {
        this.dyscoGroup = dyscoGroup;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public void setHasThumbs(boolean hasThumbs) {
        this.hasThumbs = hasThumbs;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getThumbsLess() {

//        if ((thumbsLess.isEmpty()) && (!getThumbs().isEmpty())) {
//
//            List<String> tempThumbs = getThumbs();
//            for (int i = 0; i < tempThumbs.size(); i++) {
//                if (i <= 3) {
//                    thumbsLess.add(tempThumbs.get(i));
//                }
//            }
//
//        }
        return thumbsLess;
    }

    public void setThumbsLess(List<String> thumbsLess) {
        this.thumbsLess = thumbsLess;
    }

    public List<String> getThumbs() {
        return thumbs;
    }

    public void setThumbs(List<String> thumbs) {
        this.thumbs = thumbs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setUniqueItems(List<Item> uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    public List<Item> getUniqueItems() {
        return uniqueItems;
    }

    public PostCollection getContent() {
        return content;
    }

    public void setContent(PostCollection content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(String timeslotId) {
        this.timeslotId = timeslotId;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public URL getThumb() {
        return thumb;
    }

    public void setThumb(URL thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public List<Ngram> getNgrams() {
        return ngrams;
    }

    public void setNgrams(List<Ngram> ngrams) {
        this.ngrams = ngrams;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public PresentationDimension getPresentationDimension() {
        return presentationDimension;
    }

    public void setPresentationDimension(PresentationDimension presentationDimension) {
        this.presentationDimension = presentationDimension;
    }

    public SentimentDimension getSentimentDimension() {
        return sentimentDimension;
    }

    public void setSentimentDimension(SentimentDimension sentimentDimension) {
        this.sentimentDimension = sentimentDimension;
    }

    public SocialDimension getSocialDimension() {
        return socialDimension;
    }

    public void setSocialDimension(SocialDimension socialDimension) {
        this.socialDimension = socialDimension;
    }

    public SpatialDimension getSpatialDimension() {
        return spatialDimension;
    }

    public void setSpatialDimension(SpatialDimension spatialDimension) {
        this.spatialDimension = spatialDimension;
    }

    public TopicDimension getTopicDimension() {
        return topicDimension;
    }

    public void setTopicDimension(TopicDimension topicDimension) {
        this.topicDimension = topicDimension;
    }

    public EnvironmentDimension getEnvironmentDimension() {
        return environmentDimension;
    }

    public void setEnvironmentDimension(EnvironmentDimension environmentDimension) {
        this.environmentDimension = environmentDimension;
    }

    public void addNgram(Ngram ngram) {
        ngrams.add(ngram);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public int getTrending() {
        return trending;
    }

    public void setTrending(int trending) {
        this.trending = trending;
    }
}
