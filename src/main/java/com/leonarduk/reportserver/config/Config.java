/**
 * Config
 *
 * @author ${author}
 * @since 07-Aug-2016
 */
package com.leonarduk.reportserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * replace dispatcher-servlet.xml and this from from WEB-INF/web.xml
 *
 * <context-param> <param-name>contextConfigLocation</param-name>
 * <param-value>/WEB-INF/dispatcher-servlet.xml</param-value> </context-param>
 *
 */
@Configuration       // Marks this class as configuration
// Specifies which package to scan
@ComponentScan("com.leonarduk.reportserver")
// Enables Spring's annotations
@EnableWebMvc
public class Config {

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		final UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
}
