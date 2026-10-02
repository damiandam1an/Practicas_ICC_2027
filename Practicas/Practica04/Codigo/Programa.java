public class Programa{	
	public static void main(String[] args) {
	
	// Nombre del producto
	String producto = "Laptop para la carrera";
	// Precio de la Laptop
	int precio = 15000;
	// Descuento que aplicaremos a la Laptop
	int descuento = 3000;
	// Meses sin intereses
	double meses = 18.0;

	// Indicamos el inicio de la ficha de compra
	System.out.println("=== Ficha de compra ===");
	// Indicamos el nombre del producto
	System.out.println("- Producto : " + producto);
	// Calculamos el precio con descuento restando el descuento del precio total
	System.out.println("- Precio con descuento : " + (precio - descuento));
	// Calculamos el plazo de pago en años dividiendo los meses sin intereses entre los un año (12 meses)
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));
	// Calculamos el pago mensual dividiendo el precio con descuento entre los meses sin intereses
	System.out.println("- Pago mensual : " + ((precio - descuento) / meses));
	// Indicamos el cierre de la ficha
	System.out.println("=== Fin de la ficha ===");

	}
}