package com.politicalparty.controllers.NLC;

import java.io.File;

import com.politicalparty.Main;
import com.politicalparty.usersPkg.NLC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class PwpCreateProjectController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField expenditureField;

    @FXML
    private Button addFileField;

    @FXML
    private Button submitForFinancialApprovalBtn;
    
    private File attachment = null;
    
    @FXML
    void onAddFileFieldClick(ActionEvent event)
    {
    	FileChooser fc = new FileChooser();
    	attachment = fc.showOpenDialog(null);
    }

    @FXML
    void onSubmitForFinancialApprovalBtnClick(ActionEvent event)
    {
    	String title, description, location;
    	int expenditure;
    	
    	title = titleField.getText();
    	description = descField.getText();
    	location = locationField.getText();
    	expenditure = Integer.parseInt(expenditureField.getText());
    	
    	((NLC)Main.activeUser).createProject(title, description, expenditure, attachment, location);
    }

}
