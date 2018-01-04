package com.malith.JacksonJSONHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile
{
	private String path;
	private String jsonString;
	
	public ReadFile(String path)
	{		
		this.path = path;
		this.jsonString = "";	
	}
	
	public String getFileContent()
	{
		try
		{
			FileReader fr = new FileReader(path);
			BufferedReader textReader = new BufferedReader(fr);
			List<String> textData = new ArrayList<String>();

			String textLine;

			while ((textLine = textReader.readLine()) != null)
			{
				textData.add(textLine);
			}
			textReader.close();

			// System.out.println("Number of lines in file : "+textData.size());

			jsonString = String.join(" ", textData);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.jsonString;
	}

}
