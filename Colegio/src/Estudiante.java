import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estudiante {
    private final String idEstudiante;
    private final String nombre;
    private final String email;
    private final List<Inscripcion> inscripciones;

    public Estudiante(String idEstudiante, String nombre, String email) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.email = email;
        this.inscripciones = new ArrayList<>();
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        if (inscripcion != null && !this.inscripciones.contains(inscripcion)) {
            this.inscripciones.add(inscripcion);
        }
    }

    public String getIdEstudiante() { return idEstudiante; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public List<Inscripcion> getInscripciones() { return Collections.unmodifiableList(inscripciones); }
}