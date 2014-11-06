package com.transport.service;

import java.sql.Time;
import java.util.List;

import com.transport.entity.BusTrip;

public interface BusTripService {
    void save(BusTrip busTrip);

    void update(BusTrip busTrip);

    void delete(Long id);
    
    List<BusTrip> filterBusTrip(Long idStopIn, Long idStopTo, Time t, String day_type);// ��� �����;
    
    BusTrip getBusTrip(Long id);
    
    List<BusTrip> getBusTrips();

}
