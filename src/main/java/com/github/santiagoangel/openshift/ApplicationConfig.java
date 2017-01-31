package com.github.santiagoangel.openshift;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


import com.github.santiagoangel.openshift.security.authc.LoginService;
import com.github.santiagoangel.openshift.security.authc.LogoutService;


@ApplicationPath("/rest")
public class ApplicationConfig extends Application{
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(LoginService.class);
		resources.add(LogoutService.class);
		
		
	}
	
	@Override
    public Set<Object> getSingletons() {
        return Collections.emptySet();
    }
	
	

}
