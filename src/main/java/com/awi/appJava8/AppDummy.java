package com.awi.appJava8;

import java.util.stream.Stream;

/**
 * Hello world!
 */
public class AppDummy {

  public static void main(String[] args) {

    String subBin = "51";
    String[] bins = {"50","51","52","53","55","59"};
    System.out.println(bins[0]);


    if (Stream.of(bins).anyMatch(bin -> {
      System.out.println(bin + " == " + subBin);

      return bin.equals(subBin);
    })) {
      System.out.println("if");
    } else {
      System.out.println("else");

    }

  }
}
