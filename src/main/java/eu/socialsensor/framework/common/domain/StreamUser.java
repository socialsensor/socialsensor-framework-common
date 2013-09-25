package eu.socialsensor.framework.common.domain;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import eu.socialsensor.framework.common.domain.alethiometer.Score;

import java.io.Serializable;

public class StreamUser implements JSONable, Serializable {

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
    @SerializedName(value = "description")
    protected String description;
    @Expose
    @SerializedName(value = "profileImage")
    protected String profileImage;
    @Expose
    @SerializedName(value = "createdAt")
    protected String createdAt;
    @Expose
    @SerializedName(value = "popularity")
    protected Map<String, Long> popularity;
    @Expose
    @SerializedName(value = "fullScore")
    protected Score fullScore;
    @Expose
    @SerializedName(value = "location")
    protected String location;
    @Expose
    @SerializedName(value = "category")
    protected Category category;
    
    
    Long friends;
    Long followers;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

        
    public Long getFriends() {
        
        friends = 0L;
        Map<String, Long> _popularity = getPopularity();
        if (_popularity != null) {
            if (_popularity.containsKey("friends")) {
                friends = _popularity.get("friends");
            }
        }
        return friends;
    }

    public void setFriends(Long friends) {
        this.friends = friends;
    }

    public Long getFollowers() {
        followers = 0L;
        Map<String, Long> _popularity = getPopularity();
        if (_popularity != null) {
            if (_popularity.containsKey("followers")) {
                followers = _popularity.get("followers");
            }
        }
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    @Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Map<String, Long> getPopularity() {
        return popularity;
    }

    public void setPopularity(Map<String, Long> popularity) {
        this.popularity = popularity;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userid;
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String _id = getId();
        if (_id != null) {
            sb.append("id=").append(_id.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\t");
        }
        String _userid = getUserId();
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
