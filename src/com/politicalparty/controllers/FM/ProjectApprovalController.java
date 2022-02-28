package com.politicalparty.controllers.FM;

import java.net.URL;
import java.util.ResourceBundle;

import com.politicalparty.Party;
import com.politicalparty.usersPkg.NLC;
import com.politicalparty.util.Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

public class ProjectApprovalController implements Initializable {

    @FXML
    private TableView<Project> projectTableView;

    @FXML
    private TableColumn<Project, String> projectNameCol;

    @FXML
    private TableColumn<Project, String> projectCreatorCol;

    @FXML
    private TableColumn<Project, String> projectExpenditureCol;

    @FXML
    private TextField modifiedExpenditureField;

    @FXML
    private Button updateExpenditureBtn;

    @FXML
    private Button sendApprovalBtn;

    private ObservableList<Project> projects;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        projectNameCol.setCellValueFactory(new PropertyValueFactory<Project, String>("titleProperty"));
        projectCreatorCol.setCellValueFactory(new PropertyValueFactory<Project, String>("projectCreatorProperty"));
        projectExpenditureCol.setCellValueFactory(new PropertyValueFactory<Project, String>("expenditureProperty"));

        projects = getProjects();

        projectTableView.setItems(projects);

        projectTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        projectTableView.setEditable(true);
        projectExpenditureCol.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private ObservableList<Project> getProjects() {
        ObservableList<Project> projects = FXCollections.observableArrayList();

        for (Project p : Party.finaciaManager.getPwpPendingProjects()) {
            projects.add(p);
        }

        return projects;
    }

    @FXML
    void changeExpenditureCellEvent(ActionEvent event)
    {
        Project p = projectTableView.getSelectionModel().getSelectedItem();
//        String x = event.getNewValue().toString();
//        p.setExpenditure(Float.parseFloat((x)));
    }

    @FXML
    void onSendApprovalBtnClick(ActionEvent event) {
        Project project = projectTableView.getSelectionModel().getSelectedItem();
        NLC.addFinancialApprovedProject(project);

        projects.remove(project);
    }

    @FXML
    void onUpdateExpenditureBtnClick(ActionEvent event) {
        float newExpenditure = Float.parseFloat(modifiedExpenditureField.getText());
        int index = projectTableView.getSelectionModel().getSelectedIndex();
        
        projectTableView.getSelectionModel().getSelectedItem().setExpenditure(newExpenditure);
    }
}
