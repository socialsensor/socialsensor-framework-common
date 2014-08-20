package eu.socialsensor.framework.common.domain.feeds;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed;

public class ListFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6876101187566475910L;
	
	@Expose
    @SerializedName(value = "owner")
	private String owner;
	
	@Expose
    @SerializedName(value = "slug")
	private String slug;
	
	public ListFeed(String url, Date since, String id) {
		super(since, Feed.FeedType.LIST);
		this.id = id;
		
		String twitterRegex = "https://twitter.com/";
		String restString = url.replace(twitterRegex, "");
		int index = restString.indexOf("/");
	
		this.owner = restString.substring(0, index);
	
		String ownerRegex = owner+"/lists/";
	
		this.slug = restString.replace(ownerRegex, "");
		
	}

	public ListFeed(String owner, String slug, Date since, String id) {
		super(since, Feed.FeedType.LIST);
		this.id = id;
		this.owner = owner;
		this.slug = slug;
	}

	public String getListOwner() {
		return owner;
	}
	
	public String getListSlug() {
		return slug;
	}
	
	public static void main(String[] args) {
		ListFeed listFeed = new ListFeed("https://twitter.com/1basil1/lists/sundance2012filmmakers",
				new Date(), null);
		
		System.out.print(listFeed.toJSONString());
	}
}
