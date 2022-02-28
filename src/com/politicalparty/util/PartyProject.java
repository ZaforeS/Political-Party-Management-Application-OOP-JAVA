package com.politicalparty.util;

import java.io.File;
import java.io.Serializable;

public class PartyProject extends Project {

	public PartyProject(String title, String description, String location, float expenditure, File file,
			IProjectCreatable creator)
	{
		super(title, description, location, expenditure, file, creator);
	}

}
