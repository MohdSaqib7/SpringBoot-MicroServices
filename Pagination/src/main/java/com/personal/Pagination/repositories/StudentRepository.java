package com.personal.Pagination.repositories;

import com.personal.Pagination.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
