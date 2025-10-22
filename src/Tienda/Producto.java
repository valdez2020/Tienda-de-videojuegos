package Tienda;

import java.awt.desktop.AboutEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
  private static int idGenerado = 1;
  private int id;
  private String nombre;
  private double precio;
  private int stock;

  public Producto(String nombre, Double precio, int stock){
    this.nombre = nombre;
    this.precio = precio;
    this. stock = stock;
    this.id = idGenerado++;
  }

  /// ////////// GETTERS ////////////
  public int mostrarID(){
    return id;
  }
  public String mostrarNombre() {
    return nombre;
  }
  public double mostrarPrecio(){
    return precio;
  }
  public int mostrarStock(){
    return stock;
  }

  /// ////////// SETTERS ////////////
  public void modificarNombre(String nuevoNombre){
    if(!nuevoNombre.isEmpty() && !nuevoNombre.equals(nombre)){
      this.nombre = nuevoNombre;
    }else {
      System.out.println("El nombre ingresado es inválido o ya existe...");
    }

    }

  public void modificarPrecio(double nuevoPrecio){
    if (nuevoPrecio > 0){
      this.precio = nuevoPrecio;
    }else{
      System.out.println("El valor ingresado es inválido...");
    }
  }
  public void modificarStock(int nuevoStock){
    if (nuevoStock > 0){
      this.stock = nuevoStock;
    }else{
      System.out.println("El stock ingresado es inválido");
    }
  }

}

