package com.transport.service;

import com.transport.entity.Stop;

public interface StopService {
    void save(Stop stop);

    void update(Stop stop);

    void delete(Long id);
    
    Stop getStop(Long id);
}
