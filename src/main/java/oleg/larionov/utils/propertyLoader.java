package oleg.larionov.utils;

public class propertyLoader {

    private static String suffix;
    private static String preffix;

    public static String getSuffix() {
        return suffix;
    }

    public static void setSuffix(String suffix) {
        propertyLoader.suffix = suffix;
    }

    public static String getPreffix() {
        return preffix;
    }

    public static void setPreffix(String preffix) {
        propertyLoader.preffix = preffix;
    }
}
