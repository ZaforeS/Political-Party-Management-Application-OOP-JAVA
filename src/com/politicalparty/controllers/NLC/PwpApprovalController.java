package com.politicalparty.controllers.NLC;

import java.net.URL;
import java.util.ResourceBundle;

import com.politicalparty.Main;
import com.politicalparty.usersPkg.DLC;
import com.politicalparty.usersPkg.NLC;
import com.politicalparty.util.ProjectApprovalSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class PwpApprovalController implements Initializable {

    @FXML
    private TableView<ProjectApprovalSystem> approvalPendingPwpTableView;
    
    @FXML
    private TableColumn<ProjectApprovalSystem, String> projectNameCol;

    @FXML
    private TableColumn<ProjectApprovalSystem, String> expenditureCol;

    @FXML
    private TableColumn<ProjectApprovalSystem, String> locationCol;

    @FXML
    private RadioButton approveRadio;

    @FXML
    private RadioButton disapproveRadio;
    
    @FXML
    private ToggleGroup appDisappToggleGroup;

    @FXML
    private Button submitBtn;
    
    private ObservableList<ProjectApprovalSystem> projects;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		projectNameCol.setCellValueFactory(new PropertyValueFactory<>("projectName"));
		expenditureCol.setCellValueFactory(new PropertyValueFactory<>("projectExpenditure"));
		locationCol.setCellValueFactory(new PropertyValueFactory<>("projectLocation"));
		
		projects = getProjects();
		
		approvalPendingPwpTableView.setItems(projects);
		
		appDisappToggleGroup = new ToggleGroup();
		approveRadio.setToggleGroup(appDisappToggleGroup);
		disapproveRadio.setToggleGroup(appDisappToggleGroup);
	}
	
	private ObservableList<ProjectApprovalSystem> getProjects()
	{
		ObservableList<ProjectApprovalSystem> projects = FXCollections.observableArrayList();
		
		for (ProjectApprovalSystem project : NLC.getFinancialApprovedPwp())
		{
			projects.add(project);
		}
		
		return projects;
	}

    @FXML
    void onSubmitBtnClick(ActionEvent event)
    {
    	if (approveRadio.isSelected())
    	{
    		approvalPendingPwpTableView.getSelectionModel().getSelectedItem().approveProject((NLC)Main.activeUser, projects);
    	}
    	else
    	{
    		approvalPendingPwpTableView.getSelectionModel().getSelectedItem().disapproveProject((NLC)Main.activeUser, projects);
    	}
    }

}
