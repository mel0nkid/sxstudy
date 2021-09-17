package com.melon.sx.study.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;

/**
 * init
 *
 * @author imelonkid
 * @date 2021/09/17 21:21
 **/
public class InitDb {

    private static String protocol = "jdbc:derby:";



    public void initDB() {

    }

    public static void main(String[] args) throws SQLException {
        Properties props = new Properties(); // connection properties
        props.put("user", "melonkid");
        props.put("password", "melonkid");

        String dbName = "/Users/melonkid/workspace/myprojects/melonDB"; // the name of the database
        Connection conn = DriverManager.getConnection(protocol + dbName + ";create=true", props);

        System.out.println("Connected to and created database " + dbName);

        Statement s = conn.createStatement();
        DatabaseMetaData sm = null;
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet res = meta.getTables(null, null, null, new String[]{"TABLE"});
        HashSet<String> set=new HashSet<>();
        while (res.next()) {
            set.add(res.getString("TABLE_NAME"));
        }
        System.out.println(set);

        s.execute("create table m_sensitive_words(id int, word varchar(40), msg varchar(100))");
        System.out.println("Created table user");
    }
}
