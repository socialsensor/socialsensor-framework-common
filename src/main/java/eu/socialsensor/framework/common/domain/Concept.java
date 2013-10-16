package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

public class Concept implements JSONable {

	@Expose
    @SerializedName(value = "concept")
	ConceptType type;
	@Expose
    @SerializedName(value = "score")
	Double score;

	public enum ConceptType {
	    WAR, ELECTIONS, RIOTS, TSUNAMI,
	    HURRICANE, VOLCANIC_ERUPTION 
	}
	
	public Concept(ConceptType type, Double score) {
		this.type = type;
		this.score = score;
	}
	
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
        	.excludeFieldsWithoutExposeAnnotation()
        	.create();
		return gson.toJson(this);
	}
	
	
	public static void main(String[] args) {
		
		Concept concept1 = new Concept(ConceptType.WAR, 0.74209);
		Concept concept2 = new Concept(ConceptType.VOLCANIC_ERUPTION, 0.5325);
		Concept concept3 = new Concept(ConceptType.TSUNAMI, 0.6091);
		
		System.out.println(concept1.toJSONString());
		System.out.println(concept2.toJSONString());
		System.out.println(concept3.toJSONString());
	}
}
