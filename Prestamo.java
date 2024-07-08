public class Prestamo {
    private int codigoLibro;
    private int idEstudiante;

    public Prestamo(int codigoLibro, int idEstudiante) {
        this.codigoLibro = codigoLibro;
        this.idEstudiante = idEstudiante;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }
}
