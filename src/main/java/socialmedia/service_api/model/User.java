/**
 * 
 */
package socialmedia.service_api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Rajnish
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5059816846740189425L;
	//Email Id is the primary Key for unique User.
	private String emailID;
	
	private String name;
	
	private String mobileNumber;
	
	private String profilePictureRef;
	
	private Date dob;
	//List of Friends or Connections.
	private Set<String> friends;
	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}
	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
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
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the friends
	 */
	public Set<String> getFriends() {
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Set<String> friends) {
		this.friends = friends;
	}
	/**
	 * @return the profilePictureRef
	 */
	public String getProfilePictureRef() {
		return profilePictureRef;
	}
	/**
	 * @param profilePictureRef the profilePictureRef to set
	 */
	public void setProfilePictureRef(String profilePictureRef) {
		this.profilePictureRef = profilePictureRef;
	}
	
	
	

}
