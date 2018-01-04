package com.malith.JacksonJSONHandler;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONHandler
{
	private ObjectMapper objectMapper;
	
	public JSONHandler()
	{
		this.objectMapper = new ObjectMapper();
	}

	public void print(Object o)
	{
		JSONPrinter.print(this.objectMapper, o);
	}
	
	public Object readObject(String fileNameWithPath, Class<?> className)
	{		
		return new JSONReader().getObjectFromJSONString(objectMapper, className, fileNameWithPath);
	}
	
	public <T> List<T> readList(String fileNameWithPath, Class<?> className)
	{		
		return new JSONReader().getListFromJSONString(objectMapper, className, fileNameWithPath);
	}
	
	public void writeContent(String location, Object content)
	{
		new JSONWritter().writeJSONContentToFile(objectMapper, location, content);
	}	
	

}
