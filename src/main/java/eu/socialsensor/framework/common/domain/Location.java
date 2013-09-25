package eu.socialsensor.framework.common.domain;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class Location implements JSONable {

	@Expose
	@SerializedName(value = "coordinates")
	Coordinates coordinates = null;
	@Expose
	@SerializedName(value = "name")
	protected String name = null;
	@Expose
	@SerializedName(value = "bbox")
	Double bbox[][] = null;
	
	public Location(String name) {
		this.name = name;
	}
	
	public Location(Double latitude, Double longitude) {
		coordinates = new Coordinates();
		coordinates.latitude = latitude;
		coordinates.longitude = longitude;
	}
	
	public Location(Double latitude, Double longitude, String name) {
		coordinates = new Coordinates();
		coordinates.latitude = latitude;
		coordinates.longitude = longitude;
		this.name = name;
	}
	
	public Location(Double[][] bbox, String name) {
		if(bbox.length != 2 && bbox[0].length != 2){
			return;
		}
		this.name = name;
		this.bbox = bbox;
	
	}
	
	public void setLatitude(Double latitude) {
		if(coordinates==null)
			coordinates = new Coordinates();
		coordinates.latitude = latitude;
	}
	
	public void setLongitude(Double longitude) {
		if(coordinates==null)
			coordinates = new Coordinates();
		coordinates.longitude = longitude;
	}
	
	public  void setName(String name) {
		this.name = name;
	}
	
	public Double getLatitude() {
		if(coordinates==null)
			return null;
		return coordinates.latitude;
	}
	
	public Double getLongitude() {
		if(coordinates==null)
			return null;
		return coordinates.longitude;
	}
	
	public Double[][] getbbox() {
		return bbox;
	}
	
	public  String getName(){
		return name;
	}

	private static class Coordinates {
		
		public Coordinates() {
			
		}
		public Coordinates(Double latitude, Double longitude) {
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		@Expose
		@SerializedName(value = "latitude")
		protected Double latitude = null;
		@Expose
		@SerializedName(value = "longitude")
		protected Double longitude = null;
	}
	
	@Override
	public String toJSONString() {
		Gson gson = new GsonBuilder()
	 		.excludeFieldsWithoutExposeAnnotation()
	 		.create();
	
	 	return gson.toJson(this);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> toJSONMap() {
		DBObject obj = (DBObject) JSON.parse(toJSONString());
		return (Map<String, Object>) obj.toMap();
	}
}
