package com.malith.JacksonJSONHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONWritter
{	
	public JSONWritter()
	{
		
	}

	private String createFileName()
	{
		String date = new Date().toString().replaceAll(":", ".");
		String fileName = date+".json";
		return fileName;
	}
	
	public void writeJSONContentToFile(ObjectMapper objectMapper, String location, Object content)
	{
		String pathWithName = location+createFileName();
		// Write to file
		try
		{
			objectMapper.writeValue(new FileOutputStream(pathWithName), content);
		}
		catch (JsonGenerationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	}
}
