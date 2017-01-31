package com.github.santiagoangel.openshift;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.picketlink.annotations.PicketLink;

public class Resources {
	
	@Produces
    @PersistenceContext
    private EntityManager em;
    
    @Produces
    @PicketLink
    public EntityManager getPicketLinkEntityManager() {
        return em;
    }

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    @Named
    @Produces
    @RequestScoped
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    
    
    
    

}
