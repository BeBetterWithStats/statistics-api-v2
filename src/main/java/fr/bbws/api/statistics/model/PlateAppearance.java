package fr.bbws.api.statistics.model;

import org.junit.Ignore;

public class PlateAppearance {

	String created = null;
	
	String day = null;
	
	String field = null;
	
	String oppositePitcher = null;
	
	String oppositeTeam = null;
	
	String id = null;
	
	String team = null;
	
	Position fieldPosition = null;
	
	int battingOrder = -1;
	
	String when = null;
	
	Play what = null;
	
	Position where = null;
	
	String umpireID = null;
	
	String state = null;
	
	public PlateAppearance() {
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlateAppearance [day=" + day + ", field=" + field + ", oppositePitcher="
				+ oppositePitcher + ", oppositeTeam=" + oppositeTeam + ", id=" + id + ", team=" + team
				+ ", fieldPosition=" + fieldPosition + ", battingOrder=" + battingOrder + ", when=" + when + ", what="
				+ what + ", where=" + where + ", umpireID=" + umpireID + ", state=" + state + "]";
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return the oppositePitcher
	 */
	public String getOppositePitcher() {
		return oppositePitcher;
	}

	/**
	 * @return the oppositeTeam
	 */
	public String getOppositeTeam() {
		return oppositeTeam;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @return the fieldPosition
	 */
	public Position getFieldPosition() {
		return fieldPosition;
	}

	/**
	 * @return the battingOrder
	 */
	public int getBattingOrder() {
		return battingOrder;
	}

	/**
	 * @return the when
	 */
	public String getWhen() {
		return when;
	}

	/**
	 * @return the what
	 */
	public Play getWhat() {
		return what;
	}

	/**
	 * @return the where
	 */
	public Position getWhere() {
		return where;
	}

	/**
	 * @return the umpireID
	 */
	public String getUmpireID() {
		return umpireID;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @param oppositePitcher the oppositePitcher to set
	 */
	public void setOppositePitcher(String oppositePitcher) {
		this.oppositePitcher = oppositePitcher;
	}

	/**
	 * @param oppositeTeam the oppositeTeam to set
	 */
	public void setOppositeTeam(String oppositeTeam) {
		this.oppositeTeam = oppositeTeam;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @param fieldPosition the fieldPosition to set
	 */
	public void setFieldPosition(Position fieldPosition) {
		this.fieldPosition = fieldPosition;
	}

	/**
	 * @param when the when to set
	 */
	public void setWhen(String when) {
		this.when = when;
	}

	/**
	 * @param what the what to set
	 */
	public void setWhat(Play what) {
		this.what = what;
	}

	/**
	 * @param where the where to set
	 */
	public void setWhere(Position where) {
		this.where = where;
	}

	/**
	 * @param umpireID the umpireID to set
	 */
	public void setUmpireID(String umpireID) {
		this.umpireID = umpireID;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the created
	 */
	@Ignore
	public String getCreated() {
		return created;
	}


	/**
	 * @param created the created to set
	 */
	@Ignore
	public void setCreated(String created) {
		this.created = created;
	}

}
