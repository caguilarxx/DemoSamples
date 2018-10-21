package com.awi.utils;

public class LogUtils {

  public static void LogAwi(Object msg){
    System.out.println(msg.toString());
  }

  public static void LogSeparator(String msg){
    System.out.println("\n=========> " + msg + "<=========\n");
  }
}
