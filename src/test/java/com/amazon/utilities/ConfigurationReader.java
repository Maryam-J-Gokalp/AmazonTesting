package com.amazon.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    static Properties prop = new Properties();

    static {

        try{

            FileInputStream file = new FileInputStream("config.properties");
            prop.load(file);
            file.close();

        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Config reader check!!!");
        }
    }


    public static String getProperty(String keyword){

        return prop.getProperty(keyword);
    }
}
