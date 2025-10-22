package Tienda;

import java.util.ArrayList;

public class Pedido {
  private int idPedido;
  private ArrayList<Producto> productosPedido = new ArrayList<>();

  public Pedido(int idPedido, ArrayList<Producto> productosPedido){
    this.idPedido = idPedido;
    this.productosPedido = productosPedido;


  }
}
