package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.model.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class HospitalService {

    // Must read : When patient register himself in portal, we will assign hospital to him
    // where max beds are available

    //This is service class: All logic is written here
    //let's build connection between 'Service' and 'repository'
    // We have injected the dependency of Hospital repository into the Hospital Service
    @Autowired
    HospitalRepository hospitalRepository; // add dependency injection
    public List<Hospital> getAllHospitals(){
        //need hospitals data
        //So, service layer call repository layer
        HashMap<String,Hospital> hospitalDB = hospitalRepository.getAllHospitals();
        List<Hospital> allHospitals = new ArrayList<>();
        for(String hospitalID :hospitalDB.keySet()){
            Hospital hospital = hospitalDB.get(hospitalID);
            allHospitals.add(hospital);
        }
        return allHospitals;
    }
    public void addHospital(String id, Hospital hospital){
        //service layer call repository layer
        hospitalRepository.addHospital(id,hospital);
    }

    public Hospital getHospitalDetailsById(int id){
        // Service will call Hospital Repository to get datails
        return hospitalRepository.getHospitalDetailsById(id);
    }
}
