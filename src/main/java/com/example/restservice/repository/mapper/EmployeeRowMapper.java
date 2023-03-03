package com.example.restservice.repository.mapper;

import com.example.restservice.repository.entity.EmployeeEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Yeming Hu
 * @Date: 3/1/2023
 * @Description: com.example.restservice.repository.mapper
 * @Version: 1.0
 */
public class EmployeeRowMapper implements RowMapper<EmployeeEntity> {

    @Override
    public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EmployeeEntity.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .postalCode(rs.getString("postalCode"))
                .salary(rs.getDouble("salary"))
                .build();
    }
}
