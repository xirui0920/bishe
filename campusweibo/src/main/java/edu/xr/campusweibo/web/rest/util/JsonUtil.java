package edu.xr.campusweibo.web.rest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.Charset;


public abstract class JsonUtil {
    protected static ObjectMapper objectMapper = new ObjectMapper();

	public static String toJson(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		try {
			return objectMapper.readValue(json.getBytes(Charset.forName("utf8")), clazz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(byte[] json, Class<T> clazz) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
