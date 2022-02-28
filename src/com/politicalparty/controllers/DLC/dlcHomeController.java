package com.politicalparty.controllers.DLC;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.politicalparty.Main;
import com.politicalparty.usersPkg.NLC;

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

public class dlcHomeController implements Initializable {

    @FXML
    private Label loginLbl;

    @FXML
    private HBox bodyHbox;

    @FXML
    private Button assignPwpBtn;

    @FXML
    private Button assignCwpBtn;

    @FXML
    private Button proposedCwpBtn;

    @FXML
    private Button donateFundBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private VBox goalContent;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        loginLbl.setText("Logged in as: " + Main.activeUser.getName());
    }

    @FXML
    void onassignPwpBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/DLC Member/pwpProjectAssignScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onAssignCwpBtnClick(ActionEvent event)
    {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/DLC Member/cwpProjectAssignScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onDonateFundBtnClick(ActionEvent event)
    {
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
    void onProposedCwpBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/DLC Member/CwpApprovalScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

}
