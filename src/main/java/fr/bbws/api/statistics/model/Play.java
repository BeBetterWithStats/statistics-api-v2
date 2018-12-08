package fr.bbws.api.statistics.model;

public enum Play {

	GROUNDED_OUT (-4),
	LINED_OUT (-3),
	FLIED_OUT (-2),
	OUT (-1),
	SAFE_ON_ERROR (0),
	SAFE_ON_FIELDER_CHOICE (1),
	DOUBLE_PLAY (2),
	SLUGGING_1B (3),
	SLUGGING_2B (4),
	SLUGGING_3B (5),
	SLUGGING_4B (6),
	K_SWINGING (7),
	K_LOOKING (8),
	WALK (9),
	HIT_BY_PITCH (10),
	SACRIFICE_HIT (11),
	SACRIFICE_FLY (12),
	OBR (13),
	STOLEN_BASE (14),
	SCORE (15),
	RBI (16),
	RUNNER_ADVANCE (17),
	RUNNER_OUT_AT_FIRST (18),
	RUNNER_OUT_AT_SECOND (19),
	RUNNER_OUT_AT_THIRD (20),
	RUNNER_OUT_AT_HOME (21),
	RUNNER_PICKED_OFF (22),
	RUNNER_CAUGHT_STEALING_SECOND (23),
	RUNNER_CAUGHT_STEALING_THIRD (24),
	RUNNER_CAUGHT_STEALING_HOME (25),
	RUNNER_OUT_ON_THE_PLAY (26),
	NO_PLAY (27),
	SUBSTITUTION (28),
	TIE_BREAK_PLACED_ON_1B (29),
	TIE_BREAK_PLACED_ON_2B (30),
	INTENTIONAL_WALK (31),
	UNDEFINED (-99); // means this play can not be found in the configuration
	

	private int key = 0;
	
	Play(int p_key) {
		this.key = p_key;
	}
	
	public int intValue() {
		return this.key;
	}
}
