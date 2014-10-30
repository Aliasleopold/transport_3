package com.transport.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.transport.dao.BusTripDao;
import com.transport.entity.BusTrip;

public class BusTripJdbcDao extends BaseJdbcDaoSupport implements BusTripDao {

    private RowMapper<BusTrip> rowMapper;

    public BusTripJdbcDao() {
        this.rowMapper = new BusTripRowMapper();
    }

    public Long create(BusTrip busTrip) {
        final Long id = nextid(getSql("nextid"));
        update(getSql("insert"), new Object[] { id, busTrip.getDay_type(), busTrip.getTime(), busTrip.getBus_id() });
        busTrip.setId(id);
        return id;
    }

    public BusTrip read(Long id) {
        return queryForObject(getSql("select"), new Object[] { id }, rowMapper);
    }

    public void update(BusTrip busTrip) {
        update(getSql("update"), new Object[] { busTrip.getDay_type(), busTrip.getTime(), busTrip.getBus_id() });

    }

    public void delete(Long id) {
        update(getSql("delete"), id);
    }

    public List<BusTrip> findAll() {
        return queryForList(getSql("findAll"), rowMapper);
    }

    public static class BusTripRowMapper implements RowMapper<BusTrip> {
        public BusTrip mapRow(ResultSet rs, int count) throws SQLException {
            BusTrip busTrip = new BusTrip();
            busTrip.setId(rs.getLong("id"));
            busTrip.setDay_type(rs.getString("day_type"));
            busTrip.setTime(rs.getTime("time"));
            busTrip.setBus_id(rs.getLong("bus_id"));
            return busTrip;
        }
    }
}
