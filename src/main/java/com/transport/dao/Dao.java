package com.transport.dao;

import java.util.List;

import com.transport.entity.BusTrip;
import com.transport.entity.Checkpoint;

/**
 * @author Ihar_Maslakou
 * 
 * @param <PK>
 *            - Primary key
 * @param <T>
 *            - Type of object
 */
public interface Dao<PK, T> {

    /**
     * Save object.
     * 
     * @param object
     *            - object to create
     * @return - created object
     */
    PK create(T object);

    /**
     * Read object.
     * 
     * @param id
     *            - id of object
     * @return required object
     */
    T read(PK id);

    /**
     * Update object.
     *  
     * @param object
     *            - object to update
     */
    void update(T object);

    /**
     * Delete object.
     * 
     * @param id
     *            - id of object
     */
    void delete(PK id);
}
