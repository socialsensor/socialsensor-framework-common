package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.dysco.Entity;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a single stream update and acts as an envelop for the native
 * stream update object.
 *
 * @_author etzoannos
 */
public class Item implements JSONable {

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
    
    @Expose
    @SerializedName(value = "id")
    protected String id;
    
    @Expose
    @SerializedName(value = "reference")
    protected String reference;
    
    @Expose
    @SerializedName(value = "streamId")
    protected String streamId;
    
    @Expose
    @SerializedName(value = "title")
    protected String title;
    
    @Expose
    @SerializedName(value = "description")
    protected String description;
    
    @Expose
    @SerializedName(value = "tags")
    protected String[] tags;

    @Expose
    @SerializedName(value = "uid")
    protected String uid;
    
    @Expose
    @SerializedName(value = "list")
    protected String[] lists;
    
    protected StreamUser streamUser;
    
    @Expose
    @SerializedName(value = "mentions")
    protected String[] mentions;
    
    @Expose
    @SerializedName(value = "inReply")
    protected String inReply;
    
    @Expose
    @SerializedName(value = "referencedUser")
    protected String referencedUser;
    
    @Expose
    @SerializedName(value = "referencedUserId")
    protected String referencedUserId;
    
    @Expose
    @SerializedName(value = "links")
    protected URL[] links;
    
    @SerializedName(value = "webPages")
    protected List<WebPage> webPages;
    
    @Expose
    @SerializedName(value = "publicationTime")
    protected long publicationTime;
    
    @SerializedName(value = "operation")
    protected Operation operation;
    
    @Expose
    @SerializedName(value = "votes")
    protected List<Vote> votes = new ArrayList<Vote>();
    
    @Expose
    @SerializedName(value = "location")
    protected Location location;
    
    @Expose
    @SerializedName(value = "text")
    protected String text;
    
    @SerializedName(value = "mediaItems")
    protected List<MediaItem> mediaItems = new ArrayList<MediaItem>();
    
    @Expose
    @SerializedName(value = "mediaIds")
    protected List<String> mediaIds = new ArrayList<String>();
    
    @Expose
    @SerializedName(value = "sentiment")
    protected String sentiment;
    
    @Expose
    @SerializedName(value = "entities")
    protected List<Entity> entities;
    
    @Expose
    @SerializedName(value = "lang")
    protected String lang;
    
    @Expose
    @SerializedName(value = "category")
    protected String category;
    
    protected Feed feed;
    
    protected String feedType;
    
    @Expose
    @SerializedName(value = "original")
    protected boolean original;
    
    // the following fields are added for the UI purposes (after retrieval from Solr)
    // no need to be populated at crawling time
    protected int alethiometerScore;
    @Expose
    @SerializedName(value = "alethiometerUserScore")
    protected int alethiometerUserScore;
    
    @Expose
    @SerializedName(value = "authorFullName")
    protected String authorFullName;
    
    @Expose
    @SerializedName(value = "authorScreenName")
    protected String authorScreenName;
    
    @Expose
    @SerializedName(value = "userRole")
    protected String userRole;
    
    protected int followersCount;
    protected int friendsCount;
    
    @Expose
    @SerializedName(value = "avatarImage")
    protected String avatarImage;
    
    @Expose
    @SerializedName(value = "avatarImageSmall")
    protected String avatarImageSmall;
    
    @Expose
    @SerializedName(value = "alethiometerUserStatus")
    protected String alethiometerUserStatus;
    
    @Expose
    @SerializedName(value = "webLink")
    protected String webLink;
    
    @Expose
    @SerializedName(value = "content")
    protected String content;
    
    @Expose
    @SerializedName(value = "keywords")
    protected List<String> keywords = new ArrayList<String>();
    
    @Expose
    @SerializedName(value = "comments")
    protected String[] comments;
    
    @Expose
    @SerializedName(value = "isSearched")
    protected boolean isSearched;
    
    @Expose
    @SerializedName(value = "positiveVotes")
    protected int positiveVotes = 0;
    
