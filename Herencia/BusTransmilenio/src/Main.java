import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE CONTROL DE FLOTA TRANSMILENIO ===");
        System.out.println("Seleccione el tipo de bus que desea registrar:");
        System.out.println("1. Bus Articulado (Troncal)");
        System.out.println("2. Bus Zonal (SITP)");
        System.out.print("Opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        if (opcion == 1) {
            System.out.println("\n--- REGISTRO DE BUS ARTICULADO ---");
            System.out.print("Ingrese el ID del bus (ej. TM-A012): ");
            String id = scanner.nextLine();

            System.out.print("Ingrese la capacidad máxima de pasajeros: ");
            int capacidad = scanner.nextInt();

            System.out.print("Ingrese el número de vagones: ");
            int vagones = scanner.nextInt();

            
            BusArticulado articulado = new BusArticulado(id, capacidad, vagones);

            System.out.print("¿Cuantos pasajeros van a abordar?: ");
            int pasajeros = scanner.nextInt();

            System.out.println("\n--- EJECUCIÓN DEL SISTEMA ---");
            articulado.acoplarEstacion();
            articulado.procesarCobro();
            articulado.abordarPasajeros(pasajeros);
            articulado.arrancar();
            articulado.acelerar(40.0);

        } else if (opcion == 2) {
            System.out.println("\n--- REGISTRO DE BUS ZONAL ---");
            System.out.print("Ingrese el ID del bus (ej. Z10-4055): ");
            String id = scanner.nextLine();

            System.out.print("Ingrese la capacidad máxima de pasajeros: ");
            int capacidad = scanner.nextInt();

            System.out.print("¿El validador a bordo está activo? (true/false): ");
            boolean validador = scanner.nextBoolean();

            
            BusZonal zonal = new BusZonal(id, capacidad, validador);

            System.out.print("¿Cuántos pasajeros van a abordar?: ");
            int pasajeros = scanner.nextInt();

            System.out.println("\n--- EJECUCIÓN DEL SISTEMA ---");
            zonal.procesarCobro();
            zonal.abordarPasajeros(pasajeros);
            zonal.arrancar();
            zonal.acelerar(30.0);

        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close(); 
    }
}