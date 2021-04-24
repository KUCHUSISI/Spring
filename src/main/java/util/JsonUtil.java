package util;

import java.io.IOException;

import org.slf4j.LoggerFactory;

import com.example.controller.ControllerClass;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;

public class JsonUtil 
{
	static Logger logger=(Logger) LoggerFactory.getLogger(ControllerClass.class);	
		public static String getJackson2SerializedObject(Object object, Include inclusion)
		{
		ObjectMapper om = new ObjectMapper();
		om.setSerializationInclusion(inclusion);
		try {
			return om.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error("Can't parse json", e.getMessage());
		} catch (JsonMappingException e) {
			logger.error("Can't parse json", e.getMessage());
		} catch (IOException e) {
			logger.error("Can't parse json", e.getMessage());
		}
		return "";
	}
}
