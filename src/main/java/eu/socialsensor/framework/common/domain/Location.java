package eu.socialsensor.framework.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import java.io.Serializable;
import java.util.Map;

public class Location implements JSONable, Serializable{

	@Expose
	@SerializedName(value = "coordinates")
	protected Coordinates coordinates = null;
	
	@Expose
	@SerializedName(value = "radius")
	protected Double radius = null;
	
	@Expose
	@SerializedName(value = "name")
	protected String name = null;
	
	@Expose
	@SerializedName(value = "city")
	protected String city = null;
	
	@Expose
	@SerializedName(value = "country")
	protected String country = null;
	
	@Expose
	@SerializedName(value = "bbox")
	protected Double bbox[][] = null;
	
	@Expose
	@SerializedName(value = "inferred")
	protected Boolean inferred = false;
	
	public Location(String name) {
		this.name = name;
	}
	
	public Location(Double latitude, Double longitude) {
		coordinates = new Coordinates();
		coordinates.latitude = latitude;
		coordinates.longitude = longitude;
	}
	
	public Location(Double latitude, Double longitude, Double radius) {
		coordinates = new Coordinates();
		coordinates.latitude = latitude;
		coordinates.longitude = longitude;
		this.radius = radius;
	}
	
	public Location(Double latitude, Double longitude, String name) {
		coordinates = new Coordinates(latitude, longitude);
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
	
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	public  void setName(String name) {
		this.name = name;
	}

	public  void setCityName(String city) {
		this.city = city;
	}
	
	public  void setCountryName(String country) {
		this.country = country;
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
	
	public Double getRadius() {
		return radius;
	}
	
	public Double[][] getbbox() {
		return bbox;
	}
	
	public  String getName(){
		return name;
	}

	public  String getCityName(){
		return city;
	}
	
	public  String getCountryName(){
		return country;
	}
	
	
	private static class Coordinates implements Serializable{
		
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
