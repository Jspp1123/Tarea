import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE GESTIÓN DE CURSOS ONLINE (LMS) ===");

       
        Curso javaPro = new Curso("CUR-01", "Java Enterprise & Spring Boot", 2); // Cupo máximo: 2
        Curso pythonData = new Curso("CUR-02", "Python para Data Science", 30);

        
        System.out.println("\n--- REGISTRO DE NUEVO ESTUDIANTE ---");
        System.out.print("Ingrese ID del estudiante (ej. EST-101): ");
        String idEst = scanner.nextLine();

        System.out.print("Ingrese nombre completo: ");
        String nombreEst = scanner.nextLine();

        System.out.print("Ingrese correo electrónico: ");
        String emailEst = scanner.nextLine();

        Estudiante estudiante1 = new Estudiante(idEst, nombreEst, emailEst);

        
        System.out.println("\n--- INSCRIPCIÓN DE CURSOS ---");
        System.out.println("Inscribiendo a " + estudiante1.getNombre() + " en Java y Python...");

        Inscripcion insJava = null;

        try {
           
            insJava = new Inscripcion(estudiante1, javaPro);
            
          
            new Inscripcion(estudiante1, pythonData);
            
            System.out.println("¡Inscripciones realizadas con éxito!");
        } catch (Exception e) {
            System.err.println("Error en inscripción: " + e.getMessage());
        }

        
        System.out.println("\n--- REGISTRO DE SEGUNDO ESTUDIANTE EN MISMO CURSO ---");
        System.out.print("Ingrese el nombre de un segundo estudiante para el curso de Java: ");
        String nombreEst2 = scanner.nextLine();

        Estudiante estudiante2 = new Estudiante("EST-102", nombreEst2, "correo2@email.com");
        
        try {
            
            new Inscripcion(estudiante2, javaPro);
            System.out.println("¡" + estudiante2.getNombre() + " también fue inscrito en Java exitosamente!");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        
        if (insJava != null) {
            System.out.println("\n--- ACTUALIZACIÓN DE PROGRESO DE " + estudiante1.getNombre().toUpperCase() + " ---");
            System.out.print("¿Cuánto porcentaje deseas avanzar en 'Java Enterprise'? (0-100): ");
            double avance = scanner.nextDouble();
            
            insJava.actualizarProgreso(avance);
        }

        
        System.out.println("\n--- REPORTE FINAL: CURSOS DE " + estudiante1.getNombre() + " ---");
        for (Inscripcion ins : estudiante1.getInscripciones()) {
            System.out.println(" > Curso: " + ins.getCurso().getTitulo() 
                    + " | Estado: " + ins.getEstado() 
                    + " | Progreso: " + ins.getPorcentajeProgreso() + "%");
        }

        System.out.println("\n--- REPORTE FINAL: INSCRITOS EN 'JAVA ENTERPRISE' ---");
        for (Inscripcion ins : javaPro.getInscripciones()) {
            System.out.println(" > Estudiante: " + ins.getEstudiante().getNombre() 
                    + " | Fecha: " + ins.getFechaInscripcion() 
                    + " | Estado: " + ins.getEstado());
        }

        scanner.close();
    }
}