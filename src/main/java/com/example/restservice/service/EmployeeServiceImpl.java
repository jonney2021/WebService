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

//    List<Employee> employees = new ArrayList<>(
//            List.of(Employee.builder().id(1001).name("Tom").postalCode("H3P 1H2").salary(1000.00).build(),
//                    Employee.builder().id(1002).name("Jerry").postalCode("H4B 1H4").salary(2000.00).build(),
//                    Employee.builder().id(1003).name("Jenny").postalCode("H2Q 1N6").salary(3000.00).build()
//            )
//
//    );

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
//        Optional<Employee> employeeFound = employees.stream().filter(employee -> employee.getId() == id).findFirst();
//        return employeeFound.orElse(null);
        if(id>0){
            return employeeRepository.getEmployeeById(id);
        }
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
//        Optional<Employee> employeeFound = employees.stream().filter(employee -> employee.getName().equalsIgnoreCase(name)).findFirst();
//        return employeeFound.orElse(null);
        return employeeRepository.getEmployeeByName(name);
    }

    @Override
    public int addEmployee(Employee employee) {
//        if (employees.stream().noneMatch(employee1 -> employee1.getId() == employee.getId())) {
//            employees.add(employee);
//        }
//        return employees.size();
        return employeeRepository.addEmployee(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
//        if (employees.stream().anyMatch(employee1 -> employee1.getId() == id)) {
//            Optional<Employee> toBeUpdate = employees.stream().filter(employee1 -> employee1.getId() == id).findFirst();
//            Employee updateEmployee = toBeUpdate.get();
//            updateEmployee.setId(employee.getId());
//            updateEmployee.setName(employee.getName());
//            updateEmployee.setPostalCode(employee.getPostalCode());
//            updateEmployee.setSalary(employee.getSalary());
//            return updateEmployee;
//        }

        if(id > 0){
            employeeRepository.updateEmployee(id,employee);
            return employee;
        }
        return null;
//        Optional<Employee> employeeFound = employees.stream().filter(emp -> emp.getId()== id).findFirst();
//        if(employeeFound.isPresent()){
//            Employee employeeTobeUpdated = employeeFound.get();
//            employeeTobeUpdated.setName(employee.getName());
//            employeeTobeUpdated.setSalary(employee.getSalary());
//            employeeTobeUpdated.setPostalCode(employee.getPostalCode());
//        }
    }


    @Override
    public void deleteEmployee(int id) {
//        if (employees.stream().anyMatch(employee -> employee.getId() == id)) {
//            Optional<Employee> toBeDelete = employees.stream().filter(employee -> employee.getId() == id).findFirst();
//            Employee deleteEmployee = toBeDelete.get();
//            employees.remove(deleteEmployee);
//        }
        if(id >0){
            employeeRepository.deleteEmployee(id);
        }
    }
}
