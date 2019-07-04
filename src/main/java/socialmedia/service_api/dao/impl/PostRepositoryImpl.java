package socialmedia.service_api.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import socialmedia.service_api.dao.PostRepository;
import socialmedia.service_api.enums.PostMode;
import socialmedia.service_api.exception.SocialMediaServiceException;
import socialmedia.service_api.model.Comment;
import socialmedia.service_api.model.Post;

@Repository
public class PostRepositoryImpl implements PostRepository
{
	public static ConcurrentMap<Long,Post> postCollection = new ConcurrentHashMap<Long,Post>(); 
	private final static int LIMIT_SIZE = 20;
	
	public static ConcurrentMap<String, List<String>> followerMap = new ConcurrentHashMap<String, List<String>>();

	static {
		followerMap.putIfAbsent("rajnish", Arrays.asList("shivanshu", "arpan"));
		followerMap.putIfAbsent("arpan", Arrays.asList(""));
		followerMap.putIfAbsent("shivanshu", Arrays.asList("arpan"));
	}
	
	/*
	 * Creating static data for service.
	 */
	
	static{
		Post p1 = new Post(1, "First Sample Post", "rajnish", new Date(), PostMode.PUBLIC);
		p1.setLastUpdatedOn(new Date());
		postCollection.put(Long.valueOf(1), p1);
		Post p = new Post(2, "First Sample Post", "shivanshu21", new Date(), PostMode.PUBLIC);
		Comment ct = new Comment("2#23","rajnish","good article",new Date());
		p.getComments().add(ct);
		p.getLikedBy().add("rajnish");
		Calendar cal  = Calendar.getInstance();
		cal.set(2019, 4, 8);
		p.setLastUpdatedOn(cal.getTime());
		postCollection.put(Long.valueOf(2), p);
		Post p3 = new Post(3, "First Sample Post", "arpanrocks", new Date(), PostMode.PUBLIC);
		p3.setLastUpdatedOn(new Date());
		postCollection.put(Long.valueOf(3), p3);
	}
	
	@Override
	public boolean addPost(Post p) throws SocialMediaServiceException {
		boolean success = false;
		try{
			if(!postCollection.containsKey(p.getId())){
				postCollection.put(p.getId(), p);
				success = true;
			}
		}catch(Exception ex){
			throw new SocialMediaServiceException(ex.getMessage(), ex.getCause());
		}
		return success;
	}

	@Override
	public List<Post> getRecentFeedByUser(String userId) throws SocialMediaServiceException {
		if(userId !=null){
			List<Post> postList  = new ArrayList<Post>(postCollection.values());
			postList.sort((Post p1 , Post p2) -> p1.getLastUpdatedOn().compareTo(p2.getLastUpdatedOn()));
			Stream<Post> publicPostList = postList.stream().filter(e-> !PostMode.PRIVATE.equals(e.getPostMode()));
			List<String> followeeList = followerMap.get(userId);
			return publicPostList.filter(e-> userId.equals(e.getCreatedBy()) || followeeList.contains(e.getCreatedBy()))
					.limit(LIMIT_SIZE)
					.collect(Collectors.toList());
			
		}
		return null;
	}

}
