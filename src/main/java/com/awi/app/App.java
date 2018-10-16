package com.awi.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    System.out.println("Hello World!");


    Stream fibonacci = Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]});

    List<Integer> numeros = new ArrayList<>();
    for (int i = 0; i < 10000000; i++) {
      numeros.add((int) Math.round(Math.random() * 100));
    }

    System.out.println(numeros.size());

    for (int i = 0; i < 100; i++) {
      long start = System.currentTimeMillis();
      List<Integer> even = numeros.parallelStream()
                                  .filter(x -> x % 2 == 0)
                                  .sorted()
                                  .collect(Collectors.toList());

      System.out.printf("%d elements computed in %5d msecs with %d threads \n", even.size(), System.currentTimeMillis() - start, Thread.activeCount());

    }
  }
}
