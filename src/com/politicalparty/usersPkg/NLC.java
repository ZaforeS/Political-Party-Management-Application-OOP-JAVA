package com.politicalparty.usersPkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.politicalparty.Party;
import com.politicalparty.util.CommunityProject;
import com.politicalparty.util.Donation;
import com.politicalparty.util.IFundPayable;
import com.politicalparty.util.IProjectCreatable;
import com.politicalparty.util.PP_ObjectOutputStream;
import com.politicalparty.util.PartyProject;
import com.politicalparty.util.Project;
import com.politicalparty.util.ProjectApprovalSystem;
import com.politicalparty.util.Report;

public class NLC extends User implements IProjectCreatable, IFundPayable
{
	private static ArrayList<ProjectApprovalSystem> financialApprovedPwp = new ArrayList<>();
	private static ArrayList<ProjectApprovalSystem> financialApprovedCwp = new ArrayList<>();
	private ArrayList<Project> requestedProjectReport;

	public NLC(String name, String nid, String location, String emailAddress, String phoneNumber, int age)
	{
		super(name, nid, location, emailAddress, phoneNumber, age);
		
		requestedProjectReport = new ArrayList<>();
	}
	
	public static boolean hasApproveablePwp()
	{
		return !financialApprovedPwp.isEmpty();
	}
	
	public static boolean hasApproveableCwp()
	{
		return !financialApprovedCwp.isEmpty();
	}

	public static ArrayList<ProjectApprovalSystem> getFinancialApprovedPwp()
	{
		return financialApprovedPwp;
	}
	
	@Override
	public void createProject(String projectTitle, String projectDescription, int expenditure, File attachment,
			String location)
	{
		PartyProject project = new PartyProject(projectTitle, projectDescription, location, expenditure, attachment, this);
		
		Party.finaciaManager.addProjectForFinancialApproval(project);
	}
	
	public static void addFinancialApprovedProject(Project project)
	{
		if (project instanceof PartyProject)
		{
			financialApprovedPwp.add(new ProjectApprovalSystem(project));
		}
		else
		{
			financialApprovedCwp.add(new ProjectApprovalSystem(project));
		}
	}
	
	public static void removeFinancialApprovedProject(Project project)
	{
		if (project instanceof PartyProject)
		{
			for (ProjectApprovalSystem p : financialApprovedPwp)
			{
				if (p.getProject() == project)
				{
					financialApprovedPwp.remove(p);
					break;
				}
			}
		}
		else
		{
			for (ProjectApprovalSystem p : financialApprovedCwp)
			{
				if (p.getProject() == project)
				{
					financialApprovedCwp.remove(p);
					break;
				}
			}
		}
	}
	
	public void markProjectCompletion(Project project)
	{
		project.getAppointee().projectCompleted();
		Party.removeOnGoingProject(project);
	}
	
	public void requestReport(Project project)
	{
		Party.manager.addReportRequest(project, this);
	}
	
	public void addRequestedProjectReport(Project project)
	{
		requestedProjectReport.add(project);
	}
	
	public void giveProjectFeedback(Project project, String message, int rating)
	{
		project.setReport(new Report(message, null));
		Party.manager.addNlcFeedback(project, rating);
	}

	@Override
	public void donateFund(float amount)
	{
		Party.finaciaManager.addFund(new Donation(amount, this));		
	}
	
}


























