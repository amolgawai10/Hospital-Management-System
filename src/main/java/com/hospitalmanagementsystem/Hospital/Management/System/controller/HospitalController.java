package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class HospitalController {
        //After ? there is key - value pair called as Query parameter or Request Parameter

        //have to create url which give all details of hospitals
        //Add injection dependency of Service into Controller
        @Autowired
        HospitalService hospitalService;
        @GetMapping("/api/hospitals")
        public List<Hospital> getAllHospitals(){
            //To get all the hospitals we need to write logic
            //logic is present in 'service'
            List<Hospital> hospitals = hospitalService.getAllHospitals();
            return hospitals;
        }

        // User provide information in the form of JSON :- Javascript object notation
        // JSON is key-value pair
        // SpringBoot will convert JSON object or JSON payload or body into Hospital class object
        int count=0;
        @PostMapping("/api/addhospital")
        public String addHospital(@RequestBody Hospital hospital){
            String id = hospital.id + "";
            hospitalService.addHospital(id,hospital);
            return "Hospital Object has been added";
            // Service layer -> call service layer to add hospital object into the system
        }
        // In controller, we have to provide 'url'

        // Inside parenthesis i.e called as 'end point' or 'url'
        // @RestController : Tells Spring that this is a Controller !!
        // Note : postman is a client who request to server and get response from Controller

        //------------Learning Request Parameter-----------------------//
        //Syntax : http://localhost:8080/api/hospital?hospitalId=1 That 1 is dynamic
        @GetMapping("/api/hospital")
        public Hospital getSpecificHospitalDetails(@RequestParam int hospitalId){
            //Hospital Controller call Hospital Service
            return hospitalService.getHospitalDetailsById(hospitalId);
        }

        //----- Learn Path Variable -------//
        // Syntax : http://localhost:8080/api/hospital/1 that 1 can change into other id

        @GetMapping("/api/hospital/{hospitalId}/detail")
        public Hospital getSpecificHospitalDetailsByPathVariable(@PathVariable int hospitalId){
            return hospitalService.getHospitalDetailsById(hospitalId);
        }


    }
