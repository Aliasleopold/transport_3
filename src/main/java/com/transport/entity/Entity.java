package com.transport.entity;

import java.io.Serializable;

/**
 * The class Entity.
 * 
 * @author Ihar_Maslakou
 * 
 */
public class Entity implements Serializable {

	/** the entity id */
	private Long id;

	/**
	 * Getter for id
	 * 
	 * @return id entity
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for id
	 * 
	 * @param id
	 *            - id entity
	 */
	public void setId(Long id) {
		this.id = id;
	}
} // class
