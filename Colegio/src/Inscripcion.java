import java.time.LocalDate;

public class Inscripcion {
    private final Estudiante estudiante;
    private final Curso curso;
    private final LocalDate fechaInscripcion;
    private double porcentajeProgreso;
    private EstadoInscripcion estado;

    public Inscripcion(Estudiante estudiante, Curso curso) {
        if (estudiante == null || curso == null) {
            throw new IllegalArgumentException("Estudiante y Curso no pueden ser nulos.");
        }
        if (curso.estaLleno()) {
            throw new IllegalStateException("El curso '" + curso.getTitulo() + "' ya no tiene cupos disponibles.");
        }

        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaInscripcion = LocalDate.now();
        this.porcentajeProgreso = 0.0;
        this.estado = EstadoInscripcion.ACTIVO;

        
        this.estudiante.agregarInscripcion(this);
        this.curso.agregarInscripcion(this);
    }

    public void actualizarProgreso(double avance) {
        if (estado != EstadoInscripcion.ACTIVO) {
            System.out.println("No se puede actualizar el progreso: la inscripción no está activa.");
            return;
        }

        this.porcentajeProgreso += avance;
        if (this.porcentajeProgreso >= 100.0) {
            this.porcentajeProgreso = 100.0;
            this.estado = EstadoInscripcion.COMPLETADO;
            System.out.println("¡Felicidades! " + estudiante.getNombre() + " completó el curso: " + curso.getTitulo());
        } else {
            System.out.println("Progreso de " + estudiante.getNombre() + " en " 
                    + curso.getTitulo() + ": " + porcentajeProgreso + "%");
        }
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Curso getCurso() { return curso; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public double getPorcentajeProgreso() { return porcentajeProgreso; }
    public EstadoInscripcion getEstado() { return estado; }
}