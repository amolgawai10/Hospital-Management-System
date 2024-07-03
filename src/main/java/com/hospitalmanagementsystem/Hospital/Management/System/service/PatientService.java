package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.model.Patient;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.HospitalRepository;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.HashMap;

@Service
public class PatientService {
    // call the PatientRepository
    PatientRepository patientRepository = new PatientRepository();
    @Autowired
    HospitalRepository hospitalRepository;
    public Hospital registerPatient(Patient patient){
        patientRepository.registerPatient(patient);
        //Once patient register we have to assign hospital who has max beds
        //patientService require HospitalRepository
        HashMap<String, Hospital> allHospitals = hospitalRepository.getAllHospitals();
        int maxBed = Integer.MIN_VALUE;
        Hospital maxBedHospital = null;

        for(String key : allHospitals.keySet()){
            Hospital hospital = allHospitals.get(key);
            int bedCount = hospital.totalBeds;
            if(bedCount > maxBed){
                maxBed = bedCount;
                maxBedHospital = hospital;
            }
        }
        return maxBedHospital;

    }

}
