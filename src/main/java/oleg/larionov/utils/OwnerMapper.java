package oleg.larionov.utils;

import oleg.larionov.model.Owner;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerMapper implements RowMapper<Owner> {

    @Override
    public Owner mapRow(ResultSet resultSet) throws SQLException {
        Owner owner = new Owner();
        owner.setId(resultSet.getInt("id_owner"));
        owner.setName(resultSet.getString("name"));
        owner.setSec_name(resultSet.getString("sec_name"));
        return owner;
    }
}
