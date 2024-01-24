package com.personal.Pagination.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="")
public class Student {

    @Id
    @Column()
    private Integer id;

    @Column(name="student_name")
    private String studentName;

    @Column(name="course")
    private String Course;

    @Column(name="enrollment_id")
    private Integer enrollmentId;
}
