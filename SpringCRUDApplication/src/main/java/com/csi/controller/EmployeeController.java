package com.csi.controller;

import com.csi.model.Employee;
import com.csi.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServicesimpl;

    @PostMapping("/save")
    public ResponseEntity<String> Save(@RequestBody Employee employee){
        employeeServicesimpl.save(employee);
        return ResponseEntity.ok("Data Saved Successfully");
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Employee> FindById(@PathVariable int empId){
        return ResponseEntity.ok(employeeServicesimpl.findById(empId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){

        List<Employee> employeeList = employeeServicesimpl.findAll();
        return ResponseEntity.ok(employeeServicesimpl.findAll()) ;
    }

    @PutMapping("/updatebyid/{empId}")
    public ResponseEntity<String> updateById(@PathVariable int empId, @RequestBody Employee employee){

        employeeServicesimpl.updateById(employee,empId);

        return ResponseEntity.ok("Data Updated Successfully");

    }

    @DeleteMapping("/deletebyId/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        employeeServicesimpl.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        employeeServicesimpl.deleteAll();
        return ResponseEntity.ok("All Data Goan.....");
    }


}
