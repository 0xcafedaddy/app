package com.uflowertv.resource;

import org.glassfish.jersey.server.ResourceConfig;

public class RestJaxRsApplication extends ResourceConfig{

	/**
	 * Register JAX-RS application components.
	 */
	public RestJaxRsApplication() {
        packages("com.uflowertv.resource");
	}
}
