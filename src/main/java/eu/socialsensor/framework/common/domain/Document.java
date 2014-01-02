package eu.socialsensor.framework.common.domain;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import eu.socialsensor.framework.common.domain.Item.Operation;

public class Document implements JSONable{
	public enum Operation {

        NEW("New"),
        DELETED("Deleted");
        private final String label;

        private Operation(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
	 }
	 
	 public Document(){
		 
	 }
	 
	 public Document(String sourceId,Operation operation){
		 this.sourceId = sourceId;
		 this.operation = operation;
	 }
	 
	 // Unique id of an instance with the following structure: SourceName#internalId
	 @Expose
	 @SerializedName(value = "id")
	 protected String id;
	 
	 // The name of the source that the document was retrieved from
     @Expose
     @SerializedName(value = "sourceId")
     protected String sourceId;
     
     // The title of the document
     @Expose
     @SerializedName(value = "title")
     protected String title;
	  
     // The content of the document
     @Expose
     @SerializedName(value = "content")
     protected String content;
     
     // The publication time of the document
     @Expose
     @SerializedName(value = "publicationTime")
     protected long publicationTime;
     
     // The url where the document can be found
     @Expose
     @SerializedName(value = "url")
     protected String url;
     
     // The category of document belongs to
     @Expose
     @SerializedName(value = "category")
     protected String category;
     
     // The operation associated with the DOCUMENT : NEW, UPDATE, DELETE
     @SerializedName(value = "operation")
     protected Operation operation;
     
     
     // Getters  & Setters for the fields of this class
	 
     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }
     
     public String getSourceId() {
         return sourceId;
     }

     public void setSourceId(String sourceId) {
         this.sourceId = sourceId;
     }
     
     public String getTitle() {
         return title;
     }

     public void setTitle(String title) {
         this.title = title;
     }
     
     public String getContent() {
         return content;
     }

     public void setContent(String content) {
         this.content = content;
     }
     
     public long getPublicationTime() {
         return publicationTime;
     }

     public void setPublicationTime(long publicationTime) {
         this.publicationTime = publicationTime;
     }
     
     public String getUrl() {
         return url;
     }

     public void setUrl(String url) {
         this.url = url;
     }
     
     public String getCategory() {
         return category;
     }

     public void setCategory(String category) {
         this.category = category;
     }
     
	 // Creates the JSON representation of a Document
     @Override
     public String toJSONString() {
         Gson gson = new GsonBuilder()
                 .excludeFieldsWithoutExposeAnnotation()
                 .registerTypeAdapter(Date.class, new DateSerializer())
                 //.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                 .create();
         return gson.toJson(this);
     }
     
     public static synchronized Document create(String json) {
 		Gson gson = new GsonBuilder()
 	    		.excludeFieldsWithoutExposeAnnotation()
 	    		.create();
 		
 		synchronized (gson) {
 		    Document doc = gson.fromJson(json, Document.class);
 		    return doc;
 		}
 	}
     
     public static class DateSerializer extends TypeAdapter<Date> {
     	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
     	
 	    @Override
 	    public void write(JsonWriter out, Date date) throws IOException {
 	    	out.beginObject();
 	    	String d = df.format(date);
 	    		
 	    	out.name("$date");
     		out.value(d);
 	    	
 	    	out.endObject();
 	    }

 	    @Override
 	    public Date read(JsonReader in) throws IOException {
 	        return null;
 	    }
 	}
}
