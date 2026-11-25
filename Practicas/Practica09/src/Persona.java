/**
 * guarda los datos de una persona del sistema postal
 *
 * @author damian gil
 * @version 1.1
 */
public class Persona {

    private String identificador;
    private String nombreComlpeto;
    private String ubicacion;

    /** crea una persona */
public Persona() {
        this.identificador = "PER-00";
        this.nombreComlpeto = "sin nombre";
        this.ubicacion = "sin ubicacion";

    }

/**
* crea una persona con los datos recibidos
* @param identificador clave 
     * @param nombreCompleto nombre 
     * @param ubicacion ciudad o codigo postal
     */

    public Persona(String identificador, String nombreCompleto, String ubicacion) {
            this.identificador = "PER-00";
            this.nombreComlpeto = "sin nombre";
            this.ubicacion = "sin ubicacion";
            setIdentificador(identificador);
            setNombreCompleto(nombreCompleto);
            setUbicacion(ubicacion);
    }

    /** consulta identificador
     * @return valor consultado
     */
        public String getIdentificador() {
            return identificador;
    }

    /** cambia identificador
     * @param identificador valor nuevo
     */
    public void setIdentificador(String identificador) {

        if (identificador != null && !identificador.trim().equals("")) {
            this.identificador = identificador.trim();

        }
    }

    /** consulta nombrecompleto
     * @return valor consultado
     */
    public String getNombreCompleto() {
         return nombreComlpeto;
    }

    /** cambia nombrecompleto
     * @param nombreCompleto valor nuevo
     */

    public void setNombreCompleto(String nombreCompleto) {
            if (nombreCompleto != null && !nombreCompleto.trim().equals("")) {
                this.nombreComlpeto = nombreCompleto.trim();
            }
    }

    /** consulta ubicacion
     * @return valor consultado
     */

public String getUbicacion() {
        return ubicacion;
    }

    /** cambia ubicacion
     * @param ubicacion valor nuevo
     */

    public void setUbicacion(String ubicacion) {
            if (ubicacion != null && !ubicacion.trim().equals("")) {
                this.ubicacion = ubicacion.trim();
            }
    }

    /**
     * compara las ubicaciones de dos
     * @param otra persona con quien comparar
     * @return true cuando tienen la misma ubicacion
     */

        public boolean mismaUbicacionQue(Persona otra) {
            return otra != null && this.ubicacion.equalsIgnoreCase(otra.ubicacion);
    }

    /**
     * compara las claves de dos personas
     * @param otra persona con quien comparar
     * @return true cuando tienen la misma clave
     */

        public boolean esLaMismaPersona(Persona otra) {
            return otra != null && this.identificador.equals(otra.identificador);
    }

    /** muestra la persona
     * @return datos principales */
    @Override
    public String toString() {
        return nombreComlpeto + " | id: " + identificador + " | ubicacion: " + ubicacion;
        
    }



}
