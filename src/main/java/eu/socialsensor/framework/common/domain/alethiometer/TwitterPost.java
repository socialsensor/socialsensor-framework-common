package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author etzoannos
 */
public class TwitterPost extends Post {

    @Expose
    @SerializedName(value = "retweets")
    private Retweets retweets = new Retweets();
    @Expose
    @SerializedName(value = "contributor")
    private TwitterContributor contributor;
    @Expose
    @SerializedName(value = "originator")
    private TwitterContributor originator;

    
    public TwitterContributor getOriginator() {
		return originator;
	}

	public void setOriginator(TwitterContributor originator) {
		this.originator = originator;
	}

	public Retweets getRetweets() {
        return retweets;
    }

    public void setRetweets(Retweets retweets) {
        this.retweets = retweets;
    }

    public TwitterContributor getContributor() {
        return contributor;
    }

    public void setContributor(TwitterContributor contributor) {
        this.contributor = contributor;
    }
}
