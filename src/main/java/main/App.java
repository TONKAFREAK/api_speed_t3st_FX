package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        
        scene = new Scene(loadFXML("startMenu"));
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("AI API tester");

    }

    @Override
    public void init() {
        Font.loadFont(getClass().getResourceAsStream("/main/fonts/Duplexide.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("/main/fonts/Consolas.ttf"), 14);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}