package com.personal.Pagination.services;

import com.personal.Pagination.models.Student;
import com.personal.Pagination.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentPaginationService {

    private final StudentRepository studentRepository;

    public StudentPaginationService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getStudentsList(Integer offset, Integer pageSize){
        Page<Student> students = studentRepository.findAll(PageRequest.of(offset,pageSize));
        return students;
    }
}
