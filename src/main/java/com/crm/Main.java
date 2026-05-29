package com.crm;

import com.crm.infra.DatabaseConnection;
import com.crm.view.SalesConsole;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();

        SalesConsole console = new SalesConsole();

        console.viewConsole();
        
    }
}
