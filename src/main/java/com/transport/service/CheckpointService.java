package com.transport.service;

import java.util.List;

import com.transport.entity.Checkpoint;

public interface CheckpointService {
    void save(Checkpoint checkpoint);

    void update(Checkpoint checkpoint);

    void delete(Long id);

	Checkpoint getCheckpoint(Long id);

	List<Checkpoint> getCheckpoints();
}
