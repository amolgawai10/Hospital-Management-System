package com.hospitalmanagementsystem.Hospital.Management.System.model;
//public : variable will accessible outside package
//private :
//default : variable access within package only

public class Hospital {
    public int id;
    public String name;
    public int totalBeds;
    public int totalPatients;
    public int totalDoctors;

    public Hospital(int id, String name, int totalBeds, int totalPatients, int totalDoctors) {
        this.id = id;
        this.name = name;
        this.totalBeds = totalBeds;
        this.totalPatients = totalPatients;
        this.totalDoctors = totalDoctors;
    }

    public Hospital() {

    }
}
