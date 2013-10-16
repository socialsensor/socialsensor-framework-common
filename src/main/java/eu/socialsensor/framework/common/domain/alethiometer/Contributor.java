package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 *
 * @author etzoannos
 */
public class Contributor {

    @Expose
    @SerializedName(value = "contributor id")
    private long contributorId;
    @Expose
    @SerializedName(value = "screen name")
    private String screenName;
    @Expose
    @SerializedName(value = "posts count")
    private int postsCount;
    @Expose
    @SerializedName(value = "followers count")
    private int followersCount;
    @Expose
    @SerializedName(value = "credible followers count")
    private int credibleFollowersCount;
    @Expose
    @SerializedName(value = "klout score")
    private int klout;
    @Expose
    @SerializedName(value = "credibility score")
    int credibility;
    @Expose
    @SerializedName(value = "unreliability score")
    private int unreliability;
    @Expose
    @SerializedName(value = "frequency")
    private float frequency;
    private Date lastUpdate;
    @Expose
    @SerializedName(value = "source credibility factor")
    private Integer scf = 0;

    
    
    public int getUnreliability() {
		return unreliability;
	}

	public void setUnreliability(int unreliability) {
		this.unreliability = unreliability;
	}

	public Integer getScf() {
		return scf;
	}

	public void setScf(Integer scf) {
		this.scf = scf;
	}

	public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public long getContributorId() {
        return contributorId;
    }

    public void setContributorId(long contributorId) {
        this.contributorId = contributorId;
    }

    public int getCredibility() {
        return credibility;
    }

    public void setCredibility(int credibility) {
        this.credibility = credibility;
    }

    public int getCredibleFollowersCount() {
        return credibleFollowersCount;
    }

    public void setCredibleFollowersCount(int credibleFollowersCount) {
        this.credibleFollowersCount = credibleFollowersCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(int postsCount) {
        this.postsCount = postsCount;
    }

    public int getKlout() {
        return klout;
    }

    public void setKlout(int klout) {
        this.klout = klout;
    }
}
