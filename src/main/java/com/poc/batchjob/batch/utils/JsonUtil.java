package com.poc.batchjob.batch.utils;

import com.google.gson.Gson;

public class JsonUtil {
	
	private static final Gson gson = new Gson();

	private JsonUtil() {

	}

	/**This method convert the object into json.
	 * 
	 * @param objectBody
	 * @return
	 */
	public static String convertToJson(Object objectBody) {
		return gson.toJson(objectBody);
	}
	
	/**This method convert the object into json.
	 * 
	 * @param objectBody
	 * @return
	 */
	public static <T> T convertToObject(String jsonStr, Class<T> targerClass) {
		return gson.fromJson(jsonStr, targerClass);
	}
	
}
