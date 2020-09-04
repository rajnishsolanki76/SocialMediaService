package socialmedia.service_api.test.controller;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import socialmedia.service_api.dao.PostRepository;
import socialmedia.service_api.enums.PostMode;
import socialmedia.service_api.exception.SocialMediaServiceException;
import socialmedia.service_api.model.Post;

@RunWith(SpringRunner.class)
@Import(value = {SocialMediaTestConfiguration.class})
public class PostRepositoryTest {

	@Autowired
	private PostRepository postRepo;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testAddPost_Null() throws SocialMediaServiceException {
		
		thrown.expect(SocialMediaServiceException.class);
		//thrown.expectMessage(null);
		postRepo.addPost(null);
		
	}
	
	
	@Test
	public void testAddPost_Success() throws SocialMediaServiceException {
		
		//thrown.expect(SocialMediaServiceException.class);
		//thrown.expectMessage(null);
		Post p1 = new Post("5", "First Sample Post", "rajnish", new Date(), PostMode.PUBLIC);
		p1.setLastUpdatedOn(new Date());
		p1.setStatus(true);
		
		postRepo.addPost(p1);
		
	}
	
}
