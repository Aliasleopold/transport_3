package com.transport.service;

import com.transport.dao.StopDao;
import com.transport.entity.Stop;

public class StopServiceImpl implements StopService {
    private StopDao dao;
    public void setDao(StopDao dao) {
        this.dao = dao;
    }

    public void save(Stop stop) {
        if (stop.getId() == null) {
            dao.create(stop);
        } else {
            dao.update(stop);
        }
    }

    public void update(Stop stop) {
        dao.update(stop);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public Stop getStop(Long id) {
        return dao.read(id);
    }
}
