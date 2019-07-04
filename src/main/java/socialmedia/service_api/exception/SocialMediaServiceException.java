package socialmedia.service_api.exception;

public class SocialMediaServiceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 653080146202517487L;
	
	public SocialMediaServiceException() {
		super();
	}
	
	public SocialMediaServiceException(String message) {
		super(message);
	}
	
	public SocialMediaServiceException(String message,Throwable cause) {
		super(message, cause);
	}
	

}
