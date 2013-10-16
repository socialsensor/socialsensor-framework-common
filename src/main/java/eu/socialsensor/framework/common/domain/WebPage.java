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

    @Expose
    @SerializedName(value = "url")
    private String url;
    @Expose
    @SerializedName(value = "expandedUrl")
    private String expandedUrl;
    @Expose
    @SerializedName(value = "title")
    private String title;
    @Expose
    @SerializedName(value = "content")
    private String content;
    @Expose
    @SerializedName(value = "date")
    private Date date;
    @Expose
    @SerializedName(value = "reference")
    private String reference;
    @Expose
    @SerializedName(value = "streamId")
    private String streamId;
    @Expose
    @SerializedName(value = "status")
    private String status = "new";
    @Expose
    @SerializedName(value = "shares")
    private int shares = 0;

    public WebPage(String url, String reference) {
        this.url = url;
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getTitle() {

//        if (title != null) {
//
//            return title;
//            
//        } else {
//            
//            return url;
//        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
