# Práctica 7 :)

En esta práctica hice un programa en Java para una empresa de paquetería usando clases, objetos, constructores, getters, setters y métodos para calcular los costos de envío y revisar si un paquete necesita seguro, también agregue una función propia para cobrar un extra por paquetes frágiles.

## Archivos

**Paquete.java:** Guarda los datos del paquete como peso, dimensiones y valor declarado, también calcula el peso volumétrico y cobrable, **CotizadorEnvio.java:** Revisa que los paquetes sean válidos, calcula el precio del envío y determina si necesitan seguro Y **PruebaPaqueteria.java:** Hace varias pruebas para comprobar que los métodos funcionen correctamente.

## Compilación y ejecución

Desde la carpeta `Practica07`:

**Compilar los tres archivos**

```bash
javac -d bin src/Paquete.java src/CotizadorEnvio.java src/PruebaPaqueteria.java
```

**Ejecutar el programa**

```bash
java -cp bin PruebaPaqueteria
```

**Generar Javadoc**

```bash
javadoc -author -d doc src/Paquete.java src/CotizadorEnvio.java src/PruebaPaqueteria.java
```

La documentación se guarda en la carpeta `doc` y se puede ver abriendo `index.html`.

## Ejemplos

**Paquete.java:** Un paquete de 2 kg con dimensiones de 50 x 40 x 50 cm tiene un peso volumétrico de 20 kg.

**CotizadorEnvio.java:** Un paquete con peso cobrable de 20 kg cuesta $425 y uno con valor declarado mayor a $3,000 necesita seguro.

**PruebaPaqueteria.java:** Se prueban 6 casos, entre ellos uno donde el paquete cuesta $120 y al marcarlo como frágil aumenta a $155.
