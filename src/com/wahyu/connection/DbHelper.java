package com.wahyu.connection;

import com.wahyu.model.Department;
import jdk.nashorn.internal.codegen.CompilerConstants;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.OracleTypes;

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
    public static ResultSet selectPackage(String query)
    {
        bukaKoneksi();

        ResultSet rs = null;
        try {
            CallableStatement cs = koneksi.prepareCall(query);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);
        }
        catch (SQLException t)
        {
            System.err.format("SQL State: %s\n%s", t.getSQLState(), t.getMessage());
            t.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet selectPackageById(String query, int id)
    {
        bukaKoneksi();

        ResultSet rs = null;
        try {
            CallableStatement cs = koneksi.prepareCall(query);
            cs.setInt(1, id);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(2);
        }
        catch (SQLException t)
        {
            System.err.format("SQL State: %s\n%s", t.getSQLState(), t.getMessage());
            t.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    public static int insertPackageGetId(String query){
        bukaKoneksi();
        int num = 0;
        int result = -1;
        try {
            CallableStatement cs = koneksi.prepareCall(query);
            num = cs.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = cs.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            cs.close();
        } catch(Exception e){
            e.printStackTrace();
            result = -1;
        }
        return result;
    }
    public static boolean executePackage(String query){
        bukaKoneksi();
        boolean result = false;
        try {
            CallableStatement cs = koneksi.prepareCall(query);
            cs.executeUpdate();

            result = true;

            cs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
