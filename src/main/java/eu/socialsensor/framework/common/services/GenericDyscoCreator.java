
package eu.socialsensor.framework.common.services;

import eu.socialsensor.framework.common.domain.Item;
import eu.socialsensor.framework.common.domain.dysco.Dysco;
import java.util.List;

/**
 *
 * @author etzoannos - e.tzoannos@atc.gr
 */
public interface GenericDyscoCreator {
    
    public List<Dysco> createDyscos(List<Item> items);
    
}
