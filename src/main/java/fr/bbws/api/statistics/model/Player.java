package fr.bbws.api.statistics.model;

public class Player {

	private String id;
	
	private String name;
	
	private String firstName;
	
	private String jersey;
	
	private String team;
	
	private Position fieldPosition = Position.UNDEFINED;
	
	private int battingOrder = -1;
	
	public Player( String p_id) {
		this.id = p_id;
	}

	public Player( String p_id, String p_team, String p_jersey, Position p_position, int p_order) {
		this.id = p_id;
		this.jersey = p_jersey;
		this.team = p_team;
		this.fieldPosition = p_position;
		this.battingOrder = p_order;
	}

	public String getID() {
		return id;
	}

	public String getJersey() {
		return jersey;
	}

	public String getTeam() {
		return team;
	}

	public Position getFieldPosition() {
		return fieldPosition;
	}

	public int getBattingOrder() {
		return battingOrder;
	}

	public String getFieldPreference() {
		return "undefined".toUpperCase();
	}
	
	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String p_firstName) {
		this.firstName = p_firstName;
	}
	
	public void setName(String p_name) {
		this.name = p_name;
	}
	
	public void setFieldPosition(Position p_position) {
		this.fieldPosition = p_position;
	}

	public void setBattingOrder(int p_order) {
		this.battingOrder = p_order;
	}
		
	@Override
	public String toString() {
		/*
		String value = this.name + "  (AB) : ";
		for (int i = 1; i < 99; i++) {
			switch (Integer.toString(ab[i]).length()) {
			case 0:
				value +=" 00 |";
				break;
			case 1:
				value +=" 0" + Integer.toString(ab[i]) + " |";
				break;
			case 2:
				value +=" " + Integer.toString(ab[i]) + " |";
				break;
			default:
				value +="" + Integer.toString(ab[i]) + " |";
				break;
			}
		}
		
		value +="\n" + this.name + "   (H) : ";
		for (int i = 1; i < 99; i++) {
			switch (Integer.toString(hit[i]).length()) {
			case 0:
				value +=" 00 |";
				break;
			case 1:
				value +=" 0" + Integer.toString(hit[i]) + " |";
				break;
			case 2:
				value +=" " + Integer.toString(hit[i]) + " |";
				break;
			default:
				value +="" + Integer.toString(hit[i]) + " |";
				break;
			}
		}
		*/
		
		String value = "Ord. " + this.battingOrder + " " + this.id + " #" + this.jersey + " " + this.fieldPosition + " " + this.team;
		return value;
		
	}

}
