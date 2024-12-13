package util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/*
 *  This test class consists helper methods
 *
 *  @author: Swarnaprabha Ghosh
 * */

public class Helper {

    private String testDataPath;

    public String readFileAsString(String path)  {


        try {
            return FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\0";
    }

    public String readData(String property) {
        try {
            FileReader fileReader = new FileReader("src/test/resources/configuration.properties");
            Properties properties = new Properties();
            properties.load(fileReader);
            testDataPath = properties.getProperty(property);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return testDataPath;
    }

}