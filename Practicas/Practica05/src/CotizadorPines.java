/*
 * Cotizador del senor Pines: calcula el interes simple de un prestamo,
 * el total a pagar y la mensualidad.
 */
public class CotizadorPines {
    public static void main(String[] args) {

        // Datos del cliente
        String nombreCliente = "Robbie Valentino";
        char clasificacionCliente = 'E';

        // Datos del prestamo
        double capital = 12899.0;
        double tasaAnual = 15.0;
        int plazoMeses = 21;

        // Valido los datos
        boolean tipoValdo = clasificacionCliente == 'P' || clasificacionCliente == 'E' || clasificacionCliente == 'R';

        if (capital <= 0) {
            System.out.println("Error: el capital debe ser mayor que cero.");
            return;
        }
        if (tasaAnual <= 0) {
            System.out.println("Error: la tasa debe ser mayor que cero.");
            return;
        }
        if (plazoMeses <= 0) {
            System.out.println("Error: el plazo debe ser mayor que cero.");
            return;
        }
        if (tipoValdo == false) {
            System.out.println("Error: la clasificacion debe ser P, E o R.");
            return;
        }

        // Ajusto la tasa
        double tasaAplicda = tasaAnual;
        if (clasificacionCliente == 'P') {
            tasaAplicda = tasaAnual - 2;
        } else if (clasificacionCliente == 'E') {
            tasaAplicda = tasaAnual;
        } else {
            tasaAplicda = tasaAnual + 3;
        }

        // Calculos
        double plazoAnios = plazoMeses / 12.0;
        double interes = capital * (tasaAplicda / 100) * plazoAnios;
        double totalAPagar = capital + interes;
        double mensualidad = totalAPagar / plazoMeses;

        // Resultados
        System.out.println("\n+++++ Cotizador de La Cabana del Misterio +++++\n");
        System.out.println("--- Datos del cliente ---");
        System.out.printf("Cliente: %s%n", nombreCliente);
        System.out.printf("Clasificacion: %c%n", clasificacionCliente);
        System.out.println();
        System.out.println("--- Datos del prestamo ---");
        System.out.printf("Capital: $%.2f%n", capital);
        System.out.printf("Tasa base: %.2f%%%n", tasaAnual);
        System.out.printf("Tasa aplicada: %.2f%%%n", tasaAplicda);
        System.out.printf("Plazo: %d meses (%.2f anios)%n", plazoMeses, plazoAnios);
        System.out.println();
        System.out.println("--- Resultado ---");
        System.out.printf("Interes total: $%.2f%n", interes);
        System.out.printf("Total a pagar: $%.2f%n", totalAPagar);
        System.out.printf("Mensualidad: $%.2f%n", mensualidad);
        System.out.println();

        // Calculo el interes compuesto
        double tasaMensual = tasaAplicda / 100 / 12;
        double saldoAcumulado = capital;

        System.out.println("--- Saldo mes por mes ---");
        for (int mes = 1; mes <= plazoMeses; mes++) {
            saldoAcumulado = saldoAcumulado * (1 + tasaMensual);
            System.out.printf("Mes %d: $%.2f%n", mes, saldoAcumulado);
        }

        // Comparo los resultados
        double interesCompuesto = saldoAcumulado - capital;
        double totalConFormula = capital * Math.pow(1 + tasaMensual, plazoMeses);

        System.out.println();
        System.out.printf("Interes compuesto: $%.2f%n", interesCompuesto);
        System.out.printf("Total con interes compuesto: $%.2f%n", saldoAcumulado);
        System.out.printf("Total con Math.pow: $%.2f%n", totalConFormula);
    }
}
