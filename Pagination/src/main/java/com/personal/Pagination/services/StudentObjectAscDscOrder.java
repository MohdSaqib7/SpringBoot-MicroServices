package com.personal.Pagination.services;

import com.personal.Pagination.models.Student;
import com.personal.Pagination.repositories.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentObjectAscDscOrder {

    private final StudentRepository studentRepository;

    public StudentObjectAscDscOrder(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentsList(String ord){
        List<Student> students;
        if(ord==""){
            students = studentRepository.findAll(Sort.by(Sort.Direction.ASC, ord));
        }else{
            students = studentRepository.findAll(Sort.by(Sort.Direction.DESC, ord));
        }
        return students;
    }
}
