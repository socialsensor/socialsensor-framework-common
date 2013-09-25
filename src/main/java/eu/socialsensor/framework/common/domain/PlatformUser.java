/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import eu.socialsensor.framework.common.domain.dysco.Dysco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stzoannos
 */
public class PlatformUser implements JSONable {

    @Expose
    @SerializedName(value = "name")
    String name;
    @Expose
    @SerializedName(value = "topics")
    List<DynamicTopic> topics = new ArrayList<DynamicTopic>();
    @Expose
    @SerializedName(value = "organizationName")
    String organizationName;
    @Expose
    @SerializedName(value = "organizationId")
    String organizationId;
    @Expose
    @SerializedName(value = "votes")
    List<Vote> votes = new ArrayList<Vote>();
    
    public void addVote(Vote vote) {
        votes.add(vote);
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DynamicTopic> getTopics() {
        return topics;
    }

    public void setTopics(List<DynamicTopic> topics) {
        this.topics = topics;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void addTopic(DynamicTopic topic) {
        topics.add(topic);
    }
    
    @Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }
}
