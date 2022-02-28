package com.politicalparty.util;

import java.io.File;

public interface IProjectCreatable
{
	public void createProject(String projectTitle, String projectDescription, int expenditure,
			File attachment, String location);
}
