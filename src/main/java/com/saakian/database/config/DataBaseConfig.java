package com.saakian.database.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DataBaseConfig {

//    public Connection connection() throws SQLException {
//        Connection connection = DriverManager.getConnection(
//                "jdbc:postgresql://" + DB_HOST + ":" + PORT + "/" + DB,
//                USER,
//                PASSWORD
//        );
//        connectionResultOutput(connection);
//        return connection;
//    }

}
