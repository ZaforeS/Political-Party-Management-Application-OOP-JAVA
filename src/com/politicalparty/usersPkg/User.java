package com.politicalparty.usersPkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.politicalparty.Main;
import com.politicalparty.Party;

public abstract class User implements Serializable {
	String name, nid, location, emailAddress, phoneNumber;
	int age;
	
	public User(String name, String nid, String location, String emailAddress, String phoneNumber, int age)
	{
		this.name = name;
		this.nid = nid;
		this.location = location;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
	
	public void logout()
	{
//		// save all the instances
//		File outputFile = new File("./data/user data/NLC Member.bin");
//		ObjectOutputStream outputStream = null;
//		
//		try
//		{
//			outputStream = new ObjectOutputStream(new FileOutputStream(outputFile));
//			
//			for (NLC nlc : Party.nlcMembers)
//			{
//				outputStream.writeObject(nlc);
//			}
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			try
//			{
//				outputStream.close();
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		outputFile = new File("./data/user data/DLC Member.bin");
//		outputStream = null;
//		
//		try
//		{
//			outputStream = new ObjectOutputStream(new FileOutputStream(outputFile));
//			
//			for (DLC dlc : Party.dlcMembers)
//			{
//				outputStream.writeObject(dlc);
//			}
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			try
//			{
//				outputStream.close();
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		outputFile = new File("./data/user data/General Member.bin");
//		outputStream = null;
//		
//		try
//		{
//			outputStream = new ObjectOutputStream(new FileOutputStream(outputFile));
//			
//			for (GeneralMember gm : Party.generalMembers)
//			{
//				outputStream.writeObject(gm);
//			}
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			try
//			{
//				outputStream.close();
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		outputFile = new File("./data/user data/Manager.bin");
//		outputStream = null;
//		
//		try
//		{
//			outputStream = new ObjectOutputStream(new FileOutputStream(outputFile));
//			
//			outputStream.writeObject(Party.manager);
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			try
//			{
//				outputStream.close();
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		outputFile = new File("./data/user data/Financial Manager.bin");
//		outputStream = null;
//		
//		try
//		{
//			outputStream = new ObjectOutputStream(new FileOutputStream(outputFile));
//			
//			outputStream.writeObject(Party.finaciaManager);
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			try
//			{
//				outputStream.close();
//			}
//			catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		Main.activeUser = null;
	}
	
	public String getNid()
	{
		return this.nid;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEmailAddress()
	{
		return this.emailAddress;
	}
}
