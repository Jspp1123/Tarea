import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE CARRERAS F1 ===");

        
        System.out.println("\n--- REGISTRO DEL MONOPLAZA ---");
        System.out.print("Ingrese el nombre de la escudería (ej. Ferrari): ");
        String escuderia = scanner.nextLine();

        System.out.print("Ingrese el número del monoplaza (ej. 16): ");
        int numeroAuto = scanner.nextInt();
        scanner.nextLine(); 

        Monoplaza car1 = new Monoplaza(escuderia, numeroAuto);

        
        System.out.println("\n--- CONFIGURACIÓN DE TELEMETRÍA ---");
        System.out.print("Ingrese el nombre del servidor receptor (ej. AWS-F1-Server-PitLane): ");
        String servidor = scanner.nextLine();

        Telemetria pitWall = new Telemetria(servidor);

        
        System.out.println("\n--- SIMULACIÓN EN PISTA ---");
        System.out.print("¿Cuánto deseas acelerar en la primera prueba? (km/h): ");
        double primeraAceleracion = scanner.nextDouble();
        car1.acelerar(primeraAceleracion);

        System.out.println("\n--- Reporte en tiempo real ---");
        car1.transmitirDatos(pitWall);

        System.out.println("\n--- SIMULACIÓN DE ALTA EXIGENCIA DE MOTOR ---");
        System.out.print("¿Cuánto deseas acelerar adicionalmente para forzar el motor? (km/h): ");
        double segundaAceleracion = scanner.nextDouble();
        car1.acelerar(segundaAceleracion);

        System.out.println("\n--- Reporte final de telemetría ---");
        car1.transmitirDatos(pitWall);

        scanner.close(); 
    }
}