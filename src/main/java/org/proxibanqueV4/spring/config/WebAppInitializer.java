package org.proxibanqueV4.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebConfig.class);

		// manage the lifecycle of rootcontext
		servletContext.addListener(new ContextLoaderListener(rootContext));

		DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);

		//mets ici le filtre
//		DelegatingFilterProxy filter=new DelegatingFilterProxy("springSecurityFilterChain");
		
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		
//		servletContext.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, false, "/");

		//charge l'instance 1 ds servlet qd commence
		registration.setLoadOnStartup(1);
		
		//servlet prend en compte tt
		registration.addMapping("/");
			
		
	}

}
