package com.transport.service;

import java.util.List;

import com.transport.dao.CheckpointDao;
import com.transport.entity.Checkpoint;

public class CheckpointServiceImpl implements CheckpointService {
    private CheckpointDao dao;

    public void setDao(CheckpointDao dao) {
        this.dao = dao;
    }

    public void save(Checkpoint checkpoint) {
        if (checkpoint.getId() == null) {
            dao.create(checkpoint);
        } else {
            dao.update(checkpoint);
        }
    }

    public void update(Checkpoint checkpoint) {
        dao.update(checkpoint);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public Checkpoint getCheckpoint(Long id) {
        return dao.read(id);
    }

    public List<Checkpoint> getCheckpoints() {
        return dao.findAll();
    }
}
