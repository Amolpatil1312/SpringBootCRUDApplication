package com.csi.services;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceimpl implements EmployeeServices {

    @Autowired
    EmployeeDao employeeDaoimpl;
    @Override
    public void save(Employee employee) {
        employeeDaoimpl.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDaoimpl.findAll();
    }

    @Override
    public Employee findById(int empid) {
        return employeeDaoimpl.findById(empid);
    }

    @Override
    public void updateById(Employee employee, int empId) {
        employeeDaoimpl.updateById(employee,empId);

    }

    @Override
    public void deleteById(int empId) {
        employeeDaoimpl.deleteById(empId);
    }

    @Override
    public void deleteAll() {
        employeeDaoimpl.deleteAll();
    }
}
