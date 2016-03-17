package me.alb_i986.settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author ascotto
 */
public class FileSettingRetriever implements SettingRetriever {

    private static final Logger LOGGER = Logger.getLogger(FileSettingRetriever.class.getName());

    private final String configFileName;
    private Properties properties;

    public FileSettingRetriever(String configFileName) {
        this.configFileName = configFileName;
        reload();
    }

    @Override
    public String retrieve(String key) {
        return properties.getProperty(key);
    }

    public void reload() {
        this.properties = new Properties();
        InputStream resourceAsStream = FileSettingRetriever.class.getResourceAsStream("/" + this.configFileName);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new SettingException("Cannot load properties from the file '" + configFileName + "'", e);
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                LOGGER.warning("Cannot close the file " + configFileName);
            }
        }
    }
}
