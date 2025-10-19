package Tienda;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

  mensajeBienvenida();
  menu();

  }
  //// //////////////// MENSAJE AL INICIO DE PANTALLA /// ////////////////
  public static void mensajeBienvenida(){
    System.out.println("""
            =======================================================
            ==============TIENDA DE VIDEOJUEGOS RETRO==============
            =======================================================
        
                 ¡Bienvenid@ a nuestra tienda de coleccionistas!
    aquí encontrarás un catálogo con los juegos mejor puntuados de la industria.
Tenemos una amplia variedad de juegos a la venta dirigido a ese público coleccionista.
               (Versión atlas 1.2.3 para Gestión de tiendas online)
     
                          PULSA ENTER PARA INICIAR...""");
    pausa();
  }

  /// //////////////// MENÚ DE OPCIONES PARA EL USUARIO /// ////////////////
  public static void menu(){
    Scanner entrada = new Scanner(System.in);
    boolean bandera = true;
    int opcion;
    while (bandera){
      System.out.println("""
        MENU DE OPCIONES:
        
        1 - Agregar juego al catalogo.
        2 - Mostrar catálogo.
        3 - Buscar/actualizar juego.
        4 - Crear un pedido.
        5 - Mostrar pedidos.
        6.- Finalizar programa.""");
      System.out.println("Ingrese su opción: ");
      opcion = entrada.nextInt();
      switch (validacionMenu(opcion)){
        case 1:
          agregarJuego();
          break;
        case 2:
          mostrarCatalogo();
          break;
        case 3:
          subMenu();
          break;
        case 4:
          crearPedido();
          break;
        case 5:
          mostrarPedidos();
          break;
        case 6:
          bandera = false;
          System.out.println("CERRANDO APLICACIÓN...");
          break;

      };
    }
  }

  /// //////////////// SUBMENU OPCION 3 /// ////////////////
  public static void subMenu(){
    Scanner entrada = new Scanner(System.in);
    int opcion;

    System.out.println("""
        ¿DESEAS BUSCAR O ACTUALIZAR UN JUEGO DEL CATÁLOGO?
        1 - Buscar juego.
        2 - Actualizar juego.
        """);
    opcion = entrada.nextInt();
    switch (validacionSubMenu(opcion)){
      case 1:
        buscarEnCatalogo();
        break;
      case 2:
        actualizarCatalogo();
        break;
    }

  }

  /// //////////////// FUNCIONES PRINCIPALES PARA EL CRUD (Create - Read - Update - Delete) /// ////////////////

  public static void agregarJuego(){} //Create

  public static void mostrarCatalogo(){} //Read

  public static void buscarEnCatalogo(){} //Read

  public static void actualizarCatalogo(){} //Update

  public static void eliminarJuegoCatalogo(){} //Delete

  /// //////////////// FUNCIONES PEDIDOS /// ////////////////
  public static void crearPedido(){}

  public static void mostrarPedidos(){}

  /// //////////////// FUNCIONES AUXILIARES/// ////////////////

  public static void pausa() {
    Scanner entrada = new Scanner(System.in);
    entrada.nextLine();
  }

  /// //////////////// VALIDACIONES /// ////////////////

  public static int validacionMenu(int opcionUsuario){

    if(opcionUsuario <= 0 || opcionUsuario > 6 ){
      System.out.println("Opción inválida.\n");
    }else {
      return opcionUsuario;
    }

  return 0;
  }

  public static int validacionSubMenu(int opcionUsuario){

    if(opcionUsuario <= 0 || opcionUsuario > 2){
      System.out.println("Opción inválida.");
      subMenu();
    }else{
      System.out.println("LA OPCION ES VÁLIDA");
      pausa();
      return opcionUsuario;
    }
    return 0;
  }
}