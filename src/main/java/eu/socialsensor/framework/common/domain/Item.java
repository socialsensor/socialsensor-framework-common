package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.dysco.Entity;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Represents a single stream update and acts as an envelop for the native
 * stream update object.
 *
 * @_author etzoannos
 */
public class Item implements JSONable {

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
    protected String id;
    @Expose
    @SerializedName(value = "reference")
    protected String reference;
    @Expose
    @SerializedName(value = "streamId")
    protected String streamId;
    @Expose
    @SerializedName(value = "source")
    protected String source;
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
    @SerializedName(value = "categories")
    protected String[] categories;
    @Expose
    @SerializedName(value = "author")
    protected String author;
    //@Expose
    //@SerializedName(value = "screenname")
    //protected String screenname;
    @Expose
    @SerializedName(value = "uid")
    protected String uid;
    @Expose
    @SerializedName(value = "streamUser")
    protected StreamUser streamUser;
    @Expose
    @SerializedName(value = "mentions")
    protected String[] mentions;
    @Expose
    @SerializedName(value = "replies")
    protected String[] replies;
    @Expose
    @SerializedName(value = "popularity")
    protected Map<String, Integer> popularity;
    @Expose
    @SerializedName(value = "links")
    protected URL[] links;
    @SerializedName(value = "webPages")
    protected List<WebPage> webPages;
    @Expose
    @SerializedName(value = "mediaLinks")
    protected List<MediaItemLight> mediaLinks;
    @Expose
    @SerializedName(value = "publicationTime")
    protected long publicationTime;
    @Expose
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
    protected Map<URL, MediaItem> mediaItems = new HashMap<URL, MediaItem>();
    @Expose
    @SerializedName(value = "mediaIds")
    protected List<String> mediaIds = new ArrayList<String>();
    @Expose
    @SerializedName(value = "dyscoId")
    protected String dyscoId;
    @Expose
    @SerializedName(value = "timeslotId")
    protected String timeslotId;
    @Expose
    @SerializedName(value = "sentiment")
    protected String sentiment;
    @Expose
    @SerializedName(value = "entities")
    private List<Entity> entities = new ArrayList<Entity>();
    // added: 27.3.2013
    @Expose
    @SerializedName(value = "retweets")
    private Integer retweetsCount;
    @Expose
    @SerializedName(value = "lang")
    private String lang;
    @Expose
    @SerializedName(value = "category")
    private String category;
    protected Feed feed;
    protected String feedType;
    @Expose
    @SerializedName(value = "original")
    private boolean original;
    
    @Expose
    @SerializedName(value = "isSearched")
    protected boolean isSearched = false;
    
    private Date publicationDate;
    // the following fields are added for the UI purposes (after retrieval from Solr)
    // no need to be populated at crawling time
    private int alethiometerScore;
    @Expose
    @SerializedName(value = "alethiometerUserScore")
    private int alethiometerUserScore;
    @Expose
    @SerializedName(value = "authorFullName")
    private String authorFullName;
    @Expose
    @SerializedName(value = "authorScreenName")
    private String authorScreenName;
    @Expose
    @SerializedName(value = "userRole")
    private String userRole;
    private int followersCount;
    private int friendsCount;
    @Expose
    @SerializedName(value = "avatarImage")
    private String avatarImage;
    @Expose
    @SerializedName(value = "avatarImageSmall")
    private String avatarImageSmall;
    @Expose
    @SerializedName(value = "alethiometerUserStatus")
    private String alethiometerUserStatus;
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
    @SerializedName(value = "positiveVotes")
    protected int positiveVotes = 0;
    @Expose
    @SerializedName(value = "negativeVotes")
    protected int negativeVotes = 0;

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
    private int validityScore;
    private String validityVotes;
    private List<String> people;
    private static final long HOUR = 1000L * 60L * 60;
    private static final long DAY = 1000L * 60L * 60L * 24L;
    private static final long MINUTE = 1000L * 60L;

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

    public Date getPublicationDate() {
        publicationDate = new Date(getPublicationTime());
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isOriginal() {
        return original;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }
    
    public boolean getIsSearched(){
    	return isSearched;
    }
    public void setIsSearched(boolean isSearched){
    	this.isSearched = isSearched;
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

    public Integer getRetweetsCount() {
        return retweetsCount;
    }

    public void setRetweetsCount(Integer retweetsCount) {
        this.retweetsCount = retweetsCount;
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

    public String getDyscoId() {
        return dyscoId;
    }

    public void setDyscoId(String dyscoId) {
        this.dyscoId = dyscoId;
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

    public String getSource() {
        return source;
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

    public String getAuthor() {
        return author;
    }

    public Map<String, Integer> getPopularity() {
        return popularity;
    }

    public URL[] getLinks() {
        return links;
    }

    public String getStreamId() {
        return streamId;
    }

    public String[] getCategories() {
        return categories;
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

    public Map<URL, MediaItem> getMediaItems() {
        return mediaItems;
    }

    public List<String> getMediaIds() {
        return mediaIds;
    }

    public List<MediaItemLight> getMediaLinks() {
        return mediaLinks;
    }

    public List<WebPage> getWebPages() {
        return webPages;
    }

    public void setMediaLinks(List<MediaItemLight> mediaLinks) {
        this.mediaLinks = mediaLinks;
    }

    public String getRef() {
        return reference;
    }

    public String getTimeslotId() {
        return timeslotId;
    }

    public void setTimeslotId(String timeslotId) {
        this.timeslotId = timeslotId;
    }

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
        String _source = getSource();
        if (_source != null) {
            sb.append("source=").append(_source.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\t");
        }
        String _streamId = getStreamId();
        if (_streamId != null) {
            sb.append("streamId=").append(_streamId).append("\t");
        }
        String _author = getAuthor();
        if (_author != null) {
            sb.append("author=").append(_author.replaceAll("\\r", " ").replaceAll("\\t", " ")
                    .replaceAll("\\n", " ").trim()).append("\t");
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
        String[] _categories = getCategories();
        if (_categories != null && _categories.length > 0) {
            sb.append("categories=").append("\"");
            for (int i = 0; i < _categories.length; i++) {
                sb.append(_categories[i].replaceAll("\\r", " ").replaceAll("\\t", " ")
                        .replaceAll("\\n", " ").trim()).append(i < _categories.length - 1 ? "," : "");
            }
            sb.append("\"\t");
        }
        long pubTime = getPublicationTime();
        if (pubTime != -1) {
            sb.append("pubTime=").append(pubTime).append("\t");
        }

        Map<String, Integer> _popularity = getPopularity();
        if (_popularity != null) {
            for (Entry<String, Integer> pop : _popularity.entrySet()) {
                sb.append(pop.getKey()).append("=").append(pop.getValue()).append("\t");
            }
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

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setMentions(String[] mentions) {
        this.mentions = mentions;
    }

    public void setReplies(String[] replies) {
        this.replies = replies;
    }
    
    public String[] getMentions() {
        return mentions;
    }

    public String[] getReplies() {
        return replies;
    }
    
    public void setStreamUser(StreamUser streamUser) {
        this.streamUser = streamUser;
    }

    public void setPopularity(Map<String, Integer> popularity) {
        this.popularity = popularity;
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

    public void setMediaItems(Map<URL, MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
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