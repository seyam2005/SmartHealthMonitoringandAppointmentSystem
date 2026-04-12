/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smarthealthmonitoringandappointmentsystem.service;

import com.mycompany.smarthealthmonitoringandappointmentsystem.model.HealthRecord;
import com.mycompany.smarthealthmonitoringandappointmentsystem.model.HealthResult;

public class HealthService {

    public void saveRecord(HealthRecord hr) {
        System.out.println("Saved Heart Rate: " + hr.getHeartRate());
        System.out.println("Saved Temperature: " + hr.getTemperature());
        System.out.println("Saved Blood Pressure: " + hr.getBloodPressure());
    }

    public HealthResult checkHealth(HealthRecord hr) {

        String message = "";
        boolean isWarning = false;

        int heart = hr.getHeartRate();
        double temp = hr.getTemperature();
        String bp = hr.getBloodPressure();

        // Heart Check
        if (heart > 100) {
            message += "⚠ High Heart Rate!\n";
            isWarning = true;
        }

        // Temperature Check
        if (temp > 100) {
            message += "⚠ High Temperature!\n";
            isWarning = true;
        }

        // Blood Pressure Check
        if (bp != null && bp.contains("/")) {
            try {
                String[] parts = bp.split("/");
                int sys = Integer.parseInt(parts[0]);

                if (sys >= 140) {
                    message += "⚠ High Blood Pressure!\n";
                    isWarning = true;
                }
            } catch (Exception ex) {
                message += "Invalid BP format!\n";
                isWarning = true;
            }
        }

        if (!isWarning) {
            message = "✅ Normal Condition";
        }

        return new HealthResult(message, isWarning);
    }
}
