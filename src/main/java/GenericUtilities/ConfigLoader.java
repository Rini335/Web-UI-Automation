package GenericUtilities;

import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {
    private Map<String, String> configMap;

    public ConfigLoader(Map<String, String> parameters) {
        configMap = new HashMap<>();
        // Initialize configMap with parameters
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            configMap.put(entry.getKey(), entry.getValue());
        }
    }

    public String getProperty(String key) {
        return configMap.get(key);
    }
}
