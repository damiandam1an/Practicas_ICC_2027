public class ProgramaNuevo {
    public static void main(String[] args) {

    // Nombre del producto
    String producto = "Laptop para la carrera";
    // Precio de la Laptop
    int precio = 15000;
    // Descuento que aplicaremos a la Laptop
    int descuento = 3000;
    // Meses sin intereses
    double meses = 18.0;

    // Indicamos el inicio de la ficha
    System.out.println("=== Ficha de compra ===");
    // Mostramos los cuatro datos de la compra con un solo printf
    System.out.printf(
            "- Producto : %s%n"
            + "- Precio con descuento : %d%n"
            + "- Plazo de pago en años : %.1f%n"
            + "- Pago mensual : %.2f%n",
            producto,
            (precio - descuento),
            (meses / 12.0),
            ((precio - descuento) / meses)
        );
    // Indicamos el cierre de la ficha
    System.out.println("=== Fin de la ficha ===");

    }
}
