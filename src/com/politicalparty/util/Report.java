package com.politicalparty.util;

import java.io.File;

public class Report
{
	private String message;
	private File file;

	public Report(String message, File file)
	{
		
	}

	public String GetMessage()
	{
		return this.message;
	}
	
	public File GetFile()
	{
		return this.file;
	}

}
