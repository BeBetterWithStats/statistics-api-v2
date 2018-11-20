package fr.bbws.api.statistics;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.bbws.api.statistics.mapper.ElasticSearchMapper;

/**
 * Root resource (exposed at "api" path)
 */
@Path("/api")
public class WelcomeResource {

	final static Logger logger = LogManager.getLogger(WelcomeResource.class.getName());
		
	
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String welcome() {
    	ElasticSearchMapper.getInstance().open();
    	return "Welcome to the Be Better With Stats API !";
    }
}
