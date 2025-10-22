package Tienda;

import java.awt.desktop.AboutEvent;
import java.util.ArrayList;

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
  public void modificarNombre(){

    String nuevoNombre;

  }
  public void modificarPrecio(){

  }
  public void modificarStock(){

  }

}

