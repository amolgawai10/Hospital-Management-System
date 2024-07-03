package com.hospitalmanagementsystem.Hospital.Management.System.repository;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class HospitalRepository {
    // Repo layer deals with data
    HashMap<String, Hospital> hospitalDB = new HashMap<>();

    public HashMap<String, Hospital> getAllHospitals(){
        return hospitalDB;
    }
    public void addHospital(String id, Hospital hospital){
        hospitalDB.put(id,hospital);
    }
    public Hospital getHospitalDetailsById(int id){
        String key = id + "";
        Hospital hospital = hospitalDB.get(key);
        return hospital;
    }
}
