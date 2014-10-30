package com.transport.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.transport.dao.BusTripDao;
import com.transport.dao.CheckpointDao;
import com.transport.entity.BusTrip;
import com.transport.entity.Checkpoint;

public class BusTripServiceImpl implements BusTripService {
    public static final Long MILLESECOND_IN_MINUTE = 60000L;

    private BusTripDao dao;

    private CheckpointDao cDao;

    public void setDao(BusTripDao dao) {
        this.dao = dao;
    }

    public void setcDao(CheckpointDao cDao) {
        this.cDao = cDao;
    }

    public void save(BusTrip busTrip) {
        if (busTrip.getId() == null) {
            dao.create(busTrip);
        } else {
            dao.update(busTrip);
        }
    }

    public void update(BusTrip busTrip) {
        dao.update(busTrip);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public List<BusTrip> filterBusTrip(Long idStopIn, Long idStopTo, Time t, String day_type) {
        List<Checkpoint> cs = cDao.filterByStopID(idStopIn);
        List<BusTrip> bts = new ArrayList<BusTrip>();
        for (Checkpoint c : cs) {
            BusTrip bt = dao.read(c.getBusTrip_id());
            bt.setTime(new Time(bt.getTime().getTime() + c.getDeltaTime() * MILLESECOND_IN_MINUTE));
            bts.add(bt);
        }
        Iterator<BusTrip> it = bts.iterator();
        while (it.hasNext()) {
            BusTrip bt = it.next();
            if (!bt.getDay_type().equals(day_type) || bt.getTime().before(t)) {
                it.remove();
            }
        }
        Iterator<BusTrip> it1 = bts.iterator();
        while (it1.hasNext()) {
            // for(BusTrip bt : bts) {
            BusTrip bt = it1.next();
            Checkpoint a = cDao.isFilterByStopIDAndBusTripID(idStopIn, bt.getBus_id());
            Checkpoint b = cDao.isFilterByStopIDAndBusTripID(idStopTo, bt.getBus_id());
            if (b == null || a.getNum().compareTo(b.getNum()) <= 0) {
                it1.remove();
            }
        }
        Collections.sort(bts, new Comparator<BusTrip>() {
            public int compare(BusTrip o1, BusTrip o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        return bts;
    }

    public BusTrip getBusTrip(Long id) {
        return dao.read(id);
    }

    public List<BusTrip> getBusTrips() {
        return dao.findAll();
    }
}
