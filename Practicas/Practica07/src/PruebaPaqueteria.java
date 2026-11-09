/**
 * prueba los paquetes y sus costos de envio.
 * @author Damian Pedro Aguilar Gil
 */
public class PruebaPaqueteria {

    /**
     * realiza los casos de prueba.
     * @param args argumentos del programa
     */
    public static void main(String[] args) {
        System.out.println("PRUEBAS DEL SISTEMA DE ENVIOS");
        System.out.println();

        // caso 1: peso fisico mayor
        System.out.println("--- Caso 1: Paquete pequeno ---");
        Paquete p1 = new Paquete("PK-001", 3.5, 20.0, 15.0, 10.0, 800.0);
        mostrarDetallePaquete(p1);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(p1));
        System.out.printf("Costo: $%.2f (Esperado: $120.00)\n",
                          CotizadorEnvio.cotizarEnvio(p1));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p1));
        System.out.println();

        // caso 2: peso volumetrico mayor
        System.out.println("--- Caso 2: Paquete voluminoso ---");
        Paquete p2 = new Paquete("PK-002", 2.0, 50.0, 40.0, 50.0, 1500.0);
        mostrarDetallePaquete(p2);
        if (CotizadorEnvio.esPaqueteValido(p2)) {
            System.out.printf("Peso volumetrico: %.2f kg\n",
                              p2.calculaPesoVolumetrico());
            System.out.printf("Peso cobrable: %.2f kg\n",
                              p2.obtenerPesoCobrable());
        }
        System.out.printf("Costo: $%.2f (Esperado: $425.00)\n",
                          CotizadorEnvio.cotizarEnvio(p2));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p2));
        System.out.println();

        // caso 3: seguro por valor
        System.out.println("--- Caso 3: Paquete de alto valor ---");
        Paquete p3 = new Paquete("PK-003", 4.0, 30.0, 25.0, 20.0, 6500.0);
        mostrarDetallePaquete(p3);
        System.out.printf("Costo: $%.2f\n", CotizadorEnvio.cotizarEnvio(p3));
        System.out.println("Requiere seguro?: " +
                           CotizadorEnvio.requiereSeguro(p3) + " (Esperado: true)");
        System.out.println();

        // caso 4: seguro por dimensiones
        System.out.println("--- Caso 4: Paquete grande ---");
        Paquete p4 = new Paquete("PK-004", 5.0, 70.0, 30.0, 20.0, 1200.0);
        mostrarDetallePaquete(p4);
        System.out.println("Requiere seguro?: " +
                           CotizadorEnvio.requiereSeguro(p4) + " (Esperado: true)");
        System.out.println();

        // caso 5: diferencia entre null y un objeto
        System.out.println("--- Caso 5: Paquete null ---");
        Paquete pNulo = null;
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(pNulo));
        System.out.printf("Costo: $%.2f (Esperado: $-1.00)\n",
                          CotizadorEnvio.cotizarEnvio(pNulo));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(pNulo));

        Paquete pDefecto = new Paquete();
        System.out.println("Es valido uno creado por defecto?: " +
                           CotizadorEnvio.esPaqueteValido(pDefecto));
        System.out.println();

        // caso 6: recargo por paquete fragil
        System.out.println("--- Caso 6: Propuesta personal ---");
        Paquete p5 = new Paquete("PK-005", 2.0, 20.0, 20.0, 20.0, 500.0);
        System.out.println("Fragil?: " + p5.isFragil());
        System.out.printf("Recargo: $%.2f\n", p5.calcularRecargoFragil());
        System.out.printf("Costo sin recargo: $%.2f\n",
                          CotizadorEnvio.cotizarEnvio(p5));

        p5.setFragil(true);
        System.out.println("Fragil?: " + p5.isFragil());
        System.out.printf("Recargo: $%.2f\n", p5.calcularRecargoFragil());
        System.out.printf("Costo con recargo: $%.2f\n",
                          CotizadorEnvio.cotizarEnvio(p5));
    }

    /**
     * muestra los datos principales de un paquete.
     * @param p paquete que se imprime
     */
    private static void mostrarDetallePaquete(Paquete p) {
        if (!CotizadorEnvio.esPaqueteValido(p)) {
            System.out.println("Paquete no valido");
            return;
        }
        System.out.println("Codigo: " + p.getCodigoRastreo());
        System.out.println("Peso fisico: " + p.getPesoFisico() + " kg");
        System.out.println("Dimensiones: " + p.getLargo() + " x " +
                           p.getAncho() + " x " + p.getAlto() + " cm");
        System.out.println("Valor declarado: $" + p.getValorDeclarado());
    }
}
