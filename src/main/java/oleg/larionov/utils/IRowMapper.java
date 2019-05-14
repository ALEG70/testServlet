package oleg.larionov.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IRowMapper<T> {
    T mapRow(ResultSet resultSet) throws SQLException;
}
