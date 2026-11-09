/**
 * representa un paquete de una empresa de envios.
 * @author Damian Pedro Aguilar Gil
 */
public class Paquete {

    private String codigoRastreo;
    private double pesoFisico;
    private double largo;
    private double ancho;
    private double alto;
    private double valorDeclarado;
    private boolean fragil;

    /** crea un paquete con valores validos. */
    public Paquete() {
        codigoRastreo = "PK-000";
        pesoFisico = 1.0;
        largo = 10.0;
        ancho = 10.0;
        alto = 10.0;
        valorDeclarado = 0.0;
        fragil = false;
    }

    /**
     * crea un paquete con los datos indicados.
     * @param codigoRastreo codigo del paquete
     * @param pesoFisico peso en kilogramos
     * @param largo largo en centimetros
     * @param ancho ancho en centimetros
     * @param alto alto en centimetros
     * @param valorDeclarado valor del contenido
     */
    public Paquete(String codigoRastreo, double pesoFisico, double largo,
                   double ancho, double alto, double valorDeclarado) {
        // primero colocamos valores validos
        this.codigoRastreo = "PK-000";
        this.pesoFisico = 1.0;
        this.largo = 10.0;
        this.ancho = 10.0;
        this.alto = 10.0;
        this.valorDeclarado = 0.0;
        fragil = false;

        setCodigoRastreo(codigoRastreo);
        setPesoFisico(pesoFisico);
        setLargo(largo);
        setAncho(ancho);
        setAlto(alto);
        setValorDeclarado(valorDeclarado);
    }

    /** @return codigo de rastreo */
    public String getCodigoRastreo() {
        return codigoRastreo;
    }

    /**
     * cambia el codigo si no esta vacio.
     * @param codigoRastreo nuevo codigo
     */
    public void setCodigoRastreo(String codigoRastreo) {
        if (codigoRastreo != null && !codigoRastreo.equals("")) {
            this.codigoRastreo = codigoRastreo;
        }
    }

    /** @return peso fisico */
    public double getPesoFisico() {
        return pesoFisico;
    }

    /**
     * cambia el peso si es positivo.
     * @param pesoFisico nuevo peso
     */
    public void setPesoFisico(double pesoFisico) {
        if (pesoFisico > 0.0) {
            this.pesoFisico = pesoFisico;
        }
    }

    /** @return largo */
    public double getLargo() {
        return largo;
    }

    /**
     * cambia el largo si es positivo.
     * @param largo nuevo largo
     */
    public void setLargo(double largo) {
        if (largo > 0.0) {
            this.largo = largo;
        }
    }

    /** @return ancho */
    public double getAncho() {
        return ancho;
    }

    /**
     * cambia el ancho si es positivo.
     * @param ancho nuevo ancho
     */
    public void setAncho(double ancho) {
        if (ancho > 0.0) {
            this.ancho = ancho;
        }
    }

    /** @return alto */
    public double getAlto() {
        return alto;
    }

    /**
     * cambia el alto si es positivo.
     * @param alto nuevo alto
     */
    public void setAlto(double alto) {
        if (alto > 0.0) {
            this.alto = alto;
        }
    }

    /** @return valor declarado */
    public double getValorDeclarado() {
        return valorDeclarado;
    }

    /**
     * cambia el valor si no es negativo.
     * @param valorDeclarado nuevo valor
     */
    public void setValorDeclarado(double valorDeclarado) {
        if (valorDeclarado >= 0.0) {
            this.valorDeclarado = valorDeclarado;
        }
    }

    /** @return true si el paquete es fragil */
    public boolean isFragil() {
        return fragil;
    }

    /**
     * indica si el paquete es fragil.
     * @param fragil true si es fragil
     */
    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    /** @return peso volumetrico en kilogramos */
    public double calculaPesoVolumetrico() {
        return (largo * ancho * alto) / 5000.0;
    }

    /** @return el mayor entre peso fisico y volumetrico */
    public double obtenerPesoCobrable() {
        double pesoVolumetrico = calculaPesoVolumetrico();
        if (pesoFisico > pesoVolumetrico) {
            return pesoFisico;
        } else {
            return pesoVolumetrico;
        }
    }

    /** @return recargo de 35 pesos si es fragil */
    public double calcularRecargoFragil() {
        if (fragil) {
            return 35.0;
        } else {
            return 0.0;
        }
    }
}

