/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.socialsensor.framework.common.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author stzoannos
 */
public class DynamicTopic {

    @Expose
    @SerializedName(value = "keywords")
    List<String> keywords = new ArrayList<String>();
    @Expose
    @SerializedName(value = "title")
    String title;
    @Expose
    @SerializedName(value = "creationDate")
    Date creationDate;
    @Expose
    @SerializedName(value = "platformUser")
    PlatformUser platformUser;
    @Expose
    @SerializedName(value = "id")
    String id;
    @Expose
    @SerializedName(value = "tags")
    List<String> tags = new ArrayList<String>();
    @Expose
    @SerializedName(value = "people")
    List<String> people = new ArrayList<String>();

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }
       

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public PlatformUser getPlatformUser() {
        return platformUser;
    }

    public void setPlatformUser(PlatformUser platformUser) {
        this.platformUser = platformUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
