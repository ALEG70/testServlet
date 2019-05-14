package oleg.larionov.dao;

import oleg.larionov.utils.DataSource;
import oleg.larionov.utils.IRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDaoTemplate {

    /**
     * 1. Конфигурируем источник данных
     * 2. Получаем Statement
     * 3. Выполняем запрос
     * 4. Парсим результат
     * 5. Возвращаем ArrayList
     * @param sql
     * @return
     * @throws SQLException
     */
    public <T> List<T> query(String sql, IRowMapper<T> rowMapper) throws SQLException{
        ResultSet resultSet; //
        List<T> list = new ArrayList<T>();

        dataSource.setDataSource("jdbc:h2:","./db/FinesBase");
        try( Connection connection = DriverManager.getConnection(dataSource.getDataSource())){
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                list.add(rowMapper.mapRow(resultSet));
            }
        }
        return list;
    }

    private DataSource dataSource = new DataSource();
}
