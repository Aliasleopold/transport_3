package com.transport.dao;


import java.util.List;

import com.transport.entity.Bus;

public interface BusDao  extends Dao<Long,Bus> {
	
	List<Bus> findAll();

    Long create(Bus bus);

    Bus read(Long id);

    void update(Bus bus);

    void delete(Long id);
}
