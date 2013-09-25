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
}
