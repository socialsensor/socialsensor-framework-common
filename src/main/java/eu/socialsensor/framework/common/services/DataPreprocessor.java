package eu.socialsensor.framework.common.services;


import eu.socialsensor.framework.common.domain.Item;

/**
 * DataPreprocessor aims at one or both of the following: 
 * (a) transforming an incoming Post to a form that is usable
 * for further analysis either by mining (e.g. DySCO creator) or search components.
 * (b) deciding whether a Post is suitable/worth for further processing (e.g. spam filter). 
 * @author papadop
 *
 */
public interface DataPreprocessor {

	/**
	 * Extract a specific feature from an input Post. The type of feature
	 * and the part of Post content/metadata used for its extraction is fully 
	 * dependent on the implementation of the class.
	 * @param post
	 * @return
	 */
//TODO: extract feature?? 
//    public Feature extractFeature(TwitterStreamUpdate post);
	
	/**
	 * 
	 * @return True if the method extractFeature has been implemented.
	 */
	public boolean canExtractFeature();
	
	
	/**
	 * Decide whether the input Post is spam or not worth further processing.
	 * @param post
	 * @return True if the Post is considered spam or noise.
	 */
	public boolean discardPost(Item post);
	
	
	/**
	 * 
	 * @return True if the method discardPost has been implemented.
	 */
	public boolean canDiscardPost();
}
