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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;

import com.google.gson.Gson;
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
    public String getIt() {
    	ElasticSearchMapper.getInstance().open();
    	return "Welcome to the Be Better With Stats API !";
    }
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pa")
    public String list(@QueryParam("search") String p_playerID, @QueryParam("sort") String p_sortOrder) {

    	// ############## GESTION DES PARAMETRES
    	logger.entry("list all plate-appearance for the player {}", p_playerID); // TODO gerer l'absence de query param
    	
    	// Par defaut le tri se fait par ordre decroissant (le plus recent en premier)
    	logger.entry(p_sortOrder);
    	SortOrder sort = SortOrder.DESC;
    	if (p_sortOrder != null && p_sortOrder.length() > 0) {
    		if ( "asc".equalsIgnoreCase(p_sortOrder) // si &sort=asc
    			|| "+created".equalsIgnoreCase(p_sortOrder)) { // ou si &sort=+created
    			sort = SortOrder.ASC;
    		}
    	}
    	
    	
    	
    	
    	List<Object> results = new ArrayList<Object>(); // the ES search result

    	// ############## EXECUTION DE LA REQUETE
    	// parcourir l'index _baseball-eu_
    	// requete exacte sur l'attribut _palyer-id_
    	// correspondant au parametre de la requete REST
    	SearchResponse response = ElasticSearchMapper.getInstance().open()
													   				.prepareSearch("baseball-eu")
													   				.setTypes("pa")
													   		        .setSearchType(SearchType.DEFAULT)
													   		        .setQuery(QueryBuilders.matchQuery("player_id", p_playerID))
													   		        .addSort("created", sort)
													   		        .setFrom(0).setSize(100).setExplain(true)
													   		        .get();

    	
    	// ############## PARCOURIR LE RESULTAT DE LA REQUETE
    	SearchHits hits = response.getHits();
    	for (SearchHit _hit : hits) {
    		logger.debug("Résultat = {}", _hit.getSourceAsMap());
    		logger.debug("      ID = {}", "/pa/" + _hit.getId());
    		
    		Map< String, Object> _result = new TreeMap< String, Object>();
    		_result.put("who", _hit.getSourceAsMap().get("player_id"));
    		_result.put("id", "/pa/" + _hit.getId());
    		_result.put("when", _hit.getSourceAsMap().get("when"));
    		_result.put("what", _hit.getSourceAsMap().get("what"));
    		_result.put("where", _hit.getSourceAsMap().get("where"));
    		results.add(_result);
    	}

    	// ############## GENERER LE JSon DE SORTIE
    	final Gson gson = new GsonBuilder().create();
    	String json = gson.toJson(results);


    	logger.traceExit("@return a list of {} plate-appearance for the player " + p_playerID, response.getHits().getTotalHits());
    	return json;
   }


   @GET 
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/pa/{id}")
   public String get(@PathParam("id") String p_ID) {
	   
	   	// ############## GESTION DES PARAMETRES
   		logger.entry("get the plate-appearance with the ID {}", p_ID); // TODO gerer l'absence de query param
	   	
	   	// ############## EXECUTION DE LA REQUETE
    	// parcourir l'index _baseball-eu_
    	// requete exacte sur l'attribut _palyer-id_
    	// correspondant au parametre de la requete REST
	   	GetResponse response = ElasticSearchMapper.getInstance().open()
													   				.prepareGet("baseball-eu", "pa", p_ID).get();

	   	Map< String, Object> result = new TreeMap< String, Object>();
		result.put("id", "/pa/" + response.getId());
		result.put("when", response.getSourceAsMap().get("when"));
		result.put("what", response.getSourceAsMap().get("what"));
		result.put("where", response.getSourceAsMap().get("where"));
		result.put("who", response.getSourceAsMap().get("player_id"));
		result.put("against", response.getSourceAsMap().get("opposite_team"));
		result.put("day", response.getSourceAsMap().get("day"));
		result.put("at", response.getSourceAsMap().get("field"));
		
	   	// ############## GENERER LE JSon DE SORTIE
	   	final Gson gson = new GsonBuilder().create();
	   	String json = gson.toJson(result);

	   	logger.traceExit("@return the item {} for the ID " + p_ID, json);
	   	return json;
   }
}
