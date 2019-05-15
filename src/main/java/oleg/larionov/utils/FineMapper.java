package oleg.larionov.utils;

import oleg.larionov.model.Fine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FineMapper implements RowMapper<Fine> {

    @Override
    public Fine mapRow(ResultSet resultSet) throws SQLException {

        Fine fine = new Fine();
        fine.setId_fine(resultSet.getInt("id_fine"));
        fine.setId_car(resultSet.getInt("car_id"));
        fine.setId_type(resultSet.getInt("type_id"));
        fine.setCar(new CarMapper().mapRow(resultSet));
        fine.setType(new FineTypeMapper().mapRow(resultSet));
        return fine;
    }
}
