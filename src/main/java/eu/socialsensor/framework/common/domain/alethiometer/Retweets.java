package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author etzoannos
 */
public class Retweets {

    @Expose
    @SerializedName(value = "retweets count")
    private int retweetsCount = 0;
    @Expose
    @SerializedName(value = "credible retweets count")
    private int credibleRetweetsCount = 0;

    public int getCredibleRetweetsCount() {
        return credibleRetweetsCount;
    }

    public void setCredibleRetweetsCount(int credibleRetweetsCount) {
        this.credibleRetweetsCount = credibleRetweetsCount;
    }

    public int getRetweetsCount() {
        return retweetsCount;
    }

    public void setRetweetsCount(int retweetsCount) {
        this.retweetsCount = retweetsCount;
    }
}
