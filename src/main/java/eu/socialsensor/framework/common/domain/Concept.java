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
		Selfie, 
		Porn, 
		Messages, 
		Memes,
		Keepcalm, 
		Graphics, 
		Crowd, 
		Logos, 
		Nature
	}
	
	public Concept(String type, Double score) {
		this.type = ConceptType.valueOf(type);
		this.score = score;
	}
	
	public Concept(ConceptType type, Double score) {
		this.type = type;
		this.score = score;
	}
	
	public String getConcept() {
		return type.toString();
	}
	
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
        	.excludeFieldsWithoutExposeAnnotation()
        	.create();
		return gson.toJson(this);
	}
	
}
