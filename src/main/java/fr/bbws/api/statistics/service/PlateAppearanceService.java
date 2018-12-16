package fr.bbws.api.statistics.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;

import fr.bbws.api.statistics.error.BadRequestException;
import fr.bbws.api.statistics.error.InternalErrorException;
import fr.bbws.api.statistics.error.NotFoundException;
import fr.bbws.api.statistics.mapper.ElasticSearchMapper;

public class PlateAppearanceService {

	final static Logger logger = LogManager.getLogger(PlateAppearanceService.class.getName());
	
	public final static String JSON_ATTRIBUT_CREATED = "created";
	public final static String JSON_ATTRIBUT_STATE = "state";
	public final static String JSON_ATTRIBUT_ID = "id";
	
	public final static String JSON_ATTRIBUT_GAME = "game";
	public final static String JSON_ATTRIBUT_WHAT = "what";
	public final static String JSON_ATTRIBUT_WHERE = "where";
	public final static String JSON_ATTRIBUT_WHO = "who";
	public final static String JSON_ATTRIBUT_WHEN = "when";
	
	public final static String JSON_ATTRIBUT_FIELD = "at";
	public final static String JSON_ATTRIBUT_UMPIRE = "umpire";
	public final static String JSON_ATTRIBUT_OPPOSITE_PITCHER = "oppositePitcher";
	public final static String JSON_ATTRIBUT_OPPOSITE_TEAM = "oppositeTeam";
	public final static String JSON_ATTRIBUT_FIELD_POSITION = "fieldPosition";
	public final static String JSON_ATTRIBUT_BATTING_ORDER = "battingOrder";
	public final static String JSON_ATTRIBUT_TEAM = "team";
	
	public final static String ES_CONFIG_INDEX = "baseball-eu";
	public final static String ES_CONFIG_TYPE = "pa";
	public final static String ES_ATTRIBUT_CREATED = "created";
	public final static String ES_ATTRIBUT_STATE = "state";
	public final static String ES_ATTRIBUT_ID = "id";
	
	public final static String ES_ATTRIBUT_GAME = "game";
	public final static String ES_ATTRIBUT_WHAT = "what";
	public final static String ES_ATTRIBUT_WHERE = "where";
	public final static String ES_ATTRIBUT_WHO = "who";
	public final static String ES_ATTRIBUT_WHEN = "when";
	
	public final static String ES_ATTRIBUT_FIELD = "field";
	public final static String ES_ATTRIBUT_UMPIRE = "umpire";
	public final static String ES_ATTRIBUT_OPPOSITE_PITCHER = "opposite_pitcher";
	public final static String ES_ATTRIBUT_OPPOSITE_TEAM = "opposite_team";
	public final static String ES_ATTRIBUT_FIELD_POSITION = "field_position";
	public final static String ES_ATTRIBUT_BATTING_ORDER = "batting_order";
	public final static String ES_ATTRIBUT_TEAM = "team";
	
	
	public PlateAppearanceService() {
		// empty constructor
	}
	