    @Expose
    @SerializedName(value = "negativeVotes")
    protected int negativeVotes = 0;

    // Popularity
    @Expose
    @SerializedName(value = "likes")
    protected Long likes = 0L;
    
    @Expose
    @SerializedName(value = "shares")
    protected Long shares = 0L;
   
    
    protected int validityScore;
    protected String validityVotes;
    //protected List<String> people;
    
    protected static final long HOUR = 1000L * 60L * 60;
    protected static final long DAY = 1000L * 60L * 60L * 24L;
    protected static final long MINUTE = 1000L * 60L;
    
    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public int getValidityScore() {
        return validityScore;
    }

    public void setValidityScore(int validityScore) {
        this.validityScore = validityScore;
    }

    public int getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(int positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public int getNegativeVotes() {
        return negativeVotes;
    }

    public void setNegativeVotes(int negativeVotes) {
        this.negativeVotes = negativeVotes;
    }

    public String getValidityVotes() {
        return validityVotes;
    }

    public void setValidityVotes(String validityVotes) {
        this.validityVotes = validityVotes;
    }

    public String getAlethiometerUserStatus() {
        return alethiometerUserStatus;
    }

    public void setAlethiometerUserStatus(String alethiometerUserStatus) {
        this.alethiometerUserStatus = alethiometerUserStatus;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public String getFeedType() {
        return feedType;
    }

    public void setFeed(String feedType) {
        this.feedType = feedType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }
    

    public String getAuthorScreenName() {
        return authorScreenName;
    }

    public void setAuthorScreenName(String authorScreenName) {
        this.authorScreenName = authorScreenName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getAlethiometerScore() {
        return alethiometerScore;
    }

    public void setAlethiometerScore(int alethiometerScore) {
        this.alethiometerScore = alethiometerScore;
    }

    public int getAlethiometerUserScore() {
        return alethiometerUserScore;
    }

    public void setAlethiometerUserScore(int alethiometerUserScore) {
        this.alethiometerUserScore = alethiometerUserScore;
    }

    public String getAuthorFullName() {
        return authorFullName;
    }

    public void setAuthorFullName(String authorFullName) {
        this.authorFullName = authorFullName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getAvatarImageSmall() {
        return avatarImageSmall;
    }

    public void setAvatarImageSmall(String avatarImageSmall) {
        this.avatarImageSmall = avatarImageSmall;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Item() {
    }

    public Item(String streamId, Operation operation) {
        this.streamId = streamId;
        this.operation = operation;
    }

    public String getId() {
        return id;
    }

    public String getLang() {
        return lang;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String[] getTags() {
        return tags;
    }

    public StreamUser getStreamUser() {
        return streamUser;
    }
    
    public String getUserId() {
        return uid;
    }
    
    public String[] getList() {
        return lists;
    }
    
    public URL[] getLinks() {
        return links;
    }

    public String getStreamId() {
        return streamId;
    }

    public long getPublicationTime() {
        return publicationTime;
    }

    public Operation getOperation() {
        return operation;
    }

    public Double getLatitude() {
        if (location == null) {
            return null;
        }
        return location.getLatitude();
    }

    public Double getLongitude() {
        if (location == null) {
            return null;
        }
        return location.getLongitude();
    }

    public String getLocationName() {
        if (location == null) {
            return null;
        }
        return location.getName();
    }

    public Location getLocation() {
        return location;
    }

    public String getText() {
        return text;
    }

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public List<String> getMediaIds() {
        return mediaIds;
    }
    
    public void setMediaIds(List<String> mediaIds) {
        this.mediaIds = mediaIds;
    }

    public List<WebPage> getWebPages() {
        return webPages;
    }

    public String getRef() {
        return reference;
    }

//    public String getTimeslotId() {
//        return timeslotId;
//    }

    public Long getLikes() {
        return likes;
    }
    
    public Long getShares() {
        return shares;
    }
    
//    public void setTimeslotId(String timeslotId) {
//        this.timeslotId = timeslotId;
//    }

    /**
     * @brief returns item's content
     * @param void
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @brief sets item's content
     * @param content
     * @return void
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @brief returns item's web link
     * @param void
     * @return webLink
     */
    public String getWebLink() {
        return webLink;
    }

    /**
     * @brief sets item's web link
     * @param webLink
     * @return void
     */
    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
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

        String _streamId = getStreamId();
        if (_streamId != null) {
            sb.append("streamId=").append(_streamId).append("\t");
        }

        String _description = getDescription();
        if (_description != null) {
            sb.append("description=").append("\"").append(_description.replaceAll("\\r", " ")
                    .replaceAll("\\t", " ").replaceAll("\\n", " ").trim()).append("\"").append("\t");
        }
        String _title = getTitle();
        if (_title != null) {
            sb.append("title=").append("\"").append(_title.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\"").append("\t");
        }
        String[] _tags = getTags();
        if (_tags != null && _tags.length > 0) {
            sb.append("tags=").append("\"");
            for (int i = 0; i < _tags.length; i++) {
                sb.append(_tags[i].replaceAll("\\r", " ").replaceAll("\\t", " ").replaceAll("\\n", " ")
                        .trim()).append(i < _tags.length - 1 ? "," : "");
            }
            sb.append("\"\t");
        }

        long pubTime = getPublicationTime();
        if (pubTime != -1) {
            sb.append("pubTime=").append(pubTime).append("\t");
        }

        Double _latitude = getLatitude();
        Double _longitude = getLongitude();
        if (_latitude != null && _longitude != null) {
            sb.append("latitude=").append(_latitude).append("\t");
            sb.append("longitude=").append(_longitude).append("\t");
        }

        String _location = getLocationName();
        if (_location != null) {
            sb.append("location=").append(_location).append("\t");
        }
        return sb.toString();
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    //public List<String> getPeople() {
    //    return people;
    //}

    //public void setPeople(List<String> people) {
    //    this.people = people;
    //}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setMentions(String[] mentions) {
        this.mentions = mentions;
    }

    public void setInReply(String inReply) {
        this.inReply = inReply;
    }
    
    public String[] getMentions() {
        return mentions;
    }

    public String getInReply() {
        return inReply;
    }
    
    public void setStreamUser(StreamUser streamUser) {
        this.streamUser = streamUser;
    }

    public void setUserId(String uid) {
        this.uid = uid;
    }
    
    public void setList(String[] lists) {
        this.lists = lists;
    }
    
    public void setLinks(URL[] links) {
        this.links = links;
    }

    public void setPublicationTime(long publicationTime) {
        this.publicationTime = publicationTime;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation(Double latitude, Double longitude) {
        this.location = new Location(latitude, longitude);
    }

    public void setLocation(Double latitude, Double longitude, String name) {
        this.location = new Location(latitude, longitude, name);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMediaItems(List<MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

    public String getSentiment() {
        return sentiment;
    }

    public boolean getIsSearched() {
        return isSearched;
    }
    
    public void setIsSearched(boolean isSearched) {
        this.isSearched = isSearched;
    }
    
    
    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }
    
    public void setShares(Long shares) {
        this.shares = shares;
    }
    
    public void setRef(String reference) {
        this.reference = reference;
    }

    public Long getLifeDuration() {
        Long now = new Date().getTime();
        Long difference = now - getPublicationTime();

        return difference / (60L * 1000L);

    }

    public String getLifeDurationText() {

        Long now = new Date().getTime();
        Long difference = now - getPublicationTime();

        if (difference > DAY) {

            long difInDays = (difference / DAY);
            if (difInDays == 1) {
                return difInDays + " day";
            } else {
                return difInDays + " days";
            }
        } else if (difference > (2L * HOUR)) {
            long difInHours = (difference / HOUR);
            if (difInHours == 1) {
                return difInHours + " hour";
            } else {
                return difInHours + " hours";
            }
        } else {
            long difInMinutes = (difference / MINUTE);
            return difInMinutes + " min";
        }

    }
}