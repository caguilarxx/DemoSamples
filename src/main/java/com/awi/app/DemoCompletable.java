package com.awi.app;

import com.awi.model.Perro;
import com.awi.model.Persona;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.List;

public class DemoCompletable {


  public static void main(String[] args) {

    Perro perro1 = new Perro(1, "perro1");
    Perro perro2 = new Perro(1, "perro2");
    Perro perro3 = new Perro(1, "perro3");
    Perro perro4 = new Perro(4, "perro4");
    Perro perro5 = new Perro(5, "perro5");

    List<Perro> perros1 = new ArrayList<>();
    perros1.add(perro1);
    perros1.add(perro2);

    List<Perro> perros2 = new ArrayList<>();
    perros2.add(perro3);
    perros2.add(perro4);
    perros2.add(perro5);

    Persona persona1 = new Persona(1, "nombres1", "apellidos1", 1, perros1);
    Persona persona2 = new Persona(2, "nombres2", "apellidos2", 2, perros2);

    //////////////////
    List<Persona> personas = new ArrayList<>();
    personas.add(persona1);
    personas.add(persona2);

    Single<List<Perro>> listObservable = Observable.just(personas)
                                                   .flatMapIterable(personas1 -> personas1)
                                                   .flatMap(persona -> Observable.just(persona.getPerros()))
                                                   .flatMapIterable(perros -> perros)
                                                   .toList();


    List<Perro> perros4 = listObservable.blockingGet();

//    List<Perro> perros3 = perros.blockingGet();
//    perros.blockingGet();

    String x = "aAAA";
    System.out.println(x);

  }
}
