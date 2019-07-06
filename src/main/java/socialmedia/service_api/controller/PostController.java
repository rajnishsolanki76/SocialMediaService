/**
 * 
 */
package socialmedia.service_api.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import socialmedia.service_api.dao.PostRepository;
import socialmedia.service_api.enums.PostMode;
import socialmedia.service_api.exception.SocialMediaServiceException;
import socialmedia.service_api.model.Post;
import socialmedia.service_api.response.ServiceResponse;

/**
 * @author Rajnish
 *
 */
@RestController
@RequestMapping("/post")
public class PostController {

	private static Logger log = LogManager.getLogger();

	@Autowired
	private PostRepository postRepo;

	@PostMapping(path = "/create", produces = "application/json")
	public @ResponseBody Object createPost(String userId, String postId, String content) {
		log.info("Performing validation for new Post .. ");
		if(StringUtils.isEmpty(userId)){
			ServiceResponse serr = new ServiceResponse();
			serr.setMessage("User Id is either null or empty");
			serr.setStatus(false);
			serr.setError("Validation Error");
			return serr;
		}else if(StringUtils.isEmpty(postId)){
			ServiceResponse serr = new ServiceResponse();
			serr.setMessage("Post Id is either null or empty");
			serr.setStatus(false);
			serr.setError("Validation Error");
			return serr;
		}
		
		log.info("Creating new Post .. ");
		try {
			Post post = new Post(postId, content, userId, new Date(), PostMode.PUBLIC);
			post = postRepo.addPost(post);
			log.info("New Post Created Successfully Post Id - {}, User Id - {} ", postId, userId);
			return post;

		} catch (SocialMediaServiceException sex) {
			ServiceResponse serr = new ServiceResponse();
			serr.setMessage(sex.getMessage());
			serr.setType(sex.getCause().getClass().getName());
			serr.setStatus(false);
			serr.setError("Application Error");
			return serr;
		}
	}	

	@GetMapping(path = "/newfeeds/{userid}", produces = "application/json")
	public @ResponseBody Object getNewsFeed(@PathVariable(value = "userid") String userId) {
		try {
			List<Post> postList = postRepo.getRecentFeedByUser(userId);
			if (postList != null) {
				return postList;
			}
		} catch (SocialMediaServiceException sex) {
			ServiceResponse serr = new ServiceResponse();
			serr.setMessage(sex.getMessage());
			serr.setType(sex.getCause().getClass().getName());
			serr.setStatus(false);
			serr.setError("Application Error");
			return serr;
		}
		return null;
	}

}
