package oleg.larionov.dao;

import oleg.larionov.model.Fine;
import oleg.larionov.utils.FineMapper;

import java.util.List;

public class JdbcFineDao extends Jdbc implements Dao<Fine>{


    @Override
    public List<Fine> findAll() {
        return null;
    }

    @Override
    public Fine findById(Integer id) {
        return null;
    }

    @Override
    public List<Fine> findWithParameters(Object[] parameters) {
        System.out.println("Параметры в JdbcFineDao: " + parameters[0]);
        String sql = "select * from" +
                "(select * from cars join owners on cars.owner_id = owners.id_owner) co" +
                " join " +
                " (select * from fines join fine_types on fines.type_id=fine_types.id_ft) ft" +
                " on ft.car_id = co.id_car and sec_name LIKE ? AND license_plate LIKE ?";
        return jdbcTemplate.queryWithParams(sql, parameters, new FineMapper());
    }
}
