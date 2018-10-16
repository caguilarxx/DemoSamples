package com.awi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {

  private int id;
  private String nombres;
  private String apellidos;
  private int edad;
  private List<Perro> perros;
}
