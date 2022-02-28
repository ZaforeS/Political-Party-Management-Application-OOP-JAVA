package com.politicalparty.usersPkg;

import java.util.ArrayList;

import com.politicalparty.util.CommunityProject;
import com.politicalparty.util.Donation;
import com.politicalparty.util.IFundPayable;
import com.politicalparty.util.PartyProject;
import com.politicalparty.util.Project;

public class FinancialManager extends User
{
	private ArrayList<PartyProject> financialApprovalPendingPwp;
	private ArrayList<CommunityProject> financialApprovalPendingCwp;
	
	private ArrayList<Donation> newDonations;
	private ArrayList<Donation> processedDonations;
	private ArrayList<Float> annualDonations;
	private float partyFund;

	public FinancialManager(String name, String nid, String location, String emailAddress, String phoneNumber,
			int age)
	{
		super(name, nid, location, emailAddress, phoneNumber, age);
		
		financialApprovalPendingPwp = new ArrayList<>();
		financialApprovalPendingCwp = new ArrayList<>();
		newDonations = new ArrayList<>();
		processedDonations = new ArrayList<>();
		annualDonations = new ArrayList<>();
	}
	
	public void addProjectForFinancialApproval(Project project)
	{
		if (project instanceof PartyProject)
			financialApprovalPendingPwp.add((PartyProject)project);
		else
			financialApprovalPendingCwp.add((CommunityProject)project);
	}
	
	public void modifyProjectExpenditure(Project project, float newExpenditure)
	{
		project.setExpenditure(newExpenditure);
	}
	
	public void approveProject(Project project)
	{
		NLC.addFinancialApprovedProject(project);
	}
	
	public void addFund(Donation dontation)
	{
		newDonations.add(dontation);
	}
	
	public void processDonations()
	{
		for (Donation donation : newDonations)
		{
			processedDonations.add(donation);
			sendDonationNotice(donation.getDonator());
			newDonations.remove(donation);
		}
	}
	
	public void sendDonationNotice(IFundPayable payer)
	{
		System.out.println("Donation approval notice sending to " + ((User)payer).getName() + " at " + ((User)payer).getEmailAddress());
	}

	public void updateAnnualFund()
	{
		for (Donation donation : processedDonations)
		{
			annualDonations.add(donation.getFundAmount());
			partyFund += donation.getFundAmount();
			processedDonations.remove(donation);
		}
	}
	
	public ArrayList<PartyProject> getPwpPendingProjects()
	{
		return this.financialApprovalPendingPwp;
	}

}























