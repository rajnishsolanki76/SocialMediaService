package socialmedia.service_api.test.controller;

import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import socialmedia.service_api.dao.PostRepository;
import socialmedia.service_api.dao.impl.PostRepositoryImpl;

@SpringJUnitConfig
public class SocialMediaTestConfiguration {

	public PostRepository postRepository(){
		return Mockito.mock(PostRepositoryImpl.class);
	}
}
