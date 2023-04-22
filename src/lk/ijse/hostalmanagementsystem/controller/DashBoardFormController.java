/**
 * @author :Hansaka Malshan
 * created 3/30/2023---6:45 PM
 */
package lk.ijse.hostalmanagementsystem.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.hostalmanagementsystem.utill.Navigation;
import lk.ijse.hostalmanagementsystem.utill.Route;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardFormController implements Initializable {


    public Pane contex;
    public AnchorPane mainpane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void studentFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("studentsForm.fxml");
    }

    private void setUi(String Ui) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource("/lk/ijse/hostalmanagementsystem/view/" + Ui));
        contex.getChildren().clear();
        contex.getChildren().add(node);
    }

    public void comeondashboardOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.DASHBOARDFORM,mainpane);
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
       Navigation.navigate(Route.LOGINFORM,mainpane);
    }

    public void roomOnAction(ActionEvent actionEvent) throws IOException {
       setUi("roomForm.fxml");
    }

    public void paymentOnAction(ActionEvent actionEvent) throws IOException {
        setUi("paymentForm.fxml");
    }

    public void reservationOnAction(ActionEvent actionEvent) throws IOException {
       setUi("reservationroomForm.fxml");
    }
}
