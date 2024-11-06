package icesi.seg5.controller;

import icesi.seg5.HelloApplication;
import icesi.seg5.model.Member;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.annotation.processing.Generated;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Member> dataTableView;

    @FXML
    private TableColumn<Member, String> nameTC;

    @FXML
    private TableColumn<Member, String> typeTC;

    @FXML
    private TableColumn<Member, Double> lengthTC;

    @FXML
    private TableColumn<Member, Double> caloriesTC;

    private MemberController memberController;

    @FXML
    protected void onHelloButtonClick() {
        HelloApplication.openWindow("form-exercise.fxml");
    }

    @FXML
    protected void onStatisticsButton() {
        HelloApplication.openWindow("statistics.fxml");
    }

    @FXML
    protected void onDeleteButton() {
        HelloApplication.openWindow("delete.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        lengthTC.setCellValueFactory(new PropertyValueFactory<>("length"));
        caloriesTC.setCellValueFactory(new PropertyValueFactory<>("calories"));

        dataTableView.setItems(MemberController.getInstance().getMemberList());
    }

    public void save(){
        MemberController.getInstance().save();
    }

}