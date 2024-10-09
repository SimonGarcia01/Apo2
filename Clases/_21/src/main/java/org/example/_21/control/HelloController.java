package org.example._21.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example._21.exceptions.PersonAlreadyCreatedException;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    //Defining all graphical elements
    @FXML
    private Label welcomeText;

    @FXML
    private Label nameLabel;

    @FXML
    private Label codeLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField codeTextField;

    //Define other controllers
    private PersonController personController;

    @FXML
    public void onRegisterUser(){
        String name = nameTextField.getText();
        String code = codeTextField.getText();

        try{
            personController.addPerson(name, code);
        } catch (PersonAlreadyCreatedException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Person created");
            alert.setContentText(e.getMessage());
            //Shows the window and then wait for the person to click wait
            alert.showAndWait();
        }


        welcomeText.setText(personController.printPeople());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personController = new PersonController();
    }


//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//        nameLabel.setText("Nombre: Estudiante 1");
//    }
}