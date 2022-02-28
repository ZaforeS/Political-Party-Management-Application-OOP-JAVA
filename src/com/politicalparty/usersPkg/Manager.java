package com.politicalparty.usersPkg;

import java.util.Hashtable;

import com.politicalparty.util.Project;
import com.politicalparty.util.Report;

public class Manager extends User
{
	private Hashtable<Project, Report> reportsRecievedFromGeneralMembers;
	private Hashtable<Project, NLC> reportRequest;
	
	private Hashtable<Project, Integer> nlcFeedbackForGeneralManager;

	public Manager(String name, String nid, String location, String emailAddress, String phoneNumber, int age)
	{
		super(name, nid, location, emailAddress, phoneNumber, age);
		// TODO Auto-generated constructor stub
		reportsRecievedFromGeneralMembers = new Hashtable<>();
		reportRequest = new Hashtable<>();
		nlcFeedbackForGeneralManager = new Hashtable<>();
	}
	
	public void addReportRequest(Project project, NLC nlc)
	{
		reportRequest.putIfAbsent(project, nlc);
	}
	
	public void sendReportRequestToGM(GeneralMember gm)
	{
		gm.requestReport();
	}
	
	public void addProjectImplementationReport(Project project, Report report)
	{
		reportsRecievedFromGeneralMembers.putIfAbsent(project, report);
	}
	
	public void forwardReportToNlc(Project project)
	{
		project.setReport(reportsRecievedFromGeneralMembers.get(project));
		reportRequest.get(project).addRequestedProjectReport(project);
	}
	
	public void processReceivedReports()
	{
		nlcFeedbackForGeneralManager.forEach((proj, rate) -> proj.getAppointee().setCurrentProjectRating(rate));
	}
	
	public void addNlcFeedback(Project project, int rating)
	{
		nlcFeedbackForGeneralManager.putIfAbsent(project, rating);
	}

}
