package com.yang;

interface Driver {
    public void connect();
}

class MySqlDriver implements Driver {
    @Override
    public void connect() {
        System.out.println("Connecting MySQL....");
    }
}

class SqlServerDriver implements Driver {
    @Override
    public void connect() {
        System.out.println("Connecting SqlServer....");
    }
}

abstract class Bridge {
    private Driver driver;

    public void connect() {
        this.driver.connect();
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

class MyBridge extends Bridge {

}

public class BridgePattern {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();
        Driver mysqlDriver = new MySqlDriver();
        Driver sqlServerDriver = new SqlServerDriver();

        bridge.setDriver(mysqlDriver);
        bridge.connect();

        bridge.setDriver(sqlServerDriver);
        bridge.connect();

    }
}
