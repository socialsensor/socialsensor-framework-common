package eu.socialsensor.framework.common.domain.feeds;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Feed;
import eu.socialsensor.framework.common.domain.Location;

public class LocationFeed extends Feed {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6371051856398652350L;
	
	@Expose
    @SerializedName(value = "location")
	private Location location;
	
	public LocationFeed(Location location, Date since, String id) {
		super(since, Feed.FeedType.LOCATION);
		this.location = location;
		this.id = id;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
}
