package com.politicalparty;

import java.util.ArrayList;

import com.politicalparty.usersPkg.*;
import com.politicalparty.util.CommunityProject;
import com.politicalparty.util.PartyProject;
import com.politicalparty.util.Project;

public class Party
{
	public static ArrayList<NLC> nlcMembers = new ArrayList<>();
	public static ArrayList<DLC> dlcMembers = new ArrayList<>();
	public static ArrayList<GeneralMember> generalMembers = new ArrayList<>();
	public static Manager manager;
	public static FinancialManager finaciaManager;
	
	/*
	 * To Be Implemented...
	 * 
	 * public static Election dlcPromotionElection;
	 * public static Election gmPromotionElection;
	 * 
	 */
	
	private static ArrayList<PartyProject> onGoingPwp = new ArrayList<>();
	private static ArrayList<CommunityProject> onGoingCwp = new ArrayList<>();
	 
	public static void addOnGoingProject (Project project)
	{
		if (project instanceof PartyProject)
		{
			onGoingPwp.add((PartyProject)project);
		}
		else
		{
			onGoingCwp.add((CommunityProject)project);
		}
	}
	
	public static void removeOnGoingProject (Project project)
	{
		if (project instanceof PartyProject)
		{
			onGoingPwp.remove((PartyProject)project);
		}
		else
		{
			onGoingCwp.remove((CommunityProject)project);
		}
	}
	
}
