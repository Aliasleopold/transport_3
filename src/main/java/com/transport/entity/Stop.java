package com.transport.entity;

public class Stop extends Entity {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Boolean is_finish;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIs_finish() {
		return is_finish;
	}

	public void setIs_finish(Boolean is_finish) {
		this.is_finish = is_finish;
	}

}
