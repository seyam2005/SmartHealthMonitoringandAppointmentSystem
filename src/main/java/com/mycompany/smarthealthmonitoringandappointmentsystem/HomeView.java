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

    public HomeView(Stage stage){

        Label title = new Label("Welcome to Smart Health Monitoring And Appointment System");
       
        
        
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Patient Name");

        Button btn = new Button("Go to Dashboard");

        btn.setOnAction(e -> {
            String name = nameField.getText();

            DashboardView dv = new DashboardView(stage, name);
          Scene scene = new Scene(dv, 640, 480);

// CSS add again
         var css_url = getClass().getResource("styles.css");
         if(css_url != null){
         scene.getStylesheets().add(css_url.toExternalForm());
         }

        stage.setScene(scene);
            stage.setScene(scene);
        });

        this.getChildren().addAll(title, nameField, btn);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }
}