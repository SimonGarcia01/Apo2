package icesi.seg5.controller;

import icesi.seg5.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Delete {

    @FXML
    private TextField deleteType;

    @FXML
    private Button deleteButton;

    public void onDelete(ActionEvent event) {
        String type = deleteType.getText();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Just for your information!");
        alert.setContentText("The entries that will be deleted are the following:" + MemberController.getInstance().deleteActivity(type));
        alert.showAndWait();

        Stage stage = (Stage) deleteButton.getScene().getWindow();
        stage.close();
    }

}
