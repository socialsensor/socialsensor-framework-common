package eu.socialsensor.framework.common.domain;

/**
 * A user account in an online community site. It has the same semantics as sioc:UserAccount.
 * A UserAccount is an online account of a member of an online community. 
 * It is connected to Items and Posts that a UserAccount creates or edits, 
 * to Containers and Forums that it is subscribed to or moderates and to 
 * Sites that it administers. UserAccounts can be grouped for purposes 
 * of allowing access to certain Forums or enhanced community site 
 * features (weblogs, webmail, etc.).
 * A foaf:Person will normally hold a registered UserAccount 
 * on a Site (through the property foaf:account), and will use this 
 * account to create content and interact with the community. 
 * The foaf:Person can hold multiple sioc:UserAccounts.
 * sioc:UserAccount describes properties of an online account, 
 * and is used in combination with a foaf:Person (using the property 
 * sioc:account_of) which describes information about the individual themselves.
 * @see <a href="http://rdfs.org/sioc/spec/#sec-modules-types">SIOC module types</a>.
 * @author papadop
 *
 */

public class Contributor {

	// name of the user account (sioc:name)
	private String name;
	
	// URL pointing to a visual depiction (image) for the user account
	private String avatar;
	
	// email of the user account
	private String email;
	
	
	public Contributor(String name) {
		this.name = name;
                
	}
	
	public Contributor(String name, String avatar){
		this(name);
		this.avatar = avatar;
	}
	
	public Contributor(String name, String avatar, String email){
		this(name, avatar);
		this.email = email;
	}

	/**
	 * 
	 * @return Name of the user account.
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * 
	 * @return URL of an image depicting the user account.
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * 
	 * @param avatar URL of an image depicting the user account.
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * 
	 * @return Email associated with the user account.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email Email associated with the user account.
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	
}
