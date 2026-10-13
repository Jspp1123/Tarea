

public class Telemetria {
    private String servidorReceptor;

    public Telemetria(String servidorReceptor) {
        this.servidorReceptor = servidorReceptor;
    }

    public void enviarDiagnostico(int numeroAuto, double velocidad, double tempMotor) {
        System.out.println("[TELEMETRÍA -> " + servidorReceptor + "]");
        System.out.println(" > Carro #" + numeroAuto + " | Vel: " + velocidad + " km/h | Temp Motor: " + tempMotor + " °C");
        
        if (tempMotor > 110.0) {
            System.out.println(" > ALERTA BOXES: Sobrecalentamiento detectado en auto #" + numeroAuto);
        }
    }
}