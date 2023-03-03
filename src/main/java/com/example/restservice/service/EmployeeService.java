package com.example.restservice.service;

import com.example.restservice.model.Employee;

import java.util.List;

/**
 * @Author: Yeming Hu
 * @Date: 2/27/2023
 * @Description: com.example.restservice.service
 * @Version: 1.0
 */
public interface EmployeeService {

    /**
     *
     * @return the list of employees
     */
    List<Employee> getAllEmployees();

    /**
     *
     * @param id  the id of the employee
     * @return an employee with that id
     */
    Employee getEmployeeById(int id);

    /**
     *
     * @param name the name of the employee
     * @return  an employee with that name
     */
    Employee getEmployeeByName(String name);

    /**
     *
     * @param employee an employee
     * @return  the number of employees
     */
    int addEmployee(Employee employee);

    /**
     *
     * @param id the id of employee
     * @param employee an employee with that id
     * @return
     */
    Employee updateEmployee(int id, Employee employee);

    /**
     *
     * @param id the id of employee
     */
    void deleteEmployee(int id);

}
