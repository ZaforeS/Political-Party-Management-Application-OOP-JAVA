package com.politicalparty.util;

import java.io.File;

import com.politicalparty.usersPkg.GeneralMember;
import com.politicalparty.usersPkg.User;
import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public abstract class Project implements Serializable
{
	protected String title, description, nlcFeedback, location;
	public SimpleStringProperty titleProperty, expenditureProperty, projectCreatorProperty;
	protected float expenditure;
	protected File file;
	protected IProjectCreatable projectCreator;
	protected GeneralMember appointee;
	protected Report report;
	
	public Project(String title, String description, String location, float expenditure, File file, IProjectCreatable creator)
	{
		this.title = title;
		this.description = description;
		this.location = location;
		this.expenditure = expenditure;
		this.file = file;
		this.projectCreator = creator;
		
		this.titleProperty = new SimpleStringProperty(title);
		this.expenditureProperty = new SimpleStringProperty(Float.toString(expenditure));
		this.projectCreatorProperty = new SimpleStringProperty(((User)projectCreator).getName());
//		this.projectLocation = new SimpleStringProperty(location);
	}

	public String getNlcFeedback()
	{
		return nlcFeedback;
	}

	public void setNlcFeedback(String nlcFeedback)
	{
		this.nlcFeedback = nlcFeedback;
	}
	
	public String getLocation()
	{
		return this.location;
	}

	public GeneralMember getAppointee()
	{
		return appointee;
	}

	public void setAppointee(GeneralMember appointee)
	{
		this.appointee = appointee;
	}

	public Report getReport()
	{
		return report;
	}

	public void setReport(Report report)
	{
		this.report = report;
	}
	
	public float getExpenditure()
	{
		return this.expenditure;
	}
	
	public void setExpenditure(float expenditure)
	{
		this.expenditure = expenditure;
		this.expenditureProperty.set(Float.toString(expenditure));
	}
	
	public String getTitleProperty()
	{
		return titleProperty.get();
	}
	
	public String getExpenditureProperty()
	{
		return expenditureProperty.get();
	}
	
	public String getProjectCreatorProperty()
	{
		return projectCreatorProperty.get();
	}
	
	public String getProjectLocation()
	{
		return location;
	}
	
}
