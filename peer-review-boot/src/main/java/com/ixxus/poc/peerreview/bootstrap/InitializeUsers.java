package com.ixxus.poc.peerreview.bootstrap;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeUsers {

	@Bean
	public InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

		return new InitializingBean() {
			public void afterPropertiesSet() throws Exception {

                // install groups & users
				Group reviewers = identityService.newGroup("reviewer");
				reviewers.setName("reviewers");
				reviewers.setType("security-role");
				identityService.saveGroup(reviewers);
			
                User vilmosz = identityService.newUser("vilmosz");
                vilmosz.setFirstName("Vilmos");
                vilmosz.setLastName("Zsombori");
                vilmosz.setPassword("password");
                vilmosz.setEmail("vilmos.zsombori@ixxus.com");
                identityService.saveUser(vilmosz);

                User rich = identityService.newUser("rich");
                rich.setFirstName("Rich");
                rich.setLastName("Hart");
                rich.setPassword("password");
                rich.setEmail("rich.hart@ixxus.com");
                identityService.saveUser(rich);

                identityService.createMembership(vilmosz.getId(), reviewers.getId());
                identityService.createMembership(rich.getId(), reviewers.getId());								
			}
		};
	}

}
