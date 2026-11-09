/**
 * calcula costos y revisa si un paquete necesita seguro.
 * @author Damian Pedro Aguilar Gil
 */
public class CotizadorEnvio {

    /**
     * revisa los datos del paquete.
     * @param p paquete que se revisa
     * @return true si es valido
     */
    public static boolean esPaqueteValido(Paquete p) {
        if (p == null) {
            return false;
        }
        if (p.getCodigoRastreo() == null || p.getCodigoRastreo().equals("")) {
            return false;
        }
        if (p.getPesoFisico() <= 0.0 || p.getLargo() <= 0.0 ||
            p.getAncho() <= 0.0 || p.getAlto() <= 0.0 ||
            p.getValorDeclarado() < 0.0) {
            return false;
        }
        return true;
    }

    /**
     * calcula el precio del envio y agrega el recargo si es fragil.
     * @param p paquete que se cotiza
     * @return precio o -1.0 si no es valido
     */
    public static double cotizarEnvio(Paquete p) {
        if (!esPaqueteValido(p)) {
            return -1.0;
        }

        double peso = p.obtenerPesoCobrable();
        double costo;

        if (peso <= 5.0) {
            costo = 120.0;
        } else if (peso <= 15.0) {
            costo = 120.0 + (peso - 5.0) * 18.0;
        } else {
            costo = 300.0 + (peso - 15.0) * 25.0;
        }

        return costo + p.calcularRecargoFragil();
    }

    /**
     * revisa si el paquete necesita seguro.
     * @param p paquete que se revisa
     * @return true si necesita seguro
     */
    public static boolean requiereSeguro(Paquete p) {
        if (!esPaqueteValido(p)) {
            return false;
        }

        if (p.getValorDeclarado() > 3000.0 ||
            p.getLargo() > 60.0 || p.getAncho() > 60.0 ||
            p.getAlto() > 60.0 ||
            p.getLargo() + p.getAncho() + p.getAlto() > 150.0) {
            return true;
        } else {
            return false;
        }
    }
}
