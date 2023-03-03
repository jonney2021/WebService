package com.example.restservice.api;

import com.example.restservice.model.Employee;
import com.example.restservice.service.EmployeeService;
import com.example.restservice.service.EmployeeServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author: Yeming Hu
 * @Date: 2/24/2023
 * @Description: com.example.restservice.api
 * @Version: 1.0
 */
@RestController
@RequestMapping("/jac")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // get all employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    // get employee by name
    @GetMapping("/employees/employee")
    public ResponseEntity<Employee> getEmployeeByName(@RequestParam(value = "name", defaultValue = "") String name) {
        return new ResponseEntity<>(employeeService.getEmployeeByName(name),HttpStatus.OK);
    }

    // add employee
    @PostMapping("/employees")
    public ResponseEntity<Integer> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.CREATED);
    }

    //update employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id,employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete employee
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
