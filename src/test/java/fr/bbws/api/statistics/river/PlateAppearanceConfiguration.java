package fr.bbws.api.statistics.river;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import fr.bbws.api.statistics.model.Play;
import fr.bbws.api.statistics.model.Position;

/**
 * Singleton thread safe
 * (se referer a l'article de JM Doudoux https://www.jmdoudoux.fr/java/dej/chap-design-patterns.htm)
 * permettant de charger la configuration lie a l'outil de scorage
 */
public class PlateAppearanceConfiguration {
   
    /** Constructeur prive */  
    private PlateAppearanceConfiguration(){
    }
     
    /** Holder */
    private static class GameSheetConfigurationHolder {       
        /** Instance unique non preinitialisee */
        private final static PlateAppearanceConfiguration instance = new PlateAppearanceConfiguration();
    }
 
    /** Point d'acces pour l'instance unique du singleton */
    public static PlateAppearanceConfiguration getInstance() {
        return GameSheetConfigurationHolder.instance;
    }
	
    public boolean shouldPositionBeEmpty(String p_play) {
    	
    	
    	if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("advanced to")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("failed pickoff")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("hit by pitch")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("intentionally walked")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("no advance")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("- On the same play -")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("out at home")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("out at third")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("out at second")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("out on batter's interference")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("out on double play")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("out on the play")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("picked off")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("pinch hit")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("pinch ran")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("placed on first")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("placed on second")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("scored")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("stole")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("struck out")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("walked")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("to ")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("/")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("visit to")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("coach visit")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("Coach visit")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("Coaching visit")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("out by rule")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("indifference")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("foul ball,")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("time asked during defensive conference")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("the same play")) {
    		return true;
    	} else if ( StringUtils.isNotEmpty(p_play) && p_play.startsWith("set to")) {
    		return true;
    	}
    	
