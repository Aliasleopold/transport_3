package com.transport.service;


import java.util.List;

import com.transport.entity.Bus;

public interface BusService {

    void save(Bus bus);

    void update(Bus bus);

    void delete(Long id);

	Bus getBus(Long id);

	List<Bus> getBuses();
}
