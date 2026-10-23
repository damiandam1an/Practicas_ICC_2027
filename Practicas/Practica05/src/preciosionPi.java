public class preciosionPi {
	public static void main(String[] args) {
		//Declaro la tolerancia la estimacion inicial y los contadores de dardos
		double tolerancia = 0.1;
		double estimacion = 0;
		double errorDeEstimacion = Math.abs(estimacion - Math.PI);
		int dardosTotales = 0;
		int dardosDentro = 0;

		//Hago el ciclo que se repetira mientras el error de estimacion sea mayor o igual a mi tolerancia
	while(errorDeEstimacion >= tolerancia){
		double coordenadaX = (Math.random()  * 1);
		double coordenadaY = (Math.random()  * 1);

		double xCuadrada = Math.pow(coordenadaX, 2);
		double yCuadrada = Math.pow(coordenadaY, 2);
		// Sumo ambas coordenadas que eleve al cuadrado.
		double sumaDeCuadrados = xCuadrada + yCuadrada;
		//Actualizacion
		dardosTotales++;
		//Checo si el dardo cayo dentro del circulo para actualizar el contador.
		estimacion = (double) dardosDentro / dardosTotales * 4;
		errorDeEstimacion = Math.abs(estimacion - Math.PI);

	if(sumaDeCuadrados <= 1){
		dardosDentro++;
	}

	}
	//Imprimo los resultados finales! :)
	System.out.println("Dardos totales =" + " " + dardosTotales);
	System.out.printf("Estimacion de pi = %.6f\n", estimacion);

	}
}