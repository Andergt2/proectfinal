public class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private String genero;
    private int añoPublicacion;
    private int ejemplaresDisponibles;

    public Libro(int codigo, String titulo, String autor, String genero, int añoPublicacion, int ejemplaresDisponibles) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.añoPublicacion = añoPublicacion;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public boolean prestarEjemplar() {
        if (ejemplaresDisponibles > 0) {
            ejemplaresDisponibles--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", añoPublicacion=" + añoPublicacion +
                ", ejemplaresDisponibles=" + ejemplaresDisponibles +
                '}';
    }
}
