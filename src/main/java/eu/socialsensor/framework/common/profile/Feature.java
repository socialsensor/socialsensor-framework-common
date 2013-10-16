package eu.socialsensor.framework.common.profile;

import java.util.HashMap;


/**
 * Describe a feature and its profile
 * @author yosimass
 *
 */
public class Feature {
	String name;
	float weight = 0;
	// The raw content of the feature
	String value;
	// The intra feature values with their weights
	HashMap<String, FeatureValue> featureValues;

	public Feature(String name) {
		super();
		this.name = name;
	}

	public Feature(String name, float weight, String value) {
		this.name = name;
		this.weight = weight;
		this.value = value;
	}
	
	public Feature(String name, HashMap<String, FeatureValue> featureValues) {
		this(name, 0, featureValues);
	}

	public Feature(String name, float weight, HashMap<String, FeatureValue> featureValues) {
		super();
		this.name = name;
		this.weight = weight;
		this.featureValues = featureValues;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public HashMap<String, FeatureValue> getFeatureValues() {
		return featureValues;
	}

	public void setFeatureValues(HashMap<String, FeatureValue> featureValues) {
		this.featureValues = featureValues;
	}
	
	public void addFeatureValue(FeatureValue featureValue) {
		featureValues.put(featureValue.getValue(), featureValue);
	}

	public FeatureValue getFeatureValue(String name) {
		return featureValues.get(name);
	}

}
