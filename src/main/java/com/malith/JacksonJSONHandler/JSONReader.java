package com.malith.JacksonJSONHandler;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReader
{	
	public JSONReader()
	{	

	}

	public <T> List<T> getListFromJSONString(ObjectMapper objectMapper, Class<?> className, String pathWithName)
	{
		JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, className);
		
		String jsonString = new ReadFile(pathWithName).getFileContent();
		List <T> list;
		try
		{
			//list = Arrays.asList(objectMapper.readValue(jsonString, className));
			//list = objectMapper.readValue(jsonString, new TypeReference<List<Movie>>(){});
			list = objectMapper.readValue(jsonString, type);

			return list;
		}
		catch (JsonParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public Object getObjectFromJSONString(ObjectMapper objectMapper, Class<?> className, String pathWithName)
	{
		String jsonString = new ReadFile(pathWithName).getFileContent();
		Object object;
		try
		{
			//list = Arrays.asList(objectMapper.readValue(jsonString, className));
			//list = objectMapper.readValue(jsonString, new TypeReference<List<Movie>>(){});
			object = objectMapper.readValue(jsonString, className);

			return object;
		}
		catch (JsonParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
