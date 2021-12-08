package com.wahyu.services;

import com.wahyu.connection.DbHelper;
import com.wahyu.model.Department;
import com.wahyu.model.Employee;
import com.wahyu.interfaces.IPackages;
import com.wahyu.pojo.Pojo;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.*;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@WebService(endpointInterface = "com.wahyu.interfaces.IPackages")
public class PackageServices implements IPackages
{
    // Insert
    @Override
    public void insertPackageDepartment(Department department) {
        try
        {
            String sql = "{ call department_pkg.add_department('" + department.getName_dept() + "') }";

            DbHelper.insertPackageGetId(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void insertPackageEmployee(Employee employee) {
        try
        {
            String sql = "{ call employees_pkg.add_employees('" + employee.getId() + "', " +
                                                             "'" + employee.getName() + "', " +
                                                             "'" + employee.getAge() + "', " +
                                                             "'" + employee.getDepartment().getId_dept() + "'" +
                                                             ")}";

            DbHelper.insertPackageGetId(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    // Select All
    @Override
    public Pojo getAllPackageDepartment() {
        Pojo dept = new Pojo();
        Department departmentList = new Department();
        dept.setListDepartment(new ArrayList<Department>());
        ResultSet rs = DbHelper.selectPackage("{ call department_pkg.list_department(?) }");
        try {
            while (rs.next())
            {
                Department d = new Department();
                d.setId_dept(rs.getInt("id_dept"));
                d.setName_dept(rs.getString("name_dept"));
                dept.getListDepartment().add(d);
            }
        }
        catch (Exception t)
        {
            t.printStackTrace();
        }
        return dept;
    }

    @Override
    public Pojo getAllPackageEmployee() {
        Pojo emp = new Pojo();
        Employee employeeList = new Employee();
        emp.setListEmployee(new ArrayList<Employee>());
        ResultSet rs = DbHelper.selectPackage("{ call employees_pkg.list_employees(?) }");
        try {
            while (rs.next())
            {
                Employee e = new Employee();

                Department d = new Department();
                d.setId_dept(rs.getInt("id_dept"));
                d.setName_dept(rs.getString("name_dept"));

                e.setDepartment(d);
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setAge(rs.getInt("age"));

                emp.getListEmployee().add(e);
            }
        }
        catch (Exception t)
        {
            t.printStackTrace();
        }
        return emp;
    }
    // Get Data By Id
    @Override
    public Department selectPackageDepartment(int id_dept) {
        Department dept = new Department();
        ResultSet rs = DbHelper.selectPackageById("{ call DEPARTMENT_PKG.search_department_by_id(?,?) }", id_dept);
        try {
            while (rs.next())
            {
                dept = new Department();

                dept.setId_dept(rs.getInt("id_dept"));
                dept.setName_dept(rs.getString("name_dept"));

            }
        }
        catch (Exception t)
        {
            t.printStackTrace();
        }
        return dept;
    }

    @Override
    public Employee selectPackageEmployee(int id) {
        Employee emp = new Employee();
        ResultSet rs = DbHelper.selectPackageById("{ call EMPLOYEES_PKG.search_employee_by_id(?,?) }", id);
        try {
            while (rs.next())
            {
                emp = new Employee();
                Department dept = new Department();

                dept.setId_dept(rs.getInt("id_dept"));
                dept.setName_dept(rs.getString("name_dept"));
                emp.setDepartment(dept);
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
            }
        }
        catch (Exception t)
        {
            t.printStackTrace();
        }
        return emp;
    }

    // Delete
    @Override
    public void deletePackageDepartment(int id_dept) {
        String sql = "{ call department_pkg.delete_department("+ id_dept + ") }";
        DbHelper.executePackage(sql);
    }

    @Override
    public void deletePackageEmployee(int id) {
        String sql = "{ call employees_pkg.delete_employee("+ id + ") }";
        DbHelper.executePackage(sql);
    }

    // Update
    @Override
    public void updatePackageDepartment(Department department)
    {
        try
        {
            String sql = "{ call department_pkg.update_department('"+ department.getName_dept()+ "','" + department.getId_dept() + "') }";
            DbHelper.executePackage(sql);
        }
        catch (Exception t)
        {
            t.printStackTrace();
        }
    }

    @Override
    public void updatePackageEmployee(Employee employee) {
        try
        {
            String sql = "{ call employees_pkg.update_employee('" + employee.getName() + "', " +
                                                              "'" + employee.getAge() + "', " +
                                                              "'" + employee.getDepartment().getId_dept() + "', " +
                                                              "'" + employee.getId() + "') }";
            DbHelper.executePackage(sql);
        }
        catch (Exception t)
        {
            t.printStackTrace();
        }
    }
}
