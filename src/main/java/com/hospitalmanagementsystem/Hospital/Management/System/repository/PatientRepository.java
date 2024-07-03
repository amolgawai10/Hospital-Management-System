package com.hospitalmanagementsystem.Hospital.Management.System.repository;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PatientRepository {
    HashMap<String, Patient> patientDb = new HashMap<>();
    public void registerPatient(Patient patient){
        String id = patient.getPatientId()+"";
        patientDb.put(id,patient);

    }
}
