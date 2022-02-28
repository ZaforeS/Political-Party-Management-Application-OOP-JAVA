package com.politicalparty.usersPkg;

import java.util.ArrayList;

import com.politicalparty.Party;
import com.politicalparty.util.CommunityProject;
import com.politicalparty.util.Donation;
import com.politicalparty.util.IFundPayable;
import com.politicalparty.util.PartyProject;
import com.politicalparty.util.Project;

public class DLC extends User implements IFundPayable
{
	int overallRating, deliveredCwpCounter;
	private static ArrayList<CommunityProject> dlcApprovalPendingCwpFromGm;
	private static ArrayList<PartyProject> pwpToAssign = new ArrayList<>();
	private static ArrayList<CommunityProject> cwpToAssign;
	
	public static ArrayList<PartyProject> getPwpToAssign()
	{
		return pwpToAssign;
	}

	public DLC(String name, String nid, String location, String emailAddress, String phoneNumber, int age)
	{
		super(name, nid, location, emailAddress, phoneNumber, age);
	}
	
	public static void addProjectToAssign(Project project)
	{
		if (project instanceof PartyProject)
		{
			pwpToAssign.add((PartyProject)project);
		}
		else
		{
			cwpToAssign.add((CommunityProject)project);
		}
	}
	
	public void assignProject(Project project, GeneralMember gm)
	{
		gm.assignProject(project);
		project.setAppointee(gm);
		Party.addOnGoingProject(project);
	}
	
	@Override
	public void donateFund(float amount)
	{
		Party.finaciaManager.addFund(new Donation(amount, this));		
	}

}
