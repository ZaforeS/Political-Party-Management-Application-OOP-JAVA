package com.politicalparty.util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class PP_ObjectOutputStream extends ObjectOutputStream {

	public PP_ObjectOutputStream(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void writeStreamHeader()
	{
		
	}

}
