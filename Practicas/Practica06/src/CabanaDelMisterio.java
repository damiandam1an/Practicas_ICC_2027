import java.util.Scanner;

public class CabanaDelMisterio {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Datos del cliente
        String nombreCliente = "";
        String clasificacionCliente = "E";

        // Datos del prestamo
        double capital = 0;
        double tasaAnual = 1;
        int plazoMeses = 1;

        // variables de control
        boolean datoNoValido = true;
        boolean capitalNoValida = true;
        double ajusteTasa = 0;
        int opcion = 0;
        int operacionesEfectivas = 0;
        int errores = 0;

        // Nombre completo del cliente
        System.out.println("Ingrese el nombre completo del cliente: ");
        nombreCliente = entrada.nextLine();

        //
        // Valido la clasificacion del cliente
        while(datoNoValido) {

        System.out.println("Ingrese la clasificacion del cliente (E, R, P): ");

        if (entrada.hasNext("E|P|R")) {

            // Reviso si hay que restar o sumar a la tasa
            if(entrada.hasNext("P")) {
                ajusteTasa = -2;
            } else if(entrada.hasNext("R")) {
                ajusteTasa = 3;
            }
            clasificacionCliente = entrada.next();
            datoNoValido = false;

        } else {
            entrada.next();
            System.out.println("Error: Ingrese unicamente E, P o R.");
        }

        }

        // Valido que sea un numero mayor a cero
        // capital
        while(datoNoValido == false) {

        System.out.println("Ingrese el monto de la capital completo: ");

            if (entrada.hasNextDouble()) {
                capital = entrada.nextDouble();

            if (capital <= 0) {
                System.out.println("Error: La capital debe ser un numero mayor a cero.");
            } else {
                datoNoValido = true;
            }
            } else {
                entrada.next();
                System.out.println("Error: La capital debe ser un numero.");
            }

        } 

        // Valido que la tasa sea un numero y no sea negativa
        // tasa anual
        // Valido la clasificacion del cliente
        while(datoNoValido) {
            System.out.println("Ingrese la tasa anual total:");
            if (entrada.hasNextDouble()) {
                tasaAnual = entrada.nextDouble();

            if (tasaAnual < 0) {
                System.out.println("Error: La tasa anual debe ser un numero mayor a cero.");
            } else {
                datoNoValido = false;
            }
            } else {
                entrada.next();
                System.out.println("Error: La tasa anual debe ser un numero.");
            }
        }  

        // Valido que el plazo sea un entero mayor a cero
        // plazo en meses
        while(datoNoValido == false) {
            System.out.println("Ingrese el plazo en meses:");

            if (entrada.hasNextInt()) {
                plazoMeses = entrada.nextInt();

            if (plazoMeses <= 0) {
                System.out.println("Error: El plazo a meses debe ser un numero entero mayor a cero");
            } else {
                datoNoValido = true;
            }
            } else {
                entrada.next();
                System.out.println("Error: El plazo a meses debe ser un numero entero.");
            }
        } 

        // Ajusto la tasa
        double tasaAplicda = tasaAnual + ajusteTasa;
        if (clasificacionCliente == "P") {
            tasaAplicda = tasaAnual - 2;
        } else if (clasificacionCliente == "E") {
            tasaAplicda = tasaAnual;
        } else if (clasificacionCliente == "R") {
            tasaAplicda = tasaAnual + 3;
        }           

