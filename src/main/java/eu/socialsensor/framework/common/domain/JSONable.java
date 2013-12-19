
package eu.socialsensor.framework.common.domain;

import java.io.Serializable;


/**
 * 
 * @author etzoannos - e.tzoannos@atc.gr
 */

public interface JSONable extends Serializable {

	// Creates the JSON representation of the object that 
	// implements this interface
    public String toJSONString();
    
}
