package com.transport.entity;

import java.sql.Time;


public class BusTrip extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long bus_id;
	private String day_type;
	private Time time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBus_id() {
		return bus_id;
	}

	public void setBus_id(Long bus_id) {
		this.bus_id = bus_id;
	}

	public String getDay_type() {
		return day_type;
	}

	public void setDay_type(String day_type) {
		this.day_type = day_type;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
