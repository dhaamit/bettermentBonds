//Author - @Amit Dharmale
package betterment.bonds.org.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentUtil {
    public String URL;
    public void setURL(final String url) throws IOException {
        String propertiesFile = "environment.properties";
        try (InputStream input = EnvironmentUtil.class.getClassLoader().getResourceAsStream(propertiesFile)) {

            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Error: Unable to find " + propertiesFile);
                return;
            }

            // Load a properties file from class path
            prop.load(input);

            // Get the property value
            this.URL = prop.getProperty("env.url")+url;
        }
    }
    public String getURL() {
        return this.URL;
    }
}
