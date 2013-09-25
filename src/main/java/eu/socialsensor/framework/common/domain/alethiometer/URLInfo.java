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
public class URLInfo {

    @Expose
    @SerializedName(value = "url")
    private String url = "";
    @Expose
    @SerializedName(value = "domain credible")
    private boolean domainCredible = false;
    @Expose
    @SerializedName(value = "domain info available")
    private boolean domainInfoAvailable = false;
    @Expose
    @SerializedName(value = "domain registration difference in days")
    private int domainRegistrationDifferenceInDays = 0;
    @Expose
    @SerializedName(value = "alexa score")
    private AlexaScore alexaScore;

    public AlexaScore getAlexaScore() {
        return alexaScore;
    }

    public void setAlexaScore(AlexaScore alexaScore) {
        this.alexaScore = alexaScore;
    }

    public boolean isDomainCredible() {
        return domainCredible;
    }

    public void setDomainCredible(boolean domainCredible) {
        this.domainCredible = domainCredible;
    }

    public boolean isDomainInfoAvailable() {
        return domainInfoAvailable;
    }

    public void setDomainInfoAvailable(boolean domainInfoAvailable) {
        this.domainInfoAvailable = domainInfoAvailable;
    }

    public int getDomainRegistrationDifferenceInDays() {
        return domainRegistrationDifferenceInDays;
    }

    public void setDomainRegistrationDifferenceInDays(int domainRegistrationDifferenceInDays) {
        this.domainRegistrationDifferenceInDays = domainRegistrationDifferenceInDays;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
