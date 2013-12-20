package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public class WebPage implements JSONable, Comparable<WebPage> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8783341713025378581L;
	
	// The URL of a WebPage. This is usuually a short URL
	@Expose
    @SerializedName(value = "url")
    private String url;
	
	// The expanded version of URL
    @Expose
    @SerializedName(value = "expandedUrl")
    private String expandedUrl;
    
    // The title extracted from the WebPage
    @Expose
    @SerializedName(value = "title")
    private String title;
    
    // The textual content of the web page
    @Expose
    @SerializedName(value = "text")
    private String text;
    
    // The title extracted from the WebPage
    @Expose
    @SerializedName(value = "keywords")
    private String[] keywords;
    
    // The date that a web page shared for the first time
    @Expose
    @SerializedName(value = "date")
    private Date date;
    
    // The id of the Item that share a web page for the forst time
    @Expose
    @SerializedName(value = "reference")
    private String reference;
    
    // The stream of the Item that the web page comes from 
    @Expose
    @SerializedName(value = "streamId")
    private String streamId;
    
    // The number of times a web page has been shared
    @Expose
    @SerializedName(value = "shares")
    private int shares = 0;

    // The crawling status of this web page
    @Expose
    @SerializedName(value = "status")
    private String status = "new";
    
    public WebPage(String url, String reference) {
        this.url = url;
        this.reference = reference;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpandedUrl() {
        return this.expandedUrl;
    }

    public void setExpandedUrl(String expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getStreamId() {
        return streamId;
    }
    
    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
    
    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }

    @Override
    public int compareTo(WebPage o) {
        if (o.getShares() > getShares()) {
            return 1;
        }
        return -1;
    }

  
}
