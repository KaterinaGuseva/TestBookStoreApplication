package configurations;

import utils.ParseJson;

public class TestConfiguration {

    private final String configurationFileName;

    public TestConfiguration(String configurationFileName) {
        this.configurationFileName = configurationFileName;
    }

    public String getTestConfiguration(String jsonKeyName) {
        return ParseJson.parseJson(configurationFileName, jsonKeyName);
    }
}
