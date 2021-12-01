package com.wahyu.connection;

import oracle.jdbc.OracleDriver;

import java.sql.*;

public class DbHelper
{
    private static Connection koneksi;
    public static void bukaKoneksi(){
        if (koneksi == null) {
            try {
                String url = "jdbc:oracle:thin:@localhost:1521:orcl";
                DriverManager.registerDriver(new OracleDriver());
                koneksi = DriverManager.getConnection(url, "wahyu", "wahyu");
            } catch(SQLException t) {
                System.out.println("Error koneksi !");
            }
        }
    }
    public static int insertQueryGetId(String query){
        bukaKoneksi();
        int num = 0;
        int result = -1;
        try {
            Statement stmt = koneksi.createStatement();
            num = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch(Exception e){
            e.printStackTrace();
            result = -1;
        }
        return result;
    }
    public static boolean executeQuery(String query){
        bukaKoneksi();
        boolean result = false;
        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeUpdate(query);

            result = true;

            stmt.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public static ResultSet SelectQuery(String query){
        bukaKoneksi();
        ResultSet rs = null;
        try {
            Statement stmt = koneksi.createStatement();
            rs = stmt.executeQuery(query);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
