package com.awi.appJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class AppStreams {

  public static void main(String[] args) {

//    Stream fibonacci = Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]});
//    Object[] objects = fibonacci.toArray();
//    for (Object o: objects) {
//      LogAwi(o.toString());
//    }

    //===================================== SETUP
    List<Integer> numeros = new ArrayList<>();
    for (int i = 0; i < 10000000; i++) {
      numeros.add((int) Math.round(Math.random() * 100));
    }

    System.out.println("Cantidad de elementos en Listado: " + numeros.size());

    //===================================== STREAM
    for (int i = 0; i < 10; i++) {
      long start = System.currentTimeMillis();
      List<Integer> filteredList = numeros.stream()
                                  .filter(x -> x % 2 == 0)
                                  .sorted()
                                  .collect(Collectors.toList());
      System.out.printf("%d elements computed (STREAM) in %5d msecs with %d threads\n", filteredList.size(), System.currentTimeMillis() - start, Thread.activeCount());
    }

    //===================================== PARALLEL STREAM
    for (int i = 0; i < 10; i++) {
      long start = System.currentTimeMillis();
      List<Integer> filteredList = numeros.parallelStream()
                                          .filter(x -> x % 2 == 0)
                                          .sorted()
                                          .collect(Collectors.toList());
      System.out.printf("%d elements computed (PARALLEL STRREAM) in %5d msecs with %d threads\n", filteredList.size(), System.currentTimeMillis() - start, Thread.activeCount());
    }
  }
}
