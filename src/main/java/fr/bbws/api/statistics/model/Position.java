package fr.bbws.api.statistics.model;

public enum Position {

	DESIGNATED_HITTER(0),
	PITCHER (1),
	CATCHER (2),
	FIRST_BASE (3),
	SECOND_BASE (4),
	THIRD_BASE (5),
	SHORTSTOP (6),
	LEFT_FIELD (7),
	CENTER_FIELD (8),
	RIGHT_FIELD (9),
	UP_THE_MIDDLE (10),
	UNLOCATED_BATTED_BALL (20), // means position was not specified by the scorekeeper
	EMPTY (99), // means no position, cause the play does not need a position
	UNDEFINED (-99); // means position can not be found in the configuration

	private int key = 0;
	
	Position(int p_key) {
		this.key = p_key;
	}
	
	public int intValue() {
		return this.key;
	}
}
