package com.transport.service;

import java.util.List;

import com.transport.dao.BusDao;
import com.transport.entity.Bus;

public class BusServiceImpl implements BusService {
    private BusDao dao;

    public void setDao(BusDao dao) {
        this.dao = dao;
    }

    public void save(Bus bus) {
        if (bus.getId() == null) {
            dao.create(bus);
        } else {
            dao.update(bus);
        }
    }

    public void update(Bus bus) {
        dao.update(bus);
        
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public Bus getBus(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Bus> getBuses() {
        // TODO Auto-generated method stub
        return null;
    }

}
