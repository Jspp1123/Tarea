

public class Monoplaza {
    private String escuderia;
    private int numero;
    private double velocidad;
    private double tempMotor;

    public Monoplaza(String escuderia, int numero) {
        this.escuderia = escuderia;
        this.numero = numero;
        this.velocidad = 0.0;
        this.tempMotor = 90.0; // Temperatura normal inicial
    }

    public void acelerar(double incremento) {
        this.velocidad += incremento;
        this.tempMotor += (incremento * 0.15); // A mayor aceleración, sube la temperatura
        System.out.println("Carro #" + numero + " (" + escuderia + ") acelerando a " + velocidad + " km/h...");
    }

    // AQUÍ OCURRE LA DEPENDENCIA:
    // Monoplaza "usa" a Telemetria puntualmente como parámetro de entrada
    public void transmitirDatos(Telemetria telemetria) {
        if (telemetria != null) {
            telemetria.enviarDiagnostico(this.numero, this.velocidad, this.tempMotor);
        } else {
            System.out.println("ERROR: No hay conexión con el sistema de telemetría.");
        }
    }

    public int getNumero() { return numero; }
    public String getEscuderia() { return escuderia; }
}