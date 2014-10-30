package com.transport.dao.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public abstract class BaseJdbcDaoSupport extends JdbcDaoSupport {

    private Map<String, String> map;

    private String properties;

    public void setProperties(final String properties) {
        this.properties = properties;
    }

    public void init() throws IOException {
        final ClassPathResource res = new ClassPathResource(properties);
        final InputStream is = res.getInputStream();

        final Properties props = new Properties();
        props.load(is);

        map = new HashMap<String, String>();

        for (Map.Entry<Object, Object> e : props.entrySet()) {
            map.put((String) e.getKey(), (String) e.getValue());
        }

        is.close();
    }

    public Long nextid(final String sql) {
        return getJdbcTemplate().queryForLong(sql);
    }

    public int update(final String sql) {
        return getJdbcTemplate().update(sql);
    }

    public int update(final String sql, final Object param) {
        return getJdbcTemplate().update(sql, param);
    }

    public int update(final String sql, final Object[] params) {
        return getJdbcTemplate().update(sql, params);
    }

    public int update(final String sql, final Object[] params,
 final RowMapper<?> mapper) {
        return getJdbcTemplate().update(sql, params, mapper);
    }

    public <T> T queryForObject(final String sql, final RowMapper<T> mapper) {
        return getJdbcTemplate().queryForObject(sql, mapper);
    }

    public <T> T queryForObject(final String sql, final Object[] params,
            final RowMapper<T> mapper) {
        return getJdbcTemplate().queryForObject(sql, params, mapper);
    }

    public <T> List<T> queryForList(final String sql, final RowMapper<T> mapper) {
        return getJdbcTemplate().query(sql, mapper);
    }

    public <T> List<T> queryForList(final String sql, final Object[] params,
            final RowMapper<T> mapper) {
        return getJdbcTemplate().query(sql, params, mapper);
    }

    public String getSql(final String key) {
        return map.get(key);
    }
}
