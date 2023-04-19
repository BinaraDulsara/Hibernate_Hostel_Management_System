package lk.hostal_management_system.unil;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    private static AnchorPane pane;

    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/hostal_management_system/view/"+location)));
    }

    public static void navigation(lk.hostal_management_system.unil.Routes routes, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (routes) {
            case DASHBOARD:
                window.setTitle("Dashboard");
                initUI("dash_board.fxml");
                break;

            case LOGIN:
                window.setTitle("Login Form");
                initUI("login_form.fxml");
                break;

            case STUDENT:
                window.setTitle("Student Form");
                initUI("student.fxml");
                break;
        }
    }
}
