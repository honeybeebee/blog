/* @()JacksonUtils.java
 *
 * (c) COPYRIGHT 2009-2013 Bee INC. All rights reserved.
 * Bee CONFIDENTIAL PROPRIETARY
 * Bee Advanced Technology and Software Operations
 *
 * REVISION HISTORY:
 * Author             Date                   Brief Description
 * -----------------  ----------     ---------------------------------------
 * Linfeng            下午5:17:50                init version
 * 
 */
package com.bee.myApp.blog.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 * CLASS:
 * 封装jackson的工具类
 * 
 * RESPONSIBILITIES:
 * High level list of things that the class does
 * -) 
 * 
 * COLABORATORS:
 * List of descriptions of relationships with other classes, i.e. uses, contains, creates, calls...
 * -) class   relationship
 * -) class   relationship
 * 
 * USAGE:
 * Description of typical usage of class.  Include code samples.
 * 
 * 
 **/
public class JacksonUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtils.class);

	private static ObjectMapper objectMapper = new ObjectMapper();

	static {
		/* 允许json注释 */
		objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		/* 允许使用非双引号属性名字 */
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		/* 允许单引号来包住属性名称和字符串值 */
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		/* 允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符） */
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	}

	private JacksonUtils() {
	}

	public static String objToString(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			LOGGER.error("objToString(Object)", e);
		} catch (JsonMappingException e) {
			LOGGER.error("objToString(Object)", e);
		} catch (IOException e) {
			LOGGER.error("objToString(Object)", e);
		}
		return null;
	}

	/**
	 * 将json string反序列化成对象
	 *
	 * @param json
	 * @param valueType
	 * @return
	 */
	public static <T> T stringToObj(String json, Class<T> valueType) {
		try {
			return objectMapper.readValue(json, valueType);
		} catch (JsonParseException e) {
			LOGGER.error("stringToObj(String, Class<T>)", e);
		} catch (JsonMappingException e) {
			LOGGER.error("stringToObj(String, Class<T>)", e);
		} catch (IOException e) {
			LOGGER.error("stringToObj(String, Class<T>)", e);
		}
		return null;
	}

	/**
	 * 将json array反序列化为对象
	 *
	 * @param json
	 * @param jsonTypeReference
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T stringToObj(String json, TypeReference<T> typeReference) {
		try {
			return (T) objectMapper.readValue(json, typeReference);
		} catch (JsonParseException e) {
			LOGGER.error("stringToObj(String, JsonTypeReference<T>)", e);
		} catch (JsonMappingException e) {
			LOGGER.error("stringToObj(String, JsonTypeReference<T>)", e);
		} catch (IOException e) {
			LOGGER.error("stringToObj(String, JsonTypeReference<T>)", e);
		}
		return null;
	}
}
