package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.alethiometer.Score;

import java.io.Serializable;

public class StreamUser implements JSONable, Serializable {

    public enum Operation {
        NEW("New"),
        UPDATE("Update"),
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

    public enum Category {
    	politician("politician"),
    	official("official"),
    	journalist("journalist"),
    	footballer("footballer");
    	
    	private final String label;
    	
    	private Category(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    
    public StreamUser(String streamId, Operation operation) {
        this.streamId = streamId;
        this.operation = operation;
    }
    
    @Expose
    @SerializedName(value = "operation")
    protected Operation operation;
    
    // SocialSensor internal id
    @Expose
    @SerializedName(value = "id")
    protected String id;
    
    @Expose
    @SerializedName(value = "userid")
    protected String userid;
    @Expose
    @SerializedName(value = "username")
    protected String username;
    
    @Expose
    @SerializedName(value = "name")
    protected String name;
    
    @Expose
    @SerializedName(value = "streamId")
    protected String streamId;
    
    @Expose
    @SerializedName(value = "items")
    protected Integer items;
    
    @Expose
    @SerializedName(value = "imageUrl")
    protected String imageUrl;
    
    @Expose
    @SerializedName(value = "profileImage")
    protected String profileImage;
    
    @Expose
    @SerializedName(value = "pageUrl")
    protected String pageUrl;
    
    @Expose
    @SerializedName(value = "url")
    protected String url;
    
    @Expose
    @SerializedName(value = "description")
    protected String description;
    
    @Expose
    @SerializedName(value = "createdAt")
    protected String createdAt;
    
    @Expose
    @SerializedName(value = "lastUpdated")
    protected Long lastUpdated;
    
    @Expose
    @SerializedName(value = "fullScore")
    protected Score fullScore;
    
    @Expose
    @SerializedName(value = "location")
    protected String location;
    
    @Expose
    @SerializedName(value = "category")
    protected Category category;
    
    @Expose
    @SerializedName(value = "mentions")
    protected long mentions = 0;
    
    @Expose
    @SerializedName(value = "friends")
    protected Long friends;
    
    @Expose
    @SerializedName(value = "followers")
    protected Long followers;
    
    @Expose
    @SerializedName(value = "listedCount")
    protected Long listedCount;
    
    
    @Expose
    @SerializedName(value = "shares")
    protected Long shares;
    
    @Expose
    @SerializedName(value = "verified")
    protected Boolean verified = false;
    
    @Expose
    @SerializedName(value = "linkToProfile")
    protected String linkToProfile;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFriends() {
        return friends;
    }

    public void setFriends(Long friends) {
        this.friends = friends;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }
    
    public Long getShares() {
        return shares;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }
    
    public Score getFullScore() {
        return fullScore;
    }

    public void setFullScore(Score fullScore) {
        this.fullScore = fullScore;
    }
   
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    public Long getLastUpdated() {
        return lastUpdated;
    }
    
    public void setLastUpdated(Long lastUpdated){
    	this.lastUpdated = lastUpdated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
     public void setUsername(String username) {
         this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getStreamId() {
        return streamId;
    }

    public String getLocation() {
        
        if (location.equals("") || location==null) {
            return "Unknown";
        }
        return location;
    }
    
    public void setCategory(Category category) {
    	this.category = category;
    }
    
    public Category getCategory() {
    	return category;
    }
    
    public void setVerified(Boolean verified) {
    	this.verified = verified;
    }
    
    public Boolean isVerified() {
    	return verified;
    }
    
    public void setLinkToProfile(String linkToProfile){
    	this.linkToProfile = linkToProfile;
    }
    
    public String getLinkToProfile(){
    	return linkToProfile;
    }
    
    @Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String _id = getId();
        if (_id != null) {
            sb.append("id=").append(_id.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\t");
        }
        String _userid = getUserid();
        if (_userid != null) {
            sb.append("userid=").append(_userid.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\t");
        }
        String _streamId = getStreamId();
        if (_streamId != null) {
            sb.append("streamId=").append(_streamId).append("\t");
        }
        String _username = getUsername();
        if (_username != null) {
            sb.append("username=").append(_username.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\t");
        }

        String _name = getName();
        if (_name != null) {
            sb.append("name=").append(_name.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\t");
        }

        return sb.toString();
    }
}
