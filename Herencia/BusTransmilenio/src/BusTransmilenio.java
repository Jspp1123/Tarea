

public abstract class BusTransmilenio {
    protected String idBus;
    protected int capacidadMax;
    protected int pasajerosActuales;
    protected double velocidadActual;

    public BusTransmilenio(String idBus, int capacidadMax) {
        this.idBus = idBus;
        this.capacidadMax = capacidadMax;
        this.pasajerosActuales = 0;
        this.velocidadActual = 0.0;
    }

    public void abordarPasajeros(int cantidad) {
        if (this.pasajerosActuales + cantidad <= capacidadMax) {
            this.pasajerosActuales += cantidad;
            System.out.println("[" + idBus + "] Abordaron " + cantidad + " pasajeros. Total: " + pasajerosActuales);
        } else {
            System.out.println("[" + idBus + "] ALERTA: Capacidad superada. No pueden abordar " + cantidad + " personas.");
        }
    }

    public void acelerar(double incremento) {
        this.velocidadActual += incremento;
        System.out.println("[" + idBus + "] Velocidad actual: " + velocidadActual + " km/h");
    }

    // Método que cada tipo de bus implementa según su infraestructura de cobro
    public abstract boolean procesarCobro();

    // Método abstracto para definir cómo inicia marcha cada tipo de bus
    public abstract void arrancar();

    // Getters
    public String getIdBus() { return idBus; }
    public int getCapacidadMax() { return capacidadMax; }
    public int getPasajerosActuales() { return pasajerosActuales; }
}