package eu.socialsensor.framework.common.profile;


/**
 * A feature value represents a possible value of a feature
 * @author yosimass
 *
 */
public class FeatureValue {
	String value;
	float weight = 0;
	
	public FeatureValue(String value) {
		super();
		this.value = value;
	}

	public FeatureValue(String value, float weight) {
		super();
		this.value = value;
		this.weight = weight;
	}

	public String getValue() {
		return value;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
