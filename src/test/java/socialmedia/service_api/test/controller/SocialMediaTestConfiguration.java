package socialmedia.service_api.test.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import socialmedia.service_api.controller.PostController;
import socialmedia.service_api.dao.PostRepository;
import socialmedia.service_api.dao.impl.PostRepositoryImpl;

@SpringJUnitConfig
public class SocialMediaTestConfiguration {

	@Bean
	public PostController postController() {
		return new PostController();
	}
	
	@Bean
	public PostRepository postRepository() {
		return new PostRepositoryImpl();
	}
	
	
}
