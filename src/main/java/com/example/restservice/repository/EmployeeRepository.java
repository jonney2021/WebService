package com.example.restservice.repository;

import com.example.restservice.model.Employee;
import com.example.restservice.repository.entity.EmployeeEntity;
import com.example.restservice.repository.mapper.EmployeeRowMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yeming Hu
 * @Date: 2/27/2023
 * @Description: com.example.restservice.repository
 * @Version: 1.0
 */
@Repository
public class EmployeeRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ModelMapper modelMapper;

    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeRowMapper());
        List<Employee> employeeResult = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntityList) {
            Employee employee = modelMapper.map(employeeEntity, Employee.class);
            employeeResult.add(employee);
        }
        return employeeResult;
    }

    public Employee getEmployeeById(int id) {
        try {
            EmployeeEntity employeeEntity = jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE where id = ?", new EmployeeRowMapper(), id);
            Employee employee = modelMapper.map(employeeEntity, Employee.class);
            return employee;
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    public Employee getEmployeeByName(String name) {
        String sql = "SELECT * FROM EMPLOYEE where name = ?";
        try {
            EmployeeEntity employeeEntity = jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), name);
            return modelMapper.map(employeeEntity, Employee.class);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }


    public Integer addEmployee(Employee employee) {
        String sql = "INSERT INTO EMPLOYEE(name, postalCode, salary) VALUES(?,?,?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getPostalCode(), employee.getSalary());

        //I want to the inserted id in the db
        return jdbcTemplate.queryForObject("SELECT MAX(ID) FROM EMPLOYEE", Integer.class);
    }

    public void updateEmployee(int id, Employee employee) {
        String sql = "UPDATE EMPLOYEE SET NAME=?,postalCode=?, salary=? where id=?";
        jdbcTemplate.update(sql, employee.getName(), employee.getPostalCode(), employee.getSalary(), id);
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM EMPLOYEE WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

}
