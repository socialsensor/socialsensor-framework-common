package eu.socialsensor.framework.common.profile;

import java.util.HashMap;


/**
 * An abstarct class for an entity (e.g., a user or a topic)
 * @author yosimass
 *
 */
public abstract class User {
	String id;
	String name = null;

	HashMap<Domain, Profile> profiles = new HashMap<Domain, Profile>();

	public User(String id) {
		super();
		this.id = id;
	}
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Domain, Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(HashMap<Domain, Profile> profiles) {
		this.profiles = profiles;
	}

	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public void addProfile(Profile profile) {
		profiles.put(profile.getDomain(), profile);
	}
}
