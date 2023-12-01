package com.csi.controller;

import com.csi.model.Employee;
import com.csi.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServicesImpl;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Employee employee){
        employeeServicesImpl.save(employee);
        return ResponseEntity.ok("Data Saved Successfully");
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){

        List<Employee> employeeList = employeeServicesImpl.findAll();
        
        return ResponseEntity.ok(employeeList) ;
    }
    
    @GetMapping("/findbytid/{empId}")
    public ResponseEntity<Employee> findById(@PathVariable int empId ){
        
        return ResponseEntity.ok(employeeServicesImpl.findById(empId));
        
    } 
    
    @PutMapping("/updatebyid/{empId}")
    public ResponseEntity<String> updateById(@RequestBody Employee employee,@PathVariable int empId){
        employeeServicesImpl.updateById(employee,empId);
        return ResponseEntity.ok("Data Updated Successfully");
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleateById(@PathVariable int empId){
        employeeServicesImpl.deleteById(empId);
        return ResponseEntity.ok("Date deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        employeeServicesImpl.deleteAll();
        return ResponseEntity.ok("Date deleted Successfully");
    }
}
