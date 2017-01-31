package com.github.santiagoangel.openshift.security;

import javax.enterprise.event.Observes;

import org.picketlink.config.HttpSecurityBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

public class HTTPStarter {
	
	public void onInit(@Observes SecurityConfigurationEvent event) {

		HttpSecurityBuilder httpbuilder = event.getBuilder().http();

		httpbuilder.allPaths()
		.forPath("/").unprotected()
		.forPath("/rest/*").unprotected()//public services
		.forPath("/rest/**").unprotected();

	}

}
