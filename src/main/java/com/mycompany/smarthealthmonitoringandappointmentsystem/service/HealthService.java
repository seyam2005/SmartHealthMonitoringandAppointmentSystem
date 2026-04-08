/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smarthealthmonitoringandappointmentsystem.service;



import com.mycompany.smarthealthmonitoringandappointmentsystem.model.HealthRecord;

public class HealthService {

    public void saveRecord(HealthRecord hr){
        System.out.println("Saved Heart Rate: " + hr.getHeartRate());
        System.out.println("Saved Temperature: " + hr.getTemperature() +hr.getBloodPressure());
        System.out.println("Saved Blood Pressure " +hr.getBloodPressure());
    }
}