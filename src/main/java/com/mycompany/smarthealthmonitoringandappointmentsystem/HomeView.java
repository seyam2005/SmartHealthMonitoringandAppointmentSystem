/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smarthealthmonitoringandappointmentsystem;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeView extends VBox {

    public HomeView(Stage stage) {

        Label title = new Label("Welcome to Smart Health Monitoring And Appointment System");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Patient Name");

        Button btn = new Button("Explore Dashboard");

        btn.setOnAction(e -> {
            String name = nameField.getText(); //textfield as string convert

            DashboardView dv = new DashboardView(stage, name); //object creation and data passing 
            Scene scene = new Scene(dv, 640, 480);

            // CSS add again
            var css_url = getClass().getResource("styles.css");
            if (css_url != null) {
                scene.getStylesheets().add(css_url.toExternalForm()); //css add in scene

            }
            stage.setScene(scene); //scene switching from home to dashboard
    
        });

        this.getChildren().addAll(title, nameField, btn);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }
}

//pass the Stage object to different views and 
// change the Scene dynamically using stage.setScene(),
//  which allows smooth navigation between pages