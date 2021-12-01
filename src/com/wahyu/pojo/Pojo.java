package com.wahyu.pojo;

import com.wahyu.model.Department;
import com.wahyu.model.Employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


//@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pojo
{
    // Employee
    @XmlElement(name = "employee")
    private List<Employee> listEmployees = null;

    public List<Employee> getListEmployee() {
        return listEmployees;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployees = listEmployee;
    }
    // Department
    @XmlElement(name = "Department")
    private List<Department> listDepartment = null;

    public List<Department> getListDepartment() {
        return listDepartment;
    }

    public void setListDepartment(List<Department> listDepartment) {
        this.listDepartment = listDepartment;
    }
    // All Data
    @XmlElement(name = "employee")
    private List<Employee> listData = null;

    public List<Employee> getListData() {
        return listData;
    }

    public void setListData(List<Employee> listData) {
        this.listData = listData;
    }
}
