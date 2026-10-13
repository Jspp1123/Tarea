

public class BusZonal extends BusTransmilenio {
    private boolean validadorAbordoActivo;
    private static final double TARIFA_ZONAL = 2950.0;

    public BusZonal(String idBus, int capacidadMax, boolean validadorAbordoActivo) {
        super(idBus, capacidadMax);
        this.validadorAbordoActivo = validadorAbordoActivo;
    }

    @Override
    public boolean procesarCobro() {
        if (validadorAbordoActivo) {
            System.out.println("[" + idBus + "] Validando pasaje en torniquete a bordo ($" + TARIFA_ZONAL + ")");
            return true;
        }
        System.out.println("[" + idBus + "] ERROR: Validador fuera de servicio.");
        return false;
    }

    @Override
    public void arrancar() {
        System.out.println("[" + idBus + "] Cerrando puerta única frontal y arrancando en carril mixto...");
    }
}