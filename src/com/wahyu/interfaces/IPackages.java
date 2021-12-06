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
    // Employees

    // Department
    //  Insert
    @WebMethod
    public void insertPackageDepartment(Department department);

    //  Get All
    @WebMethod
    public Pojo getAllPackageDepartment();

    //    DELETE

    @WebMethod
    public void deletePackageDepartment(int id_dept);

    //    UPDATE

    @WebMethod
    public void updatePackageDepartment(Department department);

}
