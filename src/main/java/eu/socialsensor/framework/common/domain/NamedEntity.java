/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.socialsensor.framework.common.domain;

/**
 * This class represents a named entity (could be a location, person or organization)
 * @author gpetkos
 */
public class NamedEntity {
    private String name;
    public static enum NE_TYPE{LOCATION,PERSON,ORGANIZATION};
    private NE_TYPE neType;
    private int pos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NE_TYPE getNeType() {
        return neType;
    }

    public void setNeType(NE_TYPE neType) {
        this.neType = neType;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    
    
}
