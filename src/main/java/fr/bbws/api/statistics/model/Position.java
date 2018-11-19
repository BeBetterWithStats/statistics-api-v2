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
	UNLOCATED_BATTED_BALL (20),
	EMPTY (99),
	UNDEFINED (-99);

	private int key = 0;
	
	Position(int p_key) {
		this.key = p_key;
	}
	
	public int intValue() {
		return this.key;
	}
}
