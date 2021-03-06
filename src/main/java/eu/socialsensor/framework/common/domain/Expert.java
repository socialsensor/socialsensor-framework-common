package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.StreamUser.Category;

public class Expert implements JSONable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 673802988788312082L;

	@Expose
	@SerializedName(value = "id")
	private String id;
	
	@Expose
	@SerializedName(value = "source")
	private String source;
	 
	
	@Expose
	@SerializedName(value = "category")
	private Category category;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
	    	.excludeFieldsWithoutExposeAnnotation()
	    	.create();
		return gson.toJson(this);
	}

	public static void main() {
		
	}
}
