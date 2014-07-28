package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author etzoannos
 */
public class ContentScore implements Serializable {

    @Expose
    @SerializedName(value = "reputation")
    private int reputation = 0;
    @Expose
    @SerializedName(value = "history")
    private int history = 0;
    @Expose
    @SerializedName(value = "originality")
    private int originality = 0;
    @Expose
    @SerializedName(value = "authenticity")
    private int authenticity = 0;
    @Expose
    @SerializedName(value = "proximity")
    private int proximity = 0;

    public int getAuthenticity() {
        return authenticity;
    }

    public void setAuthenticity(int authenticity) {
        this.authenticity = authenticity;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getOriginality() {
        return originality;
    }

    public void setOriginality(int originality) {
        this.originality = originality;
    }

    public int getProximity() {
        return proximity;
    }

    public void setProximity(int proximity) {
        this.proximity = proximity;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
