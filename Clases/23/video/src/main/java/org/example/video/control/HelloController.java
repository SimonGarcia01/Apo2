package org.example.video.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.video.HelloApplication;
import org.example.video.model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private ControllerStudent controllerStudents;

    @FXML
    private TableView<Student> studentsTableView;

    @FXML
    private TableColumn<Student, String> nameTC;

    @FXML
    private TableColumn<Student, String> idTC;

    @FXML
    private TableColumn<Student, Integer> ageTC;

    @FXML
    private Button addStudentBtn;

    @FXML
    protected void onAddStudent() {
        HelloApplication.openWindow("form-add-student.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));

        studentsTableView.setItems(ControllerStudent.getInstance().getStudents());
    }
}