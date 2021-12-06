package com.wahyu.main;

import com.wahyu.model.Department;
import com.wahyu.model.Employee;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypes;

import java.sql.*;

public class TestPackage
{
    public static void main(String[]args)
    {
        String jbdcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "wahyu";
        String password = "wahyu";
        String sql = "{ call employees_pkg.list_employees(?) }";

//        String sql = "SELECT ID FROM TBL_EMPLOYEE";

        try (Connection conn = DriverManager.getConnection(jbdcUrl, username, password);
             CallableStatement cs = conn.prepareCall(sql);
        )
        {
//            cs.setInt(1, 1);
//            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);
//            System.out.println("ID = " + rs.getInt(1));
            while (rs.next()) {
                Employee d = new Employee();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));

                System.out.println("id      : " + d.getId());
                System.out.println("name    : " + d.getName());
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
