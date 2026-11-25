/**
 * revisa que las clases del sistema postal funcionen
 *
 * @author damian gil
 * @version 1.1
 */
public class PruebaEnvio {


    private static int pruebasExitosas = 0;
    private static int totalPruebas = 0;


    /** ejecuta las pruebas
     * @param args argumentos */
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO");
        System.out.println("================================================================================\n");


        // parte 1: paquetes
    System.out.println(">>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE");
    Paquete kitBase = new Paquete("KIT-101", 4.0, 20.0, 20.0, 20.0, 500.0, false);
    Paquete otroPaquete = new Paquete("PKG-202", 12.0, 40.0, 30.0, 30.0, 1500.0, false);

    String txtKit = kitBase.toString();
    verificar("toString muestra el codigo", txtKit != null && txtKit.contains("KIT-101"));
    verificar("toString muestra los pesos y el valor",
                txtKit.contains("peso real") && txtKit.contains("peso volumetrico")
                && txtKit.contains("peso cobrable") && txtKit.contains("500.0")
                && txtKit.contains("express"));

    Paquete kitClon = new Paquete(kitBase);
    double pesoOriginal = kitBase.getPeso();
    kitBase.setPeso(99.0);
    verificar("el paquete clonado es independiente",
                kitClon != kitBase && Math.abs(kitClon.getPeso() - pesoOriginal) < 0.000001);
    kitBase.setPeso(pesoOriginal);

    kitClon.setCodigoRastreo("KIT-102");
    verificar("cambiar el clon no cambia el original",
                kitBase.getCodigoRastreo().equals("KIT-101")
                && kitClon.getCodigoRastreo().equals("KIT-102"));
    Paquete clonNulo = new Paquete(null);
    verificar("el constructor por copia acepta null", CotizadorEnvio.esPaqueteValido(clonNulo)
                  && clonNulo.getCodigoRastreo().equals("ND-000"));
    System.out.println();


        // parte 2: la people
    System.out.println(">>> PARTE 2: VERIFICACION DE LA CLASE PERSONA");
    Persona personaX = new Persona("PER-01", "ana lopez", "cdmx");
    Persona personaY = new Persona("PER-02", "luis perez", "CDMX");
    Persona personaZ = new Persona("PER-03", "sofia ramirez", "puebla");
    Persona copiaX = new Persona("PER-01", "ana lopez", "cdmx");
    Persona porOmision = new Persona();

    verificar("dos personas pueden tener la misma ubicacion", personaX.mismaUbicacionQue(personaY));
    verificar("las ciudades diferentes no coinciden", !personaX.mismaUbicacionQue(personaZ));
    verificar("no se puede comparar con null", !personaX.mismaUbicacionQue(null));
    verificar("el mismo identificador representa a la misma persona", personaX.esLaMismaPersona(copiaX));
    verificar("identificadores diferentes son personas diferentes", !personaX.esLaMismaPersona(personaY));
    verificar("la comparacion de identidad rechaza null", !personaX.esLaMismaPersona(null));
    verificar("el texto de persona incluye sus datos",
                personaX.toString().contains("ana lopez")
                && personaX.toString().contains("PER-01")
                && personaX.toString().contains("cdmx"));
        verificar("los valores por omision no estan vacios",
                !porOmision.getIdentificador().equals("")
                && !porOmision.getNombreCompleto().equals("")
                && !porOmision.getUbicacion().equals(""));
    personaX.setNombreCompleto("");
    verificar("un setter no acepta un nombre vacio", personaX.getNombreCompleto().equals("ana lopez"));
    System.out.println();


        // parte 3: guias y costos
    System.out.println(">>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS");
    verificar("al inicio hay cero guias", Envio.getTotalGuias() == 0);

    Envio guiaLocal = new Envio(personaX, personaY, kitBase);
    Envio guiaForanea = new Envio(personaX, personaZ, kitClon);

