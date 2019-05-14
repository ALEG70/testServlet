package oleg.larionov.dao;

import oleg.larionov.model.Car;
import oleg.larionov.utils.CarMapper;

import java.sql.SQLException;
import java.util.List;

public class JdbcCarDao implements CarDao {

    JdbcDaoTemplate jdbcDaoTemplate = new JdbcDaoTemplate();

    @Override
    public Car findById(Integer id_car){
        String SQL = "SELECT * FROM cars JOIN owners ON cars.owner_id = owners.id_owner AND cars.id_car=?";

        return jdbcDaoTemplate.queryForObject(SQL, id_car, new CarMapper());
    }

    @Override
    public List<Car> findWithParameters(Integer id, String maker, Integer id_owner) {
        final String SQL = "SELECT * FROM cars join owners on cars.owner_id = owners.id_owner WHERE id_car LIKE ? " +
                "                     AND maker LIKE ? " +
                "                     AND owner_id LIKE ? ORDER BY cars.id_car";
        Object [] parameters = {
                id == null ? "%" : id+"%",
                maker+"%",
                id_owner == null ? "%" : id_owner+"%"
        };
        return null;
    }

    @Override
    public List<Car> findAll() {
        final String SQL = "SELECT * FROM cars join owners on cars.owner_id = owners.id_owner ORDER BY cars.id_car";
        return jdbcDaoTemplate.query(SQL, new CarMapper());
    }

}
