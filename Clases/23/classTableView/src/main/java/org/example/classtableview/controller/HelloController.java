package org.example.classtableview.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.classtableview.HelloApplication;
import org.example.classtableview.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Person> peopleTV;

    @FXML
    private TableColumn<Person, String> nameTC;

    @FXML
    private TableColumn<Person, String> idTC;

    @FXML
    private TableColumn<Person, Integer> ageTC;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTC.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
        ageTC.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));

        peopleTV.setItems(PersonController.getInstance().getPeople());
    }

    public void onAddPerson(ActionEvent actionEvent) {
        HelloApplication.openWindow("form-view.fxml");
    }
}