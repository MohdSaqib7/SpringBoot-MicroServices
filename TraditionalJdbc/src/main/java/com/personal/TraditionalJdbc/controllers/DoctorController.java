package com.personal.TraditionalJdbc.controllers;

import com.personal.TraditionalJdbc.models.Doctor;
import com.personal.TraditionalJdbc.services.DoctorRegistrationService;
import com.personal.TraditionalJdbc.services.GetDoctorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRegistrationService doctorRegistrationService;

    @Autowired
    private GetDoctorDetailsService getDoctorDetailsService;

    @PostMapping("/register")
    public String registerDoctor(@RequestBody Doctor doctor){
        return doctorRegistrationService.registerDoctor(doctor);
    }

    @GetMapping("/get/Doctor/{name}")
    public Doctor getDoctor(@PathVariable String name){
        return getDoctorDetailsService.getDoctor(name);
    }

    @GetMapping("/getAll/Doctors")
    public List<Doctor> getAllDoctors(){
        return getDoctorDetailsService.getAllDoctors();
    }

    @GetMapping("update/Doctor")
    public String updateDoctor(@RequestParam String doctorCode, @RequestParam Integer contact){
        return doctorRegistrationService.updateDoctor(doctorCode,contact);
    }

    @GetMapping("/delete/Doctor/{id}")
    public String deleteDoctor(@PathVariable Integer id){
        return doctorRegistrationService.deleteDoctor(id);
    }

}
