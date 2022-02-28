package com.politicalparty.controllers.Manager;

import com.politicalparty.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class managerHomeController implements Initializable{

    @FXML
    private Label loginLbl;

    @FXML
    private Label jobWindowStatusLbl;

    @FXML
    private HBox bodyHbox;

    @FXML
    private Button requestProjectReportBtn;

    @FXML
    private Button forwardReportBtn;

    @FXML
    private Button forwardNlcFeedback;

    @FXML
    private Button toggleJobWindowBtn;

    @FXML
    private Button viewJobApplicationBtn;

    @FXML
    private Button hireApplicant;

    @FXML
    private Button logoutBtn;

    @FXML
    private VBox goalContent;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginLbl.setText("Logged in as: " + Main.activeUser.getName());
    }

    @FXML
    void onForwardNlcFeedbackClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Manager/feedbackForwardScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onForwardReportBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Manager/reportForwardScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onHireApplicantClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Manager/hireApplicantScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onRequestProjectReportBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Manager/reportRequestScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onToggleJobWindowBtnClick(ActionEvent event) {
        Main.isJobWindowOpen = !Main.isJobWindowOpen;
        
        if (Main.isJobWindowOpen)
            jobWindowStatusLbl.setText("Job Window Status: Open");
        else
            jobWindowStatusLbl.setText("Job Window Status: Close");
    }

    @FXML
    void onViewJobApplicationBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Manager/jobApplicantScene.fxml"));
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

}