    	return false;
    }
    
    /** return all batted baseballs by hitters */
    public Map<String, Position> loadAllPositions() {

    	Map<String, Position> positions = new HashMap<String, Position>();
    	

    	positions.put("/ ", Position.EMPTY);

    	positions.put("- obr _ Infield fly not caught ", Position.EMPTY);
    	
//    	_map.put("advanced to ", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to home on a fielder's choice.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a balk", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a balk.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a fielder's choice", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a fielder's choice.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a fielding error by 2b.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a fielding error by ss", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a fielding error by ss, advanced to third on the error.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a fielding error by ss.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by 1b, failed pickoff attempt.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by 2b, assist by 3b, advanced to third on the error", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by 2b, assist by 3b.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by 2b, assist by p", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by 2b, assist by p, advanced to third on the error.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by 2b, assist by ss", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by 2b, assist by ss.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by ss, assist by 2b.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a muffed throw by ss, assist by c 1b 2b", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a passed ball", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a passed ball, advanced to third on a fielder's choice", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a passed ball, advanced to third on a throwing error by c.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a passed ball.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by 1b, advanced to third on the error", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by 1b, advanced to third on the error.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by 2b", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by 2b.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by 3b", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by 3b, advanced to third on the error.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by c", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by c, failed pickoff attempt", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by c.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by p", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by p, advanced to third on the error.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by p, failed pickoff attempt", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by p, failed pickoff attempt.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by p.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by ss", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a throwing error by ss.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a wild pitch", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on a wild pitch.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on an error by 2b, assist by 3b.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on an error by lf.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on the error", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on the error.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second on the throw", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on a fielding error by 2b.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on a fielding error by cf", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on a fielding error by rf", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on a muffed throw by 3b, assist by rf.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on a throwing error by 1b.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on a throwing error by c, out at home cf to c.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on a throwing error by cf", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on a wild pitch.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on the error", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on the error.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on the throw", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, advanced to third on the throw, scored on a throwing error by cf", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to second, out at second lf to ss.", Play.RUNNER_OUT_AT_SECOND);  // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third 2b to c to 3b", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third 2b to ss to 3b.", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third c to 3b", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third c to 3b to c", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third cf to 2b to 3b.", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third cf to c to 3b", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third lf to 3b", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third lf to 3b.", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third rf to 3b", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third rf to 3b to p", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out at third rf to 3b.", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out on the play, assist by 1b 3b 2b p.", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out on the play, assist by c", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, out on the play.", Play.RUNNER_OUT_AT_SECOND); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, scored on the error", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, scored on the error, unearned", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second, scored on the error, unearned.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to second.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a balk", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a balk.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a fielder's choice", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a fielding error by p.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a muffed throw by 3b, assist by c, caught stealing.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a passed ball", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a passed ball, advanced to home on a fielder's choice, unearned.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a passed ball.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a throwing error by c.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a throwing error by cf.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a throwing error by p, failed pickoff attempt.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a throwing error by p, out at home ss to c.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a throwing error by p.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a throwing error by rf.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a wild pitch", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a wild pitch, out at home c to p.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on a wild pitch.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on an error by p.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on the error", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on the error, scored on a throwing error by c, unearned", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on the error, scored on a throwing error by cf, unearned", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on the error.", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third on the throw", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third, advanced to home on a fielder's choice", Play.RUNNER_ADVANCE);
//    	_map.put("advanced to third, out at home 1b to c to 3b to c.", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home 3b to c", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home c to 3b to c.", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home cf to c", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home cf to c.", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home lf to 3b to p.", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home lf to ss to c.", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home rf to 1b to c", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home rf to c", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home rf to c.", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at home rf to p.", Play.RUNNER_OUT_AT_HOME); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out at third cf to ss to 3b.", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out on double play rf to c to ss.", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out on the play, assist by 1b", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, out on the play.", Play.RUNNER_OUT_AT_THIRD); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a fielding error by c", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a fielding error by cf, unearned", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a fielding error by lf.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a fielding error by ss.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a muffed throw by c.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a throwing error by 2b.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a throwing error by cf", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a throwing error by p.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a throwing error by rf, unearned.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a throwing error by rf.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a throwing error by ss", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on a throwing error by ss, unearned.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on an error by c, assist by ss, unearned.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on the error", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on the error, unearned", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on the error, unearned.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third, scored on the error.", Play.SCORE); // TODO g�rer ce cas particulier
//    	_map.put("advanced to third.", Play.RUNNER_ADVANCE);
    	
    	positions.put("doubled", Position.UNLOCATED_BATTED_BALL);
    	positions.put("doubled down the lf line", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (0-0).", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (0-1 F)", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (0-1 F).", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (0-1 K)", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (0-1 K).", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (0-2 KK).", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (0-2 SS).", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (1-0 B).", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (1-1 BF)", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (1-1 BK)", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (2-0 BB)", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (2-1 BKB).", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (2-1 KBB)", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line (3-2 FKBBBF)", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line, advanced to third on the throw (2-1 BBK)", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line, ground-rule", Position.LEFT_FIELD);
    	positions.put("doubled down the lf line.", Position.LEFT_FIELD);
    	positions.put("doubled down the rf line", Position.RIGHT_FIELD);
    	positions.put("doubled down the rf line (1-0 B)", Position.RIGHT_FIELD);
    	positions.put("doubled down the rf line (1-0 B).", Position.RIGHT_FIELD);
    	positions.put("doubled down the rf line (1-1 KB)", Position.RIGHT_FIELD);
    	positions.put("doubled down the rf line (1-2 KBK)", Position.RIGHT_FIELD);
    	positions.put("doubled down the rf line (2-1 BFB)", Position.RIGHT_FIELD);
    	positions.put("doubled down the rf line (3-1 BBKB).", Position.RIGHT_FIELD);
    	positions.put("doubled down the rf line, ground-rule.", Position.RIGHT_FIELD);
    	positions.put("doubled down the rf line.", Position.RIGHT_FIELD);
    	positions.put("doubled through the left side", Position.LEFT_FIELD);
    	positions.put("doubled through the left side (1-0 B)", Position.LEFT_FIELD);
    	positions.put("doubled through the left side.", Position.LEFT_FIELD);
    	positions.put("doubled to center field", Position.CENTER_FIELD);
    	positions.put("doubled to center field (0-0)", Position.CENTER_FIELD);
    	positions.put("doubled to center field (0-1 F)", Position.CENTER_FIELD);
    	positions.put("doubled to center field (1-1 KB).", Position.CENTER_FIELD);
    	positions.put("doubled to center field (3-2 BBKBK).", Position.CENTER_FIELD);
    	positions.put("doubled to center field (3-2 BBSBF)", Position.CENTER_FIELD);
    	positions.put("doubled to center field, advanced to third on the throw", Position.CENTER_FIELD);
    	positions.put("doubled to center field, advanced to third on a fielding error by cf (1-0 B).", Position.CENTER_FIELD);
    	positions.put("doubled to center field, ground-rule", Position.CENTER_FIELD);
    	positions.put("doubled to center field, ground-rule (1-2 KFB).", Position.CENTER_FIELD);
    	positions.put("doubled to center field, out at third cf to ss to 3b.", Position.CENTER_FIELD); // TODO
    	positions.put("doubled to center field, scored on a fielding error by cf, unearned.", Position.CENTER_FIELD);
    	positions.put("doubled to center field.", Position.CENTER_FIELD);
    	positions.put("doubled to left center", Position.LEFT_FIELD);
    	positions.put("doubled to left center (0-0)", Position.LEFT_FIELD);
    	positions.put("doubled to left center (0-1 K)", Position.LEFT_FIELD);
    	positions.put("doubled to left center (1-1 KB)", Position.LEFT_FIELD);
    	positions.put("doubled to left center (2-2 KBBS)", Position.LEFT_FIELD);
    	positions.put("doubled to left center, ground-rule", Position.LEFT_FIELD);
    	positions.put("doubled to left center, ground-rule (1-1 FB).", Position.LEFT_FIELD);
    	positions.put("doubled to left center.", Position.LEFT_FIELD);
    	positions.put("doubled to left field", Position.LEFT_FIELD);
    	positions.put("doubled to left field (0-0)", Position.LEFT_FIELD);
    	positions.put("doubled to left field (0-1 K)", Position.LEFT_FIELD);
    	positions.put("doubled to left field (1-2 KBFF).", Position.LEFT_FIELD);
    	positions.put("doubled to left field (3-2 BBBKFF)", Position.LEFT_FIELD);
    	positions.put("doubled to left field, advanced to third on the throw", Position.LEFT_FIELD);
    	positions.put("doubled to left field, ground-rule", Position.LEFT_FIELD);
    	positions.put("doubled to left field, ground-rule.", Position.LEFT_FIELD);
    	positions.put("doubled to left field, out at third lf to ss to 3b.", Position.LEFT_FIELD); // TODO g�rer ce cas particulier
    	positions.put("doubled to left field.", Position.LEFT_FIELD);
    	positions.put("doubled to right center", Position.RIGHT_FIELD);
    	positions.put("doubled to right center (0-0)", Position.RIGHT_FIELD);
    	positions.put("doubled to right center (0-0).", Position.RIGHT_FIELD);
    	positions.put("doubled to right center (0-1 K)", Position.RIGHT_FIELD);
    	positions.put("doubled to right center (2-1 BBK).", Position.RIGHT_FIELD);
    	positions.put("doubled to right center (3-1 BBFB).", Position.RIGHT_FIELD);
    	positions.put("doubled to right center (3-2 BKBBF)", Position.RIGHT_FIELD);
    	positions.put("doubled to right center (3-2 KBFBB).", Position.RIGHT_FIELD);
    	positions.put("doubled to right center.", Position.RIGHT_FIELD);
    	positions.put("doubled to right field", Position.RIGHT_FIELD);
    	positions.put("doubled to right field (1-2 BKFF)", Position.RIGHT_FIELD);
    	positions.put("doubled to right field (2-0 BB).", Position.RIGHT_FIELD);
    	positions.put("doubled to right field (2-2 KBBKF)", Position.RIGHT_FIELD);
    	positions.put("doubled to right field, ground-rule", Position.RIGHT_FIELD);
    	positions.put("doubled to right field.", Position.RIGHT_FIELD);
    	positions.put("doubled to shortstop", Position.SHORTSTOP);
    	positions.put("doubled, ground-rule.", Position.UNLOCATED_BATTED_BALL);
    	
//    	_map.put("failed pickoff attempt", Play.NO_PLAY);
//    	_map.put("failed pickoff attempt, advanced to second on a throwing error by c, advanced to third on the error.", Play.RUNNER_ADVANCE); // TODO g�rer ce cas particulier
//    	_map.put("failed pickoff attempt, advanced to third on a throwing error by p.", Play.RUNNER_ADVANCE); // TODO g�rer ce cas particulier
//    	_map.put("failed pickoff attempt.", Play.NO_PLAY);
    	
    	positions.put("flied into double play ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("flied into double play cf to c", Position.CENTER_FIELD);
    	positions.put("flied into double play cf to 1b", Position.CENTER_FIELD);
    	positions.put("flied into double play cf to 2b to 1b", Position.CENTER_FIELD);
    	positions.put("flied into double play cf to 3b", Position.CENTER_FIELD);
    	positions.put("flied into double play cf to ss to 2b", Position.CENTER_FIELD);
    	positions.put("flied into double play cf unassisted", Position.CENTER_FIELD);
    	positions.put("flied into double play lf to 2b", Position.LEFT_FIELD);
    	positions.put("flied into double play lf to c", Position.LEFT_FIELD);
    	positions.put("flied into double play lf to c to 3b to 2b", Position.LEFT_FIELD);
    	positions.put("flied into double play lf to ss to 1b", Position.LEFT_FIELD);
    	positions.put("flied into double play lf unassisted", Position.LEFT_FIELD);
    	positions.put("flied into double play rf to 1b", Position.RIGHT_FIELD);
    	positions.put("flied into double play rf to 2b to 3b", Position.RIGHT_FIELD);
    	positions.put("flied into double play rf to 3b to 2b", Position.RIGHT_FIELD);
    	positions.put("flied into double play rf to ss", Position.RIGHT_FIELD);
    	positions.put("flied into double play lf unassisted", Position.RIGHT_FIELD);
    	
    	positions.put("flied out to ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("flied out to 1b.", Position.FIRST_BASE);
    	positions.put("flied out to 2b", Position.SECOND_BASE);
    	positions.put("flied out to 2b (0-0).", Position.SECOND_BASE);
    	positions.put("flied out to 2b (0-1 F).", Position.SECOND_BASE);
    	positions.put("flied out to 2b (1-1 BK).", Position.SECOND_BASE);
    	positions.put("flied out to 2b (1-2 BFF).", Position.SECOND_BASE);
    	positions.put("flied out to 2b (1-2 KBK).", Position.SECOND_BASE);
    	positions.put("flied out to 2b.", Position.SECOND_BASE);
    	positions.put("flied out to 3b (0-0).", Position.THIRD_BASE);
    	positions.put("flied out to 3b (2-2 KBBK).", Position.THIRD_BASE);
    	positions.put("flied out to 3b.", Position.THIRD_BASE);
    	positions.put("flied out to c, bunt.", Position.CATCHER);
    	positions.put("flied out to c.", Position.CATCHER);
    	positions.put("flied out to cf", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-0).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-1 F).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-1 K)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-1 K).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-1 S)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-1 S).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-2 FF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-2 KF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-2 KFFF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-2 KK).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-2 KSF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (0-2 SF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-0 B).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-1 BF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-1 BK)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-1 BK).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-1 BS).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-1 FB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-1 KB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-2 BSF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-2 BSS).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-2 FBF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-2 FSB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-2 KBKF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-2 KFB)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (1-2 KFBF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-0 BB)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-0 BB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-1 BBK)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-1 BKB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-1 KBB)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-1 KBB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-2 BBFF)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-2 BBFS).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-2 BBKF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-2 BKFBF)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-2 BSSBF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-2 BSSBFFF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-2 KBKBF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (2-2 KKBFBF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-1 KBBB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 BBBKK).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 BFBBS).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 BFKBB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 BKBBF)", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 BKBBK).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 BKSBB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 BSBSB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 KBFBBF).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 KBSBB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf (3-2 KBSBFFB).", Position.CENTER_FIELD);
    	positions.put("flied out to cf.", Position.CENTER_FIELD);
    	positions.put("flied out to lf",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (0-0)",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (0-0).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (0-1 F)",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (0-1 K).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (0-2 KS).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (0-2 SK).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (1-0 B).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (1-1 FB)",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (1-1 FB).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (1-1 KB).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (1-2 FBF).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (1-2 KBK).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (1-2 KKB).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (1-2 KSB).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-0 BB)",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-0 BB).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-1 BBS).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-1 BFB).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-1 BKB).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-1 FBB).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-2 BSBF).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-2 KBBF).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (2-2 SBKFBF).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (3-2 BBKBK).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf (3-2 BKBBK).",  Position.LEFT_FIELD);
    	positions.put("flied out to lf.",  Position.LEFT_FIELD);
    	positions.put("flied out to p.", Position.PITCHER);
    	positions.put("flied out to p (0-0).", Position.PITCHER);
    	positions.put("flied out to rf", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-0)", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-0).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-1 F).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-1 K).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-1 S).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-2 KF)", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-2 KFF).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-2 KSFF).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (0-2 SK).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-0 B)", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-0 B).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-1 BF).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-1 BK).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-1 BS).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-1 FB)", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-1 FB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-1 KB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-2 BKF).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-2 FFB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-2 KBF).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-2 KFB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-2 KKB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-2 KKBF).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (1-2 KSB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-0 BB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-1 BBK).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-1 BFB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-1 BKB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-1 FBB)", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-1 KBB)", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-1 KBB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-2 BBFS).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-2 FBBF).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-2 FBFB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-2 KBBK).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (2-2 KBBS).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (3-1 BBBK).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (3-1 BBFB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (3-1 KBBB)", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (3-1 KBBB).", Position.RIGHT_FIELD);
    	positions.put("flied out to rf (3-2 BBFBF)", Position.RIGHT_FIELD);
    	positions.put("flied out to rf.", Position.RIGHT_FIELD);
    	positions.put("flied out to ss (0-0).", Position.SHORTSTOP);
    	positions.put("flied out to ss (0-1 F).", Position.SHORTSTOP);
    	positions.put("flied out to ss (0-1 K).", Position.SHORTSTOP);
    	positions.put("flied out to ss (1-0 B).", Position.SHORTSTOP);
    	positions.put("flied out to ss (1-2 FKB).", Position.SHORTSTOP);
    	positions.put("flied out to ss (2-0 BB).", Position.SHORTSTOP);
    	positions.put("flied out to ss (2-1 BBK).", Position.SHORTSTOP);
    	positions.put("flied out to ss (2-2 KSBB).", Position.SHORTSTOP);
    	positions.put("flied out to ss (3-1 BBBK).", Position.SHORTSTOP);
    	positions.put("flied out to ss (3-2 BKBSB).", Position.SHORTSTOP);
    	positions.put("flied out to ss.", Position.SHORTSTOP);
    	
    	positions.put("fouled into double play ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("fouled into double play 1b to 3b", Position.FIRST_BASE);
    	positions.put("fouled into double play 1b to c", Position.FIRST_BASE);
    	positions.put("flied into double play 2b to ss", Position.SECOND_BASE);
    	
    	positions.put("fouled out to ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("fouled out to 1b", Position.FIRST_BASE);
    	positions.put("fouled out to 1b (0-0).", Position.FIRST_BASE);
    	positions.put("fouled out to 1b (0-1 F).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (0-1 K).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (0-2 FK).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (0-2 KK).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (1-0 B).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (1-1 BF).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (1-1 BK).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (1-1 KB).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (1-2 BKF).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (1-2 SFFBFF).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (2-0 BB).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (2-2 KFBB).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (3-2 KFFBBB).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b (0-1 S).",Position.FIRST_BASE);
    	positions.put("fouled out to 1b.",Position.FIRST_BASE);
    	positions.put("fouled out to 2b (2-1 KBB).",Position.SECOND_BASE);
    	positions.put("fouled out to 2b.",Position.SECOND_BASE);
    	positions.put("fouled out to 3b",Position.THIRD_BASE);
    	positions.put("fouled out to 3b (1-0 B).",Position.THIRD_BASE);
    	positions.put("fouled out to 3b (1-1 KB).",Position.THIRD_BASE);
    	positions.put("fouled out to 3b (3-2 KBBBF).",Position.THIRD_BASE);
    	positions.put("fouled out to 3b (3-2 KBBFFB).",Position.THIRD_BASE);
    	positions.put("fouled out to 3b.",Position.THIRD_BASE);
    	positions.put("fouled out to c (0-2 KK).", Position.CATCHER);
    	positions.put("fouled out to c (1-1 KB).", Position.CATCHER);
    	positions.put("fouled out to c (2-1 BKB).", Position.CATCHER);
    	positions.put("fouled out to c (2-1 SBB).", Position.CATCHER);
    	positions.put("fouled out to c.", Position.CATCHER);
    	positions.put("fouled out to lf (2-1 BBK)", Position.LEFT_FIELD);
    	positions.put("fouled out to lf (3-2 KBKBB).", Position.LEFT_FIELD);
    	positions.put("fouled out to lf.", Position.LEFT_FIELD);
    	positions.put("fouled out to p.", Position.PITCHER);
    	positions.put("fouled out to rf.", Position.RIGHT_FIELD);
    	positions.put("fouled out to ss.", Position.THIRD_BASE);
    	
    	positions.put("grounded into double play ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("grounded into double play 1b to ss", Position.FIRST_BASE);
    	positions.put("grounded into double play 1b to ss to 1b", Position.FIRST_BASE);
    	positions.put("grounded into double play 2b to 1b", Position.SECOND_BASE);
    	positions.put("grounded into double play 2b to 1b (0-1 K)", Position.SECOND_BASE);
    	positions.put("grounded into double play 2b to ss to 1b", Position.SECOND_BASE);
    	positions.put("grounded into double play 2b to ss to 1b (1-1 BK)", Position.SECOND_BASE);
    	positions.put("grounded into double play 3b to 1b", Position.THIRD_BASE);
    	positions.put("grounded into double play 3b to 2b to 1b", Position.THIRD_BASE);
    	positions.put("grounded into double play 3b to 2b to 1b (1-0 B)", Position.THIRD_BASE);
    	positions.put("grounded into double play 3b to 2b to 1b (1-1 FB)", Position.THIRD_BASE);
    	positions.put("grounded into double play 3b to 2b to 1b (1-1 KB)", Position.THIRD_BASE);
    	positions.put("grounded into double play 3b to 2b to 1b (2-1 BBF)", Position.THIRD_BASE);
    	positions.put("grounded into double play 3b to 2b to 1b (2-2 BBKF)", Position.THIRD_BASE);
    	positions.put("grounded into double play 3b to 2b to 1b (2-2 FSBB)", Position.THIRD_BASE);
    	positions.put("grounded into double play 3b to c to 1b", Position.THIRD_BASE);
    	positions.put("grounded into double play p to 2b to 1b", Position.PITCHER);
    	positions.put("grounded into double play p to c to 1b", Position.PITCHER);
    	positions.put("grounded into double play p to c to 1b (0-0)", Position.PITCHER);
    	positions.put("grounded into double play p to ss to 1b", Position.PITCHER);
    	positions.put("grounded into double play p to ss to 1b (2-2 KBBK)", Position.PITCHER);
    	positions.put("grounded into double play p to ss to 1b (3-1 BBFB)", Position.PITCHER);
    	positions.put("grounded into double play ss to 1b", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 1b (2-1 BBK)", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 2b to 1b", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 2b to 1b (0-0)", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 2b to 1b (0-1 F)", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 2b to 1b (1-1 KB)", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 2b to 1b (1-2 FBFF)", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 2b to 1b (1-2 KKFBF)", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 2b to 1b (2-1 FBB)", Position.SHORTSTOP);
    	positions.put("grounded into double play ss to 2b to 1b (2-2 KSBB)",Position.SHORTSTOP);
    	
    	positions.put("grounded out to ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("grounded out to 1b unassisted", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (0-0)", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (0-0).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (0-1 K)", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (0-1 K).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (0-2 KS)", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (0-2 KS).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (1-0 B).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (1-1 BK).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (1-1 FB).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (1-1 KB).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (1-2 BSS).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (1-2 KBF).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (2-0 BB).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (2-2 BBKFF)", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (2-2 BFBF).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (2-2 BKBSF).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (2-2 FKBBF).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted (3-2 BBKBS).", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted, on appeal.", Position.FIRST_BASE);
    	positions.put("grounded out to 1b unassisted.", Position.FIRST_BASE);
    	positions.put("grounded out to 2b", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (0-0)", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (0-0).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (0-1 F).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (0-1 K).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (0-2 FF).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (0-2 FKF)", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (0-2 KFF).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (0-2 KK).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-0 B)", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-0 B).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-1 BK)", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-1 BK).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-2 BKK).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-2 KBF).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-2 KBK).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-2 KKB).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (1-2 SBF)", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (2-0 BB).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (2-1 BBS).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (2-1 BFB).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (2-1 BSB)", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (2-2 KBBF)", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (2-2 SSFBBFF).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (3-2 BBBKK).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (3-2 BFBBF).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (3-2 BFBBS).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b (3-2 KKBBB).", Position.SECOND_BASE);
    	positions.put("grounded out to 2b unassisted", Position.SECOND_BASE);
    	positions.put("grounded out to 2b unassisted.", Position.SECOND_BASE);
    	positions.put("grounded out to 2b.", Position.SECOND_BASE);
    	positions.put("grounded out to 3b", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-0)", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-0).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-1 F)", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-1 F).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-1 K).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-1 S).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-2 FFF).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-2 FK).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-2 KK).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-2 KS).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-2 SF).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-2 SK)", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (0-2 SS).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-0 B).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-1 BS).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-1 FB)", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-1 KB).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-2 BKF).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-2 BKK).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-2 FBS).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-2 KBF).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (1-2 KFB).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (2-0 BB).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (2-1 BKB)", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (2-1 BKB).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (2-2 BKBS)", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (2-2 FFBB).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (2-2 KBSFBF).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (3-1 BBBK).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (3-2 BBKBK).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (3-2 BKSBB).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b (3-2 KBKBB).", Position.THIRD_BASE);
    	positions.put("grounded out to 3b unassisted.", Position.THIRD_BASE);
    	positions.put("grounded out to 3b.", Position.THIRD_BASE);
    	positions.put("grounded out to c", Position.CATCHER);
    	positions.put("grounded out to c unassisted (1-2 BKF).", Position.CATCHER);
    	positions.put("grounded out to c unassisted (0-0).", Position.CATCHER);
    	positions.put("grounded out to c unassisted, interference.", Position.CATCHER);
    	positions.put("grounded out to c unassisted.", Position.CATCHER);
    	positions.put("grounded out to c.", Position.CATCHER);
    	positions.put("grounded out to p", Position.PITCHER);
    	positions.put("grounded out to p (0-0)", Position.PITCHER);
    	positions.put("grounded out to p (0-0).", Position.PITCHER);
    	positions.put("grounded out to p (0-1 K).", Position.PITCHER);
    	positions.put("grounded out to p (0-2 SF).", Position.PITCHER);
    	positions.put("grounded out to p (1-0 B)", Position.PITCHER);
    	positions.put("grounded out to p (1-0 B).", Position.PITCHER);
    	positions.put("grounded out to p (1-1 BF)", Position.PITCHER);
    	positions.put("grounded out to p (1-1 FB)", Position.PITCHER);
    	positions.put("grounded out to p (1-1 KB)", Position.PITCHER);
    	positions.put("grounded out to p (1-1 KB).", Position.PITCHER);
    	positions.put("grounded out to p (1-2 BFK).", Position.PITCHER);
    	positions.put("grounded out to p (1-2 BKF).", Position.PITCHER);
    	positions.put("grounded out to p (1-2 KBF).", Position.PITCHER);
    	positions.put("grounded out to p (1-2 KKBF).", Position.PITCHER);
    	positions.put("grounded out to p (2-0 BB).", Position.PITCHER);
    	positions.put("grounded out to p (2-1 BBS)", Position.PITCHER);
    	positions.put("grounded out to p (2-1 FBB).", Position.PITCHER);
    	positions.put("grounded out to p (2-2 KBSB)", Position.PITCHER);
    	positions.put("grounded out to p (3-2 BBKBF).", Position.PITCHER);
    	positions.put("grounded out to p unassisted", Position.PITCHER);
    	positions.put("grounded out to p unassisted (1-2 BKS).", Position.PITCHER);
    	positions.put("grounded out to p unassisted.", Position.PITCHER);
    	positions.put("grounded out to p.", Position.PITCHER);
    	positions.put("grounded out to ss", Position.SHORTSTOP);
    	positions.put("grounded out to ss (0-0).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (0-1 F).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (0-1 K).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (0-2 KK).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (0-2 SS).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-0 B)", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-0 B).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-1 BK).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-1 KB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-1 SB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 BKF).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 BSF).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 FFB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 KBK).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 KFB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 KKFB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 KSB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 SBFFF).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (1-2 SBK).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (2-0 BB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (2-1 BKB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (2-2 BFSB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (2-2 BKFB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (2-2 KBSBF).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (2-2 SKBB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (2-2 SKBBF).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (3-1 BBBF).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (3-2 BBKBK)", Position.SHORTSTOP);
    	positions.put("grounded out to ss (3-2 BBSSB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (3-2 BFBBK).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (3-2 KBBFB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (3-2 KBBSB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss (3-2 SKBBB).", Position.SHORTSTOP);
    	positions.put("grounded out to ss.", Position.SHORTSTOP);
    	
    	
    	
//    	_map.put("hit by pitch", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (0-0)", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (0-0).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (0-1 F).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (0-1 K).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (0-2 FF).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (0-2 KSF).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (1-0 B)", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (1-0 B).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (1-1 BF).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (1-1 BK).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (1-2 BKK).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (1-2 KFB).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (2-1 KBB)", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (2-2 FSBBFFF).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (2-2 KFBB).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (2-2 SBSB).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (3-2 BBBKK).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (3-2 BBKBF).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (3-2 BKBFFB).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch (3-2 BKBKFB).", Play.HIT_BY_PITCH);
//    	_map.put("hit by pitch.", Play.HIT_BY_PITCH);
    	
    	positions.put("hit into double play ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("hit into double play 3b to 1b", Position.THIRD_BASE);
    	positions.put("hit into double play 3b to 1b to 3b", Position.THIRD_BASE);
    	positions.put("hit into double play cf to 3b", Position.CENTER_FIELD);
    	positions.put("hit into double play p to 1b to 3b", Position.PITCHER);
    	positions.put("hit into double play ss to 1b to ss (2-1 FBB)", Position.SHORTSTOP);
    	positions.put("hit into double play ss to 2b to 1b", Position.SHORTSTOP);
    	positions.put("hit into double play ss to 1b", Position.SHORTSTOP);
    	
    	positions.put("homered ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("homered down the lf line.", Position.LEFT_FIELD);
    	positions.put("homered to center field (0-0)", Position.CENTER_FIELD);
    	positions.put("homered to center field (1-0 B)", Position.CENTER_FIELD);
    	positions.put("homered to center field (1-1 BF).", Position.CENTER_FIELD);
    	positions.put("homered to center field, unearned (0-0)", Position.CENTER_FIELD);
    	positions.put("homered to left center (1-2 BKS)", Position.LEFT_FIELD);
    	positions.put("homered to left center", Position.LEFT_FIELD);
    	positions.put("homered to left center.", Position.LEFT_FIELD);
    	positions.put("homered to left field", Position.LEFT_FIELD);
    	positions.put("homered to left field (0-0)", Position.LEFT_FIELD);
    	positions.put("homered to left field (2-2 KKBFB).", Position.LEFT_FIELD);
    	positions.put("homered to left field (3-1 BBBK)", Position.LEFT_FIELD);
    	positions.put("homered to left field (3-2 BKBBK).", Position.LEFT_FIELD);
    	positions.put("homered to left field, team unearned (1-2 KKB)", Position.LEFT_FIELD);
    	positions.put("homered to left field.", Position.LEFT_FIELD);
    	positions.put("homered to right center", Position.RIGHT_FIELD);
    	positions.put("homered to right center (1-0 B).", Position.RIGHT_FIELD);
    	positions.put("homered to right field", Position.RIGHT_FIELD);
    	positions.put("homered to right field (0-0)", Position.RIGHT_FIELD);
    	positions.put("homered to right field (1-0 B)", Position.RIGHT_FIELD);
    	positions.put("homered to right field (1-2 BFF)", Position.RIGHT_FIELD);
    	positions.put("homered to right field (2-2 SBBF)", Position.RIGHT_FIELD);
    	positions.put("homered to right field.", Position.RIGHT_FIELD);
    	
    	positions.put("infield fly double play ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("infield fly double play 2b to c", Position.SECOND_BASE);
    	positions.put("infield fly double play c to 3b", Position.CATCHER);
    	
    	positions.put("infield fly to ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("infield fly to 1b (1-1 BK).", Position.FIRST_BASE);
    	positions.put("infield fly to 2b (0-0).", Position.SECOND_BASE);
    	positions.put("infield fly to 2b.", Position.SECOND_BASE);
    	positions.put("infield fly to 3b.", Position.THIRD_BASE);
    	positions.put("infield fly to p.", Position.PITCHER);
    	positions.put("infield fly to ss.", Position.SHORTSTOP);
    	
//    	_map.put("intentionally walked", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked (0-1 K).", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked (1-0 B).", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked (1-1 KB).", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked (3-0 BBB).", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked (3-0 BBBB).", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked (3-1 BBBK).", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked (3-1 KBBB).", Play.INTENTIONAL_WALK);
//    	_map.put("intentionally walked.", Play.INTENTIONAL_WALK);
    	
    	positions.put("lined into double play ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("lined into double play 1b unassisted", Position.FIRST_BASE);
    	positions.put("lined into double play 1b unassisted (0-0)", Position.FIRST_BASE);
    	positions.put("lined into double play 1b unassisted (1-2 KFBFF)", Position.FIRST_BASE);
    	positions.put("lined into double play 2b to 1b", Position.SECOND_BASE);
    	positions.put("lined into double play 2b to 1b (2-1 BKB)", Position.SECOND_BASE);
    	positions.put("lined into double play 2b to ss", Position.SECOND_BASE);
    	positions.put("lined into double play 3b to 1b", Position.THIRD_BASE);
    	positions.put("lined into double play 3b unassisted", Position.THIRD_BASE);
    	positions.put("lined into double play p to 1b", Position.PITCHER);
    	positions.put("lined into double play p to ss", Position.PITCHER);
    	positions.put("lined into double play rf to 1b", Position.RIGHT_FIELD);
    	positions.put("lined into double play ss to 1b", Position.SHORTSTOP);
    	positions.put("lined into double play ss to 2b", Position.SHORTSTOP);
    	positions.put("lined into double play ss to 2b (1-1 BK)", Position.SHORTSTOP);
    	positions.put("lined into double play ss unassisted", Position.SHORTSTOP);
    	positions.put("lined into double play ss unassisted (3-2 BKFBBF)", Position.SHORTSTOP);
    	
    	positions.put("lined out to ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("lined out to 1b (0-0).", Position.FIRST_BASE);
    	positions.put("lined out to 1b (2-1 BFB).", Position.FIRST_BASE);
    	positions.put("lined out to 1b.", Position.FIRST_BASE);
    	positions.put("lined out to 2b (0-0).", Position.SECOND_BASE);
    	positions.put("lined out to 2b (1-1 BF).", Position.SECOND_BASE);
    	positions.put("lined out to 2b (1-1 BS).", Position.SECOND_BASE);
    	positions.put("lined out to 2b (2-2 KBFB).", Position.SECOND_BASE);
    	positions.put("lined out to 2b.", Position.SECOND_BASE);
    	positions.put("lined out to 3b (0-0).", Position.THIRD_BASE);
    	positions.put("lined out to 3b (1-0 B).", Position.THIRD_BASE);
    	positions.put("lined out to 3b (1-2 BKKF).", Position.THIRD_BASE);
    	positions.put("lined out to 3b (2-1 BFB).", Position.THIRD_BASE);
    	positions.put("lined out to 3b.", Position.THIRD_BASE);
    	positions.put("lined out to c.", Position.CATCHER);
    	positions.put("lined out to cf.", Position.CENTER_FIELD);
    	positions.put("lined out to lf.", Position.LEFT_FIELD);
    	positions.put("lined out to p (0-1 K).", Position.PITCHER);
    	positions.put("lined out to p (0-2 SKF).", Position.PITCHER);
    	positions.put("lined out to p (1-1 BF).", Position.PITCHER);
    	positions.put("lined out to p (2-2 KFFBFB).", Position.PITCHER);
    	positions.put("lined out to p.", Position.PITCHER);
    	positions.put("lined out to rf (1-1 KB)", Position.RIGHT_FIELD);
    	positions.put("lined out to rf.", Position.RIGHT_FIELD);
    	positions.put("lined out to ss", Position.SHORTSTOP);
    	positions.put("lined out to ss (0-2 KKF).", Position.SHORTSTOP);
    	positions.put("lined out to ss (1-1 BF).", Position.SHORTSTOP);
    	positions.put("lined out to ss (1-1 FB).", Position.SHORTSTOP);
    	positions.put("lined out to ss (1-2 BKKFF).", Position.SHORTSTOP);
    	positions.put("lined out to ss (2-0 BB).", Position.SHORTSTOP);
    	positions.put("lined out to ss (2-2 BFKB).", Position.SHORTSTOP);
    	positions.put("lined out to ss (3-2 BKBBKF).", Position.SHORTSTOP);
    	positions.put("lined out to ss.", Position.SHORTSTOP);
    	
//    	_map.put("no advance.", Play.NO_PLAY);
//    	_map.put("no advance.", Play.NO_PLAY);
    	
//    	_map.put("- On the same play -.", Play.NO_PLAY);
//    	_map.put("- On the same play -.", Play.NO_PLAY);
    	
    	positions.put("out at first ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("out at first 1b to 2b", Position.FIRST_BASE);
    	positions.put("out at first 1b to 2b (0-0)", Position.FIRST_BASE);
    	positions.put("out at first 1b to 2b (0-1 F)", Position.FIRST_BASE);
    	positions.put("out at first 1b to 2b (1-0 B)", Position.FIRST_BASE);
    	positions.put("out at first 1b to 2b.", Position.FIRST_BASE);
    	positions.put("out at first 1b to p", Position.FIRST_BASE);
    	positions.put("out at first 1b to p (0-1 F).", Position.FIRST_BASE);
    	positions.put("out at first 1b to p (0-2 KS).", Position.FIRST_BASE);
    	positions.put("out at first 1b to p (1-0 B)", Position.FIRST_BASE);
    	positions.put("out at first 1b to p (1-0 B).", Position.FIRST_BASE);
    	positions.put("out at first 1b to p (1-2 KBSF).", Position.FIRST_BASE);
    	positions.put("out at first 1b to p (2-1 BKB).", Position.FIRST_BASE);
    	positions.put("out at first 1b to p (3-2 BBBKK).", Position.FIRST_BASE);
    	positions.put("out at first 1b to p.", Position.FIRST_BASE);
    	positions.put("out at first 1b unassisted.", Position.FIRST_BASE);
    	positions.put("out at first 2b to 1b", Position.SECOND_BASE);
    	positions.put("out at first 2b to p", Position.SECOND_BASE);
    	positions.put("out at first 2b to p (0-1 F).", Position.SECOND_BASE);
    	positions.put("out at first 2b to p.", Position.SECOND_BASE);
    	positions.put("out at first 2b to ss to 1b.", Position.SECOND_BASE);
    	positions.put("out at first 3b to 1b to c (0-1 F)", Position.THIRD_BASE);
    	positions.put("out at first 3b to 2b", Position.THIRD_BASE);
//    	_map.put("out at first c to 1b, caught stealing, picked off.", Play.RUNNER_PICKED_OFF); // TODO g�rer ce cas particulier
//    	_map.put("out at first c to 1b, picked off.", Play.RUNNER_PICKED_OFF); // TODO g�rer ce cas particulier
    	positions.put("out at first c to 1b.", Position.CATCHER);
    	positions.put("out at first c to 2b", Position.CATCHER);
//    	_map.put("out at first c to 2b to 1b, caught stealing.", Play.RUNNER_CAUGHT_STEALING_SECOND); // TODO g�rer ce cas particulier
//    	_map.put("out at first c to ss to 1b, caught stealing.", Play.RUNNER_CAUGHT_STEALING_SECOND); // TODO g�rer ce cas particulier
//    	_map.put("out at first p to 1b, picked off.", Play.RUNNER_PICKED_OFF); // TODO g�rer ce cas particulier
    	positions.put("out at first p to 2b", Position.PITCHER);
    	positions.put("out at first p to 2b to 1b.", Position.PITCHER);
    	positions.put("out at first p to 2b.", Position.PITCHER);
    	positions.put("out at first p to 3b to 1b (0-2 KS).", Position.PITCHER);
    	positions.put("out at first p to ss to 1b.", Position.PITCHER);
    	positions.put("out at first rf to 1b (3-1 SBBB).", Position.RIGHT_FIELD);
    	positions.put("out at first ss to 2b.", Position.SHORTSTOP);
    	
//    	_map.put("out at home ", Play.NO_PLAY); // RUNNER_OUT_AT_HOME);
//    	_map.put("out at home 1b to c, caught stealing.", Play.RUNNER_CAUGHT_STEALING_HOME);// TODO g�rer ce cas particulier
//    	_map.put("out at home 1b to c.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at home 3b to c.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at home c to 2b to c, caught stealing.", Play.RUNNER_CAUGHT_STEALING_HOME);// TODO g�rer ce cas particulier
//    	_map.put("out at home c to 3b to p, caught stealing.", Play.RUNNER_CAUGHT_STEALING_HOME);// TODO g�rer ce cas particulier
//    	_map.put("out at home c to p.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at home c unassisted.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at home p to 3b to c.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at home p to c to 3b to p.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at home p to c, caught stealing.", Play.RUNNER_CAUGHT_STEALING_HOME);// TODO g�rer ce cas particulier
//    	_map.put("out at home p to c.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at home p unassisted.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at home ss to c.", Play.RUNNER_OUT_AT_HOME);
    	
//    	_map.put("out at second ", Play.NO_PLAY); // RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 1b to ss", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 1b to ss.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 2b to ss", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 2b to ss.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 2b unassisted", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 2b unassisted.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 3b to 2b", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 3b to 2b.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 3b to ss.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second 3b unassisted.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second c to 2b, caught stealing.", Play.RUNNER_CAUGHT_STEALING_SECOND);// TODO g�rer ce cas particulier
//    	_map.put("out at second c to 3b to 2b, caught stealing.", Play.RUNNER_CAUGHT_STEALING_SECOND);// TODO g�rer ce cas particulier
//    	_map.put("out at second c to ss to 2b, caught stealing.", Play.RUNNER_CAUGHT_STEALING_SECOND);// TODO g�rer ce cas particulier
//    	_map.put("out at second c to ss, caught stealing.", Play.RUNNER_CAUGHT_STEALING_SECOND);// TODO g�rer ce cas particulier
//    	_map.put("out at second c to ss.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second cf to ss", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second cf to ss.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second lf to 2b.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second p to 1b to 2b, caught stealing, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at second p to 1b to ss to p, caught stealing, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at second p to 1b to ss, caught stealing, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at second p to 2b.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second p to 3b to ss.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second p to ss", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second p to ss, caught stealing.", Play.RUNNER_CAUGHT_STEALING_SECOND);// TODO g�rer ce cas particulier
//    	_map.put("out at second p to ss, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at second p to ss.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second rf to ss", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second rf to ss.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second ss to 2b", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second ss to 2b.", Play.RUNNER_OUT_AT_SECOND);
//    	_map.put("out at second ss unassisted.", Play.RUNNER_OUT_AT_SECOND);
    	
//    	_map.put("out at third ", Play.NO_PLAY); // RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third 2b to c to 3b.", Play.RUNNER_OUT_AT_HOME);
//    	_map.put("out at third 3b to c to 3b.", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third 3b unassisted", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third 3b unassisted.", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third c to 2b to 3b, caught stealing.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at third c to 3b, caught stealing.", Play.RUNNER_CAUGHT_STEALING_THIRD);// TODO g�rer ce cas particulier
//    	_map.put("out at third c to 3b, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at third c to 3b.", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third c to ss to 3b, caught stealing, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at third lf to 3b.", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third lf to ss to 3b, on appeal.", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third p to 3b to ss to 3b, caught stealing.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at third p to 3b, caught stealing.", Play.RUNNER_CAUGHT_STEALING_THIRD);// TODO g�rer ce cas particulier
//    	_map.put("out at third p to 3b, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at third p to 3b.", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third p to c to 3b.", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third p to ss to 3b to p, caught stealing, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at third p to ss to 3b, caught stealing, picked off.", Play.RUNNER_PICKED_OFF);// TODO g�rer ce cas particulier
//    	_map.put("out at third ss to 3b", Play.RUNNER_OUT_AT_THIRD);
//    	_map.put("out at third ss to 3b.", Play.RUNNER_OUT_AT_THIRD);
    	
//    	_map.put("out on batter's interference", Position.UNKNOWN);
//    	_map.put("out on batter's interference (2-2 KBBS).", Position.UNKNOWN);
    	
//    	_map.put("out on double play ", Position.UNLOCATED_BATTED_BALL); // RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on double play c to 2b to c, caught stealing", Play.RUNNER_CAUGHT_STEALING_HOME);
//    	_map.put("out on double play lf to 3b to 2b", Play.RUNNER_OUT_AT_THIRD);
    	
//    	_map.put("out on the play", Play.NO_PLAY); // RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on the play", Play.RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on the play, assist by p", Play.RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on the play, assist by ss", Play.RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on the play, assist by ss c.", Play.RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on the play, caught stealing, assist by ss.", Play.RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on the play, caught stealing.", Play.RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on the play, on appeal, assist by lf", Play.RUNNER_OUT_ON_THE_PLAY);
//    	_map.put("out on the play.", Play.RUNNER_OUT_ON_THE_PLAY);
    	
//    	_map.put("pinch hit.", Play.NO_PLAY);
//    	_map.put("placed on first.", Play.TIE_BREAK_PLACED_ON_1B);
//    	_map.put("placed on second.", Play.TIE_BREAK_PLACED_ON_2B);
    	   	
    	positions.put("popped into double play ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("popped into double play 1b to p", Position.FIRST_BASE);
    	positions.put("popped into double play 2b to 1b", Position.SECOND_BASE);
    	positions.put("popped into double play 3b to 1b", Position.THIRD_BASE);
    	positions.put("popped into double play ss to 1b", Position.SHORTSTOP);
    	
    	positions.put("popped up to ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("popped up to 1b (0-0).", Position.FIRST_BASE);
    	positions.put("popped up to 1b (0-1 S).", Position.FIRST_BASE);
    	positions.put("popped up to 1b (0-2 KSF).", Position.FIRST_BASE);
    	positions.put("popped up to 1b (1-0 B).", Position.FIRST_BASE);
    	positions.put("popped up to 1b (1-2 FBS).", Position.FIRST_BASE);
    	positions.put("popped up to 1b (2-1 BBF).", Position.FIRST_BASE);
    	positions.put("popped up to 1b (2-1 BSB).", Position.FIRST_BASE);
    	positions.put("popped up to 1b (3-2 BBBKK).", Position.FIRST_BASE);
    	positions.put("popped up to 1b.", Position.FIRST_BASE);
    	positions.put("popped up to 2b (0-0).", Position.SECOND_BASE);
    	positions.put("popped up to 2b (0-1 F).", Position.SECOND_BASE);
    	positions.put("popped up to 2b (0-1 K).", Position.SECOND_BASE);
    	positions.put("popped up to 2b (1-0 B).", Position.SECOND_BASE);
    	positions.put("popped up to 2b (1-1 BK).", Position.SECOND_BASE);
    	positions.put("popped up to 2b (1-2 BKK).", Position.SECOND_BASE);
    	positions.put("popped up to 2b (2-1 KBB).", Position.SECOND_BASE);
    	positions.put("popped up to 2b (2-2 KBBF).", Position.SECOND_BASE);
    	positions.put("popped up to 2b (2-2 KBBFF).", Position.SECOND_BASE);
    	positions.put("popped up to 2b.", Position.SECOND_BASE);
    	positions.put("popped up to 3b (0-1 K).", Position.THIRD_BASE);
    	positions.put("popped up to 3b (1-0 B).", Position.THIRD_BASE);
    	positions.put("popped up to 3b (1-1 KB).", Position.THIRD_BASE);
    	positions.put("popped up to 3b (2-2 BKBF).", Position.THIRD_BASE);
    	positions.put("popped up to 3b (2-2 BKKBF).", Position.THIRD_BASE);
    	positions.put("popped up to 3b.", Position.THIRD_BASE);
    	positions.put("popped up to c (1-1 FB).", Position.CATCHER);
    	positions.put("popped up to c.", Position.CATCHER);
    	positions.put("popped up to p (0-0).", Position.PITCHER);
    	positions.put("popped up to p (1-0 B).", Position.PITCHER);
    	positions.put("popped up to p (1-1 BF).", Position.PITCHER);
    	positions.put("popped up to p (1-2 KFB).", Position.PITCHER);
    	positions.put("popped up to p (2-1 BFB).", Position.PITCHER);
    	positions.put("popped up to p.", Position.PITCHER);
    	positions.put("popped up to ss (0-0).", Position.SHORTSTOP);
    	positions.put("popped up to ss (0-1 F).", Position.SHORTSTOP);
    	positions.put("popped up to ss (0-1 K).", Position.SHORTSTOP);
    	positions.put("popped up to ss (1-0 B).", Position.SHORTSTOP);
    	positions.put("popped up to ss (1-2 FBK).", Position.SHORTSTOP);
    	positions.put("popped up to ss (2-0 BB).", Position.SHORTSTOP);
    	positions.put("popped up to ss (2-1 BBK).", Position.SHORTSTOP);
    	positions.put("popped up to ss (2-2 KBBS).", Position.SHORTSTOP);
    	positions.put("popped up to ss (2-2 KKBBFF).", Position.SHORTSTOP);
    	positions.put("popped up to ss (3-1 BKBB).", Position.SHORTSTOP);
    	positions.put("popped up to ss (3-2 BBBKFF).", Position.SHORTSTOP);
    	positions.put("popped up to ss (3-2 KBBFFBF).", Position.SHORTSTOP);
    	positions.put("popped up to ss (3-2 KBBKFB).", Position.SHORTSTOP);
    	positions.put("popped up to ss.", Position.SHORTSTOP);
    	
    	positions.put("reached on a dropped fly by ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("reached on a dropped fly by 1b", Position.FIRST_BASE);
    	positions.put("reached on a dropped fly by 2b", Position.SECOND_BASE);
    	positions.put("reached on a dropped fly by 2b, advanced to second on the error.", Position.SECOND_BASE);
    	positions.put("reached on a dropped fly by 3b.", Position.THIRD_BASE);
    	positions.put("reached on a dropped fly by c", Position.CATCHER);
    	positions.put("reached on a dropped fly by cf", Position.CENTER_FIELD);
    	positions.put("reached on a dropped fly by cf, advanced to second on the error", Position.CENTER_FIELD);
    	positions.put("reached on a dropped fly by cf, advanced to second on the error.", Position.CENTER_FIELD);
    	positions.put("reached on a dropped fly by cf.", Position.CENTER_FIELD);
    	positions.put("reached on a dropped fly by lf", Position.LEFT_FIELD);
    	positions.put("reached on a dropped fly by lf, advanced to second on the error", Position.LEFT_FIELD);
    	positions.put("reached on a dropped fly by lf.", Position.LEFT_FIELD);
    	positions.put("reached on a dropped fly by p.", Position.PITCHER);
    	positions.put("reached on a dropped fly by rf", Position.RIGHT_FIELD);
    	positions.put("reached on a dropped fly by rf (0-1 K)", Position.RIGHT_FIELD);
    	positions.put("reached on a dropped fly by rf, advanced to second on the error", Position.RIGHT_FIELD);
    	positions.put("reached on a dropped fly by rf, advanced to third on the error", Position.RIGHT_FIELD);
    	positions.put("reached on a dropped fly by rf.", Position.RIGHT_FIELD);
    	positions.put("reached on a dropped fly by ss (0-0).", Position.SHORTSTOP);
    	
    	positions.put("reached on a fielder's choice to ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("reached on a fielder's choice to catcher", Position.CATCHER);
    	positions.put("reached on a fielder's choice to center field", Position.CENTER_FIELD);
    	positions.put("reached on a fielder's choice to center field (3-1 BKBB)", Position.CENTER_FIELD);
    	positions.put("reached on a fielder's choice to first base", Position.FIRST_BASE);
    	positions.put("reached on a fielder's choice to first base (0-0)", Position.FIRST_BASE);
    	positions.put("reached on a fielder's choice to first base (0-1 K)", Position.FIRST_BASE);
    	positions.put("reached on a fielder's choice to first base (0-2 KS)", Position.FIRST_BASE);
    	positions.put("reached on a fielder's choice to first base, advanced to second", Position.FIRST_BASE);
    	positions.put("reached on a fielder's choice to first base (1-1 BK)", Position.FIRST_BASE);
    	positions.put("reached on a fielder's choice to left field", Position.LEFT_FIELD);
    	positions.put("reached on a fielder's choice to pitcher", Position.PITCHER);
    	positions.put("reached on a fielder's choice to pitcher (0-0)", Position.PITCHER);
    	positions.put("reached on a fielder's choice to pitcher (0-2 KF)", Position.PITCHER);
    	positions.put("reached on a fielder's choice to pitcher, advanced to second", Position.PITCHER);
    	positions.put("reached on a fielder's choice to pitcher, advanced to second on the error", Position.PITCHER);
    	positions.put("reached on a fielder's choice to right field", Position.RIGHT_FIELD);
    	positions.put("reached on a fielder's choice to second base", Position.SECOND_BASE);
    	positions.put("reached on a fielder's choice to second base (0-0)", Position.SECOND_BASE);
    	positions.put("reached on a fielder's choice to second base (0-1 K)", Position.SECOND_BASE);
    	positions.put("reached on a fielder's choice to second base (1-1 BF)", Position.SECOND_BASE);
    	positions.put("reached on a fielder's choice to second base (2-1 KBB)", Position.SECOND_BASE);
    	positions.put("reached on a fielder's choice to second base, advanced to second", Position.SECOND_BASE);
    	positions.put("reached on a fielder's choice to shortstop", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (0-0)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (0-1 K)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (0-1 S)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (0-2 KF)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (1-0 B)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (1-1 BK)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (1-1 KB)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (1-2 BKF)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (1-2 BKFF)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (1-2 BKS)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (1-2 KKB)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (2-1 BBS)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (2-1 BFB)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (2-2 KKBBFF)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop (2-2 SBFB)", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop, advanced to second on a fielding error by 1b", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop, advanced to second on a throwing error by 2b", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop, advanced to second on the error", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop, advanced to third", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop, out at second 2b to 3b to ss", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to shortstop.", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice to third base", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (0-0)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (0-1 K)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (0-1 S)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (0-2 FF)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (0-2 KK)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (1-0 B)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (1-1 BS)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (2-2 BBSF)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (2-2 KFBFB)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (3-2 BBKFB)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base (3-2 KFBFBFB)", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base, advanced to second on the error", Position.THIRD_BASE);
    	positions.put("reached on a fielder's choice to third base.", Position.THIRD_BASE);
    	
    	positions.put("reached on a fielder's choice,", Position.UNLOCATED_BATTED_BALL);
    	positions.put("reached on a fielder's choice, grounded into double play 1b to ss to 3b, advanced to second", Position.FIRST_BASE);
    	positions.put("reached on a fielder's choice, grounded into double play ss to 2b", Position.SHORTSTOP);
    	positions.put("reached on a fielder's choice, hit into double play 2b to ss to c", Position.SECOND_BASE);
    	positions.put("reached on a fielder's choice, hit into double play ss to 2b to c", Position.SHORTSTOP);
    	
    	positions.put("reached on a fielding error by ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("reached on a fielding error by 1b", Position.FIRST_BASE);
    	positions.put("reached on a fielding error by 1b (0-1 K).", Position.FIRST_BASE);
    	positions.put("reached on a fielding error by 1b (1-1 BF).", Position.FIRST_BASE);
    	positions.put("reached on a fielding error by 1b, advanced to second on the error.", Position.FIRST_BASE);
    	positions.put("reached on a fielding error by 1b.", Position.FIRST_BASE);
    	positions.put("reached on a fielding error by 2b", Position.SECOND_BASE);
    	positions.put("reached on a fielding error by 2b (0-2 SS)", Position.SECOND_BASE);
    	positions.put("reached on a fielding error by 2b (2-0 BB).", Position.SECOND_BASE);
    	positions.put("reached on a fielding error by 2b, advanced to third on the error (1-0 B)", Position.SECOND_BASE);
    	positions.put("reached on a fielding error by 2b.", Position.SECOND_BASE);
    	positions.put("reached on a fielding error by 3b", Position.THIRD_BASE);
    	positions.put("reached on a fielding error by 3b (0-0).", Position.THIRD_BASE);
    	positions.put("reached on a fielding error by 3b (0-1 K)", Position.THIRD_BASE);
    	positions.put("reached on a fielding error by 3b (0-2 KF)", Position.THIRD_BASE);
    	positions.put("reached on a fielding error by 3b (1-0 B).", Position.THIRD_BASE);
    	positions.put("reached on a fielding error by 3b (1-1 SB).", Position.THIRD_BASE);
    	positions.put("reached on a fielding error by 3b, advanced to second on the error, advanced to third on a fielding error by lf.", Position.THIRD_BASE);
    	positions.put("reached on a fielding error by 3b.", Position.THIRD_BASE);
    	positions.put("reached on a fielding error by c",  Position.CATCHER);
    	positions.put("reached on a fielding error by cf", Position.CENTER_FIELD);
    	positions.put("reached on a fielding error by cf, advanced to second on the error.", Position.CENTER_FIELD);
    	positions.put("reached on a fielding error by p",  Position.PITCHER);
    	positions.put("reached on a fielding error by p.",  Position.PITCHER);
    	positions.put("reached on a fielding error by rf", Position.RIGHT_FIELD);
    	positions.put("reached on a fielding error by ss",  Position.PITCHER);
    	positions.put("reached on a fielding error by ss (0-0)", Position.SHORTSTOP);
    	positions.put("reached on a fielding error by ss (0-2 SSF).", Position.SHORTSTOP);
    	positions.put("reached on a fielding error by ss (1-1 FB)", Position.SHORTSTOP);
    	positions.put("reached on a fielding error by ss, advanced to second on a fielding error by lf.", Position.SHORTSTOP);
    	positions.put("reached on a fielding error by ss.", Position.SHORTSTOP);
    	
    	positions.put("reached on a muffed throw by ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("reached on a muffed throw by 1b, assist by 2b", Position.SECOND_BASE);
    	positions.put("reached on a muffed throw by 1b, assist by 2b, (GIDP)", Position.SECOND_BASE);
    	positions.put("reached on a muffed throw by 1b, assist by 2b, advanced to second on the error", Position.SECOND_BASE);
    	positions.put("reached on a muffed throw by 1b, assist by 2b.", Position.SECOND_BASE);
    	positions.put("reached on a muffed throw by 1b, assist by 3b", Position.THIRD_BASE);
    	positions.put("reached on a muffed throw by 1b, assist by 3b, advanced to third on the error.", Position.THIRD_BASE);
    	positions.put("reached on a muffed throw by 1b, assist by 3b.", Position.THIRD_BASE);
    	positions.put("reached on a muffed throw by 1b, assist by c.", Position.CATCHER);
    	positions.put("reached on a muffed throw by 1b, assist by p ss.", Position.PITCHER);
    	positions.put("reached on a muffed throw by 1b, assist by p.", Position.PITCHER);
    	positions.put("reached on a muffed throw by 1b, assist by ss.", Position.SHORTSTOP);
    	positions.put("reached on a muffed throw by p, assist by 1b", Position.FIRST_BASE);
    	
    	positions.put("reached on a throwing error by ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("reached on a throwing error by 1b, advanced to second on the error.", Position.FIRST_BASE);
    	positions.put("reached on a throwing error by 1b.", Position.FIRST_BASE);
    	positions.put("reached on a throwing error by 2b", Position.SECOND_BASE);
    	positions.put("reached on a throwing error by 2b, advanced to second on the error", Position.SECOND_BASE);
    	positions.put("reached on a throwing error by 2b.", Position.SECOND_BASE);
    	positions.put("reached on a throwing error by 3b", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b (0-0)", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b (3-1 BKBB).", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b (3-2 KBKFFBB).", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b (3-2 KSBBFB).", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b, advanced to second", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b, advanced to second.", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b, advanced to second on the error", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b, advanced to second on the error (0-1 F).", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b, advanced to second on the error (2-1 SBB).", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b, advanced to second on the error.", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by 3b.", Position.THIRD_BASE);
    	positions.put("reached on a throwing error by c, advanced to second on the error",  Position.CATCHER);
    	positions.put("reached on a throwing error by p", Position.PITCHER);
    	positions.put("reached on a throwing error by p, advanced to second on an error by 2b, obstruction", Position.PITCHER);
    	positions.put("reached on a throwing error by p, advanced to second on the error", Position.PITCHER);
    	positions.put("reached on a throwing error by p, advanced to third on the error", Position.PITCHER);
    	positions.put("reached on a throwing error by p, advanced to third on the error (0-1 K)", Position.PITCHER);
    	positions.put("reached on a throwing error by p.", Position.PITCHER);
    	positions.put("reached on a throwing error by ss", Position.SHORTSTOP);
    	positions.put("reached on a throwing error by ss (0-0).", Position.SHORTSTOP);
    	positions.put("reached on a throwing error by ss (0-2 SF)", Position.SHORTSTOP);
    	positions.put("reached on a throwing error by ss, advanced to second.", Position.SHORTSTOP);
    	positions.put("reached on a throwing error by ss, advanced to second on the error", Position.SHORTSTOP);
    	positions.put("reached on a throwing error by ss, advanced to second on the error.", Position.SHORTSTOP);
    	positions.put("reached on a throwing error by ss, out at second 1b to ss.", Position.SHORTSTOP);
    	positions.put("reached on a throwing error by ss.", Position.SHORTSTOP);
    	
    	positions.put("reached on an error by ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("reached on an error by 1b", Position.FIRST_BASE);
    	positions.put("reached on an error by 1b.", Position.FIRST_BASE);
    	positions.put("reached on an error by 1b, advanced to second on the error", Position.FIRST_BASE);
    	positions.put("reached on an error by 1b (0-0).", Position.FIRST_BASE);
    	positions.put("reached on an error by 1b, assist by c (0-2 KS)", Position.CATCHER);
    	positions.put("reached on an error by 1b, assist by ss", Position.SHORTSTOP);
    	positions.put("reached on an error by 1b, assist by ss.", Position.SHORTSTOP);
    	positions.put("reached on an error by 2b", Position.SECOND_BASE);
    	positions.put("reached on an error by 2b.", Position.SECOND_BASE);
    	positions.put("reached on an error by 2b, advanced to second on the error", Position.SECOND_BASE);
    	positions.put("reached on an error by 2b, assist by ss", Position.SHORTSTOP);
    	positions.put("reached on an error by 2b, assist by 3b", Position.THIRD_BASE);
    	positions.put("reached on an error by 2b (0-0)", Position.SECOND_BASE);
    	positions.put("reached on an error by 2b (3-1 BFBB)", Position.SECOND_BASE);
    	positions.put("reached on an error by 3b", Position.THIRD_BASE);
    	positions.put("reached on an error by 3b.", Position.THIRD_BASE);
    	positions.put("reached on an error by 3b, advanced to second on the error", Position.THIRD_BASE);
    	positions.put("reached on an error by 3b (2-0 BB)", Position.THIRD_BASE);
    	positions.put("reached on an error by cf", Position.CENTER_FIELD);
    	positions.put("reached on an error by cf.", Position.CENTER_FIELD);
    	positions.put("reached on an error by cf, advanced to second on the error", Position.CENTER_FIELD);
    	positions.put("reached on an error by lf", Position.LEFT_FIELD);
    	positions.put("reached on an error by lf.", Position.LEFT_FIELD);
    	positions.put("reached on an error by lf, advanced to second on the error", Position.LEFT_FIELD);
    	positions.put("reached on an error by lf (3-2 BSBBF)", Position.LEFT_FIELD);
    	positions.put("reached on an error by p", Position.PITCHER);
    	positions.put("reached on an error by rf", Position.RIGHT_FIELD);
    	positions.put("reached on an error by rf.", Position.RIGHT_FIELD);
    	positions.put("reached on an error by rf, advanced to second on the error", Position.RIGHT_FIELD);
    	positions.put("reached on an error by ss", Position.SHORTSTOP);
    	positions.put("reached on an error by ss.", Position.SHORTSTOP);
    	positions.put("reached on an error by ss, advanced to second on the error", Position.SHORTSTOP);
    	positions.put("reached on an error by ss, assist by 1b", Position.FIRST_BASE);
    	positions.put("reached on an error by ss, assist by 2b", Position.SECOND_BASE);
    	positions.put("reached on an error by ss (3-1 BBBK)", Position.SHORTSTOP);
    	
    	
    	
//    	_map.put("scored", Play.NO_PLAY); // SCORE);
//    	_map.put("scored", Play.SCORE);
//    	_map.put("scored on a balk, unearned.", Play.SCORE);
//    	_map.put("scored on a balk.", Play.SCORE);
//    	_map.put("scored on a muffed throw by 3b, assist by lf, unearned.", Play.);
//    	_map.put("scored on a muffed throw by c, unearned.", Play.);
//    	_map.put("scored on a muffed throw by p, assist by ss, unearned.", Play.);
//    	_map.put("scored on a muffed throw by ss.", Play.);
//    	_map.put("scored on a passed ball, unearned.", Play.);
//    	_map.put("scored on a passed ball.", Play.);
//    	_map.put("scored on a throwing error by 1b, unearned.", Play.);
//    	_map.put("scored on a throwing error by 3b.", Play.);
//    	_map.put("scored on a throwing error by c, caught stealing, unearned.", Play.);
//    	_map.put("scored on a throwing error by c, unearned.", Play.);
//    	_map.put("scored on a throwing error by c.", Play.);
//    	_map.put("scored on a throwing error by cf, unearned.", Play.);
//    	_map.put("scored on a throwing error by p, failed pickoff attempt, unearned.", Play.);
//    	_map.put("scored on a throwing error by p, unearned.", Play.);
//    	_map.put("scored on a throwing error by rf, unearned.", Play.);
//    	_map.put("scored on a throwing error by ss, unearned.", Play.);
//    	_map.put("scored on a wild pitch, unearned.", Play.);
//    	_map.put("scored on a wild pitch.", Play.);
//    	_map.put("scored on an error by 3b, unearned.", Play.);
//    	_map.put("scored on the error, unearned", Play.);
//    	_map.put("scored on the error, unearned.", Play.);
//    	_map.put("scored on the error.", Play.);
//    	_map.put("scored, team unearned", Play.);
//    	_map.put("scored, team unearned.", Play.);
//    	_map.put("scored, unearned", Play.);
//    	_map.put("scored, unearned.", Play.);
//    	_map.put("scored.", Play.);
    	
    	positions.put("singled ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("singled down the lf line", Position.LEFT_FIELD);
    	positions.put("singled down the lf line (0-1 F).", Position.LEFT_FIELD);
    	positions.put("singled down the lf line (1-0 B).", Position.LEFT_FIELD);
    	positions.put("singled down the lf line (1-1 BK).", Position.LEFT_FIELD);
    	positions.put("singled down the lf line (1-1 FB).", Position.LEFT_FIELD);
    	positions.put("singled down the lf line (1-1 KB).", Position.LEFT_FIELD);
    	positions.put("singled down the lf line, advanced to second on a fielding error by lf (2-1 BBK).", Position.LEFT_FIELD);
    	positions.put("singled down the lf line, advanced to second on the throw", Position.LEFT_FIELD);
    	positions.put("singled down the lf line, out at second lf to 2b.", Position.LEFT_FIELD);
    	positions.put("singled down the lf line, out at second lf to 2b to ss to 2b.", Position.LEFT_FIELD);
    	positions.put("singled down the lf line.", Position.LEFT_FIELD);
    	positions.put("singled down the rf line", Position.RIGHT_FIELD);
    	positions.put("singled down the rf line (0-0).", Position.RIGHT_FIELD);
    	positions.put("singled down the rf line (0-2 KS)", Position.RIGHT_FIELD);
    	positions.put("singled down the rf line (1-0 B)", Position.RIGHT_FIELD);
    	positions.put("singled down the rf line (1-1 KB).", Position.RIGHT_FIELD);
    	positions.put("singled down the rf line (2-1 KBB).", Position.RIGHT_FIELD);
    	positions.put("singled down the rf line (3-0 BBB)", Position.RIGHT_FIELD);
    	positions.put("singled down the rf line.", Position.RIGHT_FIELD);
    	positions.put("singled through the left side", Position.LEFT_FIELD);
    	positions.put("singled through the left side (0-0)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (0-0).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (0-1 F)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (0-1 K)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (0-1 K).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (0-1 S).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (0-2 KKF)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (0-2 KS).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (1-0 B)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (1-0 B).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (1-1 BF)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (1-1 BS).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (1-1 KB).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (1-2 BKK)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (1-2 KBF)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (1-2 KFB)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (2-1 BBK).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (2-1 BKB).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (2-1 KBB)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (2-2 KBFB)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (3-2 BBBKF)", Position.LEFT_FIELD);
    	positions.put("singled through the left side (3-2 BBBKK).", Position.LEFT_FIELD);
    	positions.put("singled through the left side (3-2 FBKBBF).", Position.LEFT_FIELD);
    	positions.put("singled through the left side, advanced to second on the throw", Position.LEFT_FIELD);
    	positions.put("singled through the left side.", Position.LEFT_FIELD);
    	positions.put("singled through the right side", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (0-0)", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (0-1 K)", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (0-2 KK)", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (1-1 BF)", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (1-1 FB).", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (1-1 KB).", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (1-2 KKB).", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (2-1 BFB)", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (2-1 BKB)", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (3-2 BKBBK)", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (3-2 BKBKFFB).", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (3-2 KBFBBF).", Position.RIGHT_FIELD);
    	positions.put("singled through the right side (3-2 KKBBB)", Position.RIGHT_FIELD);
    	positions.put("singled through the right side, advanced to second on the throw", Position.RIGHT_FIELD);
    	positions.put("singled through the right side.", Position.RIGHT_FIELD);
    	positions.put("singled to catcher", Position.CATCHER);
    	positions.put("singled to catcher.", Position.CATCHER);
    	positions.put("singled to center field", Position.CENTER_FIELD);
    	positions.put("singled to center field (0-0)", Position.CENTER_FIELD);
    	positions.put("singled to center field (0-0).", Position.CENTER_FIELD);
    	positions.put("singled to center field (0-1 K)", Position.CENTER_FIELD);
    	positions.put("singled to center field (0-2 KF)", Position.CENTER_FIELD);
    	positions.put("singled to center field (1-1 BK)", Position.CENTER_FIELD);
    	positions.put("singled to center field (1-1 FB).", Position.CENTER_FIELD);
    	positions.put("singled to center field (1-1 KB)", Position.CENTER_FIELD);
    	positions.put("singled to center field (1-1 SB)", Position.CENTER_FIELD);
    	positions.put("singled to center field (1-2 BKFF).", Position.CENTER_FIELD);
    	positions.put("singled to center field (1-2 BKK).", Position.CENTER_FIELD);
    	positions.put("singled to center field (1-2 KKBF).", Position.CENTER_FIELD);
    	positions.put("singled to center field (3-1 BFBB).", Position.CENTER_FIELD);
    	positions.put("singled to center field (3-2 KBKBB).", Position.CENTER_FIELD);
    	positions.put("singled to center field (3-2 KKBBB)", Position.CENTER_FIELD);
    	positions.put("singled to center field (3-2 KSFBBFBF).", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on a fielding error by cf", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on a fielding error by cf (0-1 F).", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on a fielding error by cf, advanced to third on a fielding error by ss.", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on a throwing error by ss", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on an error by cf (1-1 BF)", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on an error by cf, advanced to third on the error (0-0).", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on the error", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on the throw", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on the throw, advanced to third on the error", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on the throw, out at third cf to c to 3b", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on the throw (1-0 B)", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on the throw (1-1 KB)", Position.CENTER_FIELD);
    	positions.put("singled to center field, advanced to second on the throw, advanced to third on an error by c", Position.CENTER_FIELD);
    	positions.put("singled to center field, out at second lf to ss.", Position.CENTER_FIELD); // TODO g�rer ce cas particulier
    	positions.put("singled to center field.", Position.CENTER_FIELD);
    	positions.put("singled to first base", Position.FIRST_BASE);
    	positions.put("singled to first base (0-0)", Position.FIRST_BASE);
    	positions.put("singled to first base (0-1 F).", Position.FIRST_BASE);
    	positions.put("singled to first base (1-1 FB)", Position.FIRST_BASE);
    	positions.put("singled to first base (1-2 BKF)", Position.FIRST_BASE);
    	positions.put("singled to first base.", Position.FIRST_BASE);
    	positions.put("singled to left center",  Position.LEFT_FIELD);
    	positions.put("singled to left center (0-0).",  Position.LEFT_FIELD);
    	positions.put("singled to left center (1-1 BK).",  Position.LEFT_FIELD);
    	positions.put("singled to left center (1-1 FB)",  Position.LEFT_FIELD);
    	positions.put("singled to left center (2-0 BB)",  Position.LEFT_FIELD);
    	positions.put("singled to left center (2-1 BKB).",  Position.LEFT_FIELD);
    	positions.put("singled to left center (2-1 FBB)",  Position.LEFT_FIELD);
    	positions.put("singled to left center (2-1 KBB)",  Position.LEFT_FIELD);
    	positions.put("singled to left center, advanced to second on the throw",  Position.LEFT_FIELD);
    	positions.put("singled to left center.",  Position.LEFT_FIELD);
    	positions.put("singled to left field",  Position.LEFT_FIELD);
    	positions.put("singled to left field (0-0)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (0-0).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (0-1 F)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (0-1 K)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (0-1 K).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (0-1 S)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (0-2 KF).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (0-2 KK)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-0 B)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-0 B).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-1 BK).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-1 KB)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-1 SB).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-2 BFKFF)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-2 BKF).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-2 FSBFFF).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (1-2 KFFB).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-0 BB)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-0 BB).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-1 BBF)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-1 BBF).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-1 BBS).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-1 FBB)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-2 BBKS).",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-2 BSBK)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (2-2 KSBB)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (3-2 BBKBF)",  Position.LEFT_FIELD);
    	positions.put("singled to left field (3-2 BKFBB)",  Position.LEFT_FIELD);
    	positions.put("singled to left field, advanced to second on a fielding error by lf.",  Position.LEFT_FIELD);
    	positions.put("singled to left field, advanced to second on a fielding error by lf",  Position.LEFT_FIELD);
    	positions.put("singled to left field, advanced to second on a fielding error by lf (1-0 B)",  Position.LEFT_FIELD);
    	positions.put("singled to left center, advanced to second on a throwing error by ss.", Position.LEFT_FIELD);
    	positions.put("singled to left field, advanced to second on an error by lf (2-0 BB)",  Position.LEFT_FIELD);
    	positions.put("singled to left field, advanced to second on the throw",  Position.LEFT_FIELD);
    	positions.put("singled to left field, advanced to second on the throw (1-1 FB)",  Position.LEFT_FIELD);
    	positions.put("singled to left field, out at second lf to 2b.",  Position.LEFT_FIELD); // TODO g�rer ce cas particulier
    	positions.put("singled to left field, out at second lf to 3b to 1b to 2b",  Position.LEFT_FIELD); // TODO g�rer ce cas particulier
    	positions.put("singled to left field.",  Position.LEFT_FIELD);
    	positions.put("singled to pitcher", Position.PITCHER);
    	positions.put("singled to pitcher.", Position.PITCHER);
    	positions.put("singled to pitcher (1-0 B).", Position.PITCHER);
    	positions.put("singled to pitcher (2-0 BB).", Position.PITCHER);
    	positions.put("singled to pitcher (3-2 BBSFB).", Position.PITCHER);
    	positions.put("singled to pitcher (0-1 K)", Position.PITCHER);
    	positions.put("singled to pitcher (2-1 FBB)", Position.PITCHER);
    	positions.put("singled to pitcher, advanced to second on a fielding error by p", Position.PITCHER);
    	positions.put("singled to right center", Position.RIGHT_FIELD);
    	positions.put("singled to right center (0-0)", Position.RIGHT_FIELD);
    	positions.put("singled to right center (0-2 KKF)", Position.RIGHT_FIELD);
    	positions.put("singled to right center (1-0 B)", Position.RIGHT_FIELD);
    	positions.put("singled to right center (1-0 B).", Position.RIGHT_FIELD);
    	positions.put("singled to right center (1-1 BF).", Position.RIGHT_FIELD);
    	positions.put("singled to right center (1-1 KB)", Position.RIGHT_FIELD);
    	positions.put("singled to right center (1-1 KB).", Position.RIGHT_FIELD);
    	positions.put("singled to right center (1-2 FKB).", Position.RIGHT_FIELD);
    	positions.put("singled to right center (2-0 BB).", Position.RIGHT_FIELD);
    	positions.put("singled to right center (2-1 BKB)", Position.RIGHT_FIELD);
    	positions.put("singled to right center (2-2 BBKF).", Position.RIGHT_FIELD);
    	positions.put("singled to right center (2-2 FBBK).", Position.RIGHT_FIELD);
    	positions.put("singled to right center (3-2 BFBKB)", Position.RIGHT_FIELD);
    	positions.put("singled to right center, advanced to second on the throw", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on an error by rf, advanced to third.", Position.RIGHT_FIELD);
    	positions.put("singled to right center.", Position.RIGHT_FIELD);
    	positions.put("singled to right field", Position.RIGHT_FIELD);
    	positions.put("singled to right field (0-0)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (0-0).", Position.RIGHT_FIELD);
    	positions.put("singled to right field (0-1 F)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (0-1 K)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (0-1 K).", Position.RIGHT_FIELD);
    	positions.put("singled to right field (0-2 SF).", Position.RIGHT_FIELD);
    	positions.put("singled to right field (1-0 B)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (1-1 BK)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (1-1 KB)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (1-2 BFK).", Position.RIGHT_FIELD);
    	positions.put("singled to right field (1-2 BKF).", Position.RIGHT_FIELD);
    	positions.put("singled to right field (1-2 FBF)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (1-2 KBF)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (2-0 BB)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (2-0 BB).", Position.RIGHT_FIELD);
    	positions.put("singled to right field (2-1 BBK)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (2-2 KBFB)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (2-2 KBKB)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (2-2 SBSB).", Position.RIGHT_FIELD);
    	positions.put("singled to right field (3-1 BBKB)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (3-2 BBBKF)", Position.RIGHT_FIELD);
    	positions.put("singled to right field (3-2 BKBKB).", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on a fielding error by rf", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on a fielding error by rf.", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on a throwing error by rf", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on an error by rf, advanced to third on the error (2-0 BB).", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on the error", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on the throw", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on the throw (0-2 KF)", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to second on the throw, advanced to third on a throwing error by rf", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to third on a fielding error by rf", Position.RIGHT_FIELD);
    	positions.put("singled to right field, advanced to third on the throw", Position.RIGHT_FIELD);
    	positions.put("singled to right field, out at second rf to 1b to ss", Position.RIGHT_FIELD); // TODO g�rer ce cas particulier
    	positions.put("singled to right field, out at second rf to c to ss (2-1 BFB)", Position.RIGHT_FIELD); // TODO g�rer ce cas particulier
    	positions.put("singled to right field, out at second rf to ss (2-2 FBBSF)", Position.RIGHT_FIELD); // TODO g�rer ce cas particulier
    	positions.put("singled to right field, out on the play, assist by 1b", Position.RIGHT_FIELD); // TODO g�rer ce cas particulier
    	positions.put("singled to right field.", Position.RIGHT_FIELD);
    	positions.put("singled to second base", Position.SECOND_BASE);
    	positions.put("singled to second base (1-1 KB)", Position.SECOND_BASE);
    	positions.put("singled to second base (2-1 BBK).", Position.SECOND_BASE);
    	positions.put("singled to second base (2-2 BBKFF).", Position.SECOND_BASE);
    	positions.put("singled to second base (2-2 BFFB)", Position.SECOND_BASE);
    	positions.put("singled to second base (0-1 F)", Position.SECOND_BASE);
    	positions.put("singled to second base.", Position.SECOND_BASE);
    	positions.put("singled to shortstop", Position.SHORTSTOP);
    	positions.put("singled to shortstop (0-1 K)", Position.SHORTSTOP);
    	positions.put("singled to shortstop (0-1 K).", Position.SHORTSTOP);
    	positions.put("singled to shortstop (1-0 B)", Position.SHORTSTOP);
    	positions.put("singled to shortstop (1-2 KBK).", Position.SHORTSTOP);
    	positions.put("singled to shortstop (2-0 BB)", Position.SHORTSTOP);
    	positions.put("singled to shortstop (2-0 BB).", Position.SHORTSTOP);
    	positions.put("singled to shortstop (2-2 BKFB).", Position.SHORTSTOP);
    	positions.put("singled to shortstop (2-2 BKFBF)", Position.SHORTSTOP);
    	positions.put("singled to shortstop (2-2 KBFBFF).", Position.SHORTSTOP);
    	positions.put("singled to shortstop (2-2 KBSB).", Position.SHORTSTOP);
    	positions.put("singled to shortstop (2-2 KKBB).", Position.SHORTSTOP);
    	positions.put("singled to shortstop (3-1 BBFB).", Position.SHORTSTOP);
    	positions.put("singled to shortstop (3-2 BKBKB).", Position.SHORTSTOP);
    	positions.put("singled to shortstop, advanced to second", Position.SHORTSTOP);
    	positions.put("singled to shortstop, advanced to second on a throwing error by ss", Position.SHORTSTOP);
    	positions.put("singled to shortstop, advanced to second on a throwing error by ss (2-0 BB).", Position.SHORTSTOP);
    	positions.put("singled to shortstop, advanced to second on a throwing error by ss.", Position.SHORTSTOP);
    	positions.put("singled to shortstop, advanced to second on the throw", Position.SHORTSTOP);
    	positions.put("singled to shortstop, advanced to third on the throw", Position.SHORTSTOP);
    	positions.put("singled to shortstop.", Position.SHORTSTOP);
    	positions.put("singled to third base", Position.THIRD_BASE);
    	positions.put("singled to third base (0-0)", Position.THIRD_BASE);
    	positions.put("singled to third base (0-0).", Position.THIRD_BASE);
    	positions.put("singled to third base (1-0 B).", Position.THIRD_BASE);
    	positions.put("singled to third base (1-2 BSS)", Position.THIRD_BASE);
    	positions.put("singled to third base (2-2 KBBFFF).", Position.THIRD_BASE);
    	positions.put("singled to third base (3-2 BFKFBB)", Position.THIRD_BASE);
    	positions.put("singled to third base, advanced to second on a throwing error by 3b (1-1 KB).", Position.THIRD_BASE);
    	positions.put("singled to third base (1-1 FB)", Position.THIRD_BASE);
    	positions.put("singled to third base.", Position.THIRD_BASE);
    	positions.put("singled up the middle", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (0-0)", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (0-0).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (0-1 F).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (0-1 K).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (0-2 KK).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (1-0 B)", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (1-1 KB).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (1-2 KKBF)", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (1-2 KSB).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (2-1 BBK).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (2-1 BFB).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (2-1 FBB).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (2-2 BKBK).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (2-2 KBBFF).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (2-2 KKFBB)", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (3-1 BBKB)", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (3-2 BKBBF)", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle (3-2 BKFBB).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle, advanced to second on a throwing error by ss (0-1 K).", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle, advanced to second on an error by c", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle, advanced to second on the throw", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle, advanced to third on the error (1-1 BF)", Position.UP_THE_MIDDLE);
    	positions.put("singled up the middle.", Position.UP_THE_MIDDLE);
    	
//    	_map.put("stole ", Play.NO_PLAY); // STOLEN_BASE);
//    	_map.put("stole home, unearned.", Play.);
//    	_map.put("stole home.", Play.);
//    	_map.put("stole second", Play.);
//    	_map.put("stole second, advanced to third on a fielder's choice", Play.);
//    	_map.put("stole second, advanced to third on a fielding error by 2b.", Play.);
//    	_map.put("stole second, advanced to third on a muffed throw by 2b", Play.);
//    	_map.put("stole second, advanced to third on a muffed throw by ss.", Play.);
//    	_map.put("stole second, advanced to third on a passed ball", Play.);
//    	_map.put("stole second, advanced to third on a passed ball.", Play.);
//    	_map.put("stole second, advanced to third on a throwing error by c", Play.);
//    	_map.put("stole second, advanced to third on a throwing error by c.", Play.);
//    	_map.put("stole second, advanced to third on a wild pitch.", Play.);
//    	_map.put("stole second, advanced to third on the error", Play.);
//    	_map.put("stole second, failed pickoff attempt.", Play.);
//    	_map.put("stole second, out at second cf to ss.", Play.); // TODO g�rer ce cas particulier
//    	_map.put("stole second.", Play.);
//    	_map.put("stole third, scored on a throwing error by c, unearned.", Play.); // TODO g�rer ce cas particulier
//    	_map.put("stole third, scored on a throwing error by c.", Play.); // TODO g�rer ce cas particulier
//    	_map.put("stole third, scored on a throwing error by p, unearned.", Play.); // TODO g�rer ce cas particulier
//    	_map.put("stole third.", Play.);
    	
    	
//    	_map.put("struck out looking", Play.K_LOOKING);
//    	_map.put("struck out looking", Play.);
//    	_map.put("struck out looking (0-2 FFK).", Play.);
//    	_map.put("struck out looking (0-2 FKFK).", Play.);
//    	_map.put("struck out looking (0-2 KFK).", Play.);
//    	_map.put("struck out looking (0-2 KKK).", Play.);
//    	_map.put("struck out looking (0-2 KSK).", Play.);
//    	_map.put("struck out looking (0-2 SFK).", Play.);
//    	_map.put("struck out looking (0-2 SKK).", Play.);
//    	_map.put("struck out looking (1-2 BFKK).", Play.);
//    	_map.put("struck out looking (1-2 BKFK).", Play.);
//    	_map.put("struck out looking (1-2 BKKK).", Play.);
//    	_map.put("struck out looking (1-2 FBFFFFFK).", Play.);
//    	_map.put("struck out looking (1-2 FBFK).", Play.);
//    	_map.put("struck out looking (1-2 FFBK).", Play.);
//    	_map.put("struck out looking (1-2 FKBK).", Play.);
//    	_map.put("struck out looking (1-2 FSBK).", Play.);
//    	_map.put("struck out looking (1-2 KBKK).", Play.);
//    	_map.put("struck out looking (1-2 KFBK).", Play.);
//    	_map.put("struck out looking (1-2 KKBK).", Play.);
//    	_map.put("struck out looking (1-2 KSBK).", Play.);
//    	_map.put("struck out looking (1-2 SBSK).", Play.);
//    	_map.put("struck out looking (1-2 SKFBFK).", Play.);
//    	_map.put("struck out looking (2-2 BBKFK).", Play.);
//    	_map.put("struck out looking (2-2 BBKKFFK).", Play.);
//    	_map.put("struck out looking (2-2 BBKSK).", Play.);
//    	_map.put("struck out looking (2-2 BBSFK).", Play.);
//    	_map.put("struck out looking (2-2 BFBKK).", Play.);
//    	_map.put("struck out looking (2-2 BFFBFFK).", Play.);
//    	_map.put("struck out looking (2-2 BKBKK).", Play.);
//    	_map.put("struck out looking (2-2 BKKBFK).", Play.);
//    	_map.put("struck out looking (2-2 BSBFK).", Play.);
//    	_map.put("struck out looking (2-2 FBBFK).", Play.);
//    	_map.put("struck out looking (2-2 KBBFK).", Play.);
//    	_map.put("struck out looking (2-2 KBFBFK).", Play.);
//    	_map.put("struck out looking (2-2 KBFBK).", Play.);
//    	_map.put("struck out looking (2-2 KBSBFK).", Play.);
//    	_map.put("struck out looking (2-2 KBSBK).", Play.);
//    	_map.put("struck out looking (2-2 KFFBBK).", Play.);
//    	_map.put("struck out looking (2-2 KFFFBBFK).", Play.);
//    	_map.put("struck out looking (2-2 KKBBFFK).", Play.);
//    	_map.put("struck out looking (2-2 KKBBK).", Play.);
//    	_map.put("struck out looking (2-2 KKFBBK).", Play.);
//    	_map.put("struck out looking (2-2 KSBBK).", Play.);
//    	_map.put("struck out looking (2-2 SBBSK).", Play.);
//    	_map.put("struck out looking (2-2 SKBBK).", Play.);
//    	_map.put("struck out looking (3-2 BBBKKK).", Play.);
//    	_map.put("struck out looking (3-2 BBKBSFK).", Play.);
//    	_map.put("struck out looking (3-2 BBKFBFK).", Play.);
//    	_map.put("struck out looking (3-2 BBKSBFK).", Play.);
//    	_map.put("struck out looking (3-2 BFBFBK).", Play.);
//    	_map.put("struck out looking (3-2 BKBBFK).", Play.);
//    	_map.put("struck out looking (3-2 BKKBFBK).", Play.);
//    	_map.put("struck out looking (3-2 BSBBFFK).", Play.);
//    	_map.put("struck out looking (3-2 FBBFFFBK).", Play.);
//    	_map.put("struck out looking (3-2 FBBKBK).", Play.);
//    	_map.put("struck out looking (3-2 KBBBFK).", Play.);
//    	_map.put("struck out looking (3-2 KBBFBFK).", Play.);
//    	_map.put("struck out looking, reached first on a wild pitch (0-2 FKK).", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out looking.", Play.);
    	
    	
//    	_map.put("struck out swinging", Play.K_SWINGING);
//    	_map.put("struck out swinging", Play.);
//    	_map.put("struck out swinging (0-2 FFFS).", Play.);
//    	_map.put("struck out swinging (0-2 FFS).", Play.);
//    	_map.put("struck out swinging (0-2 FKS).", Play.);
//    	_map.put("struck out swinging (0-2 FSFS).", Play.);
//    	_map.put("struck out swinging (0-2 FSS).", Play.);
//    	_map.put("struck out swinging (0-2 KFFS).", Play.);
//    	_map.put("struck out swinging (0-2 KFS).", Play.);
//    	_map.put("struck out swinging (0-2 KKS).", Play.);
//    	_map.put("struck out swinging (0-2 KSFS).", Play.);
//    	_map.put("struck out swinging (0-2 KSS).", Play.);
//    	_map.put("struck out swinging (0-2 SFS).", Play.);
//    	_map.put("struck out swinging (0-2 SKS).", Play.);
//    	_map.put("struck out swinging (0-2 SSS).", Play.);
//    	_map.put("struck out swinging (1-2 BFKS).", Play.);
//    	_map.put("struck out swinging (1-2 BFSS).", Play.);
//    	_map.put("struck out swinging (1-2 BKFFS).", Play.);
//    	_map.put("struck out swinging (1-2 BKFS).", Play.);
//    	_map.put("struck out swinging (1-2 BKKS).", Play.);
//    	_map.put("struck out swinging (1-2 BKSFS).", Play.);
//    	_map.put("struck out swinging (1-2 BKSS).", Play.);
//    	_map.put("struck out swinging (1-2 BSFFFS).", Play.);
//    	_map.put("struck out swinging (1-2 BSFS).", Play.);
//    	_map.put("struck out swinging (1-2 BSKFFS).", Play.);
//    	_map.put("struck out swinging (1-2 BSKFS).", Play.);
//    	_map.put("struck out swinging (1-2 BSKS).", Play.);
//    	_map.put("struck out swinging (1-2 BSSS).", Play.);
//    	_map.put("struck out swinging (1-2 FBFS).", Play.);
//    	_map.put("struck out swinging (1-2 FBKFS).", Play.);
//    	_map.put("struck out swinging (1-2 FBSS).", Play.);
//    	_map.put("struck out swinging (1-2 FFBS).", Play.);
//    	_map.put("struck out swinging (1-2 FSBS).", Play.);
//    	_map.put("struck out swinging (1-2 KBFFS).", Play.);
//    	_map.put("struck out swinging (1-2 KBFS)", Play.);
//    	_map.put("struck out swinging (1-2 KBFS).", Play.);
//    	_map.put("struck out swinging (1-2 KBSS)", Play.);
//    	_map.put("struck out swinging (1-2 KBSS).", Play.);
//    	_map.put("struck out swinging (1-2 KFBFS).", Play.);
//    	_map.put("struck out swinging (1-2 KFBS).", Play.);
//    	_map.put("struck out swinging (1-2 KFFFBS).", Play.);
//    	_map.put("struck out swinging (1-2 KKBFFS).", Play.);
//    	_map.put("struck out swinging (1-2 KKBS).", Play.);
//    	_map.put("struck out swinging (1-2 KSBS).", Play.);
//    	_map.put("struck out swinging (1-2 KSFFFBFS).", Play.);
//    	_map.put("struck out swinging (1-2 SBKS).", Play.);
//    	_map.put("struck out swinging (1-2 SBSS).", Play.);
//    	_map.put("struck out swinging (1-2 SFBS).", Play.);
//    	_map.put("struck out swinging (1-2 SFFFBS).", Play.);
//    	_map.put("struck out swinging (1-2 SKFBS).", Play.);
//    	_map.put("struck out swinging (1-2 SSBS).", Play.);
//    	_map.put("struck out swinging (2-2 BFBKFS).", Play.);
//    	_map.put("struck out swinging (2-2 BFSFBS).", Play.);
//    	_map.put("struck out swinging (2-2 BKBSS).", Play.);
//    	_map.put("struck out swinging (2-2 BKFBFS).", Play.);
//    	_map.put("struck out swinging (2-2 BKFBS).", Play.);
//    	_map.put("struck out swinging (2-2 BKSFBS).", Play.);
//    	_map.put("struck out swinging (2-2 BSKBS).", Play.);
//    	_map.put("struck out swinging (2-2 FBKFBS).", Play.);
//    	_map.put("struck out swinging (2-2 FBSBFS).", Play.);
//    	_map.put("struck out swinging (2-2 FSBBS).", Play.);
//    	_map.put("struck out swinging (2-2 KBBKS).", Play.);
//    	_map.put("struck out swinging (2-2 KBFBS).", Play.);
//    	_map.put("struck out swinging (2-2 KBKBS).", Play.);
//    	_map.put("struck out swinging (2-2 KBKFBS).", Play.);
//    	_map.put("struck out swinging (2-2 KFFBBS).", Play.);
//    	_map.put("struck out swinging (2-2 SBBFFS).", Play.);
//    	_map.put("struck out swinging (2-2 SBBFS).", Play.);
//    	_map.put("struck out swinging (2-2 SBKFBS).", Play.);
//    	_map.put("struck out swinging (2-2 SBSBS).", Play.);
//    	_map.put("struck out swinging (2-2 SFBBS).", Play.);
//    	_map.put("struck out swinging (2-2 SSBBS).", Play.);
//    	_map.put("struck out swinging (3-2 BBBKFS).", Play.);
//    	_map.put("struck out swinging (3-2 BBBKKS).", Play.);
//    	_map.put("struck out swinging (3-2 BBFFFBS).", Play.);
//    	_map.put("struck out swinging (3-2 BBKBKS).", Play.);
//    	_map.put("struck out swinging (3-2 BBSFBS).", Play.);
//    	_map.put("struck out swinging (3-2 BKBBKS).", Play.);
//    	_map.put("struck out swinging (3-2 BKBBSFS).", Play.);
//    	_map.put("struck out swinging (3-2 BKBBSS).", Play.);
//    	_map.put("struck out swinging (3-2 BKBSBS).", Play.);
//    	_map.put("struck out swinging (3-2 BSSBBS).", Play.);
//    	_map.put("struck out swinging (3-2 FBKBBS).", Play.);
//    	_map.put("struck out swinging (3-2 FBKBFBFFS).", Play.);
//    	_map.put("struck out swinging (3-2 FFBFBFBS).", Play.);
//    	_map.put("struck out swinging (3-2 FKBBBS).", Play.);
//    	_map.put("struck out swinging (3-2 KBBFBFS).", Play.);
//    	_map.put("struck out swinging (3-2 KFBBBS).", Play.);
//    	_map.put("struck out swinging (3-2 KKBBBFS).", Play.);
//    	_map.put("struck out swinging (3-2 SBFBBS).", Play.);
//    	_map.put("struck out swinging to catcher (1-2 FBFS).", Play.);
//    	_map.put("struck out swinging to catcher (1-2 KFFBS).", Play.);
//    	_map.put("struck out swinging to catcher (2-2 FFBFBS).", Play.);
//    	_map.put("struck out swinging to catcher.", Play.);
//    	_map.put("struck out swinging, grounded out to c unassisted (0-2 KKF).", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging, hit into double play c to 2b (0-2 FKS)", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging, hit into double play c to 2b (3-2 KBBFBFS)", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging, out at first c to 1b", Play.);
//    	_map.put("struck out swinging, out at first c to 1b (0-2 FFS).", Play.);
//    	_map.put("struck out swinging, out at first c to 1b (0-2 KKS).", Play.);
//    	_map.put("struck out swinging, out at first c to 1b (0-2 KSS).", Play.);
//    	_map.put("struck out swinging, out at first c to 1b (0-2 SKS).", Play.);
//    	_map.put("struck out swinging, out at first c to 1b (1-2 BFKS).", Play.);
//    	_map.put("struck out swinging, out at first c to 1b (1-2 BSSFS).", Play.);
//    	_map.put("struck out swinging, out at first c to 1b (1-2 KFBS).", Play.);
//    	_map.put("struck out swinging, out at first c to 1b (2-2 BFBSS).", Play.);
//    	_map.put("struck out swinging, out at first c to 1b.", Play.);
//    	_map.put("struck out swinging, reached first on a passed ball", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging, reached first on a passed ball (1-2 BFKS)", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging, reached first on a passed ball.", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging, reached first on a throwing error by c (1-2 BFFS).", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging, reached first on a throwing error by c.", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging, reached first on a wild pitch.", Play.); // TODO g�rer ce cas particulier
//    	_map.put("struck out swinging.", Play.);
    	
//    	_map.put("struck out to catcher.", Play.K_SWINGING);
//    	_map.put("struck out, ", Play.K_SWINGING);
//    	_map.put("struck out, out at first c to 1b.", Play.K_SWINGING);
//    	_map.put("struck out, reached first on a muffed throw by 1b, assist by c", Play.K_SWINGING);
//    	_map.put("struck out, reached first on a passed ball", Play.);
//    	_map.put("struck out, reached first on a passed ball.", Play.);
//    	_map.put("struck out, reached first on a throwing error by c", Play.);
//    	_map.put("struck out, reached first on a wild pitch", Play.);
    	
//    	_map.put("struck out.", Play.K_SWINGING);
    	
//    	_map.put("to 1b", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to 1b for ", Play.SUBSTITUTION);
//    	_map.put("to 1b.", Play.);
    	
//    	_map.put("to 2b", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to 2b for ", Play.);
//    	_map.put("to 2b.", Play.);
    	
//    	_map.put("to 3b", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to 3b for .", Play.);
//    	_map.put("to 3b.", Play.);
    	
//    	_map.put("to c", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to c for ", Play.);
//    	_map.put("to c.", Play.);
//    	_map.put("to cf for ", Play.);
//    	_map.put("to cf.", Play.);
    	
//    	_map.put("to dh", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to dh for ", Play.);
//    	_map.put("to dh.", Play.);
    	
//    	_map.put("to lf", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to lf for ", Play.);
//    	_map.put("to lf.", Play.);
    	
//    	_map.put("to p", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to p for ", Play.);
//    	_map.put("to p.", Play.);
    	
//    	_map.put("to rf", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to rf for ", Play.);
//    	_map.put("to rf.", Play.);
    	
//    	_map.put("to ss", Play.NO_PLAY); // SUBSTITUTION);
//    	_map.put("to ss ", Play.);
//    	_map.put("to ss.", Play.);
    	
    	positions.put("tripled ", Position.UNLOCATED_BATTED_BALL);
    	positions.put("tripled down the lf line.", Position.LEFT_FIELD);
    	positions.put("tripled down the rf line", Position.RIGHT_FIELD);
    	positions.put("tripled down the rf line (3-1 BBKB).", Position.RIGHT_FIELD);
    	positions.put("tripled down the rf line.", Position.RIGHT_FIELD);
    	positions.put("tripled through the left side", Position.LEFT_FIELD);
    	positions.put("tripled to center field", Position.CENTER_FIELD);
    	positions.put("tripled to center field (1-1 BK)", Position.CENTER_FIELD);
    	positions.put("tripled to center field.", Position.CENTER_FIELD);
    	positions.put("tripled to first base, scored on the throw",  Position.FIRST_BASE); // TODO g�rer ce cas particulier
    	positions.put("tripled to left center", Position.LEFT_FIELD);
    	positions.put("tripled to left center (2-2 BFKB).", Position.LEFT_FIELD);
    	positions.put("tripled to left center, scored on a muffed throw by 3b.", Position.LEFT_FIELD); // TODO g�rer ce cas particulier
    	positions.put("tripled to left center.", Position.LEFT_FIELD);
    	positions.put("tripled to left field", Position.LEFT_FIELD);
    	positions.put("tripled to left field.", Position.LEFT_FIELD);
    	positions.put("tripled to right center", Position.RIGHT_FIELD);
    	positions.put("tripled to right center (1-0 B)", Position.RIGHT_FIELD);
    	positions.put("tripled to right center (1-2 FKB)", Position.RIGHT_FIELD);
    	positions.put("tripled to right center (1-2 KKBF)", Position.RIGHT_FIELD);
    	positions.put("tripled to right center (2-0 BB)", Position.RIGHT_FIELD);
    	positions.put("tripled to right center (2-2 KFBFB).", Position.RIGHT_FIELD);
    	positions.put("tripled to right center.", Position.RIGHT_FIELD);
    	positions.put("tripled to right field", Position.RIGHT_FIELD);
    	positions.put("tripled to right field.", Position.RIGHT_FIELD);
    	
//    	_map.put("walked", Play.WALK);
//    	_map.put("walked", Play.);
//    	_map.put("walked (3-0 BBBB)", Play.);
//    	_map.put("walked (3-0 BBBB).", Play.);
//    	_map.put("walked (3-1 BBBKB)", Play.);
//    	_map.put("walked (3-1 BBBKB).", Play.);
//    	_map.put("walked (3-1 BBFBB).", Play.);
//    	_map.put("walked (3-1 BBKBB)", Play.);
//    	_map.put("walked (3-1 BBKBB).", Play.);
//    	_map.put("walked (3-1 BBSBB).", Play.);
//    	_map.put("walked (3-1 BFBBB).", Play.);
//    	_map.put("walked (3-1 BKBBB)", Play.);
//    	_map.put("walked (3-1 BKBBB).", Play.);
//    	_map.put("walked (3-1 BSBBB)", Play.);
//    	_map.put("walked (3-1 KBBBB).", Play.);
//    	_map.put("walked (3-2 BBBKFB).", Play.);
//    	_map.put("walked (3-2 BBBKKB).", Play.);
//    	_map.put("walked (3-2 BBFFBB)", Play.);
//    	_map.put("walked (3-2 BBFFBB).", Play.);
//    	_map.put("walked (3-2 BBFKBB)", Play.);
//    	_map.put("walked (3-2 BBKBKFB)", Play.);
//    	_map.put("walked (3-2 BBKBSB).", Play.);
//    	_map.put("walked (3-2 BBKKBB).", Play.);
//    	_map.put("walked (3-2 BBKKBFB)", Play.);
//    	_map.put("walked (3-2 BBKKFFBB).", Play.);
//    	_map.put("walked (3-2 BBSBKB)", Play.);
//    	_map.put("walked (3-2 BBSSBB).", Play.);
//    	_map.put("walked (3-2 BFBKBB).", Play.);
//    	_map.put("walked (3-2 BFKFBBB).", Play.);
//    	_map.put("walked (3-2 BKBBFB).", Play.);
//    	_map.put("walked (3-2 BKBBFFB).", Play.);
//    	_map.put("walked (3-2 BKBBKB).", Play.);
//    	_map.put("walked (3-2 BKBBKFB).", Play.);
//    	_map.put("walked (3-2 BKBFBB)", Play.);
//    	_map.put("walked (3-2 BKBFBB).", Play.);
//    	_map.put("walked (3-2 BKBFBFB).", Play.);
//    	_map.put("walked (3-2 BKBFFBB)", Play.);
//    	_map.put("walked (3-2 BKBKBB).", Play.);
//    	_map.put("walked (3-2 BKBKFBB)", Play.);
//    	_map.put("walked (3-2 BKFBBB).", Play.);
//    	_map.put("walked (3-2 BKFBFBB)", Play.);
//    	_map.put("walked (3-2 BSBBKB)", Play.);
//    	_map.put("walked (3-2 BSKFBBB)", Play.);
//    	_map.put("walked (3-2 FBBBKB)", Play.);
//    	_map.put("walked (3-2 FBBKBB).", Play.);
//    	_map.put("walked (3-2 FBFBBB).", Play.);
//    	_map.put("walked (3-2 FBFFBFBFB)", Play.);
//    	_map.put("walked (3-2 FBSBBB).", Play.);
//    	_map.put("walked (3-2 KBBBFFB).", Play.);
//    	_map.put("walked (3-2 KBBBKB).", Play.);
//    	_map.put("walked (3-2 KBBFBFB).", Play.);
//    	_map.put("walked (3-2 KBFBBB).", Play.);
//    	_map.put("walked (3-2 KBKBBB)", Play.);
//    	_map.put("walked (3-2 KBKBBB).", Play.);
//    	_map.put("walked (3-2 KBKBFBB).", Play.);
//    	_map.put("walked (3-2 KBKFBBB)", Play.);
//    	_map.put("walked (3-2 KBKFFFBFBB).", Play.);
//    	_map.put("walked (3-2 KBSBBB).", Play.);
//    	_map.put("walked (3-2 KKBBBB).", Play.);
//    	_map.put("walked (3-2 KKBBBFFB).", Play.);
//    	_map.put("walked (3-2 KKFFBBFFBB)", Play.);
//    	_map.put("walked (3-2 SBBBSFB).", Play.);
//    	_map.put("walked (3-2 SBKBBB).", Play.);
//    	_map.put("walked, advanced to second on the throw", Play.); // TODO g�rer ce cas particulier
//    	_map.put("walked.", Play.);
    	
    	
    	return positions;
    }

    /** return all plays, runners or hitters */
    public Map<String, Play> loadAllPlays() {
    	
    	Map<String, Play> plays = new HashMap<String, Play>();
    	
    	plays.put("/ ", Play.NO_PLAY);
    	plays.put("- obr _ Infield fly not caught ", Play.NO_PLAY);
    	plays.put("- OBR - Running out of line ", Play.NO_PLAY);
    	plays.put("- On the same play -.", Play.RUNNER_OUT_ON_THE_PLAY);
    	plays.put("advanced to ", Play.RUNNER_ADVANCE);
    	plays.put("Batter set", Play.NO_PLAY);
    	plays.put("Coach visit ", Play.NO_PLAY);
    	plays.put("Coaching visit ", Play.NO_PLAY);
    	plays.put("coach visit ", Play.NO_PLAY);
    	plays.put("coaching visit ", Play.NO_PLAY);
    	plays.put("Defensive indifference", Play.NO_PLAY);
    	plays.put("doubled", Play.SLUGGING_2B);
    	plays.put("failed pickoff attempt", Play.NO_PLAY);
    	plays.put("flied out to ", Play.FLIED_OUT);
    	plays.put("foul ball, ", Play.NO_PLAY);
    	plays.put("fouled into double play ", Play.DOUBLE_PLAY);
    	plays.put("fouled out to ", Play.FLIED_OUT);
    	plays.put("grounded into double play ", Play.DOUBLE_PLAY);
    	plays.put("grounded out to ", Play.GROUNDED_OUT);
    	plays.put("hit by pitch", Play.HIT_BY_PITCH);
    	plays.put("hit into double play ", Play.DOUBLE_PLAY);
    	plays.put("homered", Play.SLUGGING_4B);
    	plays.put("indifference .", Play.NO_PLAY);
    	plays.put("infield fly double play ", Play.DOUBLE_PLAY);
    	plays.put("infield fly to ", Play.FLIED_OUT);
    	plays.put("intentionally walked", Play.INTENTIONAL_WALK);
    	plays.put("lined into double play ", Play.DOUBLE_PLAY);
    	plays.put("lined out to ", Play.LINED_OUT);
    	plays.put("no advance.", Play.NO_PLAY);
    	plays.put("No play.", Play.NO_PLAY);
    	plays.put("No time asked during defensive conference ", Play.NO_PLAY);
    	plays.put("On the same play ", Play.NO_PLAY);
    	plays.put("out at first ", Play.OUT);
    	plays.put("out at home ", Play.RUNNER_OUT_AT_HOME);
    	plays.put("out at second ", Play.RUNNER_OUT_AT_SECOND);
    	plays.put("out at third ", Play.RUNNER_OUT_AT_THIRD);
    	plays.put("out by rule - Batter's interference ", Play.RUNNER_OUT_AT_SECOND);// TODO � v�rifier
    	plays.put("out by rule - Bunted foul on third strike ", Play.OBR);// TODO � v�rifier
    	plays.put("out by rule - Interference by preceding runner ", Play.OBR);// TODO � v�rifier
    	plays.put("out by rule - Interference by the batter ", Play.NO_PLAY);
    	plays.put("out by rule - Runner interfered with fielder ", Play.NO_PLAY);
    	plays.put("out by rule - Running out of line ", Play.OBR); // TODO � v�rifier
    	plays.put("out by rule - Touched by own batted ball ", Play.OBR);// TODO � v�rifier
    	plays.put("out by rule - Touched by fair ball ", Play.NO_PLAY);
    	plays.put("out by rule - Infield fly not caught ", Play.NO_PLAY);
    	plays.put("out on batter's interference", Play.OBR);
    	plays.put("out on double play ", Play.RUNNER_OUT_ON_THE_PLAY);
    	plays.put("out on the play", Play.RUNNER_OUT_ON_THE_PLAY);
    	plays.put("pinch hit ", Play.SUBSTITUTION);
    	plays.put("pinch hit.", Play.SUBSTITUTION);
    	plays.put("pinch ran for ", Play.SUBSTITUTION);
    	plays.put("placed on first.", Play.TIE_BREAK_PLACED_ON_1B);
    	plays.put("placed on second.", Play.TIE_BREAK_PLACED_ON_2B);
    	plays.put("picked off,", Play.RUNNER_PICKED_OFF);
    	plays.put("popped into double play ", Play.DOUBLE_PLAY);
    	plays.put("popped up to ", Play.FLIED_OUT);
    	plays.put("reached on a dropped fly by ", Play.SAFE_ON_ERROR);
    	plays.put("reached on a fielder's choice to ", Play.SAFE_ON_FIELDER_CHOICE);
    	plays.put("reached on a fielder's choice,", Play.SAFE_ON_FIELDER_CHOICE);
    	plays.put("reached on a fielding error by ", Play.SAFE_ON_ERROR);
    	plays.put("reached on a muffed throw by ", Play.SAFE_ON_ERROR);
    	plays.put("reached on a throwing error by ", Play.SAFE_ON_ERROR);
    	plays.put("reached on an error by ", Play.SAFE_ON_ERROR);
    	plays.put("safe on a muffed throw by 1b, no advance, assist by rf.", Play.NO_PLAY);
    	plays.put("reached on catcher's interference", Play.OBR);
    	plays.put("set to ", Play.NO_PLAY);
    	plays.put("scored", Play.SCORE);
    	plays.put("singled ", Play.SLUGGING_1B);
    	plays.put("stole ", Play.STOLEN_BASE); 
    	plays.put("struck out looking", Play.K_LOOKING);
    	plays.put("struck out swinging", Play.K_SWINGING);
    	plays.put("struck out to catcher.", Play.K_SWINGING);
    	plays.put("struck out, ", Play.K_SWINGING);
    	plays.put("struck out.", Play.K_SWINGING);
    	plays.put("time asked during defensive conference .", Play.NO_PLAY);
    	plays.put("to ", Play.SUBSTITUTION);
    	plays.put("tripled ", Play.SLUGGING_3B);
    	plays.put("the same play ", Play.NO_PLAY);
    	plays.put("visit to ", Play.NO_PLAY);
    	plays.put("walked", Play.WALK);
    	return plays;
    }
}
