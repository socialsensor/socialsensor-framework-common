package eu.socialsensor.framework.common.domain.feeds;

import java.net.URL;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed;


public class URLFeed extends Feed{
	
	@Expose
    @SerializedName(value = "url")
	private URL url = null;
	
	
	public URLFeed(URL url, Date since, String id) {
		super(since, Feed.FeedType.URL);
		this.url = url;
		this.id = id;
	}

	public URL getURL() {
		return this.url;
	}
	
	public void setURL(URL url) {
		this.url = url;
	}
}
