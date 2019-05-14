package oleg.larionov.dao;

import oleg.larionov.utils.DataSource;
import oleg.larionov.utils.IRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDaoTemplate {

    public JdbcDaoTemplate() {
        this.dataSource.setDriver("jdbc:h2:");
        this.dataSource.setPath("./db/FinesBase");
    }

    public <T> T queryForObject(String sql, Integer id, IRowMapper<T> rowMapper){
        ResultSet resultSet; //
        List<T> list = new ArrayList<T>();

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

    public <T> List<T> query(String sql, IRowMapper<T> rowMapper){
        ResultSet resultSet; //
        List<T> list = new ArrayList<T>();

        try( Connection connection = DriverManager.getConnection(dataSource.getDataSource())){
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                list.add(rowMapper.mapRow(resultSet));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void setDataSource(String driver, String path) {
        this.dataSource.setDriver("jdbc:h2:");
        this.dataSource.setPath("./db/FinesBase");
    }

    private DataSource dataSource = new DataSource();
}
