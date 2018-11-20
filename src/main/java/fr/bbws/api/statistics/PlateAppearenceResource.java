package fr.bbws.api.statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;

import com.google.gson.GsonBuilder;

import fr.bbws.api.statistics.mapper.ElasticSearchMapper;
import fr.bbws.api.statistics.model.PlateAppearance;
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
    public Response add(PlateAppearance p_pa) {
    	
    	logger.info("[{}] add the followed plate-appearance {}", "ENTRY", p_pa);
    	
    	try {
    		
			Map<String, Object> result = new TreeMap<String, Object>();
			result = new PlateAppearanceService().add(p_pa);
			String json = new GsonBuilder().create().toJson(result);
			return Response.status(Status.CREATED).entity(json).build();
		
    	} catch (BadRequestException e) {
    		return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (InternalServerErrorException e) {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("search") String p_who, @QueryParam("sort") String p_sort) {

    	// ############## GESTION DES PARAMETRES
    	logger.info("[{}] list all plate-appearance for the player {}", "ENTRY", p_who);
    	logger.info("[{}]                 with the query parameter {}", "ENTRY", p_sort);
    	
    	try {
    		
			List<Object> result = new ArrayList<Object>();
			result = new PlateAppearanceService().list(p_who, p_sort);
			String json = new GsonBuilder().create().toJson(result);
			logger.debug("[{}] @return json = {}", "EXIT", json);
	    	return Response.ok().entity(json).build();
		
    	} catch (BadRequestException e) {
    		return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (InternalServerErrorException e) {
    		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
   }


   @GET 
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/{id}")
   public Response get(@PathParam("id") String p_ID) {
	   
	   	// ############## GESTION DES PARAMETRES
	   	logger.info("[{}] get the plate-appearance with the ID", "ENTRY"); // TODO gerer l'absence de query param
	   	logger.info("[{}] [{}] /pa/{ID} = '{}'", "ENTRY", "@PathParam", p_ID);
	   	
	   	if (StringUtils.isEmpty(p_ID)) {
	   		
	   		logger.info("[{}] @return {} for the ID {}", "EXIT", Status.BAD_REQUEST, p_ID);
		   	return Response.status(Status.BAD_REQUEST).entity("The ID is not valid.").build();
		   	
	   	}
	   	// ############## EXECUTION DE LA REQUETE
    	// parcourir l'index _baseball-eu_
    	// requete exacte sur l'attribut player_id
    	// correspondant au path param de la requete REST
	   	GetResponse responseES = ElasticSearchMapper.getInstance().open()
													   				.prepareGet("baseball-eu", "pa", p_ID).get();

	   	if (responseES.isSourceEmpty()) {
	   		
	   		logger.info("[{}] @return {} for the ID {}", "EXIT", Status.NOT_FOUND, p_ID);
		   	return Response.status(Status.NOT_FOUND).entity("The ressource with the ID " + p_ID + " does not exist.").build();
		   	
	   	} else {
	   		
		   	Map< String, Object> result = new TreeMap< String, Object>();
		   	// attributs principaux
    		result.put("id", "/pa/" + responseES.getId());
			result.put("game", responseES.getSourceAsMap().get("game"));
			result.put("when", responseES.getSourceAsMap().get("when"));
			result.put("what", responseES.getSourceAsMap().get("what"));
			result.put("where", responseES.getSourceAsMap().get("where"));
			result.put("who", responseES.getSourceAsMap().get("who"));
			
			// attributs complémentaires
			result.put("oppositePitcher", responseES.getSourceAsMap().get("opposite_pitcher"));
			result.put("oppositeTeam", responseES.getSourceAsMap().get("opposite_team"));
			result.put("at", responseES.getSourceAsMap().get("field"));
			
		   	// ############## GENERER LE JSon DE SORTIE
		   	String json = new GsonBuilder().create().toJson(result);
	
		   	logger.info("[{}] @return the item {} for the ID {}", "EXIT", json, p_ID);
		   	return Response.ok().entity(json).build();
	   	}
   }
}
