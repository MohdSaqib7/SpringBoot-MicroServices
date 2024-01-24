package com.personal.TraditionalJdbc.models;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RowMapperImpl implements RowMapper<Doctor> {

    @Override
    public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException{

        Doctor doctor = new Doctor();
        doctor.setId(rs.getInt(1));
        doctor.setDoctorName(rs.getString(2));
        doctor.setSpecialization(rs.getString(3));
        doctor.setContact(rs.getInt(4));
        doctor.setDoctorCode(rs.getString(5));
        return doctor;
    }

}
