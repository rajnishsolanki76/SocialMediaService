package socialmedia.service_api.test.controller;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import socialmedia.service_api.controller.PostController;
import socialmedia.service_api.dao.PostRepository;
import socialmedia.service_api.enums.PostMode;
import socialmedia.service_api.exception.SocialMediaServiceException;
import socialmedia.service_api.model.Post;
@RunWith(SpringJUnit4ClassRunner.class)
@Import(value = {SocialMediaTestConfiguration.class})
public class PostControllerTest {
	
	private PostController postController;
	
	@Autowired
	private PostRepository postRepository;
	
	@Test
	public void testCreatePost() {
		Post p = new Post("45","test Post","uu",new Date(),PostMode.PUBLIC);
		try {
			Mockito.when(postRepository.addPost(p)).thenReturn(p);
			Object actual = postController.createPost("uu", "45", "testing ng");
			
		} catch (Exception e) {
			 Assert.assertTrue(e instanceof SocialMediaServiceException);
		}
	}

	@Test
	public void testGetNewsFeed() {
	}

}
