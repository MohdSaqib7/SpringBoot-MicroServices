package com.personal.Pagination.controllers;

import com.personal.Pagination.models.Student;
import com.personal.Pagination.services.StudentObjectAscDscOrder;
import com.personal.Pagination.services.StudentPaginationService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/studentApi")
@RestController
public class StudentController {

    private final StudentPaginationService studentPaginationService;
    private final StudentObjectAscDscOrder studentObjectAscDscOrder;

    public StudentController(StudentPaginationService studentPaginationService, StudentObjectAscDscOrder studentObjectAscDscOrder) {
        this.studentPaginationService = studentPaginationService;
        this.studentObjectAscDscOrder = studentObjectAscDscOrder;
    }

    @GetMapping("/sort/{order}")
    public List<Student> studentListOrderSpecific(@PathVariable("order") String order){
        return studentObjectAscDscOrder.getStudentsList(order);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Student> StudentListPagination(@PathVariable("offset") Integer offset, @PathVariable("pageSize") Integer pageSize){
        return studentPaginationService.getStudentsList(offset,pageSize);
    }
}
