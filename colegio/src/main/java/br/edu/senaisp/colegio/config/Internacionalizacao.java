package br.edu.senaisp.colegio.config;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import br.edu.senaisp.colegio.ColegioApplication;

import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class Internacionalizacao {
	
	Logger log = LoggerFactory.getLogger(
			ColegioApplication.class);
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messSource = 
				new ReloadableResourceBundleMessageSource();
		messSource.setBasename("classpath:message");
		messSource.setDefaultEncoding("ISO-8859-1");
		messSource.setDefaultLocale(new Locale("en", "US"));
		log.info("Info");
		log.warn("Warn");
		log.error("Error");
		log.debug("Debug");
		log.trace("Trace");
		
		return messSource;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver locResolver 
		   = new AcceptHeaderLocaleResolver();
		locResolver.setDefaultLocale(
				          new Locale("en", "US"));
		return locResolver;
	}
	

}
