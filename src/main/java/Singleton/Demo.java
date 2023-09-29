package Singleton;

public final class Demo {
    private static Demo instance;
    private String value;

    private Demo (String value){
        this.value = value;
    }

    public static Demo getInstance(String value){
        if(instance == null)
            instance = new Demo(value);
        return instance;
    }

    public String getValue() {
        return value;
    }
}
