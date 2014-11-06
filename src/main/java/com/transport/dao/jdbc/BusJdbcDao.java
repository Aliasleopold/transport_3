package com.transport.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.transport.dao.BusDao;
import com.transport.entity.Bus;

public class BusJdbcDao extends BaseJdbcDaoSupport implements BusDao {
    
	private final RowMapper<Bus> rowMapper;

    public BusJdbcDao() {
        this.rowMapper = new BusRowMapper();
    }
    
    public List<Bus> findAll() {
        return queryForList(getSql("findAll"), rowMapper);
    }
    
    public Long create(Bus bus) {
        final Long id = nextid(getSql("nextid"));
        update(getSql("insert"), new Object[] { id, bus.getName(), bus.getDirection() });
        bus.setId(id);
        return id;
    }
    
    public Bus read(Long id) {
        return queryForObject(getSql("select"), new Object[] { id }, rowMapper);
    }
    
    public void update(Bus bus) {
        update(getSql("update"), new Object[] { bus.getName(), bus.getDirection() });
    }
    
    public void delete(Long id) {
        update(getSql("delete"), id);
        
    }
    
    public static class BusRowMapper implements RowMapper<Bus> {
        public Bus mapRow(ResultSet rs, int count) throws SQLException {
            Bus bus = new Bus();
            bus.setId(rs.getLong("id"));
            bus.setName(rs.getString("name"));
            bus.setDirection(rs.getString("passwd"));
            return bus;
        }
    }
}
