package com.personal.TraditionalJdbc.services;

import com.personal.TraditionalJdbc.configs.JdbcTemplateConfig;
import com.personal.TraditionalJdbc.models.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
@Slf4j
public class DoctorRegistrationService {

    JdbcTemplateConfig config = new JdbcTemplateConfig();
    DataSource dataSource = config.myDataSource();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public String registerDoctor(Doctor doctor){
        String sql = "INSERT into tableName(id, doctorName, specialization, contact, doctorCode) VALUES (?,?,?,?,?)";
        try {
            int res = this.jdbcTemplate.update(sql,5,"malik","Neuro",972222,"D05ns");
            log.info("Sucess---");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "Successfully saved the Doctor details";
    }

    public String updateDoctor(String doctorCode, Integer contact) {
        String sql = "UPDATE tableName set contact=? where doctorCode=?";
        int res = this.jdbcTemplate.update(sql,contact,doctorCode);
        return "updated successfully";
    }

    public String deleteDoctor(Integer id){
        String sql = "DELETE from tableName WHERE id=?";
        int res = this.jdbcTemplate.update(sql,id);
        return "Delete Successfully";
    }


}
