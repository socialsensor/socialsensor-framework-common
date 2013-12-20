package eu.socialsensor.framework.common.domain.dysco;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.socialsensor.framework.common.domain.JSONable;

public class Message implements JSONable{
	
	String dyscoId;
	
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Message message = new Message();
		message.setDyscoId("94cf702e-1625-4869-bc43-20e193048eec");
		message.setAction(Action.NEW);
		
		System.out.println("Message : "+message.toJSONString());
	}

}
