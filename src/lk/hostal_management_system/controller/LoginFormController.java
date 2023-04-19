package lk.hostal_management_system.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.hostal_management_system.unil.Navigation;
import lk.hostal_management_system.unil.Routes;

import java.io.IOException;

public class LoginFormController {

    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXTextField txtShowPassword;
    public JFXPasswordField txtPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
          Navigation.navigation(Routes.DASHBOARD,pane);

    }

    public void EnterMouseOnAction(MouseEvent mouseEvent) {
        txtPassword.setVisible(false);
        txtShowPassword.setVisible(true);
        txtShowPassword.setText(txtPassword.getText());
    }

    public void ExitMouseOnAction(MouseEvent mouseEvent) {
        txtPassword.setVisible(true);
        txtShowPassword.setVisible(false);
    }
}
