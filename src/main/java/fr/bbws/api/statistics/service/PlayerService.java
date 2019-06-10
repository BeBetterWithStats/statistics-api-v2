package fr.bbws.api.statistics.service;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import fr.bbws.api.statistics.mapper.ElasticSearchMapper;

public class PlayerService {

	final static Logger logger = LogManager.getLogger(PlayerService.class.getName());

	public PlayerService() {
		// empty constructor
	}

	public Map<String, Object> add(Map<String, Object> p_player)
			throws BadRequestException, InternalErrorException {
		
		Map<String, Object> result = new TreeMap<String, Object>();
		result.put(ES_ATTRIBUT_WHO, p_player.get(JSON_ATTRIBUT_WHO));
		
		IndexResponse responseES = ElasticSearchMapper.getInstance().open()
				.prepareIndex(ES_CONFIG_INDEX, ES_CONFIG_TYPE).setSource(result, XContentType.JSON).get();

		if (StringUtils.isNotBlank(responseES.getId())) {

			result.put(JSON_ATTRIBUT_ID, "/player/" + responseES.getId());
			result.put(JSON_ATTRIBUT_WHO, p_player.get(JSON_ATTRIBUT_WHO));
			logger.debug("     [OUT] = ID {}", Status.OK, "/player/" + responseES.getId());

		} else {

			logger.error("     [OUT] = {}", "Response from database is null or not valid.");
			throw new InternalErrorException("Response from database is null or not valid.");

		}
		
		logger.info("[{}] @return = {}", "add", result);
    	return result;

	}
	
	public Set<Object> list(String p_sort, int p_size)
			throws BadRequestException, InternalErrorException {

		logger.info("[{}] @p_sort = '{}'", "list", p_sort);
		logger.info("[{}] @p_size = '{}'", "list", p_size);

		// DEBUT -- vérification des paramètres d'entrée
		SortOrder sort = SortOrder.ASC;
    	if (StringUtils.isNotEmpty(p_sort)) {
    		if ( "desc".equalsIgnoreCase(p_sort)) { // si &sort=desc
    			sort = SortOrder.DESC;
    		} else {
    			throw new BadRequestException("Value for the sort parameter is not valid. Please check documentation.");
    		}
    	} // else {sort = SortOrder.ASC;}

    	if (p_size == 0) {
    		p_size = ES_CONFIG_MAX_RESULT;
    	}
    	// FIN -- vérification des paramètres d'entrée


		Set<Object> results = new TreeSet<Object>(); // the ES search result

    	// ############## EXECUTION DE LA REQUETE
    	// parcourir l'index _baseball-eu_
    	// requete tous les résultats
    	// correspondant au parametre de la requete REST
		SearchResponse responseES = ElasticSearchMapper.getInstance().open()
													   				.prepareSearch(ES_CONFIG_INDEX)
													   				.setTypes(ES_CONFIG_TYPE)
													   		        .setSearchType(SearchType.QUERY_THEN_FETCH)
													   		        .setQuery(QueryBuilders.matchAllQuery())
													   		        // .addSort(ES_ATTRIBUT_CREATED, sort)
													   		        .setFrom(0).setSize(p_size).setExplain(true)
													   		        .get();

    	// ############## PARCOURIR LE RESULTAT DE LA REQUETE
    	SearchHits hits = responseES.getHits();

    	if ( null != responseES.getHits()) {

	    	for (SearchHit _hit : hits) {
	    		logger.debug("    [OUT] = {}", _hit.getSourceAsMap());
	    		logger.debug("            /player/{ID} = {}", "/player/" + _hit.getId());

	    		Map< String, Object> _result = new TreeMap< String, Object>();
	    		// attributs principaux only
	    		// _result.put(JSON_ATTRIBUT_WHO, _hit.getSourceAsMap().get(ES_ATTRIBUT_WHO));
	    		// results.add(_result);
	    		results.add( _hit.getSourceAsMap().get(ES_ATTRIBUT_WHO));
	    	}

	    	logger.info("[{}] @return = {}", "list", results);
	    	return results;

    	} else {
    		// en mode list le service elastic search ne renvoit jamais null
    		// sauf en cas d'erreur interne
    		throw new InternalErrorException("Response from database is null or not valid.");
    	}
	}



	public final static String JSON_ATTRIBUT_CREATED = "created";
	public final static String JSON_ATTRIBUT_STATE = "state";
	public final static String JSON_ATTRIBUT_ID = "id";

	public final static String JSON_ATTRIBUT_WHO = "who";
	public final static String JSON_ATTRIBUT_FIELD_POSITION = "fieldPosition";
	public final static String JSON_ATTRIBUT_BATTING_ORDER = "battingOrder";
	public final static String JSON_ATTRIBUT_TEAM = "team";

	public final static String ES_CONFIG_INDEX = "baseball-players";
	public final static String ES_CONFIG_TYPE = "player";
	public final static int ES_CONFIG_MAX_RESULT = 10000;
	
	public final static String ES_ATTRIBUT_CREATED = "created";
	public final static String ES_ATTRIBUT_STATE = "state";
	public final static String ES_ATTRIBUT_ID = "id";

	public final static String ES_ATTRIBUT_WHO = "who";
	public final static String ES_ATTRIBUT_FIELD_POSITION = "field_position";
	public final static String ES_ATTRIBUT_BATTING_ORDER = "batting_order";
	public final static String ES_ATTRIBUT_TEAM = "team";

}
