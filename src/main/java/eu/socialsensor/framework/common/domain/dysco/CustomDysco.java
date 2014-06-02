package eu.socialsensor.framework.common.domain.dysco;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.Location;

public class CustomDysco extends Dysco {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1386334046873014627L;

	
		
	public CustomDysco() {
		dyscoType = DyscoType.CUSTOM;
	}
			
	@Expose
    @SerializedName(value = "twitterUsers")
	private List<String> twitterUsers;
	
	@Expose
    @SerializedName(value = "mentionedUsers")
	private List<String> mentionedUsers;
	
	@Expose
    @SerializedName(value = "listsOfUsers")
	private List<String> listsOfUsers;
	
	@Expose
    @SerializedName(value = "otherSocialNetworks")
	private Map<String, String> otherSocialNetworks;
	
	@Expose
    @SerializedName(value = "nearLocations")
	private List<Location> nearLocations;
	
	@Expose
    @SerializedName(value = "wordsToAvoid")
	private List<String> wordsToAvoid;
	
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
    
    public Map<String, String> getOtherSocialNetworks() {
        return otherSocialNetworks;
    }
    
    public void setOtherSocialNetworks(Map<String, String> otherSocialNetworks) {
        this.otherSocialNetworks = otherSocialNetworks;
    }
    
    public List<Location> getNearLocations() {
        return nearLocations;
    }
    
    public void setNearLocations(List<Location> nearLocations) {
        this.nearLocations = nearLocations;
    }
    
    public void setWordsToAvoid(List<String> wordsToAvoid){
    	this.wordsToAvoid = wordsToAvoid;
    }
    
    public List<String> getWordsToAvoid(){
    	return this.wordsToAvoid;
    }
}
