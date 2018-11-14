package fr.bbws.api.statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.GET;
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
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;

import com.google.gson.GsonBuilder;

import fr.bbws.api.statistics.mapper.ElasticSearchMapper;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/api")
public class StatisticsResource {

	final static Logger logger = LogManager.getLogger(StatisticsResource.class.getName());
		
	
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
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pa")
    public Response list(@QueryParam("search") String p_playerID, @QueryParam("sort") String p_sortOrder) {

    	// ############## GESTION DES PARAMETRES
    	logger.info("[{}] list all plate-appearance for the player {}", "ENTRY", p_playerID);
    	if (StringUtils.isEmpty(p_playerID)) {
    		return Response.status(Status.BAD_REQUEST).entity("A value for the search query parameter is mandatory. Please check documentation.").build();
    	}
    	
    	logger.info("[{}] [{}] ?search = '{}'", "ENTRY", "@QueryParam", p_playerID);
    	
    	// Par defaut le tri se fait par ordre decroissant (le plus recent en premier)
    	logger.info("[{}] [{}] &sort = '{}'", "ENTRY", "@QueryParam", p_sortOrder);
    	SortOrder sort = SortOrder.DESC;
    	if (StringUtils.isNotEmpty(p_sortOrder)) {
    		if ( "asc".equalsIgnoreCase(p_sortOrder) // si &sort=asc
    			|| " created".equalsIgnoreCase(p_sortOrder) // ou si &sort=+created
    			|| "created".equalsIgnoreCase(p_sortOrder) // ou si &sort=created
    			|| "asc(created)".equalsIgnoreCase(p_sortOrder) // ou si &sort=asc(created)
    			|| "created.asc".equalsIgnoreCase(p_sortOrder)) { // ou si &sort=created.asc
    			sort = SortOrder.ASC;
    		} else {
    			return Response.status(Status.BAD_REQUEST).entity("Value for the sort parameter is not valid. Please check documentation.").build();
    			// else {sort = SortOrder.DESC;}
    		}
    	} // else {sort = SortOrder.DESC;}
    	
    	
    	
    	
    	List<Object> results = new ArrayList<Object>(); // the ES search result

    	// ############## EXECUTION DE LA REQUETE
    	// parcourir l'index _baseball-eu_
    	// requete exacte sur l'attribut _palyer-id_
    	// correspondant au parametre de la requete REST
    	SearchResponse responseES = ElasticSearchMapper.getInstance().open()
													   				.prepareSearch("baseball-eu")
													   				.setTypes("pa")
													   		        .setSearchType(SearchType.DEFAULT)
													   		        .setQuery(QueryBuilders.matchQuery("player_id", p_playerID))
													   		        .addSort("created", sort)
													   		        .setFrom(0).setSize(100).setExplain(true)
													   		        .get();

    	
    	// ############## PARCOURIR LE RESULTAT DE LA REQUETE
    	SearchHits hits = responseES.getHits();
    	for (SearchHit _hit : hits) {
    		logger.debug("[{}] @return from ES = {}", "RESPONSE", _hit.getSourceAsMap());
    		logger.debug("           /pa/{ID} = {}", "/pa/" + _hit.getId());
    		
    		Map< String, Object> _result = new TreeMap< String, Object>();
    		_result.put("who", _hit.getSourceAsMap().get("player_id"));
    		_result.put("id", "/pa/" + _hit.getId());
    		_result.put("when", _hit.getSourceAsMap().get("when"));
    		_result.put("what", _hit.getSourceAsMap().get("what"));
    		_result.put("where", _hit.getSourceAsMap().get("where"));
    		results.add(_result);
    	}

    	// ############## GENERER LE JSon DE SORTIE
    	String json = new GsonBuilder().create().toJson(results);

    	logger.info("[{}] @return a list of {} plate-appearance for the player {}", "EXIT", responseES.getHits().getTotalHits(), p_playerID);
    	return Response.ok().entity(json).build();
   }


   @GET 
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/pa/{id}")
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
			result.put("id", "/pa/" + responseES.getId());
			result.put("when", responseES.getSourceAsMap().get("when"));
			result.put("what", responseES.getSourceAsMap().get("what"));
			result.put("where", responseES.getSourceAsMap().get("where"));
			result.put("who", responseES.getSourceAsMap().get("player_id"));
			result.put("against", responseES.getSourceAsMap().get("opposite_team"));
			result.put("day", responseES.getSourceAsMap().get("day"));
			result.put("at", responseES.getSourceAsMap().get("field"));
			
		   	// ############## GENERER LE JSon DE SORTIE
		   	String json = new GsonBuilder().create().toJson(result);
	
		   	logger.info("[{}] @return the item {} for the ID {}", "EXIT", json, p_ID);
		   	return Response.ok().entity(json).build();
	   	}
   }
}
