package com.transport.dao;

import java.util.List;

import com.transport.entity.Checkpoint;

public interface CheckpointDao extends Dao<Long, Checkpoint> {

    List<Checkpoint> filterByStopID(Long id);

    Checkpoint isFilterByStopIDAndBusTripID(Long idStop, Long idBusTrip);

    List<Checkpoint> findAll();

    Long create(Checkpoint checkpoint);

    Checkpoint read(Long id);

    void update(Checkpoint checkpoint);

    void delete(Long id);
}
