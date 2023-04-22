/**
 * @author :Hansaka Malshan
 * created 3/31/2023---12:29 AM
 */
package lk.ijse.hostalmanagementsystem.utill;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane mainpane;

    public static void navigate(Route route, AnchorPane mainpane) throws IOException {
        Navigation.mainpane = mainpane;
        Navigation.mainpane.getChildren().clear();
        Stage window = (Stage) Navigation.mainpane.getScene().getWindow();
        switch (route){

            case DASHBOARDFORM:
                window.setTitle("DashBoardForm");
                initUI("dashboardForm.fxml");
                break;
            case STUDENTFORM:
                window.setTitle("STUDENTFORM");
                initUI("studentsForm.fxml");
                break;
            case ROOMFORM:
                window.setTitle("ROOMFORM");
                initUI("roomForm.fxml");
                break;
            case RESERVATIONFORM:
                window.setTitle("RESERVATIONFORM");
                initUI("reservationroomForm.fxml");
                break;
            case PAYMENT:
                window.setTitle("PAYMENT");
                initUI("paymentForm.fxml");
                break;
            case REGISTER:
                window.setTitle("REGESTER");
                initUI("registeruser.fxml");
                break;
            case FORGOTPASSWORD:
                window.setTitle("FORGOTPASSWORD");
                initUI("forgetpassword.fxml");
                break;
            case LOGINFORM:
                window.setTitle("DASHBOARD");
                initUI("loginForm.fxml");
                break;
            case CREATEREGISTER:
                 window.setTitle("CREATEREGISTER");
                initUI("loginForm.fxml");
                break;

        }

    }
private static void initUI(String location) throws IOException {
        Navigation.mainpane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/hostalmanagementsystem/view/"+ location)));
}
}
