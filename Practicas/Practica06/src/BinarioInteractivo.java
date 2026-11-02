import java.util.Scanner;

	public class BinarioInteractivo {
		public static void main (String[] args)	{

		 Scanner entrada = new Scanner(System.in);	

		 boolean datoNoValido = true;	
		 int numero = 0;
		 String binario = "";
		 String respuesta = "";

		 //Repite el programa si el usuario quiere convertir otro numero.
		 do {

		 // Solicita un numero hasta que sea valido.
		 	while (datoNoValido) {

		 	System.out.println("Ingrese un numero entero:");

		 // Verifica que el dato ingresado sea un numero entero.
		 if (entrada.hasNextInt()) {
		 	numero = entrada.nextInt();

		 //Verifica que el numero ingresado no sea negativo.
		 	if (numero < 0) {
		 		System.out.println("Dato invalido: El entero debe ser positivo");
		 //Si el numero ingresado es 0 el binario devuelve 0.
		 	} else if (numero == 0) {
		 		datoNoValido = false;
		 		binario = "0";
		 	} else {
		 		datoNoValido = false;
		 	}

		 	} else {
		 		entrada.next();
		 		System.out.println("Dato invalido: Ingrese un numero entero");
		 	}
		 	}

		 	//Conversion a binario.
		 	while (numero > 0){
		 		int residuo = numero % 2;
		 		binario = residuo + binario;
		 		numero = numero / 2;


		 	}	

		 //Imprimimos el resultado y preguntamos al usuario si quiere convertir otro numero.
		 System.out.println("Conversion a binario: " + binario);
		 System.out.println("Desea realizar otra conversion? s/n");
		 binario = "";

		 //Pide al usuario que ingrese su respuesta y si responde s o S repite el programa.
		 if (entrada.hasNext("s|S")) {
		 	respuesta = entrada.next();
		 	datoNoValido = true;

		 } else {
		 	datoNoValido = false;
		 }


		 } while (datoNoValido); {
		 }


		 }
	}