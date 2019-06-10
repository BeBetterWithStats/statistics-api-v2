package fr.bbws.api.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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
import fr.bbws.api.statistics.service.PlayerService;

/**
 * Root resource (exposed at "/players" path)
 */
@Path("/api/players")
public class PlayerResource {

	final static Logger logger = LogManager.getLogger(PlayerResource.class.getName());


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Map<String, Object> p_player) {

    	logger.info("[{}] add the followed player {}", "ENTRY", p_player);

    	try {

			Map<String, Object> result = new TreeMap<String, Object>();
			result = new PlayerService().add(p_player);
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
    public Response list(
    		@QueryParam("sort") String p_sort,
    		@QueryParam("limit") int p_size) {

    	logger.info("[{}] list all player", "ENTRY");
    	logger.info("[{}]                 with the query parameter {} {}", "ENTRY", "sort", p_sort);
    	logger.info("[{}]                 with the query parameter {} {}", "ENTRY", "limit", p_size);

    	try {

			Set<Object> result = new TreeSet<Object>();
			result = new PlayerService().list(p_sort, p_size);
			String json = new GsonBuilder().create().toJson(result);
			logger.debug("[{}] @return json = {}", "EXIT", json);
	    	return Response.ok().entity(json)
	    			.header("Access-Control-Allow-Origin", "*")
					.build();

    	} catch (Exception e) {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
   }


   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/{id}")
   public Response get(@PathParam("id") String p_ID) {

	   	logger.info("[{}] get the player", "ENTRY");
	   	logger.info("[{}]    with the @PathParam = '{}'", "ENTRY", p_ID);

	   	try {

	   		Map< String, Object> result = new HashMap<>();
			// result = new PlateAppearanceService().get(p_ID);
			String json = new GsonBuilder().create().toJson(result);
			logger.debug("[{}] @return json = {}", "EXIT", json);
	    	return Response.ok().entity(json)
	    			.header("Access-Control-Allow-Origin", "*")
					.build();

    	} catch (Exception e) {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
   }
}
