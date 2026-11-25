/**
 * relaciona a dos personas con un paquete y la guia
 *
 * @author damian gil
 * @version 1.1
 */
public class Envio {

    /** costo extra  */
    public static final double CARGO_FORANEO = 80.0;

        private String folioGua;
        private Persona remitente;
        private Persona destinatario;
        private Paquete paquete;
        private static int totalGuias = 0;

/**
 * crea una guia nueva con sus tres objetos
* @param remitente persona que envia
* @param destinatario persona que recibe
 * @param paquete paquete del envio
*/

    public Envio(Persona remitente, Persona destinatario, Paquete paquete) {

        this.remitente = (remitente != null) ? remitente : new Persona();
        this.destinatario = (destinatario != null) ? destinatario : new Persona();
        this.paquete = CotizadorEnvio.esPaqueteValido(paquete) ? paquete : new Paquete();
        this.folioGua = generarFolio();

    }

    /**
     * crea otra guia pa los mismos
     * @param guiaBase guia de donde salen las personas
     * @param nuevoPaquete paquete para el nuevo envio
     */

    public Envio(Envio guiaBase, Paquete nuevoPaquete) {

        if (guiaBase != null) {
            this.remitente = guiaBase.remitente;
            this.destinatario = guiaBase.destinatario;

        } else {
            this.remitente = new Persona();
            this.destinatario = new Persona();
        }

    this.paquete = CotizadorEnvio.esPaqueteValido(nuevoPaquete) ? nuevoPaquete : new Paquete();
    this.folioGua = generarFolio();

    }

    /** genera el folio y aumenta el contador */
    private static String generarFolio() {

        totalGuias++;
        int numeroAzar = (int) (Math.random() * 900) + 100;
        return "GUIA-" + numeroAzar + "-" + totalGuias;
    }


    /** consulta cuantas guias se hicieron
     * @return valor consultado
     */

    public static int getTotalGuias() {
        return totalGuias;
    }

    /** consulta el folio de esta guia
     * @return valor consultado
     */

    public String getFolioGuia() {
        return folioGua;
    }

    /** consulta quien envia
     * @return valor consultado
     */
    public Persona getRemitente() {
        return remitente;
    }

    /** consulta quien recibe
     * @return valor consultado
     */
    public Persona getDestinatario() {
        return destinatario;
    }

    /** consulta que paquete se envia
     * @return valor consultado
     */
    public Paquete getPaquete() {
        return paquete;
    }

    /** comprueba la ruta
     * @return true si las ubicaciones son diferentes */

    public boolean esEnvioForaneo() {
        return !remitente.mismaUbicacionQue(destinatario);
    }

    /** comprueba la identidad
     * @return true si el remitente y destinatario son la misma persona */

    public boolean esAutoEnvio() {
        return remitente.esLaMismaPersona(destinatario);
    }

    /** calcula el costo del envio
     * @return costo del paquete mas el cargo por envio foraneo */

    public double calcularCostoTotal() {

        double costo = CotizadorEnvio.cotizarEnvio(paquete);
        if (costo < 0.0) {
            return -1.0;
        }

        if (esEnvioForaneo()) {
            costo += CARGO_FORANEO;
        }
        return costo;
    }

    /**
     * cambia a la persona que recibe el paquete
     * @param nuevoDestinatario persona nueva
     * @return true si se pudo cambiar
     */

    public boolean cambiarDestinatario(Persona nuevoDestinatario) {
        if (nuevoDestinatario == null) {
            return false;
        }

        this.destinatario = nuevoDestinatario;
        return true;
    }

    /** prepara una devolucion
     * @return otra guia con el paquete de regreso */
    public Envio generarGuiaRetorno() {

        Paquete paqueteRetorno = new Paquete(paquete);
        paqueteRetorno.setCodigoRastreo("RET-" + paqueteRetorno.getCodigoRastreo());

        return new Envio(destinatario, remitente, paqueteRetorno);
    }

    /** muestra el comprobante
     * @return comprobante de la guia */
     
    @Override
    public String toString() {
        String tipo = esEnvioForaneo() ? "foraneo" : "local";
        String personal = esAutoEnvio() ? "si" : "no";

        return "\n--- guia de envio ---"
             + "\nfolio: " + folioGua
             + "\nremitente: " + remitente.toString()
             + "\ndestinatario: " + destinatario.toString()
             + "\npaquete: " + paquete.toString()
             + "\ntipo: " + tipo
             + "\nenvio personal: " + personal
             + "\ncosto total: $" + calcularCostoTotal();

    }


}