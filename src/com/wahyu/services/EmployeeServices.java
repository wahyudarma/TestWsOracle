package com.wahyu.services;

import com.wahyu.connection.DbHelper;
import com.wahyu.model.Department;
import com.wahyu.model.Employee;
import com.wahyu.interfaces.IEmployee;
import com.wahyu.pojo.Pojo;

import java.sql.ResultSet;
import java.util.*;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@WebService(endpointInterface = "com.wahyu.interfaces.IEmployee")
public class EmployeeServices implements IEmployee
{
    public EmployeeServices() {
    }
    @Override
    public void insertDepartment(Department department)
    {
        try
        {
            String sql = "INSERT INTO TBL_DEPARTMENT(name_dept) VALUES(" +
                    "'" + department.getName_dept() + "')";

            DbHelper.executeQuery(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void insertEmployee(Employee employee) {
        try
        {
            String sql = "INSERT INTO TBL_EMPLOYEE(id, name, age, id_dept) VALUES(" +
                    "'" + employee.getId() + "', " +
                    "'" + employee.getName() + "', " +
                    "'" + employee.getAge() + "', " +
                    "'" + employee.getDepartment().getId_dept() + "')";

            DbHelper.insertQueryGetId(sql);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Employee selectEmployee(int id)
    {
        Employee emp = new Employee();
        ResultSet rs = DbHelper.SelectQuery("SELECT * FROM TBL_EMPLOYEE WHERE id = " + id);
        try {
            while (rs.next())
            {
                emp = new Employee();
                Department dept = new Department();

                dept.setId_dept(rs.getInt("id_dept"));
//                dept.setName_dept(rs.getString("name_dept"));

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

    @Override
    public Department selectDepartment(int id_dept) {
        Department dept = new Department();
        ResultSet rs = DbHelper.SelectQuery("SELECT * FROM TBL_DEPARTMENT WHERE id_dept = " + id_dept);
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
    public Pojo getAllEmployee() {
//        List<Employee> employeeList = new ArrayList<>();
        Pojo emp = new Pojo();
        Employee employeeList = new Employee();
        emp.setListEmployee(new ArrayList<Employee>());
        ResultSet rs = DbHelper.SelectQuery("SELECT e.id, e.name, e.age, e.id_dept, d.name_dept FROM TBL_EMPLOYEE E INNER JOIN TBL_DEPARTMENT D ON D.id_dept = E.id_dept ORDER BY id");
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

    @Override
    public Pojo getAllDepartment() {
        Pojo dept = new Pojo();
        Department departmentList = new Department();
        dept.setListDepartment(new ArrayList<Department>());
        ResultSet rs = DbHelper.SelectQuery("SELECT * FROM TBL_DEPARTMENT ORDER BY ID_DEPT ASC");
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


    public void deleteEmployee(int id)
    {
        String sql = "DELETE FROM TBL_EMPLOYEE WHERE id = '" + id + "'";
        DbHelper.executeQuery(sql);
    }

    @Override
    public void deleteDepartment(int id_dept)
    {
        String sql = "DELETE FROM TBL_DEPARTMENT WHERE id_dept = '" + id_dept + "'";
        DbHelper.executeQuery(sql);
    }

    public void updateEmployee(Employee employee)
    {
        boolean rowUpdated;
        try
        {
            String sql = "UPDATE TBL_EMPLOYEE SET " +
                         " name = '" + employee.getName() + "'," +
                         " age = '" + employee.getAge() + "'," +
                         " id_dept = '" + employee.getDepartment().getId_dept() + "'" +
                         " WHERE id = '" + employee.getId() + "'";
            DbHelper.executeQuery(sql);
        }
        catch (Exception t)
        {
            t.printStackTrace();
        }
    }

    @Override
    public void updateDepartment(Department department) {
        try
        {
            String sql = "UPDATE TBL_DEPARTMENT SET " +
                    " name_dept = '" + department.getName_dept() + "'" +
                    " WHERE id_dept = '" + department.getId_dept() + "'";
            DbHelper.executeQuery(sql);
        }
        catch (Exception t)
        {
            t.printStackTrace();
        }
    }

}
