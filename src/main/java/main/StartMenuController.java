package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class StartMenuController {

    @FXML
    private ChoiceBox<String> modelBox;

    @FXML
    private void initialize() {
        loadModelsAndAddToComboBox();
    }

    @FXML
    private void setMainStage() throws IOException {
        if (modelBox.getValue() == null){
            return;
        }
        App.setRoot("scene2");
    }

    private void loadModelsAndAddToComboBox() {
        String filePath = "src/main/data/model_list.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String modelName;
            while ((modelName = reader.readLine()) != null) {
                if (!modelName.trim().isEmpty()) {
                    modelBox.getItems().add(modelName.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
