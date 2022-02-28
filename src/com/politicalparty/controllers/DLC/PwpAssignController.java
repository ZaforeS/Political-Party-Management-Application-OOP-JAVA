package com.politicalparty.controllers.DLC;

import java.net.URL;
import java.util.ResourceBundle;

import com.politicalparty.Party;
import com.politicalparty.usersPkg.DLC;
import com.politicalparty.usersPkg.GeneralMember;
import com.politicalparty.util.PartyProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PwpAssignController implements Initializable {

    @FXML
    private TableView<PartyProject> pendingProjectTableView;

    @FXML
    private TableColumn<PartyProject, String> projectTitleCol;

    @FXML
    private TableColumn<PartyProject, String> projectExpenditureCol;

    @FXML
    private TableColumn<PartyProject, String> projectLocationCol;

    @FXML
    private ComboBox<GeneralMember> gmSelectorCombo;

    @FXML
    private Button forwardPwpButton;
    
    private ObservableList<PartyProject> projects;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		projectTitleCol.setCellValueFactory(new PropertyValueFactory<>("titleProperty"));
		projectExpenditureCol.setCellValueFactory(new PropertyValueFactory<>("expenditureProperty"));
		projectLocationCol.setCellValueFactory(new PropertyValueFactory<>("projectLocation"));
		
		projects = getProjects();
		
		pendingProjectTableView.setItems(projects);
		
		pendingProjectTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		gmSelectorCombo.setItems(getGeneralMembers());
	}
	
	private ObservableList<PartyProject> getProjects()
	{
		ObservableList<PartyProject> projects = FXCollections.observableArrayList();
		
		for (PartyProject proj : DLC.getPwpToAssign())
		{
			projects.add(proj);
		}
		
		return projects;
	}

	private ObservableList<GeneralMember> getGeneralMembers()
	{
		ObservableList<GeneralMember> members = FXCollections.observableArrayList();
		for (GeneralMember gm : Party.generalMembers)
		{
			members.add(gm);
		}
		
		return members;
	}

    @FXML
    void onForwardPwpButtonClick(ActionEvent event)
    {
    	GeneralMember selectedGm = gmSelectorCombo.getValue();
    	PartyProject projectToAssign = pendingProjectTableView.getSelectionModel().getSelectedItem();    	
    	
    	if (selectedGm.assignProject(projectToAssign))
    	{
    		System.out.println("Project Assigned");
    		projects.remove(projectToAssign);
    	}
    	else
    	{
    		System.out.println("General Member already has a project.");
    	}
    		
    }
}
	