package Java.Junit.ExternalResourceAsParameter;

/**
 * Created by gerard on 15-06-2016.
 */
public class MyDatabase {


    private final String databaseName;
    private String status = "Not Open";


    public MyDatabase(String databaseName) {
        this.databaseName = databaseName;

    }

    void open(){
        status = "Open";
        MyPrints.printInsideObject(this,status+", "+databaseName);
    };

    void close(){
        status = "Close";
        MyPrints.printInsideObject(this, status+", "+databaseName);
    };

    @Override
    public String toString() {
        return "MyDatabase{" +
                "databaseName='" + databaseName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }
}
