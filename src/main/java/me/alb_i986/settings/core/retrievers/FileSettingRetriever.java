package me.alb_i986.settings.core.retrievers;

import me.alb_i986.settings.core.SettingException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author ascotto
 */
public class FileSettingRetriever implements SettingRetriever {

    public static final String DEFAULT_CONFIG_FILENAME = "config.properties";
    public static final String CONFIG_FILENAME_KEY = "config.filename";

    private static final Logger LOGGER = Logger.getLogger(FileSettingRetriever.class.getName());

    private final String configFileName;
    private Properties properties;

    /**
     * The file name can be specified by setting the system property <code>{@value CONFIG_FILENAME_KEY}</code>, e.g.
     * <pre>-D{@value CONFIG_FILENAME_KEY}=myconfigfile.txt</pre>
     * In this example, {@code myconfigfile.txt} is supposed to be on the classpath.
     * <p>
     * By default, the filename is <code>{@value DEFAULT_CONFIG_FILENAME}</code>.
     */
    public FileSettingRetriever() {
        this(System.getProperty(CONFIG_FILENAME_KEY, DEFAULT_CONFIG_FILENAME));
    }

    public FileSettingRetriever(String configFileName) {
        this.configFileName = configFileName;
        reload();
    }

    @Override
    public String retrieve(String key) {
        return properties.getProperty(key);
    }

    public void reload() {
        Properties tmpProperties = new Properties();
        InputStream resource = FileSettingRetriever.class.getResourceAsStream("/" + configFileName);
        if (resource == null) {
            throw new SettingException("Cannot load properties from '" + configFileName +
                    "'. Please check that the file exists.");
        }

        try {
            tmpProperties.load(resource);
            properties = tmpProperties;
        } catch (IOException e) {
            throw new SettingException("Cannot load properties from the file '" + configFileName + "'", e);
        } finally {
            try {
                resource.close();
            } catch (IOException e) {
                LOGGER.warning("Cannot close the file " + configFileName);
            }
        }
    }
}
