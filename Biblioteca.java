import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> catalogoLibros;
    private List<Prestamo> registrosPrestamos;

    public Biblioteca() {
        catalogoLibros = new ArrayList<>();
        registrosPrestamos = new ArrayList<>();
    }

    public List<Libro> getCatalogoLibros() {
        return catalogoLibros;
    }

    public boolean agregarLibro(Libro libro) {
        return catalogoLibros.add(libro);
    }

    public boolean realizarPrestamo(int codigoLibro, int idEstudiante) {
        Libro libro = buscarLibroPorCodigo(codigoLibro);
        if (libro != null && libro.prestarEjemplar()) {
            registrosPrestamos.add(new Prestamo(codigoLibro, idEstudiante));
            return true;
        }
        return false;
    }

    public boolean realizarDevolucion(int codigoLibro, int idEstudiante) {
        Prestamo prestamo = buscarPrestamo(codigoLibro, idEstudiante);
        if (prestamo != null) {
            registrosPrestamos.remove(prestamo);
            return true;
        }
        return false;
    }

    public String verHistorialPrestamos(int idEstudiante) {
        StringBuilder historial = new StringBuilder();
        for (Prestamo prestamo : registrosPrestamos) {
            if (prestamo.getIdEstudiante() == idEstudiante) {
                historial.append(buscarLibroPorCodigo(prestamo.getCodigoLibro())).append("\n");
            }
        }
        return historial.length() > 0 ? historial.toString() : null;
    }

    private Libro buscarLibroPorCodigo(int codigo) {
        for (Libro libro : catalogoLibros) {
            if (libro.getCodigo() == codigo) {
                return libro;
            }
        }
        return null;
    }

    private Prestamo buscarPrestamo(int codigoLibro, int idEstudiante) {
        for (Prestamo prestamo : registrosPrestamos) {
            if (prestamo.getCodigoLibro() == codigoLibro && prestamo.getIdEstudiante() == idEstudiante) {
                return prestamo;
            }
        }
        return null;
    }
}
