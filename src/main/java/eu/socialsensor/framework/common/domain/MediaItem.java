package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed.FeedType;
import eu.socialsensor.framework.common.domain.feeds.KeywordsFeed;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single stream media item and acts as an envelop for the native
 * stream media object.
 *
 * @author manosetro
 * @mail manosetro@iti.gr
 *
 */
public class MediaItem implements JSONable, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7811714823188242818L;
    // Unique id of an MediaItem with the following structure: StreamName#internalId
    @Expose
    @SerializedName(value = "id")
    private String id;
    // The URL of a media item
    @Expose
    @SerializedName(value = "url")
    private String url;
    // Thumbnail version of a media item
    @Expose
    @SerializedName(value = "thumbnail")
    private String thumbnail;
    // The URL of the page that contains the media item
    @Expose
    @SerializedName(value = "pageUrl")
    private String pageUrl;
    // The name of the stream that a Media Item comes from
    @Expose
    @SerializedName(value = "streamId")
    private String streamId;
    // The id of the first Item that contains the MediaItem
    @Expose
    @SerializedName(value = "reference")
    private String reference;
//    @Expose
//    @SerializedName(value = "refUrl")
//    private String refUrl;
    // The id of the user that posted the first Item that contains the MediaItem
    @Expose
    @SerializedName(value = "uid")
    private String uid;
    // A detailed instance of the user of an Item
    // This field is not exposed in mongodb
    private StreamUser streamUser;
    // Textual information
    @Expose
    @SerializedName(value = "title")
    private String title;
    @Expose
    @SerializedName(value = "description")
    private String description;
    @Expose
    @SerializedName(value = "tags")
    private String[] tags;
    // The type of a media item. Can only be image/video
    @Expose
    @SerializedName(value = "type")
    private String type;
    // The publication time of the first item that share the media item
    @Expose
    @SerializedName(value = "publicationTime")
    private long publicationTime;
    @Expose
    @SerializedName(value = "mentions")
    private String[] mentions;
    // Popularity values
    @Expose
    @SerializedName(value = "likes")
    protected Long likes = 0L;
    @Expose
    @SerializedName(value = "shares")
    protected Long shares = 0L;
    @Expose
    @SerializedName(value = "comments")
    protected Long comments = 0L;
    @Expose
    @SerializedName(value = "views")
    protected Long views = 0L;
    @Expose
    @SerializedName(value = "ratings")
    protected Float ratings = 0F;
    // The sentiment value of a MediaItem
    @Expose
    @SerializedName(value = "sentiment")
    protected int sentiment;
    // A list of concepts related to the MediaItem
    @Expose
    @SerializedName(value = "concepts")
    private List<Concept> concepts = null;
    // Geo information 
    @Expose
    @SerializedName(value = "location")
    private Location location;
    // Size of the Media item
    @Expose
    @SerializedName(value = "width")
    private Integer width;
    @Expose
    @SerializedName(value = "height")
    private Integer height;
    // Indicated whether a MediaItem has been inserted into the visual index
    @Expose
    @SerializedName(value = "vIndexed")
    private Boolean vIndexed = Boolean.FALSE;
    // Indicated whether a MediaItem has been inserted into Solr
    @Expose
    @SerializedName(value = "indexed")
    private Boolean indexed = Boolean.FALSE;
    // The fetching status of a MediaItem
    @Expose
    @SerializedName(value = "status")
    private String status = "new";
    private int source;
    private Feed feed;

    public MediaItem(URL url) {
        this.url = url.toString();
    }

    public MediaItem(URL url, WebPage page) {

        this.url = url.toString();

        this.streamId = "Web";
        this.id = "Web::" + url.hashCode();

        this.reference = page.getUrl();
        this.title = page.getTitle();

        this.publicationTime = page.getDate().getTime();
    }

    public MediaItem(URL url, MediaItem tempMediaItem) {

        this.id = tempMediaItem.getId();
        this.width = tempMediaItem.getWidth();
        this.height = tempMediaItem.getHeight();
        this.thumbnail = tempMediaItem.getThumbnail();
        this.type = tempMediaItem.getType();
        this.pageUrl = tempMediaItem.getPageUrl();

        this.url = url.toString();

        streamId = tempMediaItem.getStreamId();
        reference = tempMediaItem.getRef();

        description = tempMediaItem.getDescription();
        tags = tempMediaItem.getTags();
        title = tempMediaItem.getTitle();

        publicationTime = tempMediaItem.getPublicationTime();

        location = tempMediaItem.getLocation();

        mentions = tempMediaItem.getMentions();

        feed = tempMediaItem.getFeed();


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getRef() {
        return reference;
    }

    public void setRef(String reference) {
        this.reference = reference;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public boolean isVisualIndexed() {
        return vIndexed;
    }

    public void setVisualIndexed(boolean vIndexed) {
        this.vIndexed = vIndexed;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public void setMentions(String[] mentions) {
        this.mentions = mentions;
    }

    public Long getLikes() {
        return likes;
    }

    public Long getShares() {
        return shares;
    }

    public Long getComments() {
        return comments;
    }

    public Float getRatings() {
        return ratings;
    }

    public Long getViews() {
        return views;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public void setShares(Long shares) {
        this.shares = shares;
    }

    public void setComments(Long comments) {
        this.comments = comments;
    }

    public void setRatings(Float ratings) {
        this.ratings = ratings;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public int getSentiment() {
        return sentiment;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public long getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(long publicationTime) {
        this.publicationTime = publicationTime;
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

    public void setLatLong(Double latitude, Double longitude) {
        if (location == null) {
            location = new Location(latitude, longitude);
        } else {
            location.setLatitude(latitude);
            location.setLongitude(longitude);
        }
    }

    public Location getLocation() {
        return location;
    }

    public String getLocationName() {
        if (location == null) {
            return null;
        }
        return location.getName();
    }

    public void setLocationName(String locationName) {
        if (location == null) {
            location = new Location(locationName);
        } else {
            location.setName(locationName);
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String[] getMentions() {
        return this.mentions;
    }

    public String getUserId() {
        return uid;
    }

    public void setUserId(String uid) {
        this.uid = uid;
    }

    public StreamUser getUser() {
        return streamUser;
    }

    public void setUser(StreamUser streamUser) {
        this.streamUser = streamUser;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
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
            sb.append("id=").append(_id.replaceAll("\\r", " ")
                    .replaceAll("\\t", " ").replaceAll("\\n", " ").trim()).append("\t");
        }
        String _reference = getRef();
        if (reference != null) {
            sb.append("_reference=").append(_reference.replaceAll("\r", " ")
                    .replaceAll("\\t", " ").replaceAll("\\n", " ").trim()).append("\t");
        }
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
            sb.append("title=").append("\"").append(_title.replaceAll("\\t", " ")
                    .replaceAll("\\r", " ").replaceAll("\\n", " ").trim()).append("\"").append("\t");
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

        Long _pubTime = getPublicationTime();
        if (_pubTime != null) {
            sb.append("pubTime=").append(_pubTime).append("\t");
        }

        Double _latitude = getLatitude();
        if (_latitude != null) {
            sb.append("latitude=").append(_latitude).append("\t");
        }

        Double _longitude = getLongitude();
        if (_longitude != null) {
            sb.append("longitude=").append(_longitude).append("\t");
        }

        String _location = getLocationName();
        if (_location != null) {
            sb.append("location=").append(_location).append("\t");
        }

        Integer _width = getWidth();
        Integer _height = getHeight();
        if (_width != null && _height != null) {
            sb.append("width=").append(_width).append("\t");
            sb.append("height=").append(_height).append("\t");
        }

        return sb.toString();
    }
}
