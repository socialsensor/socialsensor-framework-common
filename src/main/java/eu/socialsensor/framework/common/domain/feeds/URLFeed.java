package eu.socialsensor.framework.common.domain.feeds;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed;


public class URLFeed extends Feed{
	
	@Expose
    @SerializedName(value = "url")
	private String url = null;
	
	@Expose
    @SerializedName(value = "network")
	private String network = null;
	
	
	public URLFeed(String url, Date since, String id) {
		super(since, Feed.FeedType.URL);
		this.url = url;
		this.id = id;
	}

	public String getURL() {
		return this.url;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
	public String getNetwork() {
		return this.network;
	}
	
	public void setNetwork(String network) {
		this.network = network;
	}
}
