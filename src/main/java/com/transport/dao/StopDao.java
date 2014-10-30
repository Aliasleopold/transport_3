package com.transport.dao;

import com.transport.entity.Stop;


public interface StopDao extends Dao<Long,Stop> {

    Long create(Stop stop);
    
    Stop read(Long id);
    
    void update(Stop stop);
    
    void delete(Long id);

}
