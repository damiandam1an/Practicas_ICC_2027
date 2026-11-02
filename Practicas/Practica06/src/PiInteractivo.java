import java.util.Scanner;

public class PiInteractivo {
	public static void main(String[] args) {

	Scanner entrada = new Scanner(System.in);

	//Declaro el boolean
	boolean datoNoValido = true;

	// Declaro la cantidad de dardos totales que voy a lanzar como 0 para que mas adelante el usuario la modifique.
	int dardosTotales = 1;
	int dardosLanzados = 0;

	//Declaro las variables de los dardos que entran en el circulo y los que no.
	int dardosDentro = 0;
	int dardosFuera = 0;

	// Inicio el ciclo mientras datoNoValido sea true.
	while (datoNoValido) {
		System.out.println("Determina la cantidad de dardos que quieres lanzar");

	//Checho si lo que puso el usuario es un numero.
		if (entrada.hasNextInt()) {
		dardosTotales = entrada.nextInt();

	// Revisa si el numero es menor o igual a cero.
		if (dardosTotales <= 0) {
		System.out.println("Ingresa un numero mayor a cero.");

	// Si es un numero entero mayor a cero termina el ciclo.
			} else {
		datoNoValido = false;
		} 

	// Si lo ingresado no es un numero entero repite el ciclo.
			} else {
			entrada.next();
			System.out.println("Ingresa un numero entero.");
		}	
	}





	//Hago el ciclo que creara coordenadas y las elevara al cuadrado.
	while(dardosLanzados < dardosTotales) {
		double coordenadaX = (Math.random()  * 1);
		double coordenadaY = (Math.random()  * 1);

		double xCuadrada = Math.pow(coordenadaX, 2);
		double yCuadrada = Math.pow(coordenadaY, 2);

	//Sumo ambas coordenadas que eleve al cuadrado.
		double sumaDeCuadrados = xCuadrada + yCuadrada;

	//Actualizo mi variable contador
		dardosLanzados++;

	//Cuento cuantos dardos cayeron dentro del circulo y cuantos quedaron fuera para actualizar sus contadores.
	if(sumaDeCuadrados <= 1.0){
		dardosDentro++;
	} else if(sumaDeCuadrados > 1.0){
		dardosFuera++;
	}

	}

	//Realizo el despeje para calcular la aproximacion de pi.
	double aproximacionPi = (double) dardosDentro / dardosTotales * 4;

	//Imprimo la cantidad de dardos que quedaron fuera, los que quedaron dentro y el resultado del despeje.
	System.out.println("Dardos fuera =" + " " + dardosFuera);
	System.out.println("Dardos dentro =" + " " + dardosDentro);
	System.out.printf("Aproximacion a pi = %.6f\n", aproximacionPi);

	}
}