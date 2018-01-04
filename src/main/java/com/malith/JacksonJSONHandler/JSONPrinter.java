package com.malith.JacksonJSONHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONPrinter
{
	private JSONPrinter()
	{
		
	}
	
	public static void print(ObjectMapper objectMapper, Object o)
	{
		// Use pretty print for printing the output
		String beautifulJson;
		try
		{
			beautifulJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
			System.out.println(beautifulJson);
		}
		catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