        // Repito el menu hasta salir o llegar al limite de operaciones o errores
        while (datoNoValido && operacionesEfectivas < 5 && errores < 3) {

        System.out.println("\n##### Sistema de prestamos de la Cabana del misterio #####");
        System.out.println("> Las operaciones disponibles son");
        System.out.println("1) Cotizar con interes simple.");
        System.out.println("2) Cotizar con interes compuesto.");
        System.out.println("3) Comparar interes simple y compuesto.");
        System.out.println("4) Cambiar el capital del prestamo.");
        System.out.println("0) Salir.");
        System.out.println("> Por favor, elige una opcion :");

        // Reviso que el usuario escriba un numero entero
        if (entrada.hasNextInt()) {
            opcion = entrada.nextInt();

            // interes simple
            // Calculo los datos para las operaciones del menu
            double plazoAnios = plazoMeses / 12.0;
            double interes = capital * (tasaAplicda / 100) * plazoAnios;
            double totalAPagar = capital + interes;
            double mensualidad = totalAPagar / plazoMeses;  
            double tasaMensual = tasaAplicda / 100 / 12;
            double saldoAcumulado = capital;    
        if (opcion == 1) {
            operacionesEfectivas++;
            System.out.println("\n+++++ Cotizador de La Cabana del Misterio +++++\n");
            System.out.println("--- Datos del cliente ---");
            System.out.printf("Cliente: %s%n", nombreCliente);
            System.out.printf("Clasificacion: %s%n", clasificacionCliente);
            System.out.println();
            System.out.println("--- Datos del prestamo ---");
            System.out.printf("Capital: $%.2f%n", capital);
            System.out.printf("Tasa base: %.2f%%%n", tasaAnual);
            System.out.printf("Tasa aplicada: %.2f%%%n", tasaAplicda);  
            System.out.printf("Plazo: %d meses (%.2f anios)%n", plazoMeses, plazoAnios);
            System.out.println();
            System.out.println("--- Interes simple ---");
            System.out.printf("Interes simple: $%.2f%n", interes);
            System.out.printf("Total a pagar: $%.2f%n", totalAPagar);
            System.out.printf("Mensualidad: $%.2f%n", mensualidad);
  

          // Opcion 2: calculo el interes compuesto
          } else if (opcion == 2) {
            operacionesEfectivas++;           
            System.out.println("\n+++++ Cotizador de La Cabana del Misterio +++++\n");
            System.out.println("--- Datos del cliente ---");
            System.out.printf("Cliente: %s%n", nombreCliente);
            System.out.printf("Clasificacion: %s%n", clasificacionCliente);
            System.out.println();
            System.out.println("--- Datos del prestamo ---");
            System.out.printf("Capital: $%.2f%n", capital);
            System.out.printf("Tasa base: %.2f%%%n", tasaAnual);
            System.out.printf("Tasa aplicada: %.2f%%%n", tasaAplicda);  
            System.out.printf("Plazo: %d meses (%.2f anios)%n", plazoMeses, plazoAnios);
            System.out.println();
            System.out.println("--- Interes compuesto ---");
            System.out.println("--- Saldo mes por mes ---");
            saldoAcumulado = capital;
            // Acumulo el interes mes por mes
            for (int mes = 1; mes <= plazoMeses; mes++) {
            saldoAcumulado = saldoAcumulado * (1 + tasaMensual);
            System.out.printf("Mes %d: $%.2f%n", mes, saldoAcumulado);
            } 
            double interesCompuesto = saldoAcumulado - capital;    
            System.out.println();
            System.out.printf("Interes compuesto: $%.2f%n", interesCompuesto);
            System.out.printf("Total con interes compuesto: $%.2f%n", saldoAcumulado);

        // Opcion 3: comparo los dos intereses
        } else if (opcion == 3) {
            operacionesEfectivas++;
            saldoAcumulado = capital;
            for (int mes = 1; mes <= plazoMeses; mes++) {
            saldoAcumulado = saldoAcumulado * (1 + tasaMensual);
            }        
            double interesCompuesto = saldoAcumulado - capital;

            System.out.printf("Interes simple: $%.2f%n", interes);            
            System.out.printf("Interes compuesto: $%.2f%n", interesCompuesto);

            // Reviso cual interes es mayor y calculo la diferencia
            if (interes > interesCompuesto) {
                double diferenciaInteres = interes - interesCompuesto;
                System.out.printf("El interes simple es mayor que el compuesto por: $%.2f%n", + diferenciaInteres); 
            } else if (interesCompuesto > interes) {
                double diferenciaCompuesto = interesCompuesto - interes;
                System.out.printf("El interes compuesto es mayor que el simple por: $%.2f%n", + diferenciaCompuesto); 
            } else {
                System.out.printf("Ambos intereses son iguales."); 
            }

        // Opcion 4: cambio el capital del prestamo
        } else if (opcion == 4) {
            operacionesEfectivas++;
            // Reinicio la validacion para poder cambiarlo otra vez
            capitalNoValida = true;
            while (capitalNoValida) {
                System.out.printf("Ingrese la nueva capital:"); 
            if (entrada.hasNextDouble()) {
                capital = entrada.nextDouble();

            if (capital <= 0) {
                System.out.println("Error: La capital debe ser un numero mayor a cero.");
            } else {
                capitalNoValida = false;
            }
            } else {
                entrada.next();
                System.out.println("Error: La capital debe ser un numero.");
            }
            }

        // Opcion 0: muestro el resumen y salgo del programa
        } else if (opcion == 0) {
            datoNoValido = false;
            System.out.println("\n+++++ Cotizador de La Cabana del Misterio +++++\n");
            System.out.println("--- Datos del cliente ---");
            System.out.printf("Cliente: %s%n", nombreCliente);
            System.out.printf("Operaciones efectivas: " + operacionesEfectivas);
            System.out.printf("\nErrores en el menu: " + errores);
            System.out.printf("\nCapital: $%.2f%n", capital);
            System.out.printf("Motivo: El usuario eligio salir.");
            System.out.println("\nGracias por utilizar el Cotizador De La Cabania Del Misterio (S.A. de C.V.)");  

        } else {
            // Cuento los numeros que no estan en el menu
            System.out.println("Error: Seleccione unicamente una de las opciones disponibles.");
            errores++;
        }
        } else {
            entrada.next();
            // Cuento las entradas que no son numeros enteros
            System.out.println("Error: Debe ingresar un numero.");
            errores++;
        }

        } 
        // Muestro el resumen si se alcanza alguno de los limites
        if (operacionesEfectivas == 5 || errores == 3) {

    if (operacionesEfectivas == 5) {
        System.out.println("\nSe alcanzo el limite de 5 operaciones.");
        } else {
            System.out.println("\nSe alcanzo el limite de 3 errores.");
        }

        // Resumen final
        System.out.println("\n+++++ Resumen final +++++");
        System.out.printf("Cliente: %s%n", nombreCliente);
        System.out.printf("Operaciones efectivas: %d%n", operacionesEfectivas);
        System.out.printf("Errores en el menu: %d%n", errores);
        System.out.printf("Capital final: $%.2f%n", capital);

        if (operacionesEfectivas == 5) {
            System.out.println("Motivo: Limite de operaciones alcanzado.");
        } else {
            System.out.println("Motivo: Limite de errores alcanzado.");
        }

        System.out.println("\nGracias por utilizar el Cotizador De La Cabania Del Misterio (S.A. de C.V.)");
    }

    }
}

