package com.transport.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.transport.dao.StopDao;
import com.transport.entity.Stop;

public class StopJdbcDao extends BaseJdbcDaoSupport implements StopDao {

    private final RowMapper<Stop> rowMapper;

    public StopJdbcDao() {
        this.rowMapper = new StopRowMapper();
    }

    public Long create(Stop stop) {
        final Long id = nextid(getSql("nextid"));
        update(getSql("insert"), new Object[] { id, stop.getName(), stop.getIs_finish() });
        stop.setId(id);
        return id;
    }

    public Stop read(Long id) {
        return queryForObject(getSql("select"), new Object[] { id }, rowMapper);
    }

    public void update(Stop stop) {
        update(getSql("update"), new Object[] { stop.getName(), stop.getIs_finish() });
    }

    public void delete(Long id) {
        update(getSql("delete"), id);
        
    }

    public static class StopRowMapper implements RowMapper<Stop> {
        public Stop mapRow(ResultSet rs, int count) throws SQLException {
            Stop stop = new Stop();
            stop.setId(rs.getLong("id"));
            stop.setName(rs.getString("name"));
            stop.setIs_finish(rs.getBoolean("is_finish"));
            return stop;
        }
    }
}
