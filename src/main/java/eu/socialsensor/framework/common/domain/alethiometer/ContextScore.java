package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author etzoannos
 */
public class ContextScore implements Serializable{

    @Expose
    @SerializedName(value = "duplication")
    private int duplication;
    @Expose
    @SerializedName(value = "history")
    private int history;
    @Expose
    @SerializedName(value = "popularity")
    private int popularity;
    @Expose
    @SerializedName(value = "influence")
    private int influence;
    @Expose
    @SerializedName(value = "proximity")
    private int proximity;

    public int getDuplication() {
        return duplication;
    }

    public void setDuplication(int duplication) {
        this.duplication = duplication;
    }

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

    public int getProximity() {
        return proximity;
    }

    public void setProximity(int proximity) {
        this.proximity = proximity;
    }
}
