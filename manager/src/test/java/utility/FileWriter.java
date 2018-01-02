package utility;

import java.io.*;
import java.util.Properties;

public class FileWriter {
    /**
     * properties path
     */
    private static String PropertiesDir = new File(".").getAbsolutePath();
    /**
     * Singleton properties object
     */
    private static Properties props = null;

    /**
     * Slaway return the same instance (singleton)
     *
     * @return
     */
    public static Properties getProps() {

        if (props == null) {
            props = loadProperties();
        }
        return props;
    }

    /**
     * Fill data from file into properties object
     *
     * @return
     */
    private static Properties loadProperties() {

        InputStream input = null;

        try {
            boolean exist = new File(PropertiesDir + "\\src\\test\\resources\\testProperties.properties").exists();
            if (exist) {
                input = new FileInputStream(PropertiesDir + "\\src\\test\\resources\\testProperties.properties");
            }
            // load a properties file
            if (FileWriter.props == null) {
                FileWriter.props = new Properties();
            }
            FileWriter.props.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }

    /**
     * Persist data object to file
     */
    public static void saveProps() {

        OutputStream output = null;

        try {
            output = new FileOutputStream(PropertiesDir + "\\src\\test\\Resources\\testProperties.properties");
            // save properties to project root folder

            FileWriter.props.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
