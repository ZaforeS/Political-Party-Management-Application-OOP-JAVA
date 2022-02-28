package com.politicalparty.util;

public class Donation
{
	float fund;
	IFundPayable donator;
	
	public Donation(float amount, IFundPayable donator)
	{
		fund = amount;
		this.donator = donator;
	}
	
	public IFundPayable getDonator()
	{
		return this.donator;
	}
	
	public float getFundAmount()
	{
		return this.fund;
	}
	
}
