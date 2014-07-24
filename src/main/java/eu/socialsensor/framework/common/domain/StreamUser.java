package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.alethiometer.Score;

import java.io.Serializable;

public class StreamUser implements JSONable, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3558927430206936262L;

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
    
    // SocialSensor user id with the following structure:
    // StreamName#userid
    @Expose
    @SerializedName(value = "id")
    protected String id;
    
    // The internal id of a user in a specific social media
    @Expose
    @SerializedName(value = "userid")
    protected String userid;
    
    // The username of the user in a specific social media
    @Expose
    @SerializedName(value = "username")
    protected String username;
    
    // A human readable version of the name of a user
    @Expose
    @SerializedName(value = "name")
    protected String name;
    
    // The name of the stream that a User comes from
    @Expose
    @SerializedName(value = "streamId")
    protected String streamId;
    
    // The number of Items posted from the user
    @Expose
    @SerializedName(value = "items")
    protected Integer items = 0;
    
    // The profile image of a user
    @Expose
    @SerializedName(value = "profileImage")
    protected String profileImage;
    
    // The url of the image of a User. Usually this image is a bigger version of profileImage
    @Expose
    @SerializedName(value = "imageUrl")
    protected String imageUrl;
    
    // The URL of the user page in the specific social media
    @Expose
    @SerializedName(value = "pageUrl")
    protected String pageUrl;
    
    // A URL of the personal web page of the user
    @Expose
    @SerializedName(value = "url")
    protected String url;
    
    // A short description of the user
    @Expose
    @SerializedName(value = "description")
    protected String description;
    
    // The date that this account has been created
    @Expose
    @SerializedName(value = "createdAt")
    protected String createdAt;
    
    // The last time that this user has been updated
    @Expose
    @SerializedName(value = "lastUpdated")
    protected Long lastUpdated;
    
    
    @Expose
    @SerializedName(value = "fullScore")
    protected Score fullScore;
    
    // The location associated with a user
    @Expose
    @SerializedName(value = "location")
    protected String location;
    
    // The category of an User
    // Nullable
    @Expose
    @SerializedName(value = "category")
    protected Category category;
    
    // The number of the times a user has been mentioned from other users
    @Expose
    @SerializedName(value = "mentions")
    protected long mentions = 0;
    
    // The number of friends of a User
    @Expose
    @SerializedName(value = "friends")
    protected Long friends = 0l;
    
    // The number of followers of a User
    @Expose
    @SerializedName(value = "followers")
    protected Long followers = 0l;
    
    // The number of the times a user is listed
    @Expose
    @SerializedName(value = "listedCount")
    protected Long listedCount = 0l;
    
    // The number of times the Items of this user have been shared
    @Expose
    @SerializedName(value = "shares")
    protected Long shares = 0L;
    
    // An indicator whether the user is verified by the social media service
    @Expose
    @SerializedName(value = "verified")
    protected Boolean verified = false;
    
    // Timezone of the specific user
    @Expose
    @SerializedName(value = "timezone")
    protected String timezone;
    
    @Expose
    @SerializedName(value = "linkToProfile")
    protected String linkToProfile;
    
    @Expose
    @SerializedName(value = "favoritiesCount")
    protected long favoritiesCount = 0L;
    
    // Getters & Setters for the fields of this class
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStreamId() {
        return streamId;
    }
    
    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }
    
    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }
    
    public void incItems(Integer items) {
        this.items += items;
    }
    
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    
    public Long getLastUpdated() {
        return lastUpdated;
    }
    
    public void setLastUpdated(Long lastUpdated){
    	this.lastUpdated = lastUpdated;
    }
    
    public Score getFullScore() {
        return fullScore;
    }

    public void setFullScore(Score fullScore) {
        this.fullScore = fullScore;
    }
    
    public String getLocation() {
        if (location.equals("") || location==null) {
            return "Unknown";
        }
        return location;
    }
    
    public Category getCategory() {
    	return category;
    }
    
    public void setCategory(Category category) {
    	this.category = category;
    }
    
    public Long getMentions() {
        return mentions;
    }

    public void setMentions(Long mentions) {
        this.mentions = mentions;
    }
    
    public void incMentions(Long mentions) {
        this.mentions += mentions;
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
    
    public long getListedCount() {
    	return listedCount;
    }
    
    public void setListedCount(long listedCount) {
    	this.listedCount = listedCount;
    }
    
    public Long getShares() {
        return shares;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }
    
    public void incShares(Long shares) {
        this.shares += shares;
    }
    
    public Long getFavoritiesCount() {
        return favoritiesCount;
    }

    public void setFavoritiesCount(Long shares) {
        this.shares = shares;
    }
    
    public void setVerified(long favoritiesCount) {
    	this.favoritiesCount = favoritiesCount;
    }
    
    public Boolean isVerified() {
    	return verified;
    }
    
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    
    public void setLinkToProfile(String linkToProfile){
    	this.linkToProfile = linkToProfile;
    }
    
    public String getLinkToProfile(){
    	return linkToProfile;
    }
    
    public boolean isVerifiedOfficial() {
    	return verified;
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
