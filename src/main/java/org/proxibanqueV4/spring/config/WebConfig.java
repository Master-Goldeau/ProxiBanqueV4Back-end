package org.proxibanqueV4.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//configuration de la class dispatcher-servlet.xml: config jpaweb

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "org.proxibanqueV4spring" })
@Import({ ApplicationConfig.class })
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

	// pr mapper une url avec un dossier
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// pr brancher angular sur spring: autorise les requetes redirigées
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE");
	}

}
