package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Concept implements JSONable {

	private static final long serialVersionUID = -7389160446822526436L;
	
	@Expose
    @SerializedName(value = "concept")
	ConceptType type;
	@Expose
    @SerializedName(value = "score")
	Double score;

	public enum ConceptType {
		graphics,
		messages,
		keepcalm,
		memes,
		porn,
		disturbing,
		images,
		heavytext
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
