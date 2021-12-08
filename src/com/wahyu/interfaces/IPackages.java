package com.wahyu.interfaces;

import com.wahyu.model.Department;
import com.wahyu.model.Employee;
import com.wahyu.pojo.Pojo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IPackages
{
    //  Insert
    @WebMethod
    public void insertPackageDepartment(Department department);

    @WebMethod
    public void insertPackageEmployee(Employee employee);

    //  Get All
    @WebMethod
    public Pojo getAllPackageDepartment();

    @WebMethod
    public Pojo getAllPackageEmployee();

    // Get Data By Id
    @WebMethod
    public Department selectPackageDepartment(int id_dept);

    @WebMethod
    public Employee selectPackageEmployee(int id);

    //    DELETE
    @WebMethod
    public void deletePackageDepartment(int id_dept);

    @WebMethod
    public void deletePackageEmployee(int id);

    //    UPDATE
    @WebMethod
    public void updatePackageDepartment(Department department);

    @WebMethod
    public void updatePackageEmployee(Employee employee);

}
