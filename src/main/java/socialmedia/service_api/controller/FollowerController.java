package socialmedia.service_api.controller;

import java.util.Arrays;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import socialmedia.service_api.dao.impl.PostRepositoryImpl;
import socialmedia.service_api.response.ServiceResponse;

@RestController
public class FollowerController {

	@PutMapping
	@RequestMapping("{}")
	public @ResponseBody ServiceResponse follow(@PathParam("follower") String followerId, @PathParam("followee") String followeeId) {
		ServiceResponse response   = new ServiceResponse();
		if (PostRepositoryImpl.followerMap.containsKey(followerId)) {
			PostRepositoryImpl.followerMap.get(followerId).add(followeeId);
		} else {
			PostRepositoryImpl.followerMap.putIfAbsent(followerId, Arrays.asList(followeeId));
		}
		response.setStatus(true);
		response.setMessage("Follower" + followerId + " following " + followeeId);
		return response;
	}

	@PutMapping
	@RequestMapping("{}")
	public @ResponseBody ServiceResponse unfollow(@PathParam("follower") String followerId, @PathParam("followee") String followeeId) {

		ServiceResponse response   = new ServiceResponse();
		if (PostRepositoryImpl.followerMap.containsKey(followerId)) {
			
			if(PostRepositoryImpl.followerMap.get(followerId).remove(followeeId)){
				response.setStatus(true);
				response.setMessage("Follower" + followerId + " unfollowed " + followeeId);
			}else{
				response.setStatus(false);
				response.setMessage("Unable to find followee in follower " + followeeId);
			}
		}else{
			response.setStatus(false);
			response.setMessage("Unable to find follower " + followerId);
		}
		return response;
	}
}
