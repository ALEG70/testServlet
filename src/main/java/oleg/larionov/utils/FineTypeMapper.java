package oleg.larionov.utils;

import oleg.larionov.model.FineType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FineTypeMapper implements IRowMapper<FineType> {

    @Override
    public FineType mapRow(ResultSet resultSet) throws SQLException {

        FineType fineType = new FineType();
        fineType.setId(resultSet.getInt("id_ft"));
        fineType.setFine_title(resultSet.getString("title"));
        fineType.setFine_fee(resultSet.getInt("price"));
        return fineType;
    }

}

