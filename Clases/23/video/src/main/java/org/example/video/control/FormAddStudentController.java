package org.example.video.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormAddStudentController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private Button addStudentBtn;

    public void onAddStudent(ActionEvent event){
        String name = nameTextField.getText();
        String id = idTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());

        ControllerStudent.getInstance().addStudent(name, id, age);

        Stage stage = (Stage) addStudentBtn.getScene().getWindow();
        stage.close();
    }
}
