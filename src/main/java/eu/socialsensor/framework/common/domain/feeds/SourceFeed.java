package eu.socialsensor.framework.common.domain.feeds;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed;
import eu.socialsensor.framework.common.domain.Source;

public class SourceFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6865708239941324229L;
	
	@Expose
    @SerializedName(value = "source")
	private Source source = null;
	
	public SourceFeed(Source source, Date since, String id) {
		super(since, Feed.FeedType.SOURCE);
		this.source = source;
		this.id = id;
	}

	public Source getSource() {
		return this.source;
	}
	
	public void setSource(Source source) {
		this.source = source;
	}

}
