package eu.socialsensor.framework.common.domain.dysco;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.JSONable;

public class Message implements JSONable{
	@Expose
	@SerializedName(value = "dyscoId")
	String dyscoId;
	
	@Expose
	@SerializedName(value = "action")
	Action action;
	
	public Message(){
		
	}
	
	public enum Action{
		NEW,UPDATE,DELETE
	}

	public String getDyscoId(){
		return dyscoId;
	}
	
	public void setDyscoId(String dyscoId){
		this.dyscoId = dyscoId;
	}
	
	public Action getAction(){
		return action;
	}
	
	public void setAction(Action action){
		this.action = action;
	}
	
    @Override
    public String toJSONString() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        return gson.toJson(this);
    }


	public static synchronized Message create(String json) {
		Gson gson = new GsonBuilder()
	    		.excludeFieldsWithoutExposeAnnotation()
	    		.create();
		
		synchronized (gson) {
		    Message message = gson.fromJson(json, Message.class);
		    return message;
		}
	}

}
