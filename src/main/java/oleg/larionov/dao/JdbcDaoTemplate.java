package oleg.larionov.dao;

import java.sql.*;
import java.util.List;

public class JdbcDaoTemplate {

    public List<? extends Object> run() throws SQLException{
        setDataSource("jdbc:h2:","./db/FinesBase");
        try( Connection connection = DriverManager.getConnection(dataSource.getDataSource())){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            //Parse result
        }
        return null;
    }

    public void setDataSource(String driver, String path){
        this.dataSource.setDriver(driver);
        this.dataSource.setPath(path);
    }

    public void setSQL(String SQL) {
        this.SQL = SQL;
    }

    private String SQL;
    private DataSource dataSource;
}
