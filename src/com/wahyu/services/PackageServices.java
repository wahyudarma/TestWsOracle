package com.wahyu.services;

import com.wahyu.connection.DbHelper;
import com.wahyu.model.Department;
import com.wahyu.model.Employee;
import com.wahyu.interfaces.IPackages;
import com.wahyu.pojo.Pojo;

import java.sql.ResultSet;
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
    // Delete
    @Override
    public void deletePackageDepartment(int id_dept) {
        String sql = "{ call department_pkg.delete_department("+ id_dept + ") }";
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
}
