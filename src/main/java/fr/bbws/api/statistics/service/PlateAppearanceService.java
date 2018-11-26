package fr.bbws.api.statistics.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
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

import fr.bbws.api.statistics.mapper.ElasticSearchMapper;
import fr.bbws.api.statistics.model.PlateAppearance;

public class PlateAppearanceService {

	final static Logger logger = LogManager.getLogger(PlateAppearanceService.class.getName());
	
	public final static String METHOD_ADD = "add";
	
	
	public PlateAppearanceService() {
		// empty constructor
	}
	
	public Map<String, Object> add(PlateAppearance p_pa) 
			throws BadRequestException, InternalServerErrorException {
		
		logger.info("[{}] @p_pa = {}", "add", p_pa);
		
		// DEBUT -- vérification des paramètres d'entrée
		if ( p_pa == null) {
			throw new BadRequestException("The JSON must not be empty.");
		}
				
		if ( StringUtils.isBlank(p_pa.getState())) {
			throw new InternalServerErrorException("The property 'state' must not be null or empty.");
		}
		
		if ( StringUtils.isBlank(p_pa.getGame())) {
			throw new BadRequestException("The property 'game' must not be null or empty.");
		}
		
		if ( StringUtils.isBlank(p_pa.getWhen())) {
			throw new BadRequestException("The property 'when' must not be null or empty.");
		}

		if ( StringUtils.isBlank(p_pa.getWho())) {
			throw new BadRequestException("The property 'who' must not be null or empty.");
		}
		
		if ( null == p_pa.getWhere()) {
			throw new BadRequestException("The property 'where' is not valid. Please read the documentation to know which values are allowed.");
		}

		if ( null == p_pa.getWhat()) {
			throw new BadRequestException("The property 'what' is not valid. Please read the documentation to know which values are allowed.");
		}
		// FIN -- vérification des paramètres d'entrée
		
		
    	Map<String, Object> result = new TreeMap<String, Object>();
		
    	// attributs techniques
		result.put("created", LocalDateTime.now().toString());
		result.put("state", p_pa.getState());
				
		// attributs obligatoires
		result.put("game",  p_pa.getGame());
		result.put("when", p_pa.getWhen());
		result.put("what",  p_pa.getWhat());
		result.put("where",  p_pa.getWhere());
		result.put("who",  p_pa.getWho());
		
		// attributs optionnels
		result.put("field",  p_pa.getField());
		result.put("umpire_id",  p_pa.getUmpireID());
		result.put("opposite_pitcher",  p_pa.getOppositePitcher());
		result.put("opposite_team", p_pa.getOppositeTeam());
		result.put("field_position",  p_pa.getFieldPosition());
		result.put("batting_order",   p_pa.getBattingOrder());
		result.put("team", p_pa.getTeam());
		
		logger.debug("[{}] {}", "add", "Envoi du JSON a ElasticSearch");
		logger.debug("     [IN] = {}", result);
		
		IndexResponse responseES = ElasticSearchMapper.getInstance().open()
				.prepareIndex("baseball-eu", "pa").setSource(result, XContentType.JSON).get();

		if (StringUtils.isNotBlank(responseES.getId())) {
			
			result.put("id", "/pa/" + responseES.getId());
			logger.debug("     [OUT] = ID {}", Status.OK, "/pa/" + responseES.getId());
			
		} else {
			
			logger.error("     [OUT] = {}", "Response from database is null or not valid.");
			throw new InternalServerErrorException("Response from database is null or not valid.");
			
		}
		
		logger.info("[{}] @return = {}", "add", result);
    	return result;
	}
	

	public List<Object> list(String p_who, String p_sort) 
			throws BadRequestException, InternalServerErrorException {
		
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
													   				.prepareSearch("baseball-eu")
													   				.setTypes("pa")
													   		        .setSearchType(SearchType.DEFAULT)
													   		        .setQuery(QueryBuilders.matchQuery("who", p_who))
													   		        .addSort("created", sort)
													   		        .setFrom(0).setSize(100).setExplain(true)
													   		        .get();

    	// ############## PARCOURIR LE RESULTAT DE LA REQUETE
    	SearchHits hits = responseES.getHits();
    	
    	if ( null == responseES.getHits()) {
    		throw new InternalServerErrorException("Response from database is null or not valid.");
    	}
    	
    	for (SearchHit _hit : hits) {
    		logger.debug("    [OUT] = {}", _hit.getSourceAsMap());
    		logger.debug("            /pa/{ID} = {}", "/pa/" + _hit.getId());
    		
    		Map< String, Object> _result = new TreeMap< String, Object>();
    		// attributs principaux only
    		_result.put("id", "/pa/" + _hit.getId());
    		_result.put("game", _hit.getSourceAsMap().get("game"));
    		_result.put("when", _hit.getSourceAsMap().get("when"));
    		_result.put("what", _hit.getSourceAsMap().get("what"));
    		_result.put("where", _hit.getSourceAsMap().get("where"));
    		_result.put("who", _hit.getSourceAsMap().get("who"));
    		results.add(_result);
    	}

    	logger.info("[{}] @return = {}", "list", results);
    	return results;
	}
	
	
	public Map< String, Object> get(String p_ID)
		throws NotFoundException {
		
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
													   				.prepareGet("baseball-eu", "pa", p_ID).get();

	   	if (responseES.isSourceEmpty()) {
	   		
	   		logger.error("[{}] @return {} for the ID {}", "EXIT", Status.NOT_FOUND, p_ID);
		   	throw new NotFoundException("The resource with the ID /pa/" + p_ID + " does not exist.");
		   	
	   	} else {
	   		
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
			
	   	}

	   	logger.info("[{}] @return {}", "get", result);
		return result;
	}
}
