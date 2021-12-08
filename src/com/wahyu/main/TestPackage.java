package com.wahyu.main;

import com.wahyu.model.Department;
import com.wahyu.model.Employee;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;
import java.util.Scanner;

import java.sql.*;

public class TestPackage
{
    public static void main(String[]args)
    {
        String jbdcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "wahyu";
        String password = "wahyu";
        String sql = "{ call department_pkg.cari_department(?,?) }";

        int input;
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(jbdcUrl, username, password);
             CallableStatement cs = conn.prepareCall(sql);
        )
        {
            System.out.println("input id dept : ");
            input = sc.nextInt();
            System.out.println();
            cs.setInt(1, input);

            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                Department d = new Department();
                d.setId_dept(rs.getInt("id_dept"));
                d.setName_dept(rs.getString("name_dept"));

                System.out.println("id      : " + d.getId_dept());
                System.out.println("name    : " + d.getName_dept());
                System.out.println("--------------------------");
            }
        }
        catch (SQLException e)
        {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
