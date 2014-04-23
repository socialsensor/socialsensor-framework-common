package eu.socialsensor.framework.common.domain;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query implements JSONable{

	public Query(){
		
	}
	
	public Query(String name,Double score){
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
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Double getScore(){
		return score;
	}
	
	public void setScore(Double score){
		this.score = score;
	}
	
	public Type getType(){
		return type;
	}
	
	public void setType(Type type){
		this.type = type;
	}
	
 	@Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                //.registerTypeAdapter(Date.class, new DateSerializer())
                //.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
        return gson.toJson(this);
    }
 	
 	public enum Type{
 		Keywords, Contributors
 	}

}
