package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 *
 * @author etzoannos
 */
public class TwitterContributor extends Contributor {

    private Date firstPostDate;
    @Expose
    @SerializedName(value = "mentions")
    private Mentions mentions = new Mentions();
    @Expose
    @SerializedName(value = "retweets")
    private Retweets retweets = new Retweets();
    
    @Expose
    @SerializedName(value = "verified")
    private boolean verified;
    
    @Expose
    @SerializedName(value = "listedCount")
    private Long listedCount;
    
    @Expose
    @SerializedName(value = "favouritesCount")
    private Long favouritesCount;

    public TwitterContributor() {

        // just initialize referenced classes with zero values for avoiding reference to null objects

        Mentions mentions = new Mentions();
        mentions.setCredibleNegativeMentions(0);
        mentions.setCrediblePositiveMentions(0);
        mentions.setNegativeMentions(0);
        mentions.setPositiveMentions(0);
        mentions.setMentions(0);

        this.mentions = mentions;

        Retweets retweets = new Retweets();
        retweets.setCredibleRetweetsCount(0);
        retweets.setRetweetsCount(0);

        this.retweets = retweets;
        
        this.verified = false;
        this.listedCount = 0L;
        this.favouritesCount = 0L;
    }

    public Date getFirstPostDate() {
        return firstPostDate;
    }

    public void setFirstPostDate(Date firstPostDate) {
        this.firstPostDate = firstPostDate;
    }

    public Mentions getMentions() {
        return mentions;
    }

    public void setMentions(Mentions mentions) {
        this.mentions = mentions;
    }

    public Retweets getRetweets() {
        return retweets;
    }

    public void setRetweets(Retweets retweets) {
        this.retweets = retweets;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Long getListedCount() {
        return listedCount;
    }

    public void setListedCount(Long listedCount) {
        this.listedCount = listedCount;
    }

    public Long getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Long favouritesCount) {
        this.favouritesCount = favouritesCount;
    }
}
