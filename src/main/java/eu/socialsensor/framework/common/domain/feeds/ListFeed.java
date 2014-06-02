package eu.socialsensor.framework.common.domain.feeds;

import java.util.Date;

import eu.socialsensor.framework.common.domain.Feed;

public class ListFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876101187566475910L;
	private String owner;
	private String slug;

	public ListFeed(String owner, String slug, Date since) {
		super(since, Feed.FeedType.LIST);
		
		this.owner = owner;
		this.slug = slug;
	}

	public String getListOwner() {
		return owner;
	}
	
	public String getListSlug() {
		return slug;
	}
}
