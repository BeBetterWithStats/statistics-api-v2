package fr.bbws.api.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.GsonBuilder;

import fr.bbws.api.statistics.error.BadRequestException;
import fr.bbws.api.statistics.error.InternalErrorException;
import fr.bbws.api.statistics.error.NotFoundException;
import fr.bbws.api.statistics.service.PlateAppearanceService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/api/pa")
public class PlateAppearenceResource {

	final static Logger logger = LogManager.getLogger(PlateAppearenceResource.class.getName());
	    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Map<String, Object> p_pa) {
    	
    	logger.info("[{}] add the followed plate-appearance {}", "ENTRY", p_pa);
    	
    	try {
    		
			Map<String, Object> result = new TreeMap<String, Object>();
			result = new PlateAppearanceService().add(p_pa);
			String json = new GsonBuilder().create().toJson(result);
			return Response.status(Status.CREATED).entity(json)
					.header("Access-Control-Allow-Origin", "*")
					.build();
		
    	} catch (BadRequestException e) {
    		return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (InternalErrorException e) {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("search") String p_who, @QueryParam("sort") String p_sort) {

    	logger.info("[{}] list all plate-appearance for the player {}", "ENTRY", p_who);
    	logger.info("[{}]                 with the query parameter {}", "ENTRY", p_sort);
    	
    	try {
    		
			List<Object> result = new ArrayList<Object>();
			result = new PlateAppearanceService().list(p_who, p_sort);
			String json = new GsonBuilder().create().toJson(result);
			logger.debug("[{}] @return json = {}", "EXIT", json);
	    	return Response.ok().entity(json)
	    			.header("Access-Control-Allow-Origin", "*")
					.build();
		
    	} catch (BadRequestException e) {
    		return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (InternalErrorException e) {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
   }


   @GET 
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/{id}")
   public Response get(@PathParam("id") String p_ID) {
	   
	   	logger.info("[{}] get the plate-appearance", "ENTRY");
	   	logger.info("[{}]    with the @PathParam = '{}'", "ENTRY", p_ID);
	   	
	   	try {
    		
	   		Map< String, Object> result = new HashMap<>();
			result = new PlateAppearanceService().get(p_ID);
			String json = new GsonBuilder().create().toJson(result);
			logger.debug("[{}] @return json = {}", "EXIT", json);
	    	return Response.ok().entity(json)
	    			.header("Access-Control-Allow-Origin", "*")
					.build();
		
    	} catch (BadRequestException e) {
    		return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (NotFoundException e) {
    		return Response.status(Status.NOT_FOUND).entity(e.getMessage()).build();
		}
   }
}
