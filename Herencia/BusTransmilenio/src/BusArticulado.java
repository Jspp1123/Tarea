

public class BusArticulado extends BusTransmilenio {
    private int numeroVagones;
    private boolean puertasEstacionAlineadas;

    public BusArticulado(String idBus, int capacidadMax, int numeroVagones) {
        super(idBus, capacidadMax); // Llama al constructor de BusTransmilenio
        this.numeroVagones = numeroVagones;
        this.puertasEstacionAlineadas = false;
    }

    public void acoplarEstacion() {
        this.puertasEstacionAlineadas = true;
        System.out.println("[" + idBus + "] Alineado con las puertas de la estación troncal.");
    }

    @Override
    public boolean procesarCobro() {
        // En troncal el cobro ocurre en la estación antes de abordar
        System.out.println("[" + idBus + "] Verificación remota: Pago procesado en torniquetes de estación.");
        return true;
    }

    @Override
    public void arrancar() {
        if (puertasEstacionAlineadas) {
            System.out.println("[" + idBus + "] Desacoplando puertas telescópicas...");
            this.puertasEstacionAlineadas = false;
        }
        System.out.println("[" + idBus + "] Arrancando por carril exclusivo con " + numeroVagones + " vagones.");
    }
}