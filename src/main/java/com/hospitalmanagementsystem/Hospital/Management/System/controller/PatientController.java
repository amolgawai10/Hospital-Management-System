package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.model.Patient;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.PatientRepository;
import com.hospitalmanagementsystem.Hospital.Management.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    //Note : When patient register himself, we will assign that hospital which has more no of beds
    @Autowired
    PatientService patientService;
    @PostMapping("api/patient/register")
    public Hospital registerPatient(@RequestBody Patient patient){
        //controller call PatientService layer
        Hospital hospital = patientService.registerPatient(patient);
        return hospital;
    }

}
