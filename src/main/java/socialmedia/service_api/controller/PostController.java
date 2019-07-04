/**
 * 
 */
package socialmedia.service_api.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import socialmedia.service_api.dao.PostRepository;
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

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public @ResponseBody Object createPost(@RequestBody Post post) {
		/*
		 * Skipping Application related validation
		 */
		try {
			boolean status = postRepo.addPost(post);
			post.setStatus(status);
			return post;
		} catch (SocialMediaServiceException sex) {
			ServiceResponse serr = new ServiceResponse();
			serr.setMessage(sex.getMessage());
			serr.setType(sex.getCause().getClass().getName());
			serr.setStatus(false);
			return serr;
		}
	}

	@GetMapping(path = "/feeds/{id}", produces = "application/json")
	public @ResponseBody Object getRecentFeedPostForUser(@PathParam(value = "id") String userId) {
		ServiceResponse serr = new ServiceResponse();
		try {
			List<Post> postList = postRepo.getRecentFeedByUser(userId);
			if(postList!=null){
				return postList;
			}
			serr.setMessage("No Feeds for User Id : " + userId);
			serr.setStatus(false);
			return serr;
		} catch (SocialMediaServiceException sex) {
			
			serr.setMessage(sex.getMessage());
			serr.setType(sex.getCause().getClass().getName());
			serr.setStatus(false);
			return serr;
		}
		
	}

}
