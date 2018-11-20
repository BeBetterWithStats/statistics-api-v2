package fr.bbws.api.statistics.service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import fr.bbws.api.statistics.mapper.ElasticSearchMapper;
import fr.bbws.api.statistics.model.PlateAppearance;

public class PlateAppearanceService {

	final static Logger logger = LogManager.getLogger(PlateAppearanceService.class.getName());
	
	public final static String METHOD_ADD = "add";
	
	
	public PlateAppearanceService() {
		// empty constructor
	}
	
	public Map<String, Object> add( PlateAppearance p_pa) 
			throws BadRequestException, InternalServerErrorException {
		
		logger.info("[{}] add the followed plate-appearance {}", "ENTRY", p_pa);
		
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
		
		logger.debug("    [IN] = {}", result);
		
		IndexResponse responseES = ElasticSearchMapper.getInstance().open()
				.prepareIndex("baseball-eu", "pa").setSource(result, XContentType.JSON).get();

		if (StringUtils.isNotBlank(responseES.getId())) {
			
			result.put("id", "/pa/" + responseES.getId());
			logger.debug("    [OUT] = ID {}", Status.OK, "/pa/" + responseES.getId());
			
		} else {
			
			logger.error("   [OUT] = {}", "Response from database is null or not valid.");
			throw new InternalServerErrorException("Response from database is null or not valid.");
			
		}
		
		logger.info("[{}] @return = {}", "EXIT", result);
    	return result;
	}
	
}
