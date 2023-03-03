package com.example.restservice.service;

import com.example.restservice.model.Employee;
import com.example.restservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: Yeming Hu
 * @Date: 2/27/2023
 * @Description: com.example.restservice.service
 * @Version: 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        if(id>0){
            return employeeRepository.getEmployeeById(id);
        }
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }

    @Override
    public Integer addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        if(id > 0){
            employeeRepository.updateEmployee(id,employee);
        }
    }


    @Override
    public void deleteEmployee(int id) {
        if(id >0){
            employeeRepository.deleteEmployee(id);
        }
    }
}
