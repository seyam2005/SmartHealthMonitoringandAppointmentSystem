package com.mycompany.smarthealthmonitoringandappointmentsystem.model;

public class HealthResult {

    private String message;
    private boolean warning;

    public HealthResult(String message, boolean warning) {
        this.message = message;
        this.warning = warning;
    }

    public String getMessage() {
        return message;
    }

    public boolean isWarning() {
        return warning;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setWarning(boolean warning) {
        this.warning = warning;
    }
}