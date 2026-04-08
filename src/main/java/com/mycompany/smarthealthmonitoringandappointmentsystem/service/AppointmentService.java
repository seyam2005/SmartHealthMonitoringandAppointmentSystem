/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smarthealthmonitoringandappointmentsystem.service;



import com.mycompany.smarthealthmonitoringandappointmentsystem.model.Appointment;

import java.util.ArrayList;

public class AppointmentService {

    ArrayList<Appointment> list = new ArrayList<>();

    public void bookAppointment(Appointment ap){
        list.add(ap);
        System.out.println("Appointment booked for " + ap.getPatientName() + " with " + ap.getDoctorName() + " on " + ap.getDate());

    }
}