package principal;

import config.ConsumoApiGutendex;
import config.ConvertirDatos;
import repository.AutorRepository;
import repository.LibroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoApiGutendex consumoApi = new ConsumoApiGutendex();
    private ConvertirDatos convertir = new ConvertirDatos();
    private static String API_BASE = "https://gutendex.com/books/?search=";

    private List<Libro> datosLibro = new ArrayList<>();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;
    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
    this.libroRepository = libroRepository;
    this.autorRepository = autorRepository;
}

public void muestraElMenu() {
    var opcion = -1;

    while (opcion!= 5) {
        var menu = """
                ************************
                Elija su opicón preferida:
                1- Buscar libro por título
                2- Lista de libros registrados
                3- Lista de autores registrados
                4- Lista de autores vivos en un año determinado
                5- Lista de libros por idiomas
                
                0- Salir
                """;

        System.out.println(menu);
        opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion) {
            case 1:
                registrarLibro();
                break;
            case 2:
                listarLibros();
                break;
            case 3:
                listarAutoresRegistrados();
                break;
            case 4:
                listarAutoresVivos();
                break;
            case 5:
                listarLibrosPorIdioma();
                break;
            case 0:
                System.out.println("Cerrando la aplicación...");
                break;
            default:
                System.out.println("Opción inválida");
            }
         }
    }
}
