package fr.bbws.api.statistics.river;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.bbws.api.statistics.Main;
import fr.bbws.api.statistics.model.Play;
import fr.bbws.api.statistics.model.Player;
import fr.bbws.api.statistics.model.Position;

public class PlateAppearanceRiver {

	private HttpServer server;

	private WebTarget target;

	final static Logger logger = LogManager.getLogger(PlateAppearanceRiver.class.getName());

    @Before
    public void setUp() throws Exception {
        // start the server
        // server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        //server.stop();
    }

	@Test
	public void start() {

		long begin = System.currentTimeMillis();

		ArrayList<Path> file_directories = new ArrayList<Path>();
		// file_directories.add(Paths.get("/Users/alexandrelods/Documents/Developpement/bbws/Games/stats 2019 D2 FR"));
		// file_directories.add(Paths.get("/Users/alexandrelods/Documents/Developpement/bbws/Games/stats 2019 D1 FR"));
		file_directories.add(Paths.get("/Users/A477315/workspace/statistic/statistics-api-v2-master/fichier"));

		logger.info("##########  ----------  ##########");
		logger.info("##########  BBWS RIVER  ##########");
		logger.info("##########  ----------  ##########");

		logger.info("[{}] The river is starting...", "ENTRY");

		StringBuffer buffer = new StringBuffer();

		// ############## PARCOURIR LE REPERTOIRE DES FEUILLES DE MATCH
		// ############## ET LE STOCKER EN MEMOIRE
		for (Path _file_dir : file_directories) {

			try {

				DirectoryStream<Path> stream = Files.newDirectoryStream(_file_dir); // repertoire contenant les fichiers HTML

				try {

					Iterator<Path> iterator = stream.iterator();


					// ##############
					// ############## POUR CHAQUE FICHIER DU REPERTOIRE
					// ##############
					while (iterator.hasNext()) {

						Path _current_file = iterator.next();
						logger.info("[{}] BEGIN [_current_file] = [{}]", "river", _current_file);

						if (!_current_file.toString().endsWith("DS_Store")) { // pour eviter les pb sur MAC OS

							List<String> lines = Files.readAllLines(_current_file, Charset.forName("ISO-8859-1"));
							buffer.delete(0, buffer.length());

							// ####  1  ### on deverse les lignes du fichier courant dans un StringBuffer
							for (String line : lines) { // pour chaque ligne du fichier
								buffer.append(line).append(" ");
							}

							// ####  2  ### on recherche la date de la rencontre
							LocalDateTime _localDate = null;
							try {

								// plusieurs formats sont possibles pour la date
								DateTimeFormatter _formatter = DateTimeFormatter.ofPattern("MMM d, yyyy HH:mm", Locale.ENGLISH);
								_localDate = LocalDateTime.parse(searchDate(buffer.toString()) + " " + searchTime(buffer.toString()), _formatter);

							} catch (Exception e) {

								try {

									DateTimeFormatter _formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH,mm", Locale.FRANCE);
									_localDate = LocalDateTime.parse(searchDate(buffer.toString()) + " " + searchTime(buffer.toString()), _formatter);

								} catch (Exception e1) {

									try {

										DateTimeFormatter _formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.FRANCE);
										_localDate = LocalDateTime.parse(searchDate(buffer.toString()) + " " + searchTime(buffer.toString()), _formatter);

									} catch (Exception e2) {
										logger.error("[{}] [_date & heure] = date can not be parsed in file [{}]", "river", _current_file);
										logger.error("[{}] [_date] = {}", "river", searchDate(buffer.toString()));
										logger.error("[{}] [_heure] = {}", "river", searchTime(buffer.toString()));
									}
								}
							}
							logger.debug("[{}] [_date & heure] = {}", "river", _localDate);


							// ####  3  ### on recherche l'arbitre de plaque
							String _umpire = searchHomePlateUmpire(buffer.toString());
							logger.debug("[{}] [_umpire] = {}", "river", _umpire);


							// ####  4  ### on recherche le terrain sur lequel s'est joue la rencontre
							String _field = searchField(buffer.toString());
							logger.debug("[{}] [_field] = {}", "river", _field);


							// ####  5  ### on recherche le nom de chaque equipe
							String _awayTeamName = searchAwayTeam(buffer.toString());
							String _homeTeamName = searchHomeTeam(buffer.toString());



							// ####  6  ### on recherche le line up de l'equipe visiteur
							List<Player> _awayTeam = searchAwayTeamStartingLineUp( buffer.toString());

							logger.debug("[{}] [_away team name] = {}", "river", _awayTeamName);
							logger.info("[{}] [_away team] = {}", "river", _awayTeam);

							createDocuments(
											_current_file,
											_awayTeam,
											_field,
											_homeTeamName,
											_umpire,
											_localDate
											);




							// ####  7  ### on recherche le line up de l'equipe recevante
							List<Player> _homeTeam = searchHomeTeamStartingLineUp( buffer.toString());

							logger.debug("[{}] [_home team name] = {}", "river", _homeTeamName);
							logger.info("[{}] [_home team] = {}", "river", _homeTeam);

							createDocuments(
											_current_file,
											_homeTeam,
											_field,
											_awayTeamName,
											_umpire,
											_localDate
											);

						} else {
							logger.info("[{}] = {}", "river", "DS_Store file is ignored.");
						}

						logger.info("[{}] END [_current_file] = [{}]", "river", _current_file);

					} // ############## FIN DU FICHIER COURANT
				} finally {
					logger.info("[{}] The river is shuting down...", "EXIT");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}



		long time = System.currentTimeMillis() - begin;
		logger.info("##########  [Execution time] = {}", time);
	}

	private String searchHomePlateUmpire(String p_file) {

		String[] lines = p_file.split("Umpires - ");
		String umpires = lines[1].split("<br>")[0];
		return SearchInFileUtils.searchFirstUppercaseWordAfter(umpires, "HP: ");
	}

	private String searchDate(String p_file) {

		try {

			String[] lines = p_file.split("</title>");
			return lines[0].split("\\(")[1].replaceFirst("\\)", "");

		} catch (Exception e) {
			return "#erreur#";
		}
	}

	private String searchTime(String p_file) {

		try {

			String[] lines = p_file.split("<br>Start: ");
			return lines[1].split(" ")[0];

		} catch (Exception e) {
			return "#erreur#";
		}
	}

	private List<Player> searchAwayTeamStartingLineUp(String p_file) {
		return searchStartingLineUp(p_file, 5, searchAwayTeam(p_file));
	}

	private List<Player> searchHomeTeamStartingLineUp(String p_file) {
		return searchStartingLineUp(p_file, 6, searchHomeTeam(p_file));
	}

	private String searchAwayTeam(String p_file) {
		return searchTeam(p_file, 5);
	}

	private String searchHomeTeam(String p_file) {
		return searchTeam(p_file, 6);
	}

	private String searchField(String p_file) {

		String[] lines = p_file.split( searchDate(p_file) + " at ");
		return lines[1].split("<br>")[0].trim();
	}


	/**
	 * Find the player's name as it is written in the game sheet.
	 * @return A string you can consider as an ID for the player. It could be 'PERDOMO' ou 'PERDOMO A' ou 'PERDOMO Al'
	 */
	private static String searchPlayerFromPlay(String play) {

		String response = "";
		String[] strings = play.replaceAll("-", " ").split(" ");
		/*
		 * TODO traiter les caracteres speciaux '_', ',', ';' qui font que
		 * le nom de l'arbitre arrive en minuscule
		 */

		for (String _string : strings) {
			try {
				if (StringUtils.isAllUpperCase(_string.substring(0, 1))) {
					response += _string + " ";
				} else {
					break;
				}
			} catch (Exception e) {
				return null;
			}
		}

		if (response.length() > 0) {
			return response.trim();
		} else {
			return null;
		}
	}

	/**
	 *
	 * @param p_file
	 * @param line, le lineup de l'equipe visiteuse est en position 5, le lineup de l'equipe recevante est en position 6
	 * @return le nom des joueurs par position sur le terrain
	 */
	private static List<Player> searchStartingLineUp(String p_file, int p_line, String p_team) {

		String[] lines = p_file.split("<font face=verdana size=2>");
		List<Player> lineup = new ArrayList<Player>();

		// en decoupant le fichier suivant la chaine de caractère "<font face=verdana size=2>"
		// le lineup de l'equipe visiteuse est en position 5
		// le lineup de l'equipe recevante est en position 6
		// c'est cette valeur qui doit etre passe dans le @param line
		String[] strings = lines[p_line].replaceFirst(p_team + " starters:", "").split(";");

		String jersey = null;
		String position = null;
		String name = null;
		Player player = null;
		int order = 0;

		for (String _string : strings) {

			// COMMENT TO DEV : _string.trim() = 25/lf MARTINEZ R
			try {

				jersey = SearchInFileUtils.searchBefore(_string.trim(), "/");
				position  = SearchInFileUtils.searchBefore(_string.trim().substring(jersey.length() + 1), " ");
				name = _string.trim().substring(jersey.length() + position.length() + 1).trim();
				player = new Player(name, p_team, jersey, null, 0);

			} catch (Exception e) {
				// ne rien faire
				// le bloc switch se chargera de ne pas alimenter la liste
				jersey = "N/A";
				position = "N/A";
				player = null;
			}

			switch (position) {
				case "p":
					player.setFieldPosition(Position.PITCHER);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "c":
					player.setFieldPosition(Position.CATCHER);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "1b":
					player.setFieldPosition(Position.FIRST_BASE);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "2b":
					player.setFieldPosition(Position.SECOND_BASE);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "3b":
					player.setFieldPosition(Position.THIRD_BASE);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "ss":
					player.setFieldPosition(Position.SHORTSTOP);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "lf":
					player.setFieldPosition(Position.LEFT_FIELD);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "cf":
					player.setFieldPosition(Position.CENTER_FIELD);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "rf":
					player.setFieldPosition(Position.RIGHT_FIELD);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				case "dh":
					player.setFieldPosition(Position.DESIGNATED_HITTER);
					player.setBattingOrder(++order);
					lineup.add(player);
					break;

				default:
					break;
			}
		}

		return lineup;
	}

	/**
	 *
	 * @param p_file
	 * @param p_line, le lineup de l'equipe visiteuse est en position 5, le lineup de l'equipe recevante est en position 6
	 * @return le nom de l'equipe
	 */
	private static String searchTeam(String p_file, int p_line) {

		String[] lines = p_file.split("<font face=verdana size=2>");

		// en decoupant le fichier suivant la chaine de caractère "<font face=verdana size=2>"
		// le lineup de l'equipe visiteuse est en position 5
		// le lineup de l'equipe recevante est en position 6
		// c'est cette valeur qui doit etre passe dans le @param line

		return lines[p_line].split(" starters:")[0].trim();
	}


	/**
	 * Genere toutes les plate appearances trouvees dans la feuille de match @p_file pour les joueurs presents dans @p_players
	 *
	 * @param p_file
	 * @param p_players
	 * @param p_field
	 * @param p_oppositeTeam
	 * @param p_umpire
	 * @param p_date
	 */
	private boolean createDocuments(Path p_file, List<Player> p_players, String p_field, String p_oppositeTeam, String p_umpire, LocalDateTime p_date) {

		// ############## PARCOURIR LE FICHIER
		// ############## ET LE STOCKER EN MEMOIRE

		StringBuffer buffer = new StringBuffer();

		try {

			List<String> lignestmp = Files.readAllLines(p_file, Charset.forName("ISO-8859-1"));

					// ON NE VA EXTRAIRE QUE LES LIGNES
					// QUI NOUS INTERESSENT
					// A SAVOIR CELLE DU PLAY BY PLAY
					boolean b = false;
					for (String _ligne : lignestmp) { // pour chaque ligne du fichier

						if (_ligne.startsWith("<font size=2><b>")) {

							buffer.append(_ligne);
							b = true;

						} else if (_ligne.startsWith("</font>")) {

							b = false;

						} else {
							if (b) {
								buffer.append(" ").append(_ligne);
							}
						}
					}
					// FIN - EXTRACTION

		} catch (IOException e) {
			e.printStackTrace();
		}

		// ############## FIN -- PARCOURIR LE FICHIER
		// ############## FIN -- ET LE STOCKER EN MEMOIRE








		// ############## DECOUPER LE FICHIER HTML EN INNING

		String[] html = buffer.toString().split("<font size=2><b>");

		List<String> innings = new ArrayList<String>();
		for (String _div : html) {
			innings.add( _div);
		}

		innings.remove(0);

		// ############## FIN -- DECOUPER LE FICHIER HTML EN INNING





		final Map<String, Play> ALL_PLAYS = PlateAppearanceConfiguration.getInstance().loadAllPlays();
		final Map<String, Position> ALL_POSITIONS = PlateAppearanceConfiguration.getInstance().loadAllPositions();
		Map<String, Object> _json = new TreeMap<String, Object>();
		List<String> _plays = new ArrayList<String>();
		List<String> __plays = new ArrayList<String>();
		String _when = null;
		Player _who = null;
		Play _what = null;
		Position _where = null;
		String _keyword = null;




		// ############## DECOUPER CHAQUE INNING EN ACTION
		for (String _inning : innings) {

			_inning = _inning.replaceAll("</font>", "</font>#").replaceAll("\\. ", "\\.#");
			_when = SearchInFileUtils.searchBetween(_inning, p_players.get(0).getTeam(), "- </b>");
			logger.debug("[{}] [_when] = {}", "createDocuments", _when);


			if (null != _when) {
				// si l'inning correspond a l'equipe passee en parametre
				// on decoupe alors l'inning en action

				_plays.clear();
				Collections.addAll(_plays, _inning.split("#"));

				// on supprime deux actions qui sont
				// "<i><b>x runs, x hit, x error, x LOB.</b></i>"
				// et "xxxx - </b></font>"
				_plays.remove(_plays.size() - 1);
				_plays.remove(0);


				for (String _play : _plays) {

					logger.debug("[{}] [_play] = {}", "createDocuments", _play);

					__plays.clear();
					Collections.addAll(__plays, _play.split("; "));

					for (String __play : __plays) {

						logger.debug("[{}]     [__play] = {}", "createDocuments", __play);

						_who = new Player( searchPlayerFromPlay(__play.replaceAll("::: ", "")));
						logger.debug("[{}]          [SearchInFileUtils.searchPlayerFromPlay()] = {}", "createDocuments", _who.getID());

						_keyword = __play.replaceAll(", SAC", "")
											.replaceAll(", SF", "")
											.replaceAll(", 4 RBI", "")
											.replaceAll(", 3 RBI", "")
											.replaceAll(", 2 RBI", "")
											.replaceAll(", RBI", "")
											.replaceAll("::: ", "")
											.replaceAll(":::", "")
											.replaceAll(", bunt", "")
											.substring( _who != null && _who.getID() != null ? _who.getID().length() + 1 : 0);
						logger.debug("[{}]          [_keyword] = {}", "createDocuments", _keyword);

						// MATCH WITH ONE OF THE
						// fr.bbws.bo.statistics.river.PlateAppearanceConfiguration.getInstance().loadAllPlays() KEYWORDS
						_what = Play.UNDEFINED;
						for (String key : ALL_PLAYS.keySet()) {
							if (_keyword.startsWith(key)) {
								_what = ALL_PLAYS.get(key);
							}
						}

						if ( Play.UNDEFINED == _what) {
							logger.error("[{}]          [_what] \'{}\' in file [{}] not found GameSheetConfiguration.loadAllPlays", "createDocuments", _keyword, p_file);
						}



						// EXACT MATCH WITH ONE OF THE
						// fr.bbws.bo.statistics.river.PlateAppearanceConfiguration.getInstance().loadAllPositions() KEYWORDS
						_where = Position.UNDEFINED;
						for (String key : ALL_POSITIONS.keySet()) {
							if (_keyword.contentEquals(key)) {
								_where = ALL_POSITIONS.get(key);
							}
						}

						if ( Position.UNDEFINED == _where) {
							if (!PlateAppearanceConfiguration.getInstance().shouldPositionBeEmpty(_keyword)) {
								logger.error("[{}]          [_where] \'{}\' in file [{}] not found GameSheetConfiguration.loadAllPositions", "createDocuments", _keyword, p_file);
							} else {
								_where = Position.EMPTY;
							}
						}

						// MATCH WITH ONE OF THE
						// PLAYERS PUT IN PARAMS
						if ( StringUtils.isNotBlank(_who.getID())) {

							for (int i = 0; i < p_players.size(); i++) {
								if ( _who.getID().contentEquals( p_players.get(i).getID())) {
									_who = p_players.get(i);
									break;
								}
							}

							// CONSTRUCTION DU DOCUMENT JSON
							// POUR CHAQUE ACTION
							_json.clear();

							if ( filterPlateAppearanceOnly(_what, _where)) {

								if (__play.contains(", bunt") || __play.contains(", SAC")) {
									// if play contains bunt or sac keyword

									if (_what.equals(Play.SLUGGING_1B)) {
										// if it is a single
										// replace _what with Play.SLUGGING_1B_BUNT
										_what = Play.SLUGGING_1B_BUNT;
									} else {
										// if it s not a single hit
										// replace _what with Play.SACRIFICE_HIT
										_what = Play.SACRIFICE_HIT;
									}
								}


								_json.put("created", LocalDateTime.now().toString());
								_json.put("state", "RIVER");
								_json.put("game", p_date.toString());
								_json.put("field", p_field);
								_json.put("oppositePitcher", "#no_opposite_pitcher#".toUpperCase()); // TODO opposite pitcher
								_json.put("oppositeTeam", p_oppositeTeam);
								_json.put("who", _who != null ? _who.getID() : "#no_name#");
								//_json.put("team", _who != null ? _who.getTeam() : "#no_team#".toUpperCase());
								_json.put("team", _who != null && _who.getTeam() != null ? _who.getTeam() : p_players.get(0).getTeam());
								_json.put("fieldPosition", _who != null ? _who.getFieldPosition() : "#no_field_position#".toUpperCase());
								_json.put("battingOrder",  _who != null ? _who.getBattingOrder() : -1);
								_json.put("when", _when);
								_json.put("what", _what);
								_json.put("where", _where);
								_json.put("umpire", p_umpire);

								logger.debug("[{}]          [_json] = {}", "createDocuments", _json);

								Response response = target.path("/api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json(_json));

								logger.info( "[{}]          [response.status] = {}", "createDocuments", response.getStatus());

								if ( response.getStatus() != 201) {
									logger.error("[{}]          [response.status] = {} for the pa {}", "createDocuments", response.getStatus(), _json);
									logger.error("[{}]          [response.json] = {}", "createDocuments", response.readEntity(String.class));
								}
							}
						}
					}
				}
			}
		}
		// ############## FIN -- DECOUPER CHAQUE INNING EN ACTION

		return true;
	}


	/**
	 * Ne retourne que des actions qui ont amenes un frappeur a etre safe ou out en premire base
	 * Les autres actions : SCORE, STOLE BASE, RUN, PICK OFF, ... ne sont pas pris en compte
	 */
	private boolean filterPlateAppearanceOnly(Play p_play, Position p_position) {

		if ( p_play == Play.DOUBLE_PLAY
				|| p_play == Play.HIT_BY_PITCH
				|| p_play == Play.INTENTIONAL_WALK
				|| p_play == Play.K_LOOKING
				|| p_play == Play.K_SWINGING
				|| p_play == Play.OBR
				|| p_play == Play.OUT
				|| p_play == Play.LINED_OUT
				|| p_play == Play.FLIED_OUT
				|| p_play == Play.GROUNDED_OUT
				|| p_play == Play.SACRIFICE_HIT
				|| p_play == Play.SACRIFICE_FLY
				|| p_play == Play.SAFE_ON_ERROR
				|| p_play == Play.SAFE_ON_FIELDER_CHOICE
				|| p_play == Play.SLUGGING_1B
				|| p_play == Play.SLUGGING_1B_BUNT
				|| p_play == Play.SLUGGING_2B
				|| p_play == Play.SLUGGING_3B
				|| p_play == Play.SLUGGING_4B
				|| p_play == Play.WALK) {

			if ( p_play == Play.OUT && p_position == Position.EMPTY) { // ceci est un pickoff => pas une plate appearance
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}
