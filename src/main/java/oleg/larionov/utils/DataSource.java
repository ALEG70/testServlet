package oleg.larionov.utils;

public class DataSource {

    private String driver;
    private String path;

    public void setDataSource (String driver, String path) {
        this.driver = driver;
        this.path = path;
    }

    public String getDataSource(){
        return driver+path;
    }

}
