package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class BigDataPlayer {


  public static final String PROPS_FILE_NAME = "/data.properties";
  public static final String JSON_FILE_NAME = "/data.json";

  private static Properties loadData() {
    Properties props = new Properties();
    InputStream inputStream = BigDataPlayer.class.getResourceAsStream(PROPS_FILE_NAME);
    try {
      props.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return props;
  }

  public static String getStringData(String propertyName) {
    Properties properties = loadData();
    return properties.getProperty(propertyName);
  }

  public static int[] getIntData(String propertyName) {
    Properties properties = loadData();
    String[] propsString = properties.getProperty(propertyName).split(",");
    int[] inputInts = new int[propsString.length];
    for (int i = 0; i < propsString.length; i++) {
      inputInts[i] = Integer.valueOf(propsString[i]);
    }
    return inputInts;
  }

  public static int[][] getArrayInt(String propertyName) {
    try {
      InputStream inputStream = BigDataPlayer.class.getResourceAsStream(JSON_FILE_NAME);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonData jsonData = objectMapper.readValue(inputStream, JsonData.class);
      return jsonData.getNodeFirst1768();
    } catch (Throwable e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void writeToLogFile1(String text) {
    try {
      Files.write(Paths.get("log1.txt"), text.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeToLogFile2(String text) {
    try {
      Files.write(Paths.get("log2.txt"), text.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void writeToLogFile(String text, String fileName) {
    try {
      Files.write(Paths.get(fileName), text.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
