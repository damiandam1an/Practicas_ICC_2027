public class EstimacionPi {
	public static void main(String[] args) {

	// Declaro la cantidad de dardos totales que voy a lanzar.
	int dardosTotales = 1000000;
	int dardosLanzados = 0;

	//Declaro las variables de los dardos que entran en el circulo y los que no.
	int dardosDentro = 0;
	int dardosFuera = 0;

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