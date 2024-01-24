package com.personal.TraditionalJdbc.services;

import com.personal.TraditionalJdbc.configs.JdbcTemplateConfig;
import com.personal.TraditionalJdbc.models.Doctor;
import com.personal.TraditionalJdbc.models.RowMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;


@Service
@Slf4j
public class GetDoctorDetailsService {

    JdbcTemplateConfig config = new JdbcTemplateConfig();
    DataSource dataSource = config.myDataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public Doctor getDoctor(String name){

        String sql = "SELECT*FROM tableName WHERE name=?";
        RowMapper<Doctor> rowMapper = new RowMapperImpl();

        Doctor doctor = jdbcTemplate.queryForObject(sql,rowMapper,name);
        log.info("Successfully getting info from database");
        return doctor;
    }

    public List<Doctor> getAllDoctors (){
        String sql = "SELECT*FROM tableName";
        List<Doctor> doctors = jdbcTemplate.query(sql,new RowMapperImpl());
        return doctors;
    }
}
