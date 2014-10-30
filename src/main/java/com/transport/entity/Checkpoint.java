package com.transport.entity;


public class Checkpoint extends Entity {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long busTrip_id;
	private Long num;
	private Long stop_id;
	private Long deltaTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusTrip_id() {
		return busTrip_id;
	}

	public void setBusTrip_id(Long busTrip_id) {
		this.busTrip_id = busTrip_id;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getStop_id() {
		return stop_id;
	}

	public void setStop_id(Long stop_id) {
		this.stop_id = stop_id;
	}

	public Long getDeltaTime() {
		return deltaTime;
	}

	public void setDeltaTime(Long deltaTime) {
		this.deltaTime = deltaTime;
	}


}
