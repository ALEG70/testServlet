package oleg.larionov.dao;

import oleg.larionov.utils.RowMapper;

import java.util.List;

public class JdbcDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public <T> List<T> findAll(String sql, RowMapper<T> rowMapper ) {
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Object findById(Integer id) {
        return null;
    }

    public List findWithParameters(Object[] parameters) {
        return null;
    }
}
