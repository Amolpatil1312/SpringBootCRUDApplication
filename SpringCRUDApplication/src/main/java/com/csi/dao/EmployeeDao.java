package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void save(Employee employee);

    public List<Employee> findAll();

    public Employee findById(int empid);

    public void updateById(Employee employee,int empId);

    public void deleteById(int empId);

    public void deleteAll();

}
