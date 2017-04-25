package com.uflowertv.resource.exception.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uflowertv.util.JsonUtils;

@Provider
public class LoggingResponseFilter
		implements ContainerResponseFilter {

	private static final Logger logger = LoggerFactory.getLogger(LoggingResponseFilter.class);

	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		String method = requestContext.getMethod();

		logger.info("Requesting " + method + " for path " + requestContext.getUriInfo().getPath());
		Object entity = responseContext.getEntity();
		if (entity != null) {
			if(responseContext.getStatus() == 404){
				ObjectMapper instance = JsonUtils.getInstance();
				String json = instance.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
				logger.info("Response " + json);
			}
		}
	}
}