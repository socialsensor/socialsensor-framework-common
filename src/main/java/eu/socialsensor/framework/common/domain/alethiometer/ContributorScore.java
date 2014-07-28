package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author etzoannos
 */
public class ContributorScore implements Serializable{

    @Expose
    @SerializedName(value = "reputation")
    private int reputation = 0;
    @Expose
    @SerializedName(value = "history")
    private int history = 0;
    @Expose
    @SerializedName(value = "popularity")
    private int popularity = 0;
    @Expose
    @SerializedName(value = "influence")
    private int influence = 0;
    @Expose
    @SerializedName(value = "presence")
    private int presence = 0;

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getInfluence() {
        return influence;
    }

    public void setInfluence(int influence) {
        this.influence = influence;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
