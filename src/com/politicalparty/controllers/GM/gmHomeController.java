package com.politicalparty.controllers.GM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.politicalparty.Main;
import com.politicalparty.usersPkg.GeneralMember;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gmHomeController implements Initializable {

    @FXML
    private Label loginLbl;

    @FXML
    private Label currentProject;

    @FXML
    private Button projectReportBtn;

    @FXML
    private Button createNewCwpBtn;

    @FXML
    private Button donateFundBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private VBox goalContent;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loginLbl.setText("Logged in as: " + Main.activeUser.getName());

        if (((GeneralMember) Main.activeUser).isVacant()) {
            currentProject.setText("Current Project: None");
        } else {
            currentProject.setText("Current Project: " + ((GeneralMember) Main.activeUser).getProjectTitle());
        }
    }

    @FXML
    void onDonateFundBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/fundDonationScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onLogoutBtnClick(ActionEvent event) {
        Main.activeUser.logout();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../../scenes/Login.fxml"));
            Stage stage = ((Stage) ((Node) event.getSource()).getScene().getWindow());
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void onProjectReportBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/General Member/ProjectReportScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onCreateNewCwpBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/General Member/CreateCwpScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

}