    verificar("la primera guia tiene folio 1",
                guiaLocal.getFolioGuia().startsWith("GUIA-")
                && guiaLocal.getFolioGuia().endsWith("-1"));
    verificar("la segunda guia tiene folio 2",
                guiaForanea.getFolioGuia().startsWith("GUIA-")
                && guiaForanea.getFolioGuia().endsWith("-2"));
    verificar("los folios no son iguales", !guiaLocal.getFolioGuia().equals(guiaForanea.getFolioGuia()));
    verificar("el contador marca dos guias", Envio.getTotalGuias() == 2);
    verificar("la primera guia es local", !guiaLocal.esEnvioForaneo());
    verificar("la segunda guia es foranea", guiaForanea.esEnvioForaneo());
    verificar("el envio local no tiene cargo extra", guiaLocal.calcularCostoTotal() == 120.0);
    verificar("el envio foraneo suma 80 pesos", guiaForanea.calcularCostoTotal() == 200.0);
    verificar("personas diferentes no son autoenvio", !guiaLocal.esAutoEnvio());
    verificar("no acepta destinatario null", !guiaForanea.cambiarDestinatario(null));
    verificar("permite cambiar el destinatario", guiaForanea.cambiarDestinatario(copiaX));
    verificar("el mismo identificador permite autoenvio", guiaForanea.esAutoEnvio());
    System.out.println();


        // parte 4: simulacion
    System.out.println(">>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO");
    Envio primerEnvio = new Envio(personaX, personaY, kitBase);
    System.out.println("\nprimer envio de x a y:" + primerEnvio);

    Envio segundoEnvio = new Envio(primerEnvio, otroPaquete);
    System.out.println("\nsegundo envio de x a y:" + segundoEnvio);
    verificar("la guia clonada conserva las mismas personas",
                segundoEnvio.getRemitente() == primerEnvio.getRemitente()
                && segundoEnvio.getDestinatario() == primerEnvio.getDestinatario());
    verificar("la guia clonada usa el paquete nuevo", segundoEnvio.getPaquete() == otroPaquete);
    verificar("la guia clonada tiene otro folio", segundoEnvio.getFolioGuia().endsWith("-4"));

    Paquete kitParaZ = new Paquete(kitBase);
    kitParaZ.setCodigoRastreo("KIT-103");
    Envio envioAZ = new Envio(personaX, personaZ, kitParaZ);
    System.out.println("\nkit clonado enviado a z:" + envioAZ);
    verificar("el paquete para z es una copia distinta", envioAZ.getPaquete() != kitBase);
    verificar("el kit para z tiene otro codigo", envioAZ.getPaquete().getCodigoRastreo().equals("KIT-103")
                && kitBase.getCodigoRastreo().equals("KIT-101"));
    verificar("el envio a z es foraneo", envioAZ.esEnvioForaneo());
    verificar("la guia para z tiene folio 5", envioAZ.getFolioGuia().endsWith("-5"));

    Envio guiaRetorno = primerEnvio.generarGuiaRetorno();
    System.out.println("\ndevolucion de y a x:" + guiaRetorno);
    verificar("el retorno invierte las personas",
            guiaRetorno.getRemitente() == personaY && guiaRetorno.getDestinatario() == personaX);
    verificar("el retorno copia el paquete", guiaRetorno.getPaquete() != primerEnvio.getPaquete());
    verificar("el codigo de retorno empieza con ret",
                guiaRetorno.getPaquete().getCodigoRastreo().startsWith("RET-KIT-101"));
    verificar("el retorno tiene folio 6", guiaRetorno.getFolioGuia().endsWith("-6"));
    verificar("se emitieron seis guias", Envio.getTotalGuias() == 6);

    System.out.println("\ntotal de guias emitidas: " + Envio.getTotalGuias());
    System.out.println("\n================================================================================");
    System.out.println("  RESUMEN DE PRUEBAS: " + pruebasExitosas + " / " + totalPruebas + " pruebas superadas con exito");
    System.out.println("================================================================================");

    }


    /** checa de si se cumplio cada prueba
     * @param nombrePrueba nombre de la comprobacion
     * @param condicion resultado */
    private static void verificar(String nombrePrueba, boolean condicion) {
        totalPruebas++;
        if (condicion) {
            pruebasExitosas++;
            System.out.println("  [OK]    " + nombrePrueba);
        } else {
            System.out.println("  [FALLO] " + nombrePrueba);

        }
}

}
