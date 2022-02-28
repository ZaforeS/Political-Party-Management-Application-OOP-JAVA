package com.politicalparty.controllers.NLC;

import java.awt.ScrollPane;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NlcHomeController implements Initializable {

    @FXML
    private Label loginLbl;

    @FXML
    private HBox bodyHbox;

    @FXML
    private Button partyProjectBtn;

    @FXML
    private Button approveProjectBtn;

    @FXML
    private Button proposedCwpBtn;

    @FXML
    private Button approveCwpBtn;

    @FXML
    private Button projectReportBtn;

    @FXML
    private Button donateFundBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private VBox goalContent;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loginLbl.setText("Logged in as: " + Main.activeUser.getName());

        if (!NLC.hasApproveablePwp()) {
            approveProjectBtn.setDisable(true);
        }
    }

    @FXML
    void onPartyProjectBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/NLC Member/CreatePwpScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        goalContent.getChildren().add(projectCreationPane);

        if (NLC.hasApproveablePwp()) {
            try {
                projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/NLC Member/PwpApprovalScene.fxml"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            goalContent.getChildren().add(projectCreationPane);
        }
    }

    @FXML
    void onApproveProjectBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/NLC Member/PwpApprovalScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }
    
    
    @FXML
    void onApproveCwpBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/NLC Member/CwpApprovalScene.fxml"));
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
    void onProjectReportBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/NLC Member/projectReportScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

    @FXML
    void onProposedCwpBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;

        if (goalContent.getChildren().size() > 0) {
            goalContent.getChildren().clear();
        }

        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/NLC Member/ProposedCwpScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        goalContent.getChildren().add(projectCreationPane);
    }

}
