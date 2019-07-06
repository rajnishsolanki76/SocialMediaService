package socialmedia.service_api.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import socialmedia.service_api.dao.impl.PostRepositoryImpl;
import socialmedia.service_api.response.ServiceResponse;

@RestController
@RequestMapping("/fol")
public class FollowerController {

	private static Logger log = LogManager.getLogger();

	@PutMapping
	@RequestMapping("/{follower}/follow/{followee}")
	public @ResponseBody ServiceResponse follow(@PathVariable(value = "follower") String followerId,
			@PathVariable(value = "followee") String followeeId) {
		log.info("Inside Follow Unfollow Method");
		ServiceResponse response = new ServiceResponse();
		if (StringUtils.isEmpty(followerId)) {
			response.setStatus(false);
			response.setMessage("FollowerID is either null or empty");
			response.setError("Validation Error");
			return response;
		} else if (StringUtils.isEmpty(followeeId)) {
			response.setStatus(false);
			response.setMessage("FolloweeID is either null or empty");
			response.setError("Validation Error");
			return response;
		}

		if (PostRepositoryImpl.followerMap.containsKey(followerId)) {
			Set<String> followeeList = PostRepositoryImpl.followerMap.get(followerId);
			if (followeeList != null) {
				followeeList.add(followeeId);
			}

		} else {
			Set<String> followeeL = new HashSet<String>();
			followeeL.add(followeeId);
			PostRepositoryImpl.followerMap.putIfAbsent(followerId, followeeL);
		}
		response.setStatus(true);
		response.setMessage("Follower" + followerId + " following " + followeeId);
		return response;
	}

	@PutMapping
	@RequestMapping("/{follower}/unfollow/{followee}")
	public @ResponseBody ServiceResponse unfollow(@PathVariable(value = "follower") String followerId,
			@PathVariable(value = "followee") String followeeId) {

		ServiceResponse response = new ServiceResponse();
		if (StringUtils.isEmpty(followerId)) {
			response.setStatus(false);
			response.setMessage("FollowerID is either null or empty");
			response.setError("Validation Error");
			return response;
		} else if (StringUtils.isEmpty(followeeId)) {
			response.setStatus(false);
			response.setMessage("FolloweeID is either null or empty");
			response.setError("Validation Error");
			return response;
		}

		if (PostRepositoryImpl.followerMap.containsKey(followerId)) {
			Set<String> followeeList = PostRepositoryImpl.followerMap.get(followerId);
			if (followeeList.remove(followeeId)) {
				response.setStatus(true);
				response.setMessage("Follower" + followerId + " unfollowed " + followeeId);
			} else {
				response.setStatus(false);
				response.setMessage("Unable to find followee in follower " + followeeId);
			}
		} else {
			response.setStatus(false);
			response.setMessage("Unable to find follower " + followerId);
		}
		return response;
	}
}
