package mkattner.web.jsoptimizer;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("START");
		ObjectMapper objectMapper = new ObjectMapper();
		String[] dependencies = objectMapper.readValue(new File("dependencies.json"), String[].class);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dependencies.length; i++) {
			sb.append(FileUtils.readFileToString(new File(dependencies[i]), "UTF-8"));
		}

		FileUtils.writeStringToFile(new File("dependencies.min.js"), sb.toString(), "UTF-8");
		System.out.println("END");
	}
}
