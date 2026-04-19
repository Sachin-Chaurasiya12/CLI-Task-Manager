package com.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Database {
    private static HikariDataSource ds;
    static{
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/cli");
        config.setUsername("root");
        config.setPassword("fycs");

        ds = new HikariDataSource(config);
    }
    public static HikariDataSource getdatasource(){
        return ds;
    }
}
