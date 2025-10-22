package Tienda;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import javax.sound.sampled.Port;

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
    ArrayList<Producto> catalogo = generarCatalogo();
    Scanner entrada = new Scanner(System.in);
    boolean bandera = true;

    int opcion;

    while (bandera){
      System.out.println("""
        MENU DE OPCIONES:
        
        1 - Agregar juego al catalogo.
        2 - Mostrar catálogo.
        3 - Buscar/actualizar juego.
        4 - Eliminar juego del catálogo.
        5 - Crear un pedido.
        6 - Mostrar pedidos.
        7.- Finalizar programa.
""");

      System.out.println("Ingrese su opción: ");
      opcion = entrada.nextInt();

      switch (opcion){
        case 1:
          agregarJuego(catalogo);
          break;
        case 2:
          mostrarCatalogo(catalogo);
          break;
        case 3:
          subMenu(catalogo);
          break;
        case 4:
          eliminarJuegoCatalogo(catalogo);
          break;
        case 5:
          crearPedido();
          break;
        case 6:
          mostrarPedidos();
          break;
        case 7:
          bandera = false;
          System.out.println("CERRANDO APLICACIÓN...");
          break;
        default:
          System.out.println("Opción inválida.\n");
          menu();
          break;

      };
    }
  }

  /// //////////////// SUBMENU OPCION 3 /// ////////////////
  public static void subMenu(ArrayList<Producto> catalogo){
    Scanner entrada = new Scanner(System.in);
    int opcion;

    System.out.println("""
        ¿DESEAS BUSCAR O ACTUALIZAR UN JUEGO DEL CATÁLOGO?
        1 - Buscar juego.
        2 - Actualizar juego.
        3 - Volver al menú.
        """);
    opcion = entrada.nextInt();
    switch (opcion){
      case 1:
        buscarEnCatalogo(catalogo);
        break;
      case 2:
        actualizarCatalogo(catalogo);
        break;
      case 3:
        menu();
        break;
      default:
        System.out.println("Opción inválida.");
        subMenu(catalogo);
        break;
    }

  }

  /// //////////////// FUNCIONES PRINCIPALES PARA EL CRUD (Create - Read - Update - Delete) /// ////////////////

  public static void agregarJuego(ArrayList<Producto> catalogo){
    Scanner entrada = new Scanner(System.in);
    String nuevoIngreso;
    double precioNuevoIngreso;
    int stockNuevoIngreso;

    System.out.println("""
        =============================================
                       NUEVOS INGRESOS
        =============================================
                      DATOS NECESARIOS
                  NOMBRE | PRECIO | STOCK\n""");

        System.out.println("Nombre del juego: ");
        nuevoIngreso = entrada.nextLine();

        System.out.println("Precio: ");
        precioNuevoIngreso = entrada.nextDouble();

        System.out.println("Stock: ");
        stockNuevoIngreso = entrada.nextInt();

        if(!nuevoIngreso.isEmpty() && precioNuevoIngreso > 0 && stockNuevoIngreso > 0){

          String textoFormateado;
          System.out.println(nuevoIngreso);

          textoFormateado = formatearNombres(nuevoIngreso);

          System.out.println(textoFormateado);

          catalogo.add(new Producto(textoFormateado, precioNuevoIngreso, stockNuevoIngreso));
        }else{
          System.out.println("Se han ingresado datos inválidos. Por favor, intente nuevamente...");
          pausa();
          agregarJuego(catalogo);
        }


  } //Create

  public static void mostrarCatalogo(ArrayList<Producto> catalogo){

    System.out.println("""
        =============================================
                       CATÁLOGO DE JUEGOS
        =============================================""");

    for (Producto juego : catalogo){
      System.out.println("ID: " + juego.mostrarID() + " - " + juego.mostrarNombre());
    }

    System.out.print("\nPulse ENTER para continuar...");
    pausa();
  } //Read

  public static void buscarEnCatalogo(ArrayList<Producto> catalogo){
Scanner entrada = new Scanner(System.in);
String busqueda;
ArrayList<Producto> coincidencias = new ArrayList<>();

    System.out.println("""
        =============================================
                       BUSCADOR DE JUEGOS
        =============================================""");

    System.out.println("Ingrese nombre de juego para buscar en el catálogo: ");
    System.out.println("Nombre: ");
    busqueda = entrada.nextLine();

    if (!busqueda.isEmpty()){

      String busquedaFormateada = formatearNombres(busqueda);

      for (Producto juego : catalogo){

        if (juego.mostrarNombre().contains(busquedaFormateada)){
          coincidencias.add(juego);
        }
      }
      mostrarCoincidencias(coincidencias);
      System.out.print("\nPulse ENTER para continuar...");
      pausa();
      subMenu(catalogo);
    }

  } //Read

  public static void actualizarCatalogo(ArrayList<Producto> catalogo){} //Update

  public static void eliminarJuegoCatalogo(ArrayList<Producto> catalogo){} //Delete


  /// //////////////// FUNCIONES PEDIDOS /// ////////////////
  public static void crearPedido(){}

  public static void mostrarPedidos(){}


  /// //////////////// FUNCIONES AUXILIARES/// ////////////////

  public static void pausa() {
    Scanner entrada = new Scanner(System.in);
    entrada.nextLine();
  }

  public static String formatearNombres(String nombre){

    String nombreFormateado = nombre.trim().toLowerCase().replaceAll("\\s+"," ");

    return nombreFormateado;
  }

  public static ArrayList<Producto> generarCatalogo(){
    ArrayList<Producto> catalogo = new ArrayList<>();

    catalogo.add(new Producto("super mario odyssey", 35000.00, 12));
    catalogo.add(new Producto("super mario galaxy", 23123.12, 21));
    catalogo.add(new Producto("super mario world", 21000.00, 18));
    catalogo.add(new Producto("super mario 64", 24000.50, 12));
    catalogo.add(new Producto("super mario sunshine", 26500.00, 10));
    catalogo.add(new Producto("tetris effect", 18000.00, 20));
    catalogo.add(new Producto("call of duty: modern warfare", 42000.00, 8));
    catalogo.add(new Producto("call of duty modern warfare 2", 45000.00, 10));
    catalogo.add(new Producto("call of duty modern warfare 3", 47000.00, 9));
    catalogo.add(new Producto("call of duty black ops", 40000.00, 11));
    catalogo.add(new Producto("call of duty black ops ii", 41000.00, 13));
    catalogo.add(new Producto("pokémon scarlet", 39000.00, 10));
    catalogo.add(new Producto("pokemon rojo", 18000.00, 15));
    catalogo.add(new Producto("pokemon azul", 18000.00, 15));
    catalogo.add(new Producto("pokemon amarillo", 19000.00, 12));
    catalogo.add(new Producto("pokemon oro", 20000.00, 10));
    catalogo.add(new Producto("pokemon plata", 20000.00, 10));
    catalogo.add(new Producto("pokemon rubí", 22000.00, 14));
    catalogo.add(new Producto("pokemon zafiro", 22000.00, 14));
    catalogo.add(new Producto("gta v", 25000.00, 15));
    catalogo.add(new Producto("gta san andrea", 250230.00, 15));
    catalogo.add(new Producto("gta iv", 21000.00, 10));
    catalogo.add(new Producto("fifa 23", 2800.00, 20));
    catalogo.add(new Producto("fifa 14", 34500.00, 20));
    catalogo.add(new Producto("fifa 03", 76000.00, 60));
    catalogo.add(new Producto("fifa 25", 97400.00, 50));
    catalogo.add(new Producto("minecraft", 15000.00, 25));
    catalogo.add(new Producto("the sims 4", 22000.00, 18));
    catalogo.add(new Producto("lego star wars: the complete saga", 26000.00, 14));
    catalogo.add(new Producto("final fantasy xvi", 47000.00, 9));
    catalogo.add(new Producto("the legend of zelda: tears of the kingdom", 52000.00, 11));
    catalogo.add(new Producto("the legend of zelda: link's awakening", 24000.00, 14));
    catalogo.add(new Producto("the legend of zelda: ocarina of time", 35000.00, 10));
    catalogo.add(new Producto("the legend of zelda: majora's mask", 33000.00, 9));
    catalogo.add(new Producto("the legend of zelda: the wind waker", 32000.00, 11));
    catalogo.add(new Producto("the legend of zelda: twilight princess", 34000.00, 10));
    catalogo.add(new Producto("the legend of zelda: phantom hourglass", 27000.00, 13));
    catalogo.add(new Producto("resident evil 4 remake", 43000.00, 10));
    catalogo.add(new Producto("resident evil 7: biohazard", 42000.00, 10));
    catalogo.add(new Producto("resident evil village", 48000.00, 8));
    catalogo.add(new Producto("resident evil revelations", 31000.00, 12));
    catalogo.add(new Producto("resident evil revelations 2", 32000.00, 10));
    catalogo.add(new Producto("resident evil outbreak", 27000.00, 9));
    catalogo.add(new Producto("monster hunter rise", 32000.00, 13));
    catalogo.add(new Producto("street fighter 6", 30000.00, 16));
    catalogo.add(new Producto("halo infinite", 34000.00, 12));
    catalogo.add(new Producto("animal crossing: new horizons", 29000.00, 15));
    catalogo.add(new Producto("madden nfl 24", 27000.00, 9));
    catalogo.add(new Producto("just dance 2024 edition", 25000.00, 20));
    catalogo.add(new Producto("efotball 2024", 50000.00, 50)); // juego gratuito
    catalogo.add(new Producto("wii sports", 20000.00, 10));

    return catalogo;
  }

  public static void mostrarCoincidencias(ArrayList<Producto> lista){

    System.out.println("""
        =============================================
                       JUEGOS ENCONTRADOS
        =============================================""");

      for (Producto titulo : lista){
        System.out.println("ID: " + titulo.mostrarID() + " " + " - " + titulo.mostrarNombre());
      }
  }

}

