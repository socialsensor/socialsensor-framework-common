package eu.socialsensor.framework.common.domain.dysco;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import eu.socialsensor.framework.common.domain.JSONable;

import java.io.Serializable;

/**
*
* @author cmartin - email: c.j.martin-dancausa@rgu.ac.uk
*/
public class Entity implements Serializable, JSONable {

    @Expose
    @SerializedName(value = "name")
    private String name;
    @Expose
    @SerializedName(value = "cont")
    private Integer cont;
    @Expose
    @SerializedName(value = "type")
    private Type type;

    public Entity(String name, int cont, Type type) {
        this.name = name;
        this.cont = cont;
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cont
     */
    public Integer getCont() {
        return cont;
    }

    /**
     * @param cont the cont to set
     */
    public void setCont(int cont) {
        this.cont = cont;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    public String toString() {
        return name + ": " + cont;
    }

    public enum Type {

        PERSON, LOCATION, ORGANIZATION
    }

	@Override
	public String toJSONString() {
        Gson gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create();
        return gson.toJson(this);
	}

	public boolean equals(Object entity) {
	    //check for self-comparison
	    if ( this == entity ) return true;

	    //use instanceof instead of getClass here for two reasons
	    //1. if need be, it can match any supertype, and not just one class;
	    //2. it renders an explict check for "that == null" redundant, since
	    //it does the check for null already - "null instanceof [type]" always
	    //returns false. (See Effective Java by Joshua Bloch.)
	    if ( !(entity instanceof Entity) ) return false;
	    //Alternative to the above line :
	    //if ( aThat == null || aThat.getClass() != this.getClass() ) return false;

	    //cast to native object is now safe
	    Entity entity1 = (Entity)entity;

	    //now a proper field-by-field evaluation can be made
	    if (!name.equalsIgnoreCase(entity1.getName()))
	    	return false;
	    
	    if (cont!=entity1.getCont())
	    	return false;
	    
	    if (type!=entity1.getType())
	    	return false;

	    return true;
	}
	
	public int hashCode() {
		  int result = 17;
		  
		  result = 31 * result + (name != null ? name.hashCode() : 0);
		  result += result + (cont != null ? cont.hashCode() : 0);
		  result += result + (type != null ? type.hashCode() : 0);
		  return result;
	}
}
