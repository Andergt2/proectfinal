public class Estudiante {
    private int id;
    private String nombre;
    private String carrera;

    public Estudiante(int id, String nombre, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
