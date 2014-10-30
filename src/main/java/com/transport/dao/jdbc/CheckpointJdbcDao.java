package com.transport.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.transport.dao.CheckpointDao;
import com.transport.entity.Checkpoint;

public class CheckpointJdbcDao extends BaseJdbcDaoSupport implements CheckpointDao {

    private final RowMapper<Checkpoint> rowMapper;

    public CheckpointJdbcDao() {
        this.rowMapper = new CheckpointRowMapper();
    }

    public Long create(Checkpoint checkpoint) {
        final Long id = nextid(getSql("nextid"));
        update(getSql("insert"),
                new Object[] { id, checkpoint.getBusTrip_id(), checkpoint.getNum(), checkpoint.getStop_id(),
                        checkpoint.getDeltaTime() });
        checkpoint.setId(id);
        return id;
    }

    public Checkpoint read(Long id) {
        return queryForObject(getSql("select"), new Object[] { id }, rowMapper);
    }

    public void update(Checkpoint checkpoint) {
        update(getSql("update"),
                new Object[] { checkpoint.getBusTrip_id(), checkpoint.getNum(), checkpoint.getStop_id(),
                        checkpoint.getDeltaTime() });
    }

    public void delete(Long id) {
        update(getSql("delete"), id);
    }

    public static class CheckpointRowMapper implements RowMapper<Checkpoint> {
        public Checkpoint mapRow(ResultSet rs, int count) throws SQLException {
            Checkpoint checkpoint = new Checkpoint();
            checkpoint.setId(rs.getLong("id"));
            checkpoint.setBusTrip_id(rs.getLong("busTrip_id"));
            checkpoint.setNum(rs.getLong("num"));
            checkpoint.setStop_id(rs.getLong("stop_id"));
            checkpoint.setDeltaTime(rs.getLong("deltaTime"));
            return checkpoint;
        }
    }

    public List<Checkpoint> filterByStopID(Long sid) {
        return queryForList(getSql("filterByStopID"), rowMapper);
    }

    public Checkpoint isFilterByStopIDAndBusTripID(Long idStop, Long idBusTrip) {
        return queryForObject(getSql("isFilterByStopIDAndBusTripID"), new Object[] { idStop, idBusTrip }, rowMapper);
    }

    public List<Checkpoint> findAll() {
        return queryForList(getSql("findAll"), rowMapper);
    }
}
