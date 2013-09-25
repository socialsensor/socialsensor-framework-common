package eu.socialsensor.framework.common.services;

import java.util.Iterator;
import java.util.Set;

import eu.socialsensor.framework.common.domain.dysco.Dysco;
import eu.socialsensor.framework.common.domain.Item;

/**
 * DyscoMaintainer is in charge of the following operations:
 * (a) identify sets of DySCOs that refer to the same story/event 
 * (b) merge sets of DySCOs
 * (c) update DySCOs on the addition of new Posts
 * @author papadop
 *
 */
public interface DyscoMaintainer {

	/**
	 * 
	 * @param dyscoIterator
	 * @return An Iterator over sets of DySCOs where each set
	 * refer to the same story/event.
	 */
	public Iterator<Set<Dysco>> findOverlappingDyscos(Iterator<Dysco> dyscoIterator);
	
	/**
	 * TODO: Define whether the implementation should take care of replacing the input DySCOs with the resulting merged DySCO in the DySCO repository.
	 * @param overlappingDyscos DySCOs to merge.
	 * @return Merged Dysco.
	 */
	public Dysco mergeDyscos(Set<Dysco> overlappingDyscos);
	
	
	/**
	 * Updates the DySCO attributes depending on the newly added Posts.
	 * @param dysco
	 * @param newlyAssignedPosts
	 * @return
	 */
	public Dysco update(Dysco dysco, Iterator<Item> newlyAssignedPosts);
	
}
