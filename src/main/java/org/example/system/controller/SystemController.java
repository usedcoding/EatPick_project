package org.example.system.controller;

import org.example.Container;
import org.example.db.DBConnection;

public class SystemController {
    private final DBConnection dbConnection;

    public SystemController() {
        this.dbConnection = Container.getDBconnection();
    }
    public void exit() {
        System.out.println("\n시스템이 종료됩니다.");
        this.dbConnection.close();
    }
}
