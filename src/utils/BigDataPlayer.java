package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class BigDataPlayer {


  public static final String FILE_NAME = "/data.properties";

  public static int[] getIntData(String propertyName) {
    Properties props = new Properties();
    InputStream inputStream = BigDataPlayer.class.getResourceAsStream(FILE_NAME);
    try {
      props.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    String[] propsString = props.getProperty(propertyName).split(",");
    int[] inputInts = new int[propsString.length];
    for (int i = 0; i < propsString.length; i++) {
      inputInts[i] = Integer.valueOf(propsString[i]);
    }
    return inputInts;
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
