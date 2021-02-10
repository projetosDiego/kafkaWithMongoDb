package com.diego.kafkamongodb.util;

import com.diego.kafkamongodb.domain.User;
import com.diego.kafkamongodb.domain.dto.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
	
	public static String objectToJson(UserDTO userDto) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(userDto);
            System.out.println("ResultingJSONstring = " + json);
            return json;
		} catch (JsonProcessingException e) {
            e.printStackTrace();
		}
		return null;
	}
	
	public static User jsonToObject(String json) {
		ObjectMapper mapper = new ObjectMapper();
		User user;
		try {
			user = mapper.readValue(json, User.class);
			return user;
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
