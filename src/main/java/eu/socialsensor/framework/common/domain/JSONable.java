
package eu.socialsensor.framework.common.domain;

import java.io.Serializable;


/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */

public interface JSONable extends Serializable {

    public String toJSONString();
    
}
