package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    public final Properties properties;

    public configReader()
    {

        BufferedReader read;
        String propertyPathFile = "configuration/configuration.properties";

        try{
            read  =new BufferedReader(new FileReader(propertyPathFile));
            properties = new Properties();
            try {
                properties.load((read));
                read.close();
            }
            catch (IOException e){

            }
        }
        catch (FileNotFoundException e)
            {
                throw new RuntimeException(e);
            }

    }

    public String getPlatformName(){
        String platformName = properties.getProperty("platformName");
        if(platformName !=null)
            return platformName;
        else
            throw new RuntimeException("Platform Name is not found");
    }
    public String getAutomationName(){
        String automationname = properties.getProperty("automationName");
        if(automationname !=null)
            return automationname;
        else
            throw new RuntimeException("Automation Name is not found");
    }
    public String getplatformVersion(){
        String platformVersion = properties.getProperty("platformVersion");
        if(platformVersion !=null)
            return platformVersion;
        else
            throw new RuntimeException("Platform Version Name is not found");
    }
    public String getdeviceName(){
        String deviceName = properties.getProperty("deviceName");
        if(deviceName !=null)
            return deviceName;
        else
            throw new RuntimeException("Device Name Name is not found");
    }
    public String getapk(){
        String apk = properties.getProperty("apk");
        if(apk !=null)
            return apk;
        else
            throw new RuntimeException("APK Name is not found");
    }
    public String geturl(){
        String url = properties.getProperty("url");
        if(url !=null)
            return url;
        else
            throw new RuntimeException("URL Name is not found");
    }
    public String getExcepPAth(){
        String excelPath = properties.getProperty("excelPath");
        if(excelPath !=null)
            return excelPath;
        else
            throw new RuntimeException("Platform Name is not found");
    }

}


