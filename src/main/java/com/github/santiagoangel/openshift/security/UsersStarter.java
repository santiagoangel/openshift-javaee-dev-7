package com.github.santiagoangel.openshift.security;

import static org.picketlink.idm.model.basic.BasicModel.grantRole;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;

@Singleton
@Startup
public class UsersStarter {

	@Inject
	private Logger logger;

	@Inject
	private PartitionManager partitionManager;

	@PostConstruct
	public void create() {

		try {
			provisionUsers();
		} catch (Exception e) {
			logger.info("PROVISION NOT EXECUTED. MAYBE USERS ALREADY EXIST OR IO ERROR.");
		}

	}

	private void provisionUsers() {

		IdentityManager identityManager = this.partitionManager.createIdentityManager();

		User test = new User("test");

		test.setEmail("test@santiagoangel.github.io");
		test.setFirstName("Test");
		test.setLastName("User");

		identityManager.add(test);
		identityManager.updateCredential(test, new Password("test"));

		User admin = new User("admin");

		admin.setEmail("admin@santiagoangel.github.io");
		admin.setFirstName("Admin");
		admin.setLastName("User");

		identityManager.add(admin);
		identityManager.updateCredential(admin, new Password("admin"));

		// Create role "ROLE_USER"
		Role ROLE_USER = new Role("ROLE_USER");
		identityManager.add(ROLE_USER);

		// Create application role "ROLE_ADMIN"
		Role ROLE_ADMIN = new Role("ROLE_ADMIN");
		identityManager.add(ROLE_ADMIN);

		RelationshipManager relationshipManager = this.partitionManager.createRelationshipManager();

		// Grant the "ROLE_USER" application role to test
		grantRole(relationshipManager, test, ROLE_USER);

		// Grant the "ROLE_ADMIN" application role to admin
		grantRole(relationshipManager, admin, ROLE_ADMIN);

	}

}
