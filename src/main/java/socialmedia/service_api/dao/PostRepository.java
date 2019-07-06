package socialmedia.service_api.dao;

import java.util.List;

import socialmedia.service_api.exception.SocialMediaServiceException;
import socialmedia.service_api.model.Post;

public interface PostRepository {

	/* have added ServiceException only because when accessing actually database 
	 * your back data layer can generate exception so wrapping into our service exception 
	 * only single exception going from service
	 *
	 */
	public Post addPost(Post p) throws SocialMediaServiceException;
	public List<Post> getRecentFeedByUser(String userId) throws SocialMediaServiceException;
}
