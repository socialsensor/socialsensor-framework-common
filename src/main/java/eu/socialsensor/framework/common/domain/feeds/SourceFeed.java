package eu.socialsensor.framework.common.domain.feeds;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed;
import eu.socialsensor.framework.common.domain.Source;

public class SourceFeed extends Feed {

	@Expose
    @SerializedName(value = "source")
	private Source source = null;
	
	public SourceFeed(Source source, Date since, String id) {
		super(since, Feed.FeedType.SOURCE);
		this.source = source;
		this.id = id;
	}
	
	public SourceFeed(Source source, Date since, String id,String dyscoId) {
		super(since, Feed.FeedType.SOURCE);
		this.source = source;
		this.id = id;
		this.dyscoId = dyscoId;
	}

	public Source getSource() {
		return this.source;
	}
	
	public void setSource(Source source) {
		this.source = source;
	}

}
