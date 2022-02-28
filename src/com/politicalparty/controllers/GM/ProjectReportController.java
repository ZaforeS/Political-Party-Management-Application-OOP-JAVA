package com.politicalparty.controllers.GM;

import java.io.File;

import com.politicalparty.Main;
import com.politicalparty.usersPkg.GeneralMember;
import com.politicalparty.util.AlertBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class ProjectReportController {

    @FXML
    private TextArea reportMsgArea;

    @FXML
    private Button addFileBtn;

    @FXML
    private Button projectDetailBtn;

    @FXML
    private Button nlcFeedbackBtn;

    @FXML
    private Button submitBtn;
    
    private File file;

    @FXML
    void onAddFileBtnClick(ActionEvent event)
    {
    	FileChooser fc = new FileChooser();
    	
    	file = fc.showOpenDialog(null);
    }

    @FXML
    void onNlcFeedbackBtnClick(ActionEvent event)
    {
    	String nlcFeedback = ((GeneralMember)Main.activeUser).getReport().GetMessage();
    	String nlcRating = Integer.toString(((GeneralMember)Main.activeUser).getCurrentRating());
    	
    	AlertBox.showMessageBox(nlcFeedback, nlcRating, "Project Report");
    }

    @FXML
    void onProjectDetailBtnClick(ActionEvent event)
    {
    	
    }

    @FXML
    void onSubmitBtnClick(ActionEvent event)
    {
    	((GeneralMember)Main.activeUser).addProjectReport(reportMsgArea.getText(), file);
    }

}
