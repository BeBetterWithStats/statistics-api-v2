package fr.bbws.api.statistics.mapper;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticSearchMapper {

	final static Logger logger = LogManager.getLogger(ElasticSearchMapper.class.getName());
	
	static TransportClient client = null;
	
	/** Constructeur prive */  
    private ElasticSearchMapper(){
    }
     
    /** Holder */
    private static class ElasticSearchMapperHolder {       
        /** Instance unique non preinitialisee */
        private final static ElasticSearchMapper instance = new ElasticSearchMapper();
    }
 
    /** Point d'acces pour l'instance unique du singleton */
    public static ElasticSearchMapper getInstance() {
        return ElasticSearchMapperHolder.instance;
    }
    
    @SuppressWarnings("resource")
	public TransportClient open() {
    	
    	if (client == null) {
    		
    		logger.info("## ElasticSearchMapper : {}", "Try to connect ElasticSearch");
    		try {
				Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
				client = new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
				logger.info("## ElasticSearchMapper : Status -- {}", "OK");
				return client;
		    } catch (UnknownHostException e) {
				logger.fatal("## ElasticSearchMapper : Status -- {}", "KO");
				logger.fatal("    -> ID : {}", "localhost:9300");
				e.printStackTrace();
				return null;
			}
    	} else {
    		logger.debug("## ElasticSearchMapper : {}", "Reuse of a previous connection");
    		return client;
    	}
    	
    }
    
    public boolean close() {
    	
    	logger.info("## ElasticSearchMapper : {}", "Try to close ElasticSearch");
		
    	if (client != null) {
			client.close();
			logger.info("## ElasticSearchMapper : Status -- {}", "OK");
    		return true;
		} else {
			logger.fatal("## ElasticSearchMapper : Status -- {}", "KO");
			logger.fatal("    -> REASON : {}", "Try to close a non opened connection");
    		return false;
		}
    }
	
	/*
	@Deprecated
	@SuppressWarnings("resource")
	public static void generateDocuments(Path file, Player player, String field, String oppositeTeam, String umpire, Date date) {

// ############## PARCOURIR LE FICHIER
// ############## ET LE STOCKER EN MEMOIRE
		
		StringBuffer buffer = new StringBuffer();
		
		try {

			List<String> lignestmp = Files.readAllLines(file, Charset.forName("ISO-8859-1"));
					
					//
					// ON NE VA EXTRAIRE QUE LES LIGNES
					// QUI NOUS INTERESSENT
					// A SAVOIR CELLE DU PLAY BY PLAY
					//
					boolean b = false;
					for (String ligne : lignestmp) { // pour chaque ligne du fichier
						
						if (ligne.startsWith("<font size=2><b>")) {
							
							buffer.append(ligne);
							b = true;
							
						} else if (ligne.startsWith("</font>")) {
							
							b = false;
							
						} else {
							if (b) {
								buffer.append(" ").append(ligne);
							}
						}
					}
					// FIN - EXTRACTION
					
		} catch (IOException e) {
			e.printStackTrace();
		}
// ############## FIN -- PARCOURIR LE FICHIER
// ############## FIN -- ET LE STOCKER EN MEMOIRE

		
// ############## OUVERTURE DU SERVEUR ELASTICSEARCH
		
		TransportClient client = null;
		
		try {
			
			Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
			client = new PreBuiltTransportClient(settings).addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
			
		} catch (UnknownHostException e) {
			
			logger.fatal("[FATAL] Impossible de se connecter au serveur ElasticSearch : " + "localhost:9300");
			e.printStackTrace();
		}


		

// ############## ON DECOUPE LE FICHIER HTML EN INNING

		String[] html = buffer.toString().split("<font size=2><b>");
		
		List<String> innings = new ArrayList<String>();
		for (String div : html) {
			innings.add( div);
		}
		
		innings.remove(0);
		
		
		
// ############## ON DECOUPE CHAQUE INNING EN ACTION
		
		boolean print_error = true;
		Map<String, Object> json = new TreeMap<String, Object>();
		
		for (String inning : innings) {
			
			List<String> plays = SearchInFileUtils.searchAfterWithAfterWordAndSpaceIncluded(inning, player.getID());
			
			if (null != plays) {
				
				for (String play : plays) {
					
					json.clear(); // reinitilisation du json
					print_error = true;
					
					for (String key : plate_appearance_words.keySet()) {
						
						if (play.startsWith(player.getID() + key)) { // si un des mot clé apparait

							print_error = false;
							
							//
							// ############## CONSTRUCTION DU DOCUMENT JSON
							// ############## POUR CHAQUE ACTION DU JOUEUR
							
							 
							//  ############## exemple de JSON en sortie
							 
//							{
//							    "day": "2018-05-28 14:05:00",
//							    "field": "Templiers Stadium",
//							    "opposite team": "Rouen",
//							    "umpire": {
//							            "id": "AZERTY",
//										"prenom": "azerty",
//							            "nom": "azerty"
//							    },
//							    "player": {
//							            "id": "AZERTY",
//										"prenom": "azerty",
//							            "nom": "Leroux",
//										"fielding position": 4,
//										"lineup position": 1,
//										"team": "azerty"
//							    },
//								"play": {
//									"slugging": 2,
//									"hitting position": 6,
//									"inning": "2nd",
//									"opposite pitcher": "QWERTY"
//								}
//							}
							
							
							
							json.put("day", date.toString());
							json.put("field", field);
							json.put("opposite-team", oppositeTeam);
							json.put("umpire-id", umpire);
							json.put("player-id", player.getID());
							json.put("player-team", player.getTeam());
							json.put("player-field-position", player.getFieldPosition());
							json.put("player-batting-order", player.getBattingOrder());
							json.put("play-when", SearchInFileUtils.searchBetween(inning, player.getTeam(), "- </b>"));
							json.put("play-where", plate_appearance_words.get(key));
							json.put("play-slugging", slugging_key_words.get(key) != null ? slugging_key_words.get(key).intValue() - KEY_WORDS.OUT.intValue() : 0);
							json.put("play-against", "TODO"); // TODO opposite pitcher
							
							IndexResponse response = client.prepareIndex("baseball-eu", "play").setSource(json, XContentType.JSON).get();
							
							break;							
						}
					}
					
					if (print_error) {
						
						for (String key : noplay_key_words) {
							
							if (play.startsWith(player.getID() + key)) {
								print_error = false;
							}
						}
						
						if (print_error) {
							logger.error("[ERROR] missing play = '" + play + "' [" + file + "]");
							print_error = false;
						} else {
							// NE RIEN FAIRE
						}
					}
				}
			}
		}
		// FIN - DECOUPAGE DE CHAQUE INNING EN ACTION
		

		// ON FERME LA CONNEXION A ELASTICSEARCH
		if (client != null) {
			client.close();
		}
	}
	*/
}
