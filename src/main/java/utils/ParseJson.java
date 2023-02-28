package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.IOException;

@UtilityClass
public class ParseJson {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String parseJson(String pathJson, String value) {
        JsonNode jsonNode;
        try {
            jsonNode = objectMapper.readTree(new FileReader(pathJson));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonNode.get(value).asText();
    }
}
