package oleg.larionov.dao;

import oleg.larionov.model.Car;
import oleg.larionov.utils.CarMapper;

import java.util.List;

public class JdbcCarDao extends Jdbc implements Dao<Car>{

    @Override
    public Car findById(Integer id_car){
        String SQL = "SELECT * FROM cars JOIN owners ON cars.owner_id = owners.id_owner AND cars.id_car=?";

        return jdbcTemplate.queryForObject(SQL, id_car, new CarMapper());
    }

    @Override
    public List<Car> findWithParameters(Object [] parameters) {
        final String SQL = "SELECT * FROM cars join owners on cars.owner_id = owners.id_owner WHERE id_car LIKE ? " +
                "                     AND maker LIKE ? " +
                "                     AND owner_id LIKE ? ORDER BY cars.id_car";

        return null;
    }

    @Override
    public List<Car> findAll() {
        final String SQL = "SELECT * FROM cars join owners on cars.owner_id = owners.id_owner ORDER BY cars.id_car";
        return jdbcTemplate.query(SQL, new CarMapper());
    }

}