	public Map<String, Object> add(Map<String, Object> p_pa) 
			throws BadRequestException, InternalErrorException {
		
		logger.info("[{}] @p_pa = {}", "add", p_pa);
		
		// DEBUT -- vérification des paramètres d'entrée
		if ( p_pa == null) {
			throw new BadRequestException("The JSON must not be empty.");
		}
				
		if ( !p_pa.containsKey(JSON_ATTRIBUT_STATE)
				|| !(p_pa.get(JSON_ATTRIBUT_STATE) instanceof String) 
				|| StringUtils.isBlank( (String) p_pa.get(JSON_ATTRIBUT_STATE))) {
			throw new InternalErrorException("The property '" + JSON_ATTRIBUT_STATE + "' must not be null or empty.");
		}
		
		if ( !p_pa.containsKey(JSON_ATTRIBUT_GAME)
				|| !(p_pa.get(JSON_ATTRIBUT_GAME) instanceof String) 
				|| StringUtils.isBlank( (String) p_pa.get(JSON_ATTRIBUT_GAME))) {
			throw new BadRequestException("The property '" + JSON_ATTRIBUT_GAME + "' must not be null or empty.");
		}
		
		if ( !p_pa.containsKey(JSON_ATTRIBUT_WHEN)
				&& !(p_pa.get(JSON_ATTRIBUT_WHEN) instanceof String) 
				&& StringUtils.isBlank( (String) p_pa.get(JSON_ATTRIBUT_WHEN))) {
			throw new BadRequestException("The property '" + JSON_ATTRIBUT_WHEN + "' must not be null or empty.");
		}

		if ( !p_pa.containsKey(JSON_ATTRIBUT_WHO)
				|| !(p_pa.get(JSON_ATTRIBUT_WHO) instanceof String) 
				|| StringUtils.isBlank( (String) p_pa.get(JSON_ATTRIBUT_WHO))) {
			throw new BadRequestException("The property '" + JSON_ATTRIBUT_WHO + "' must not be null or empty.");
		}
		
		if ( !p_pa.containsKey(JSON_ATTRIBUT_WHERE)
				|| !(p_pa.get(JSON_ATTRIBUT_WHERE) instanceof String) 
				|| StringUtils.isBlank( (String) p_pa.get(JSON_ATTRIBUT_WHERE))) {
			throw new BadRequestException("The property '" + JSON_ATTRIBUT_WHERE + "' is not valid. Please read the documentation to know which values are allowed.");
		}

		if ( !p_pa.containsKey(JSON_ATTRIBUT_WHAT)
				|| !(p_pa.get(JSON_ATTRIBUT_WHAT) instanceof String) 
				|| StringUtils.isBlank( (String) p_pa.get(JSON_ATTRIBUT_WHAT))) {
			throw new BadRequestException("The property '" + JSON_ATTRIBUT_WHAT + "' is not valid. Please read the documentation to know which values are allowed.");
		}
		// FIN -- vérification des paramètres d'entrée
		
		
    	Map<String, Object> result = new TreeMap<String, Object>();
		
    	// attributs techniques
		result.put(ES_ATTRIBUT_CREATED, LocalDateTime.now().toString());
		result.put(ES_ATTRIBUT_STATE, p_pa.get(JSON_ATTRIBUT_STATE));
				
		// attributs obligatoires
		result.put(ES_ATTRIBUT_GAME, p_pa.get(JSON_ATTRIBUT_GAME));
		result.put(ES_ATTRIBUT_WHEN, p_pa.get(JSON_ATTRIBUT_WHEN));
		result.put(ES_ATTRIBUT_WHAT, p_pa.get(JSON_ATTRIBUT_WHAT));
		result.put(ES_ATTRIBUT_WHERE, p_pa.get(JSON_ATTRIBUT_WHERE));
		result.put(ES_ATTRIBUT_WHO, p_pa.get(JSON_ATTRIBUT_WHO));
		
		// attributs optionnels
		result.put(ES_ATTRIBUT_FIELD, p_pa.get(JSON_ATTRIBUT_FIELD));
		result.put(ES_ATTRIBUT_UMPIRE, p_pa.get(JSON_ATTRIBUT_UMPIRE));
		result.put(ES_ATTRIBUT_OPPOSITE_PITCHER, p_pa.get(JSON_ATTRIBUT_OPPOSITE_PITCHER));
		result.put(ES_ATTRIBUT_OPPOSITE_TEAM, p_pa.get(JSON_ATTRIBUT_OPPOSITE_TEAM));
		result.put(ES_ATTRIBUT_FIELD_POSITION, p_pa.get(JSON_ATTRIBUT_FIELD_POSITION));
		result.put(ES_ATTRIBUT_BATTING_ORDER, p_pa.get(JSON_ATTRIBUT_BATTING_ORDER));
		result.put(ES_ATTRIBUT_TEAM, p_pa.get(JSON_ATTRIBUT_TEAM));
		
		logger.debug("[{}] {}", "add", "Envoi du JSON a ElasticSearch");
		logger.debug("     [IN] = {}", result);
		
		IndexResponse responseES = ElasticSearchMapper.getInstance().open()
				.prepareIndex("baseball-eu", "pa").setSource(result, XContentType.JSON).get();

		if (StringUtils.isNotBlank(responseES.getId())) {
			
			result.put("id", "/pa/" + responseES.getId());
			logger.debug("     [OUT] = ID {}", Status.OK, "/pa/" + responseES.getId());
			
		} else {
			
			logger.error("     [OUT] = {}", "Response from database is null or not valid.");
			throw new InternalErrorException("Response from database is null or not valid.");
			
		}
		
		logger.info("[{}] @return = {}", "add", result);
    	return result;
	}
	

