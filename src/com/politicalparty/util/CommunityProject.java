package com.politicalparty.util;

import java.io.File;

import com.politicalparty.usersPkg.DLC;

public class CommunityProject extends Project
{
	DLC cwpFilter;

	public DLC getCwpFilter()
	{
		return cwpFilter;
	}

	public void setCwpFilter(DLC cwpFilter)
	{
		this.cwpFilter = cwpFilter;
	}

	public CommunityProject(String title, String description, String location, int expenditure, File file,
			IProjectCreatable creator)
	{
		super(title, description, location, expenditure, file, creator);
	}

}
