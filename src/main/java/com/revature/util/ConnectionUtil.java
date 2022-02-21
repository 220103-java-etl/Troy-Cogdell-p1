package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil cu = null;
    private static Properties dbProp;

    private ConnectionUtil() {
        dbProp = new Properties();
        InputStream props = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");



        try {
            dbProp.load(props);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static synchronized ConnectionUtil getConnectionUtil(){
        if (cu == null) {
            cu = new ConnectionUtil();
        }
        return cu;
    }

    public Connection getConnection(){

        Connection conn= null;

        try {
            Class.forName(dbProp.getProperty("driver"));
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        // get the credentials needed to access the DB from Properties Obj we created above
        String url = dbProp.getProperty("url");
        String username = dbProp.getProperty("username");
        String password = dbProp.getProperty("password");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /*public static void main(String[] args) {
        Connection connection = getConnectionUtil().getConnection();

        try{
            if (connection != null){
                System.out.println("Connection successful");
                connection.close();
            }
            else{
                System.out.println("not connecting..");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

}
