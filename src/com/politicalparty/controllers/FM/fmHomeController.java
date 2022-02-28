package com.politicalparty.controllers.FM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.politicalparty.Main;
import com.politicalparty.Party;

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

public class fmHomeController implements Initializable {

    @FXML
    private Label loginLbl;
    
    @FXML
    private Label currentFundLbl;
    
    @FXML
    private HBox bodyHBox;
    
    @FXML
    private Button pwpApprovalBtn;
    
    @FXML
    private Button cwpApprovalBtn;
    
    @FXML
    private Button monthlyDonationBtn;
    
    @FXML
    private Button annualFundBtn;
    
    @FXML
    private Button logoutBtn;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        loginLbl.setText("Logged in as: " + Main.activeUser.getName());
        currentFundLbl.setText("Current Fund: Tk 0");
        
        if (Party.finaciaManager.getPwpPendingProjects().size() <= 0) {
            pwpApprovalBtn.setDisable(true);
        }
    }
    
    @FXML
    void onPwpApprovalBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;
        
        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Financial Manager/ProjectApprovalScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if (bodyHBox.getChildren().size() > 1) {
            bodyHBox.getChildren().remove(1);
        }
        
        bodyHBox.getChildren().add(projectCreationPane);
        
        System.out.println(Party.finaciaManager.getPwpPendingProjects().size());
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
    void onAnnualFundBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;
        
        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Financial Manager/UpdateAnualDonationScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if (bodyHBox.getChildren().size() > 1) {
            bodyHBox.getChildren().remove(1);
        }
        
        bodyHBox.getChildren().add(projectCreationPane);
    }
    
    @FXML
    void onCwpApprovalBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;
        
        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Financial Manager/CwpApprovalScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if (bodyHBox.getChildren().size() > 1) {
            bodyHBox.getChildren().remove(1);
        }
        
        bodyHBox.getChildren().add(projectCreationPane);
    }
    
    @FXML
    void onMonthlyDonationBtnClick(ActionEvent event) {
        VBox projectCreationPane = null;
        
        try {
            projectCreationPane = FXMLLoader.load(getClass().getResource("../../scenes/Financial Manager/MonthlyDonationScene.fxml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if (bodyHBox.getChildren().size() > 1) {
            bodyHBox.getChildren().remove(1);
        }
        
        bodyHBox.getChildren().add(projectCreationPane);
    }
    
}
