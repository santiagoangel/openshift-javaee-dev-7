package com.github.santiagoangel.openshift.security;

import javax.enterprise.inject.Produces;

import org.picketlink.idm.config.IdentityConfiguration;
import org.picketlink.idm.config.IdentityConfigurationBuilder;

public class JPAStarter {
	
	@Produces
	IdentityConfiguration produceIdentityManagementConfiguration() {
		IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();

		builder.named("default").stores().jpa().supportAllFeatures();

		return builder.build();
	}

}
