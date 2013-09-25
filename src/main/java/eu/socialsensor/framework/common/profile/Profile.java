package eu.socialsensor.framework.common.profile;

import java.util.HashMap;


/**
 * An abstract class to profiles
 * @author yosimass
 *
 */
public abstract class Profile {
	Domain domain;
	HashMap<String, Feature> features = new HashMap<String, Feature>();
	
	public Profile(Domain domain) {
		super();
		this.domain = domain;
	}
	
	public Profile(Domain domain, HashMap<String, Feature> features) {
		super();
		this.domain = domain;
		this.features = features;
	}

	public Domain getDomain() {
		return domain;
	}
	
	public HashMap<String, Feature> getFeatures() {
		return features;
	}

	public void setFeatures(HashMap<String, Feature> features) {
		this.features = features;
	}
	
	public Feature getFeature(String name) {
		return features.get(name);
	}
	
	public void setFeature(Feature feature) {
		features.put(feature.getName(), feature);
	}
	
}
