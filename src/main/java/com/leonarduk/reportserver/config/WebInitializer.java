/**
 * WebInitializer
 *
 * @author ${author}
 * @since 07-Aug-2016
 */
package com.leonarduk.reportserver.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Replaces this from WEB-INF/web.xml
 *
 * <servlet> <servlet-name>dispatcher</servlet-name>
 * <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 * <load-on-startup>1</load-on-startup> </servlet>
 *
 * <servlet-mapping> <servlet-name>dispatcher</servlet-name>
 * <url-pattern>/</url-pattern> </servlet-mapping>
 *
 * <listener> <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 * </listener>
 */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException {

		final AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(Config.class);

		ctx.setServletContext(servletContext);

		final Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);

	}

}
