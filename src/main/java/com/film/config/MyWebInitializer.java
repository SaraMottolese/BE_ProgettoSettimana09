package com.film.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	// Classi di configurazione delle servlet e view di Spring
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	//Dichiariamo url del sito
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
