package icesi.seg5.controller;

import icesi.seg5.exceptions.InvalidInfoException;
import icesi.seg5.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormExerciseController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField caloriesTextField;

    @FXML
    private Button addExerciseButton;

    public void onAddExercise(ActionEvent event) throws InvalidInfoException{

        String name = nameTextField.getText();
        String type = typeTextField.getText();
        String length = typeTextField.getText();
        String calories = typeTextField.getText();

        if(name.equals("") || type.equals("") || length.equals("") || calories.equals("")){
            throw new InvalidInfoException("All text boxes must be filled.");
        }

        double doubleLength = Double.parseDouble(lengthTextField.getText());
        double doubleCalories = Double.parseDouble(caloriesTextField.getText());

        if(doubleLength <= 0 || doubleCalories <= 0){
            throw new InvalidInfoException("The duration or burnt calories must be greater than 0.")
        }

        MemberController.getInstance().createMember(name, type, doubleLength, doubleCalories);

        Stage stage = (Stage) addExerciseButton.getScene().getWindow();
        stage.close();
    }
}
