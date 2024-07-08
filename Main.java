import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    realizarPrestamo();
                    break;
                case 3:
                    realizarDevolucion();
                    break;
                case 4:
                    verHistorialPrestamos();
                    break;
                case 5:
                    mostrarLibrosDisponibles();
                    break;
                case 6:
                    System.out.println("¡Gracias por usar el sistema de biblioteca!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n*** Menú de Opciones ***");
        System.out.println("1. Agregar libro");
        System.out.println("2. Realizar préstamo");
        System.out.println("3. Realizar devolución");
        System.out.println("4. Ver historial de préstamos");
        System.out.println("5. Mostrar libros disponibles");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarLibro() {
        System.out.println("\nIngrese los datos del libro:");
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el género del libro: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese el año de publicación del libro: ");
        int añoPublicacion = scanner.nextInt();
        System.out.print("Ingrese el número de ejemplares disponibles: ");
        int ejemplaresDisponibles = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        int codigo = generarCodigoLibro(); // Generar código único para el libro
        Libro libro = new Libro(codigo, titulo, autor, genero, añoPublicacion, ejemplaresDisponibles);
        boolean agregado = biblioteca.agregarLibro(libro);

        if (agregado) {
            System.out.println("Libro agregado correctamente al catálogo.");
        } else {
            System.out.println("No se pudo agregar el libro. Verifique los datos e inténtelo de nuevo.");
        }
    }

    private static void realizarPrestamo() {
        System.out.print("\nIngrese el código del libro a prestar: ");
        int codigoLibro = scanner.nextInt();
        System.out.print("Ingrese el ID del estudiante: ");
        int idEstudiante = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        boolean prestamoExitoso = biblioteca.realizarPrestamo(codigoLibro, idEstudiante);
        if (prestamoExitoso) {
            System.out.println("Préstamo realizado con éxito.");
        } else {
            System.out.println("No se pudo realizar el préstamo. Verifique los datos e inténtelo de nuevo.");
        }
    }

    private static void realizarDevolucion() {
        System.out.print("\nIngrese el código del libro a devolver: ");
        int codigoLibro = scanner.nextInt();
        System.out.print("Ingrese el ID del estudiante: ");
        int idEstudiante = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        boolean devolucionExitosa = biblioteca.realizarDevolucion(codigoLibro, idEstudiante);
        if (devolucionExitosa) {
            System.out.println("Devolución realizada con éxito.");
        } else {
            System.out.println("No se pudo realizar la devolución. Verifique los datos e inténtelo de nuevo.");
        }
    }

    private static void verHistorialPrestamos() {
        System.out.print("\nIngrese el ID del estudiante para ver su historial de préstamos: ");
        int idEstudiante = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        String historial = biblioteca.verHistorialPrestamos(idEstudiante);
        if (historial != null) {
            System.out.println("Historial de préstamos del estudiante:");
            System.out.println(historial);
        } else {
            System.out.println("El estudiante no tiene historial de préstamos.");
        }
    }

    private static void mostrarLibrosDisponibles() {
        System.out.println("\nLibros disponibles en la biblioteca:");
        for (Libro libro : biblioteca.getCatalogoLibros()) {
            System.out.println(libro);
        }
    }

    // Método para generar un código único para cada libro (simulado)
    private static int generarCodigoLibro() {
        // Simplemente incrementa un contador por ahora
        return biblioteca.getCatalogoLibros().size() + 1;
    }
}
