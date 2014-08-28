package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query implements JSONable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7635308767990413659L;

	public Query() {
		
	}
	
	public Query(String name,Double score) {
		this.name = name;
		this.score = score;
	}
	
	@Expose
    @SerializedName(value = "name")
    protected String name;
	
	@Expose
    @SerializedName(value = "score")
    protected Double score;
	
	@Expose
    @SerializedName(value = "type")
    protected Type type;
	
	@Expose
    @SerializedName(value = "coords")
    protected Double[] coords;
	
	@Expose
    @SerializedName(value = "fromExpansion")
    protected boolean fromExpansion = false;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getScore() {
		return score;
	}
	
	public void setScore(Double score) {
		this.score = score;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setLocationCoords(Double[] coords){
		this.coords = coords;
	}
	
	public Double[] getLocationCoords() {
		return this.coords;
	}
	
	public void setIsFromExpansion(boolean fromExpansion) {
		this.fromExpansion = fromExpansion;
	}
	
	public boolean getIsFromExpansion() {
		return this.fromExpansion;
	}
	
 	@Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }
 	
 	public enum Type {
 		Keywords, TwitterUsers, TwitterMentions, TwitterList, Location, URL, Contributors
 	}

}
