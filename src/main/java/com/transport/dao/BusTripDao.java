package com.transport.dao;

import java.util.List;

import com.transport.entity.BusTrip;

public interface BusTripDao extends Dao<Long,BusTrip>{

	List<BusTrip> findAll();

    Long create(BusTrip busTrip);

    BusTrip read(Long id);

    void update(BusTrip busTrip);

    void delete(Long id);


}
