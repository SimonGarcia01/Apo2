package icesi.seg5.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable {

    @FXML
    private Label avgDurationLabel;

    @FXML
    private Button doneButton;

    @FXML
    private Label topOne;

    @FXML
    private Label topTwo;

    @FXML
    private Label topThree;

    public void onDone(ActionEvent event) {
        Stage stage = (Stage) doneButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        avgDurationLabel.setText(MemberController.getInstance().averageDuration());
        String[] top3 = MemberController.getInstance().getTop3Activities();

        topOne.setText("1. " + top3[0]);
        topTwo.setText("2. " + top3[1]);
        topThree.setText("3. " + top3[2]);
    }
}
