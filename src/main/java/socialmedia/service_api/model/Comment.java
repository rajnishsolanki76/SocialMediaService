package socialmedia.service_api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Comment {
	
	private String commentID; // Prepared using post ID and comment ID
	
	private String commentedBy;
	
	private String commentMsg;
		
	private List<Comment> chainOfComments = new LinkedList<Comment>();
	
	private Date commentedOn;
	
	private Set<String> likedBy = new HashSet<String>();
	
	private Date lastUpdatedOn;
	

	public Comment(String commentId,String commentBy,String commentMsg,Date commentedOn) {
		this.commentID = commentId;
		this.commentedBy = commentBy;
		this.commentMsg = commentMsg;
		this.commentedOn = commentedOn;
	}
	
	public Comment() {
		
	}

	/**
	 * @return the commentMsg
	 */
	public String getCommentMsg() {
		return commentMsg;
	}

	/**
	 * @param commentMsg the commentMsg to set
	 */
	public void setCommentMsg(String commentMsg) {
		this.commentMsg = commentMsg;
	}

	/**
	 * @return the commentedOn
	 */
	public Date getCommentedOn() {
		return commentedOn;
	}

	/**
	 * @param commentedOn the commentedOn to set
	 */
	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
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
	 * @return the chainOfComments
	 */
	public List<Comment> getChainOfComments() {
		return chainOfComments;
	}

	/**
	 * @return the likedBy
	 */
	public Set<String> getLikedBy() {
		return likedBy;
	}

	/**
	 * @return the commentID
	 */
	public String getCommentID() {
		return commentID;
	}

	/**
	 * @param commentID the commentID to set
	 */
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}

	/**
	 * @return the commentedBy
	 */
	public String getCommentedBy() {
		return commentedBy;
	}

	/**
	 * @param commentedBy the commentedBy to set
	 */
	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}

}