	public List<Object> list(String p_who, String p_sort) 
			throws BadRequestException, InternalErrorException {
		
		logger.info("[{}] @p_who = {}", "list", p_who);
		logger.info("[{}] @p_sort = '{}'", "list", p_sort);
    	
		// DEBUT -- vérification des paramètres d'entrée
		if (StringUtils.isBlank(p_who)) {
			throw new BadRequestException("Player's name must not be null or empty.");
		}
		
		SortOrder sort = SortOrder.DESC;
    	if (StringUtils.isNotEmpty(p_sort)) {
    		if ( "asc".equalsIgnoreCase(p_sort) // si &sort=asc
    			|| " created".equalsIgnoreCase(p_sort) // ou si &sort=+created
    			|| "created".equalsIgnoreCase(p_sort) // ou si &sort=created
    			|| "asc(created)".equalsIgnoreCase(p_sort) // ou si &sort=asc(created)
    			|| "created.asc".equalsIgnoreCase(p_sort)) { // ou si &sort=created.asc
    			sort = SortOrder.ASC;
    		} else {
    			throw new BadRequestException("Value for the sort parameter is not valid. Please check documentation.");
    		}
    	} // else {sort = SortOrder.DESC;}
    	// FIN -- vérification des paramètres d'entrée
		

		List<Object> results = new ArrayList<Object>(); // the ES search result
		
    	// ############## EXECUTION DE LA REQUETE
    	// parcourir l'index _baseball-eu_
    	// requete exacte sur l'attribut _palyer-id_
    	// correspondant au parametre de la requete REST
		logger.debug("    [IN] = {}", p_who);
		SearchResponse responseES = ElasticSearchMapper.getInstance().open()
													   				.prepareSearch(ES_CONFIG_INDEX)
													   				.setTypes(ES_CONFIG_TYPE)
													   		        .setSearchType(SearchType.DEFAULT)
													   		        .setQuery(QueryBuilders.matchQuery(ES_ATTRIBUT_WHO, p_who))
													   		        .addSort(ES_ATTRIBUT_CREATED, sort)
													   		        .setFrom(0).setSize(100).setExplain(true)
													   		        .get();

    	// ############## PARCOURIR LE RESULTAT DE LA REQUETE
    	SearchHits hits = responseES.getHits();
    	
    	if ( null == responseES.getHits()) {
    		throw new InternalErrorException("Response from database is null or not valid.");
    	}
    	
    	for (SearchHit _hit : hits) {
    		logger.debug("    [OUT] = {}", _hit.getSourceAsMap());
    		logger.debug("            /pa/{ID} = {}", "/pa/" + _hit.getId());
    		
    		Map< String, Object> _result = new TreeMap< String, Object>();
    		// attributs principaux only
    		_result.put(JSON_ATTRIBUT_ID, "/pa/" + _hit.getId());
    		_result.put(JSON_ATTRIBUT_GAME, _hit.getSourceAsMap().get(ES_ATTRIBUT_GAME));
    		_result.put(JSON_ATTRIBUT_WHEN, _hit.getSourceAsMap().get(ES_ATTRIBUT_WHEN));
    		_result.put(JSON_ATTRIBUT_WHAT, _hit.getSourceAsMap().get(ES_ATTRIBUT_WHAT));
    		_result.put(JSON_ATTRIBUT_WHERE, _hit.getSourceAsMap().get(ES_ATTRIBUT_WHERE));
    		_result.put(JSON_ATTRIBUT_WHO, _hit.getSourceAsMap().get(ES_ATTRIBUT_WHO));
    		results.add(_result);
    	}

    	logger.info("[{}] @return = {}", "list", results);
    	return results;
	}
	
	
	public Map< String, Object> get(String p_ID)
		throws NotFoundException, BadRequestException {
		
		logger.info("[{}] @p_ID = {}", "get", p_ID);
    	
		// DEBUT -- vérification des paramètres d'entrée
		if (StringUtils.isEmpty(p_ID)) {
			throw new BadRequestException("ID must not be null or empty.");
		}
		// FIN -- vérification des paramètres d'entrée
		
		Map< String, Object> result = new TreeMap< String, Object>();
		
		// ############## EXECUTION DE LA REQUETE
    	// parcourir l'index _baseball-eu_
    	// correspondant au path param de la requete REST
	   	GetResponse responseES = ElasticSearchMapper.getInstance().open()
													   				.prepareGet(ES_CONFIG_INDEX, ES_CONFIG_TYPE, p_ID).get();

	   	if (responseES.isSourceEmpty()) {
	   		
	   		logger.error("[{}] @return {} for the ID {}", "EXIT", Status.NOT_FOUND, p_ID);
		   	throw new NotFoundException("The resource with the ID /pa/" + p_ID + " does not exist.");
		   	
	   	} else {
	   		
		   	// attributs principaux
    		result.put(JSON_ATTRIBUT_ID, "/pa/" + responseES.getId());
			result.put(JSON_ATTRIBUT_GAME, responseES.getSourceAsMap().get(ES_ATTRIBUT_GAME));
			result.put(JSON_ATTRIBUT_WHEN, responseES.getSourceAsMap().get(ES_ATTRIBUT_WHEN));
			result.put(JSON_ATTRIBUT_WHAT, responseES.getSourceAsMap().get(ES_ATTRIBUT_WHAT));
			result.put(JSON_ATTRIBUT_WHERE, responseES.getSourceAsMap().get(ES_ATTRIBUT_WHERE));
			result.put(JSON_ATTRIBUT_WHO, responseES.getSourceAsMap().get(ES_ATTRIBUT_WHO));
			
			// attributs complémentaires
			result.put(JSON_ATTRIBUT_OPPOSITE_PITCHER, responseES.getSourceAsMap().get(ES_ATTRIBUT_OPPOSITE_PITCHER));
			result.put(JSON_ATTRIBUT_OPPOSITE_TEAM, responseES.getSourceAsMap().get(ES_ATTRIBUT_OPPOSITE_TEAM));
			result.put(JSON_ATTRIBUT_FIELD, responseES.getSourceAsMap().get(ES_ATTRIBUT_FIELD));
			
	   	}

	   	logger.info("[{}] @return {}", "get", result);
		return result;
	}
}
