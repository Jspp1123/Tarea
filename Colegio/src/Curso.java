import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {
    private final String idCurso;
    private final String titulo;
    private final int cupoMaximo;
    private final List<Inscripcion> inscripciones;

    public Curso(String idCurso, String titulo, int cupoMaximo) {
        this.idCurso = idCurso;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public boolean estaLleno() {
        return inscripciones.size() >= cupoMaximo;
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        if (inscripcion != null && !this.inscripciones.contains(inscripcion)) {
            this.inscripciones.add(inscripcion);
        }
    }

    public String getIdCurso() { return idCurso; }
    public String getTitulo() { return titulo; }
    public int getCupoMaximo() { return cupoMaximo; }
    public List<Inscripcion> getInscripciones() { return Collections.unmodifiableList(inscripciones); }
}