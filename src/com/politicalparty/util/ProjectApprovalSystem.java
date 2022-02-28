package com.politicalparty.util;

import java.util.ArrayList;

import com.politicalparty.Main;
import com.politicalparty.Party;
import com.politicalparty.usersPkg.DLC;
import com.politicalparty.usersPkg.NLC;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProjectApprovalSystem
{
	private Project project;
	
	private SimpleStringProperty projectName, projectLocation, projectExpenditure;
	
	private int approveCount;
	private ArrayList<NLC> nlcSubmittedDecision;
	
	public Project getProject()
	{
		return project;
	}
	
	public ProjectApprovalSystem(Project project) {
		super();
		this.project = project;
		nlcSubmittedDecision = new ArrayList<>();
		
		projectName = new SimpleStringProperty(project.getTitleProperty());
		projectLocation = new SimpleStringProperty(project.getLocation());
		projectExpenditure = new SimpleStringProperty(project.getExpenditureProperty());
	}
	
	public void approveProject(NLC approver, ObservableList<ProjectApprovalSystem> projects)
	{
		if (!nlcSubmittedDecision.contains(approver))
		{
			approveCount++;
			nlcSubmittedDecision.add(approver);
			
			if (nlcSubmittedDecision.size() >= Party.nlcMembers.size())
			{
				if (approveCount >= 0)
				{
					forwardProjectToDlc();
				}
				
				removeProjectFromNlcList();
				for (ProjectApprovalSystem p : projects)
				{
					if (p.project == this.project)
					{
						projects.remove(p);
						break;
					}
				}
			}
		}
		else
		{
			
		}
	}
	
	public void disapproveProject(NLC disapprover, ObservableList<ProjectApprovalSystem> projects)
	{
		if (!nlcSubmittedDecision.contains(disapprover))
		{
			approveCount--;
			nlcSubmittedDecision.add(disapprover);
			
			if (nlcSubmittedDecision.size() >= Party.nlcMembers.size())
			{
				if (approveCount >= 0)
				{
					forwardProjectToDlc();
				}
				
				removeProjectFromNlcList();
				for (ProjectApprovalSystem p : projects)
				{
					if (p.project == this.project)
					{
						projects.remove(p);
						break;
					}
				}
			}
		}
		else
		{
			
		}
	}
	
	public void forwardProjectToDlc()
	{
		DLC.addProjectToAssign(project);
	}
	
	public void removeProjectFromNlcList()
	{
		NLC.removeFinancialApprovedProject(project);
	}

	public String getProjectName()
	{
		return projectName.get();
	}
	
	public String getProjectLocation()
	{
		return projectLocation.get();
	}
	
	public String getProjectExpenditure()
	{
		return projectExpenditure.get();
	}
	
}
