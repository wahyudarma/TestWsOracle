package com.wahyu.interfaces;

import com.wahyu.model.Department;
import com.wahyu.model.Employee;
import com.wahyu.pojo.Pojo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IEmployee
{
//  Insert
    @WebMethod
    public void insertDepartment(Department department);

    @WebMethod
    public void insertEmployee(Employee employee);


//    Get By ID
    @WebMethod
    public Employee selectEmployee(int id);

    @WebMethod
    public Department selectDepartment(int id_dept);

//  Get All
    @WebMethod
    public Pojo getAllEmployee();

    @WebMethod
    public Pojo getAllDepartment();

//    DELETE
    @WebMethod
    public void deleteEmployee(int id);

    @WebMethod
    public void deleteDepartment(int id_dept);

//    UPDATE
    @WebMethod
    public void updateEmployee(Employee employee);

    @WebMethod
    public void updateDepartment(Department department);
}

