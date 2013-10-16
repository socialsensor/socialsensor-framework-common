package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author etzoannos
 */
public class Mentions {

    @Expose
    @SerializedName(value = "mentions")
    private int mentions = 0;
    @Expose
    @SerializedName(value = "positive mentions")
    private int positiveMentions = 0;
    @Expose
    @SerializedName(value = "credible positive mentions")
    private int crediblePositiveMentions = 0;
    @Expose
    @SerializedName(value = "negative mentions")
    private int negativeMentions = 0;
    @Expose
    @SerializedName(value = "credible negative mentions")
    private int credibleNegativeMentions = 0;

    public int getCredibleNegativeMentions() {
        return credibleNegativeMentions;
    }

    public void setCredibleNegativeMentions(int credibleNegativeMentions) {
        this.credibleNegativeMentions = credibleNegativeMentions;
    }

    public int getCrediblePositiveMentions() {
        return crediblePositiveMentions;
    }

    public void setCrediblePositiveMentions(int crediblePositiveMentions) {
        this.crediblePositiveMentions = crediblePositiveMentions;
    }

    public int getMentions() {
        return mentions;
    }

    public void setMentions(int mentions) {
        this.mentions = mentions;
    }

    public int getNegativeMentions() {
        return negativeMentions;
    }

    public void setNegativeMentions(int negativeMentions) {
        this.negativeMentions = negativeMentions;
    }

    public int getPositiveMentions() {
        return positiveMentions;
    }

    public void setPositiveMentions(int positiveMentions) {
        this.positiveMentions = positiveMentions;
    }
}
