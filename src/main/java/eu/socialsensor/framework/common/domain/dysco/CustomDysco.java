package eu.socialsensor.framework.common.domain.dysco;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Location;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomDysco extends Dysco {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783551698748514873L;


	public CustomDysco() {
		
	}
	
    public CustomDysco(String id, Date creationDate, DyscoType dyscoType) {
        super(id,creationDate,dyscoType);
      
    }
    
    public CustomDysco(Dysco dysco) {
    	super();
		this.id = dysco.getId();
		this.creationDate = dysco.getCreationDate();
		this.dyscoType = dysco.getDyscoType();
		this.solrQueries = dysco.getSolrQueries();
		this.title = dysco.getTitle();
		this.keywords = dysco.getKeywords();
		this.hashtags = dysco.getHashtags();
	}

    @Expose
    @SerializedName(value = "twitterUsers")
    private List<String> twitterUsers = new ArrayList<String>();
    @Expose
    @SerializedName(value = "mentionedUsers")
    private List<String> mentionedUsers = new ArrayList<String>();
    @Expose
    @SerializedName(value = "listsOfUsers")
    private List<String> listsOfUsers = new ArrayList<String>();
    @Expose
    @SerializedName(value = "otherSocialNetworks")
    private List<String> otherSocialNetworks = new ArrayList<String>();
    @Expose
    @SerializedName(value = "nearLocations")
    private List<Location> nearLocations = new ArrayList<Location>();
    @Expose
    @SerializedName(value = "wordsToAvoid")
    private List<String> wordsToAvoid = new ArrayList<String>();


    public List<String> getTwitterUsers() {
        return twitterUsers;
    }

    public void setTwitterUsers(List<String> twitterUsers) {
        this.twitterUsers = twitterUsers;
    }

    public List<String> getMentionedUsers() {
        return mentionedUsers;
    }

    public void setMentionedUsers(List<String> mentionedUsers) {
        this.mentionedUsers = mentionedUsers;
    }

    public List<String> getListsOfUsers() {
        return listsOfUsers;
    }

    public void setListsOfUsers(List<String> listsOfUsers) {
        this.listsOfUsers = listsOfUsers;
    }

    public List<String> getOtherSocialNetworks() {
        return otherSocialNetworks;
    }

    public void setOtherSocialNetworks(List<String> otherSocialNetworks) {
        this.otherSocialNetworks = otherSocialNetworks;
    }

    public List<Location> getNearLocations() {
        return nearLocations;
    }

    public void setNearLocations(List<Location> nearLocations) {
        this.nearLocations = nearLocations;
    }

    public void setWordsToAvoid(List<String> wordsToAvoid) {
        this.wordsToAvoid = wordsToAvoid;
    }

    public List<String> getWordsToAvoid() {
        return this.wordsToAvoid;
    }
}
