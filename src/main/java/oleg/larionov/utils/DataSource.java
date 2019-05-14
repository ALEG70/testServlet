package oleg.larionov.utils;

public class DataSource {

    private String driver;
    private String path;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDataSource(){
        return driver+path;
    }

}
