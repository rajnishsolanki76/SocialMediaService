/**
 * 
 */
package socialmedia.service_api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import socialmedia.service_api.enums.PostMode;

/**
 * @author Rajnish
 *
 */
public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1459302010958664238L;
	//Id will be unique post ID. We can use any random generator for generating post ID.
	@NotNull
	private String id;
	private String postContent;
	private String postCaption;
	@NotNull
	private String createdBy;
	@NotNull
	private Date createdOn;
	@NotNull
	private PostMode postMode;
	private List<String> mediaList;
	private Set<String> likedBy = new HashSet<String>();
	private List<Comment> comments =  new LinkedList<Comment>();
	private Date lastUpdatedOn;
	private boolean status;
	
	public Post() {
		
	}
	
	public Post(String id,String postCont,String createdBy,Date createdOn,PostMode mode){
		this.id = id;
		this.postContent = postCont;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.postMode = mode;
		this.lastUpdatedOn = createdOn;
	}
	
	
	/**
	 * @return the postContent
	 */
	public String getPostContent() {
		return postContent;
	}
	/**
	 * @param postContent the postContent to set
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	/**
	 * @return the postCaption
	 */
	public String getPostCaption() {
		return postCaption;
	}
	/**
	 * @param postCaption the postCaption to set
	 */
	public void setPostCaption(String postCaption) {
		this.postCaption = postCaption;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * @return the postMode
	 */
	public PostMode getPostMode() {
		return postMode;
	}
	/**
	 * @param postMode the postMode to set
	 */
	public void setPostMode(PostMode postMode) {
		this.postMode = postMode;
	}
	/**
	 * @return the mediaList
	 */
	public List<String> getMediaList() {
		return mediaList;
	}
	/**
	 * @param mediaList the mediaList to set
	 */
	public void setMediaList(List<String> mediaList) {
		this.mediaList = mediaList;
	}
	/**
	 * @return the likedBy
	 */
	public Set<String> getLikedBy() {
		return likedBy;
	}
	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}
	/**
	 * @return the lastUpdatedOn
	 */
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}
	/**
	 * @param lastUpdatedOn the lastUpdatedOn to set
	 */
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if( obj == null || ! (obj instanceof Post)){
			return false;
		}
		if(obj instanceof Post){
			return this.id.equals(((Post) obj).getId()) ? true : false;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
