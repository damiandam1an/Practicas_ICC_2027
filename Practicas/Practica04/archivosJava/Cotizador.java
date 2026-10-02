/*
 * Práctica 4 - Actividad 3: Cotizador del señor Pines.
 * Versión del grupo con comentarios de su laboratorista.
 *
 * IMPORTANTE: Si ustedes quieren seguir una estrategía
 * diferente a la que sigue este documento, o ya tienen una
 * concluida una implementación, lo pueden dejar asi sin
 * ningún problema.
 *
 * No es necesario que modifiquen su implementación para
 * seguir la estrategía que sugirieron hace rato.
 *
 * Por otro lado, si quieren basarse de este documento,
 * también esta más que perfecto. Hace rato todos asistieron
 * al laboratorio, asi que no hay bronca ;).
 */
public class Cotizador {
    public static void main(String[] args) {

	
        // ===== Datos del cliente =====
  

	/**
	   El nombre de Robbie esta bien. El nombre de la variable,
	   lo pueden dejar como ustedes quieran: como lo vimos en el
	   labo, con este nombre sugerido o con el nombre que quieran.
	   Por ahora, el nombre la variable no influte tanto...
	*/
        String nombreCliente = "Robbie Valentino";

	
	/**
	   Esto les salio bien. Lo usaremos cuando veamos if/else.
	*/
        char clasificacionCliente = 'E';

	
	/**
	   Este fue un debate interesante...
	   Hay varias maneras de representar un precio, pero vamos a reducirlo
	   a dos solamente: Int ó Double.
	   Se puede solucionar bien con ambos, aunque si es un poco más
	   talachudo hacerlo con double (como comentaban hacer rato).
	   Por ahora, mi recomendación sería que los datos que por naturaleza 
	   son enteros van en int. Todo lo que sale de un cálculo con porcentajes
	   va en double ;).
	*/
        int precioProducto = 12899;
	

        // ===== Datos del crédito =====

	
	/**
	   Para ir de la mano con el comentario anterior, este se queda con double.
	*/
        double tasaAnual = 0.15;

	
	/**
	   Vamos a guardar el plazo de los meses en una variable, pues lo necesitarán después.
	*/
        int plazoMeses = 21;

	
	/**
	    ¡Bien por usar 12.0!
	 */
        double plazoAnios = plazoMeses / 12.0;

	
        // ===== Cálculos =====

	/**
	   Este también fue un debate interesante hace rato.
	   Sabemos que en el mundo real, el calcular interes de un crédito no
	   es algo tan sencillo. Se deben tomar en cuenta muchos factores. Muchos...
	   Para quitarnos esta bronca de encima, les recomiendo seguir con la formula
	   que propucieron hace rato.

	   Sabemos que a algún banquero profesional ve el calculo que estamos haciendo,
	   seguro le dará un infarto. Pero para fines prácticos, digamos que esta formula
	   esta bien.
	 */
        double interes = precioProducto * tasaAnual * plazoAnios;
        double totalAPagar = precioProducto + interes;

        // PENDIENTE: mensualidad.
        // Pista: ¿el total se reparte entre años o entre meses?...
		double mensualidad = totalAPagar / plazoMeses;
        // ===== Reporte en terminal =====

        System.out.printf("Cliente: %s%n", nombreCliente);
		System.out.printf("Clasificacion: %c%n", clasificacionCliente);

        // Aun queda pendiente imprimir precio, tasa, plazo, interés, total y mensualidad.
		System.out.printf("Precio de la laptop: $%d%n", precioProducto);
		System.out.printf("Interes anual: %.0f%%%n", tasaAnual * 100);
		System.out.printf("Plazo: %d meses%n", plazoMeses);
		System.out.printf("Intereses: $%.2f%n", interes);
		System.out.printf("Total a pagar: $%.2f%n", totalAPagar);
		System.out.printf("Mensualidad: $%.2f%n", mensualidad);

    }
}
