package fr.bbws.api.statistics.river;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class SearchInFileUtils {
	
	/*
	 * Find the first uppercase word of a sentence after a specific word
	 */
	public static String searchFirstUppercaseWordAfter(String sentence, String after) {

		String[] _strings = sentence.replaceAll("-", "").split(after);
		
		/*
		 * TODO traiter les caracteres speciaux '_', ',', ';' qui font que
		 * le nom de l'arbitre arrive en minuscule
		 */
		for (String _string : _strings) {

			String[] __strings = _string.split(" ");

			for (String __string : __strings) {
				if (StringUtils.isAllUpperCase(__string)) {
					return __string;
				} else {
					// do nothing
				}
			}
		}
		return null;
	}
	

	/*
	 * Find the first uppercase words of a sentence
	 */
	public static String searchUppercaseWordFromBeginning(String sentence) {

		String response = "";
		String[] strings = sentence.replaceAll("-", " ").split(" ");
		/*
		 * TODO traiter les caracteres speciaux '_', ',', ';' qui font que
		 * le nom de l'arbitre arrive en minuscule
		 */
		
		for (String _string : strings) {

			if (StringUtils.isAllUpperCase(_string)) {
				response += _string + " ";
			} else {
				break;
			}
		}
		
		if (response.length() > 0) {
			return response.trim();
		} else {
			return null;
		}
	}
	
	/*
	 *  @return the first words of a sentence before a specific word without space before and after
	 */
	public static String searchBefore(String sentence, String before) {

		boolean containsBefore = sentence.contains(before);

		if ( containsBefore) {
			
			String[] _strings = sentence.split(before);
			return _strings[0].trim();
			
		} else {
			return null;
		}
	}
	
	/*
	 * Recherche, dans @param sentence, tous les mots suivants @param after
	 * @return List puisque @param after peut apparaitre plusieurs fois ; chaque �l�ment de la liste sera pr�c�d� de @param after + espace
	 */
	public static List<String> searchAfter(String sentence, String after) {

		boolean containsAfter = sentence.contains(after);

		if ( containsAfter) {
			
			String[] _strings = sentence.split(after);
			List<String> sequences = new ArrayList<String>();
			
			if (_strings.length > 2) {

				for (String _string : _strings) {
					sequences.add(_string.trim());
				}
				sequences.remove(0);
			} else {
				sequences.add(_strings[1].trim());
			}

			return sequences;
			
		} else {
			return null;
		}
	}

	/*
	 * Recherche, dans @param sentence, tous les mots suivants @param after
	 * @return List puisque @param after peut apparaitre plusieurs fois avec chaque �l�ment de la liste pr�c�d� de @param after + espace
	 */
	public static List<String> searchAfterWithAfterWordAndSpaceIncluded(String sentence, String after) {

		boolean containsAfter = sentence.contains(after);

		if ( containsAfter) {
			
			String[] _strings = sentence.split(after);
			List<String> sequences = new ArrayList<String>();
			
			if (_strings.length > 2) {

				for (String _string : _strings) {
					sequences.add(after + " " + _string.trim());
				}
				sequences.remove(0);
			} else {
				sequences.add(after + " " + _strings[1].trim());
			}

			return sequences;
			
		} else {
			return null;
		}
		
	}
	

	/*
	 * @return tous les mots de la phrase @param sentence compris entre les mots @param after et @param before
	 */
	public static String searchBetween(String sentence, String after, String before) {

		boolean containsAfter = sentence.contains(after);
		boolean containsBefore = sentence.contains(before);

		if ( containsAfter && containsBefore) {
			
			String[] _strings = sentence.split(before);
			String[] __strings = _strings[0].split(after);
			return __strings[1].trim();
			
		} else {
			return null;
		}
		
	}

}
