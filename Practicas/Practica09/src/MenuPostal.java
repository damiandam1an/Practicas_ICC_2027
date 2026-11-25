import java.util.Scanner;

/**
 * menu para manejar las guias desde la consola
 *
 * @author damian gil
 * @version 1.1
 */
public class MenuPostal {


    /** inicia el menu
     * @param args argumentos del programa */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Envio guiaActiva = null;
        boolean continuar = true;

        System.out.println("================================================================");
        System.out.println("  SISTEMA INTERACTIVO DE GUIAS POSTALES | ICC 2027-1");
        System.out.println("================================================================");

        while (continuar) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Emitir nueva guia de envio");
            System.out.println("2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)");
            System.out.println("3. Clonar paquete de la guia activa para enviarlo a otro destinatario");
            System.out.println("4. Generar guia de retorno (devolucion al remitente)");
            System.out.println("5. Mostrar detalle y costo de la guia activa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                    guiaActiva = emitirNuevaGuia(sc);
                    break;
                case "2":
                    guiaActiva = clonarGuia(sc, guiaActiva);
                    break;
                case "3":
                    guiaActiva = clonarPaquete(sc, guiaActiva);
                    break;
                case "4":
                    guiaActiva = devolverPaquete(guiaActiva);
                    break;
                case "5":
                    mostrarGuiaActiva(guiaActiva);
                    break;
                case "0":
                    continuar = false;
                    System.out.println("Saliendo del sistema postal...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
                    break;
            }
        }
        sc.close();
    }

    /** pide los datos de un paquete
     * @param sc lector del teclado
     * @return paquete creado */
    private static Paquete capturarPaquete(Scanner sc) {
        System.out.println("\n--- Captura de datos del Paquete ---");
        System.out.print("  Codigo de rastreo (ej. PKG-500): ");
        String codigo = sc.nextLine().trim();

        System.out.print("  Peso fisico en kg (ej. 3.5): ");
        double peso = leerDouble(sc, 1.0);

        System.out.print("  Alto en cm (ej. 20): ");
        double alto = leerDouble(sc, 10.0);

        System.out.print("  Ancho en cm (ej. 20): ");
        double ancho = leerDouble(sc, 10.0);

        System.out.print("  Largo en cm (ej. 30): ");
        double largo = leerDouble(sc, 10.0);

        System.out.print("  Valor declarado en MXN (ej. 800): ");
        double valor = leerDouble(sc, 100.0);

        System.out.print("  ¿Es envio express? (s/n): ");
        boolean express = sc.nextLine().trim().equalsIgnoreCase("s");

        return new Paquete(codigo, peso, alto, ancho, largo, valor, express);
    }

    /** usa un valor por omision si no recibe un numero
     * @param sc lector del teclado
     * @param valorPorOmision valor de respaldo
     * @return numero obtenido */
    private static double leerDouble(Scanner sc, double valorPorOmision) {
        if (sc.hasNextDouble()) {
            double valor = sc.nextDouble();
            sc.nextLine(); // limpia el salto de linea
            return valor;
        }
        sc.nextLine();
        return valorPorOmision;
    }

    /** pide los datos de una persona
     * @param sc lector del teclado
     * @return persona creada */
    private static Persona capturarPersona(Scanner sc) {
        System.out.print("  Identificador (ej. PER-01): ");
        String identificador = sc.nextLine().trim();
        System.out.print("  Nombre completo: ");
        String nombre = sc.nextLine().trim();
        System.out.print("  Ciudad o codigo postal: ");
        String ubicacion = sc.nextLine().trim();
        return new Persona(identificador, nombre, ubicacion);
    }

    /** opcion 1: crea una guia
     * @param sc lector del teclado
     * @return nueva guia */
    private static Envio emitirNuevaGuia(Scanner sc) {
        System.out.println("\n--- Captura de datos del REMITENTE ---");
        Persona remitente = capturarPersona(sc);

        System.out.println("\n--- Captura de datos del DESTINATARIO ---");
        Persona destinatario = capturarPersona(sc);

        Paquete paquete = capturarPaquete(sc);
        Envio nuevaGuia = new Envio(remitente, destinatario, paquete);
        System.out.println("\nGuia emitida con exito:\n" + nuevaGuia);
        return nuevaGuia;
    }

    /** opcion 2: usa las mismas personas con otro paquete
     * @param sc lector del teclado
     * @param guiaActiva guia original
     * @return nueva guia */
    private static Envio clonarGuia(Scanner sc, Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: No hay ninguna guia activa.");
            return null;
        }

        Paquete nuevoPaquete = capturarPaquete(sc);
        Envio nuevaGuia = new Envio(guiaActiva, nuevoPaquete);
        System.out.println("\nGuia clonada:\n" + nuevaGuia);
        return nuevaGuia;
    }

    /** opcion 3: copia el paquete para otra persona
     * @param sc lector del teclado
     * @param guiaActiva guia original
     * @return nueva guia */
    private static Envio clonarPaquete(Scanner sc, Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: No hay ninguna guia activa.");
            return null;
        }

        Paquete copia = new Paquete(guiaActiva.getPaquete());
        String codigoNuevo;
        do {
            System.out.print("  Nuevo codigo de rastreo: ");
            codigoNuevo = sc.nextLine().trim();
            if (codigoNuevo.equals("") || codigoNuevo.equals(copia.getCodigoRastreo())) {
                System.out.println("El codigo debe ser diferente y no estar vacio.");
            }
        } while (codigoNuevo.equals("") || codigoNuevo.equals(copia.getCodigoRastreo()));
        copia.setCodigoRastreo(codigoNuevo);

        System.out.println("\n--- Captura del NUEVO DESTINATARIO ---");
        Persona nuevoDestinatario = capturarPersona(sc);
        Envio nuevaGuia = new Envio(guiaActiva.getRemitente(), nuevoDestinatario, copia);
        System.out.println("\nGuia con paquete clonado:\n" + nuevaGuia);
        return nuevaGuia;
    }

    /** opcion 4: crea la guia para devolver el paquete
     * @param guiaActiva guia original
     * @return guia de retorno */
    private static Envio devolverPaquete(Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: No hay ninguna guia activa.");
            return null;
        }

        Envio retorno = guiaActiva.generarGuiaRetorno();
        System.out.println("\nGuia de retorno:\n" + retorno);
        return retorno;
    }

    /** opcion 5: muestra los datos de la guia
     * @param guiaActiva guia a mostrar */
    private static void mostrarGuiaActiva(Envio guiaActiva) {
        if (guiaActiva == null) {
            System.out.println("Aviso: No hay ninguna guia activa.");
        } else {
            System.out.println("\n" + guiaActiva.toString());
        }
    }
}
