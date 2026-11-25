/**
 * guarda los datos de un paquete y calcula sus pesos.
 *
 * @author damian gil
 * @version 1.1
 */
public class Paquete {


    private String codigoRastreo;
    private double peso;
    private double alto;
    private double ancho;
    private double largo;
    private double valorDeclarado;
    private boolean envioExpress;


    /** hace un paquete con datos por omision */
    public Paquete() {
        this.codigoRastreo = "ND-000";
        this.peso = 1.0;
        this.alto = 10.0;
        this.ancho = 10.0;
        this.largo = 10.0;
        this.valorDeclarado = 100.0;
        this.envioExpress = false;
    
}

    /**
     * lo pone sin envio express
     * @param codigoRastreo code del paquete
     * @param peso peso real
     * @param alto altura
     * @param ancho anchura
     * @param largo longitud
     * @param valorDeclarado valor
     */
public Paquete(String codigoRastreo, double peso, double alto, double ancho,
                   double largo, double valorDeclarado) {
        this.codigoRastreo = (codigoRastreo != null && !codigoRastreo.equals(""))
                             ? codigoRastreo : "SIN-CODIGO";

        this.peso = (peso > 0.0) ? peso : 1.0;
        this.alto = (alto > 0.0) ? alto : 10.0;
        this.ancho = (ancho > 0.0) ? ancho : 10.0;
        this.largo = (largo > 0.0) ? largo : 10.0;
        this.valorDeclarado = (valorDeclarado >= 0.0) ? valorDeclarado : 0.0;
        this.envioExpress = false;
    }

    /**
         * paquete con todos los datos
         * @param codigoRastreo codigo del paquete
         * @param peso peso real
         * @param alto altura
         * @param ancho anchura
         * @param largo longitud
         * @param valorDeclarado valor del contenido
         * @param envioExpress modalidad de envio
     */
public Paquete(String codigoRastreo, double peso, double alto, double ancho,
                   double largo, double valorDeclarado, boolean envioExpress) {
        this.codigoRastreo = (codigoRastreo != null && !codigoRastreo.equals(""))
                             ? codigoRastreo : "SIN-CODIGO";

            this.peso = (peso > 0.0) ? peso : 1.0;
            this.alto = (alto > 0.0) ? alto : 10.0;
            this.ancho = (ancho > 0.0) ? ancho : 10.0;
            this.largo = (largo > 0.0) ? largo : 10.0;
            this.valorDeclarado = (valorDeclarado >= 0.0) ? valorDeclarado : 0.0;
            this.envioExpress = envioExpress;
    }




    /**
     * copia un paquete o usa omision si saca null
     * @param otro paquete q se va a copiar
     */

    public Paquete(Paquete otro) {

        if (otro == null) {
                this.codigoRastreo = "ND-000";
                this.peso = 1.0;
                this.alto = 10.0;
                this.ancho = 10.0;
                this.largo = 10.0;
                this.valorDeclarado = 100.0;
                this.envioExpress = false;
        } else {
                // copia los datos del otro
                this.codigoRastreo = otro.codigoRastreo;
                this.peso = otro.peso;
                this.alto = otro.alto;
                this.ancho = otro.ancho;
                this.largo = otro.largo;
                this.valorDeclarado = otro.valorDeclarado;
                this.envioExpress = otro.envioExpress;
        }
    }

    /** checa codigorastreo
     * @return valor consultado
     */

    public String getCodigoRastreo() { return codigoRastreo; }

    /** cambia codigorastreo
     * @param codigoRastreo valor nuevo
     */
    public void setCodigoRastreo(String codigoRastreo) {
            if (codigoRastreo != null && !codigoRastreo.equals("")) {
                this.codigoRastreo = codigoRastreo;
            }
    }

    /** consulta peso
     * @return valor consultado
     */
    public double getPeso() { return peso; }

    /** cambia peso
     * @param peso valor nuevo
     */

    public void setPeso(double peso) {
        if (peso > 0.0) {
             this.peso = peso;
        }
    }

    /** consulta alto
     * @return valor consultado
     */
    public double getAlto() { return alto; }

    /** cambia alto
     * @param alto valor nuevo
     */
    public void setAlto(double alto) {
        if (alto > 0.0) {
                this.alto = alto;
        } else {
                System.out.println("Error: La altura debe ser mas que cero.");
        }
    }

    /** consulta ancho
     * @return valor consultado
     */
    public double getAncho() { return ancho; }

    /** cambia ancho
     * @param ancho valor nuevo
     */

    public void setAncho(double ancho) {
        if (ancho > 0.0) {
            this.ancho = ancho;
        } else {
            System.out.println("Error: La anchura debe ser mayor a cero.");
        }
    }

    /** consulta largo
     * @return valor consultado
     */
    public double getLargo() { return largo; }

    /** cambia largo
     * @param largo valor nuevo
     */

    public void setLargo(double largo) {
        if (largo > 0.0) {
                this.largo = largo;
        } else {
                System.out.println("Error: La longitud debe ser mayor a cero");
        }
    }

    /** consulta valordeclarado
     * @return valor consultado
     */
    public double getValorDeclarado() { return valorDeclarado; }

    /** cambia valordeclarado
     * @param valorDeclarado valor nuevo
     */
    public void setValorDeclarado(double valorDeclarado) {
        if (valorDeclarado >= 0.0) {
            this.valorDeclarado = valorDeclarado;
        } else {
            System.out.println("Error: El valor declarado no puede ser negativo.");
        }
    }

    /** consulta envioexpress
     * @return valor consultado
     */
    public boolean isEnvioExpress() { return envioExpress; }

    /** cambia envioexpress
     * @param envioExpress valor nuevo
     */

    public void setEnvioExpress(boolean envioExpress) {

        this.envioExpress = envioExpress;
    }

    /** calcula el peso volumetrico
     * @return el peso calculado con las dimensiones */

    public double calculaPesoVolumetrico() {
        return (this.largo * this.ancho * this.alto) / 5000.0;
    }

    /** calcula el peso para el cobro
     * @return el mayor de los dos pesos */
    public double obtenerPesoCobrable() {
        double pesoVolumetrico = calculaPesoVolumetrico();
        return (this.peso >= pesoVolumetrico) ? this.peso : pesoVolumetrico;
    }


    /** muestra los datos del paquete
     * @return los datos principales del paquete */
    @Override
    public String toString() {
        return "codigo: " + codigoRastreo
             + " | peso real: " + peso + " kg"
             + " | peso volumetrico: " + calculaPesoVolumetrico() + " kg"
             + " | peso cobrable: " + obtenerPesoCobrable() + " kg"
             + " | valor: $" + valorDeclarado
             + " | express: " + (envioExpress ? "si" : "no");
    }
}