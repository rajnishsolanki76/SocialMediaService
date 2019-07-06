package socialmedia.service_api.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class PostRepositoryImpl implements PostRepository {
	public static ConcurrentMap<String, Post> postCollection = new ConcurrentHashMap<String, Post>();
	private final static int LIMIT_SIZE = 20;

	public static ConcurrentMap<String, Set<String>> followerMap = new ConcurrentHashMap<String, Set<String>>();

	static {
		Set<String> followeeList = new HashSet<String>();
		followeeList.add("shivanshu");
		followeeList.add("arpan");
		followerMap.putIfAbsent("rajnish", followeeList);
		followerMap.putIfAbsent("arpan", new HashSet<String>());
		Set<String> followeeList1 = new HashSet<String>();
		followeeList.add("arpan");
		followerMap.putIfAbsent("shivanshu", followeeList1);
	}

	/*
	 * Creating static data for service.
	 */

	static {
		Post p1 = new Post("1", "First Sample Post", "rajnish", new Date(), PostMode.PUBLIC);
		p1.setLastUpdatedOn(new Date());
		p1.setStatus(true);
		postCollection.put(p1.getId(), p1);
		Post p = new Post("2", "First Sample Post", "shivanshu", new Date(), PostMode.PUBLIC);
		Comment ct = new Comment("2#23", "rajnish", "good article", new Date());
		p.getComments().add(ct);
		p.getLikedBy().add("rajnish");
		Calendar cal = Calendar.getInstance();
		cal.set(2019, 4, 8);
		p.setLastUpdatedOn(cal.getTime());
		p.setStatus(true);
		postCollection.put(p.getId(), p);
		Post p3 = new Post("3", "First Sample Post", "arpan", new Date(), PostMode.PUBLIC);
		p3.setLastUpdatedOn(new Date());
		p3.setStatus(true);
		postCollection.put(p3.getId(), p3);
	}

	@Override
	public Post addPost(Post p) throws SocialMediaServiceException {
		try {
			if (!postCollection.containsKey(p.getId())) {
				postCollection.put(p.getId(), p);
			}
			p = postCollection.get(p.getId());
			p.setStatus(true);
		} catch (Exception ex) {
			throw new SocialMediaServiceException(ex.getMessage(), ex.getCause());
		}
		return p;
	}

	@Override
	public List<Post> getRecentFeedByUser(String userId) throws SocialMediaServiceException {
		if (userId != null) {
			List<Post> postList = new ArrayList<Post>(postCollection.values());
			postList.sort((Post p1, Post p2) -> p1.getLastUpdatedOn().compareTo(p2.getLastUpdatedOn()));
			Stream<Post> publicPostList = postList.stream().filter(e -> !PostMode.PRIVATE.equals(e.getPostMode()));
			Set<String> followeeList = followerMap.get(userId);
			publicPostList = publicPostList != null ? publicPostList
					.filter(e -> userId.equals(e.getCreatedBy()) || (followeeList !=null && followeeList.contains(e.getCreatedBy()))) : null;
			postList = publicPostList != null ? publicPostList.limit(LIMIT_SIZE).collect(Collectors.toList()) : null;
			return postList;

		}
		return null;
	}
}
