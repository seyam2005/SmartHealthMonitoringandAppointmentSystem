package com.mycompany.smarthealthmonitoringandappointmentsystem;


import java.net.URL;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        HomeView homeView = new HomeView(stage);
        Scene scene = createScene(homeView); // use our method
        stage.setScene(scene);
        stage.setTitle("Smart Health System with JavaFx Powered by Seyam");
        stage.show();
    }

    // 🔥 CSS add method
    public static void addCSS(Scene scene){
        var css_url = App.class.getResource("styles.css");
        if(css_url != null){
            scene.getStylesheets().add(css_url.toExternalForm());
        }
    }

    // 🔥 Scene create method (BEST PRACTICE)
    public static Scene createScene(Parent root){
        Scene scene = new Scene(root, 640, 480);
        addCSS(scene);
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}