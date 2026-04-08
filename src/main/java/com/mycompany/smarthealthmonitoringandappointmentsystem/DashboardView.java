/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smarthealthmonitoringandappointmentsystem;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

import com.mycompany.smarthealthmonitoringandappointmentsystem.model.*;
import com.mycompany.smarthealthmonitoringandappointmentsystem.service.*;

public class DashboardView extends VBox {

    public DashboardView(Stage stage, String patientName){

        // 🔷 Title
        Label welcome = new Label("🏥 Smart Health Dashboard");

        // 🔷 Input Fields
        TextField heartField = new TextField();
        heartField.setPromptText("Heart Rate");

        TextField tempField = new TextField();
        tempField.setPromptText("Temperature");

        TextField bpField = new TextField();
        bpField.setPromptText("Blood Pressure");

        // 🔷 Doctor Select
        ComboBox<String> doctorBox = new ComboBox<>();
        doctorBox.getItems().addAll(
            "Dr. Rahman",
            "Dr. Ahmed",
            "Dr. Sara"
        );
        doctorBox.setPromptText("Select Doctor");

        // 🔷 Date Picker
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Select Appointment Date");

        // 🔷 Buttons
        Button saveBtn = new Button("Save Health Data");
        Button appointBtn = new Button("Book Appointment");

        // 🔷 Output
        Label output = new Label();
        output.setWrapText(true);
        output.setMaxWidth(250);

        // 🔥 Save Button Logic
       saveBtn.setOnAction(e -> {
    try {
        int heart = Integer.parseInt(heartField.getText());
        double temp = Double.parseDouble(tempField.getText());
        String bp = bpField.getText();

        HealthRecord hr = new HealthRecord();
        hr.setHeartRate(heart);
        hr.setTemperature(temp);
        hr.setBloodPressure(bp);

        new HealthService().saveRecord(hr);

        String message = "";
        boolean isWarning = false;

        // Heart Check
        if (heart > 100) {
            message += "⚠ High Heart Rate!\n";
            isWarning = true;
        }

        // Temperature Check
        if (temp > 37.5) {
            message += "⚠ High Temperature!\n";
            isWarning = true;
        }

        // Blood Pressure Check (simple)
        if (bp.contains("140") || bp.contains("150")) {
            message += "⚠ High Blood Pressure!\n";
            isWarning = true;
        }

        // Final Output
        if (isWarning) {
            output.setText(message);
            output.setStyle("-fx-text-fill: red;");
        } else {
            output.setText("✅ Normal Condition");
            output.setStyle("-fx-text-fill: lightgreen;");
        }

    } catch (Exception ex) {
        output.setText("❌ Please enter valid numbers!");
        output.setStyle("-fx-text-fill: red;");
    }
});

        // 🔥 Appointment Button Logic
        appointBtn.setOnAction(e -> {

            if(doctorBox.getValue() == null){
                output.setText("Select a doctor!");
                return;
            }

            if(datePicker.getValue() == null){
                output.setText("Select a date!");
                return;
            }

            Appointment ap = new Appointment();
            ap.setPatientName(patientName);
            ap.setDoctorName(doctorBox.getValue());
            ap.setDate(datePicker.getValue().toString());

            new AppointmentService().bookAppointment(ap);

            output.setText("✅ Appointment booked!");
            output.setStyle("-fx-text-fill: lightgreen;");
        });

        // 🔥 Card Layout
        VBox card = new VBox();
        card.getChildren().addAll(
            welcome,
            heartField,
            tempField,
            bpField,
            doctorBox,
            datePicker,
            saveBtn,
            appointBtn,
            output
        );

        card.setSpacing(15);
        card.setAlignment(Pos.CENTER);
        card.getStyleClass().add("card");

        // 🔥 Add to main
        this.getChildren().add(card);
        this.setAlignment(Pos.CENTER);

        // 🔥 Animation
        FadeTransition ft = new FadeTransition(Duration.seconds(1), card);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
}