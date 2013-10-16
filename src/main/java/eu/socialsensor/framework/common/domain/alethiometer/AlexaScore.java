/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.socialsensor.framework.common.domain.alethiometer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author etzoannos
 */
public class AlexaScore {

    
    @Expose
    @SerializedName(value = "local")
    private long localAlexaScore = 1000000L;
    @Expose
    @SerializedName(value = "international")
    private long internationalAlexaScore = 1000000L;

    public long getInternationalAlexaScore() {
        return internationalAlexaScore;
    }

    public void setInternationalAlexaScore(long internationalAlexaScore) {
        this.internationalAlexaScore = internationalAlexaScore;
    }

    public long getLocalAlexaScore() {
        return localAlexaScore;
    }

    public void setLocalAlexaScore(long localAlexaScore) {
        this.localAlexaScore = localAlexaScore;
    }
}
