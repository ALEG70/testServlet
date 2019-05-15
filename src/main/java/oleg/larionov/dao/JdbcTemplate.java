package oleg.larionov.dao;

import oleg.larionov.utils.DataSource;
import oleg.larionov.utils.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {

    public JdbcTemplate() {
        this.dataSource.setDriver("jdbc:h2:");
        this.dataSource.setPath("./db/FinesBase");
    }

    public <T> T queryForObject(String sql, Integer id, RowMapper<T> rowMapper){
        ResultSet resultSet;
        List<T> list = new ArrayList();

        try( Connection connection = DriverManager.getConnection(dataSource.getDataSource())){
            PreparedStatement statement = connection.prepareStatement(sql);// Statement();
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                list.add(rowMapper.mapRow(resultSet));
            }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        return list.get(0);
    }

    public <T> List<T> queryWithParams(String sql, Object [] parameters, RowMapper<T> rowMapper){
        ResultSet resultSet;
        List<T> list = new ArrayList();

        System.out.println("Параметры в JdbcTemplate: " + parameters[0]);

        try( Connection connection = DriverManager.getConnection(dataSource.getDataSource())){
            PreparedStatement statement = connection.prepareStatement(sql);// Statement();
            for(int i=0; i<parameters.length; i++){
                statement.setObject(i+1, parameters[i]);
            }

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                list.add(rowMapper.mapRow(resultSet));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper){
        ResultSet resultSet;
        List<T> list = new ArrayList();

        try( Connection connection = DriverManager.getConnection(dataSource.getDataSource())){
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                T model = rowMapper.mapRow(resultSet);
                list.add(model);
                System.out.println(model);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    private DataSource dataSource = new DataSource();
}
