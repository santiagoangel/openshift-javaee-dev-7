package com.github.santiagoangel.openshift.security.authc;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.picketlink.Identity;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.model.Account;

@Path("/login")
public class LoginService {
	
	public static final String USERNAME_PASSWORD_CREDENTIAL_CONTENT_TYPE = "application/x-authc-username-password+json";
    public static final String TOKEN_CONTENT_CREDENTIAL_TYPE = "application/x-authc-token";

    @Inject
    private Identity identity;

    @Inject
    private DefaultLoginCredentials credentials;

    @POST
    @Consumes({USERNAME_PASSWORD_CREDENTIAL_CONTENT_TYPE})
    public Response authenticate(DefaultLoginCredentials credential) {
        if (!this.identity.isLoggedIn()) {
            this.credentials.setUserId(credential.getUserId());
            this.credentials.setPassword(credential.getPassword());
            this.identity.login();
        }

        Account account = this.identity.getAccount();

        return Response.ok().entity(account).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

}
