# Práctica 9: Agregación, clonación de objetos y guías de envío

**Introducción a las Ciencias de la Computación - Semestre 2027-1**  
**Facultad de Ciencias, UNAM**

En esta práctica trabajé con un sistema postal que relaciona personas y paquetes mediante guías de envío le puse lo que es la clonación de paquetes y guías además de los folios automáticos y las devoluciones. Se comento que el README serviria como nuestro reporte por eso lo hago de esta manera!!

### Persona.java

Use tres atributos privados para guardar el identificador y el nombre y la ubicación de cada persona agregué un constructor por omisión y otro con parámetros para crear los objetos. Los setters revisan que los datos no estén vacíos y los métodos de comparación permiten saber si dos personas tienen la misma ubicación o identificador.

### Envio.java

La clase guarda las referencias del remitente y destinatario junto con su paquete puse `static` para contar las guías emitidas y `Math.random()` para la parte aleatoria también agregué los métodos para calcular el costo del envío y generar una devolución invirtiendo las personas y copiando el paquete.

### Paquete.java

Completé el constructor por copia para duplicar un paquete sin modificar el original y el método `toString()` para mostrar sus datos.

## Compilación y ejecución

Ejecutar desde la carpeta `practica09`

### Para compilar

```bash
javac -d bin src/*.java
```

### Ejecutar las pruebas

```bash
java -cp bin PruebaEnvio
```

### El menú interactivo

```bash
java -cp bin MenuPostal
```

### El Javadoc

```bash
javadoc -d doc -author -version src/*.java
```

## Evidencias

### 1. Pruebas y simulación de PruebaEnvio

```text
================================================================================
  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO
================================================================================

>>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE
  [OK]    toString muestra el codigo
  [OK]    toString muestra los pesos y el valor
  [OK]    el paquete clonado es independiente
  [OK]    cambiar el clon no cambia el original
  [OK]    el constructor por copia acepta null

>>> PARTE 2: VERIFICACION DE LA CLASE PERSONA
  [OK]    dos personas pueden tener la misma ubicacion
  [OK]    las ciudades diferentes no coinciden
  [OK]    no se puede comparar con null
  [OK]    el mismo identificador representa a la misma persona
  [OK]    identificadores diferentes son personas diferentes
  [OK]    la comparacion de identidad rechaza null
  [OK]    el texto de persona incluye sus datos
  [OK]    los valores por omision no estan vacios
  [OK]    un setter no acepta un nombre vacio

>>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS
  [OK]    al inicio hay cero guias
  [OK]    la primera guia tiene folio 1
  [OK]    la segunda guia tiene folio 2
  [OK]    los folios no son iguales
  [OK]    el contador marca dos guias
  [OK]    la primera guia es local
  [OK]    la segunda guia es foranea
  [OK]    el envio local no tiene cargo extra
  [OK]    el envio foraneo suma 80 pesos
  [OK]    personas diferentes no son autoenvio
  [OK]    no acepta destinatario null
  [OK]    permite cambiar el destinatario
  [OK]    el mismo identificador permite autoenvio

>>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO

primer envio de x a y:
--- guia de envio ---
folio: GUIA-726-3
remitente: ana lopez | id: PER-01 | ubicacion: cdmx
destinatario: luis perez | id: PER-02 | ubicacion: CDMX
paquete: codigo: KIT-101 | peso real: 4.0 kg | peso volumetrico: 1.6 kg | peso cobrable: 4.0 kg | valor: $500.0 | express: no
tipo: local
envio personal: no
costo total: $120.0

segundo envio de x a y:
--- guia de envio ---
folio: GUIA-554-4
remitente: ana lopez | id: PER-01 | ubicacion: cdmx
destinatario: luis perez | id: PER-02 | ubicacion: CDMX
paquete: codigo: PKG-202 | peso real: 12.0 kg | peso volumetrico: 7.2 kg | peso cobrable: 12.0 kg | valor: $1500.0 | express: no
tipo: local
envio personal: no
costo total: $246.0
  [OK]    la guia clonada conserva las mismas personas
  [OK]    la guia clonada usa el paquete nuevo
  [OK]    la guia clonada tiene otro folio

kit clonado enviado a z:
--- guia de envio ---
folio: GUIA-613-5
remitente: ana lopez | id: PER-01 | ubicacion: cdmx
destinatario: sofia ramirez | id: PER-03 | ubicacion: puebla
paquete: codigo: KIT-103 | peso real: 4.0 kg | peso volumetrico: 1.6 kg | peso cobrable: 4.0 kg | valor: $500.0 | express: no
tipo: foraneo
envio personal: no
costo total: $200.0
  [OK]    el paquete para z es una copia distinta
  [OK]    el kit para z tiene otro codigo
  [OK]    el envio a z es foraneo
  [OK]    la guia para z tiene folio 5

devolucion de y a x:
--- guia de envio ---
folio: GUIA-691-6
remitente: luis perez | id: PER-02 | ubicacion: CDMX
destinatario: ana lopez | id: PER-01 | ubicacion: cdmx
paquete: codigo: RET-KIT-101 | peso real: 4.0 kg | peso volumetrico: 1.6 kg | peso cobrable: 4.0 kg | valor: $500.0 | express: no
tipo: local
envio personal: no
costo total: $120.0
  [OK]    el retorno invierte las personas
  [OK]    el retorno copia el paquete
  [OK]    el codigo de retorno empieza con ret
  [OK]    el retorno tiene folio 6
  [OK]    se emitieron seis guias

total de guias emitidas: 6

================================================================================
  RESUMEN DE PRUEBAS: 39 / 39 pruebas superadas con exito
================================================================================
```

### 2. Ejemplo de ejecución de MenuPostal

Ejemplo con la opción 1 para emitir una guía y la opción 5 para consultar su costo

```text
================================================================
  SISTEMA INTERACTIVO DE GUIAS POSTALES | ICC 2027-1
================================================================

--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
0. Salir
Seleccione una opcion: 1

--- Captura de datos del REMITENTE ---
  Identificador (ej. PER-01): PER-01
  Nombre completo: ana lopez
  Ciudad o codigo postal: cdmx

--- Captura de datos del DESTINATARIO ---
  Identificador (ej. PER-01): PER-02
  Nombre completo: luis perez
  Ciudad o codigo postal: cdmx

--- Captura de datos del Paquete ---
  Codigo de rastreo (ej. PKG-500): KIT-101
  Peso fisico en kg (ej. 3.5): 4
  Alto en cm (ej. 20): 20
  Ancho en cm (ej. 20): 20
  Largo en cm (ej. 30): 20
  Valor declarado en MXN (ej. 800): 500
  ¿Es envio express? (s/n): n

Guia emitida con exito:

--- guia de envio ---
folio: GUIA-362-1
remitente: ana lopez | id: PER-01 | ubicacion: cdmx
destinatario: luis perez | id: PER-02 | ubicacion: cdmx
paquete: codigo: KIT-101 | peso real: 4.0 kg | peso volumetrico: 1.6 kg | peso cobrable: 4.0 kg | valor: $500.0 | express: no
tipo: local
envio personal: no
costo total: $120.0

--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
0. Salir
Seleccione una opcion: 5


--- guia de envio ---
folio: GUIA-362-1
remitente: ana lopez | id: PER-01 | ubicacion: cdmx
destinatario: luis perez | id: PER-02 | ubicacion: cdmx
paquete: codigo: KIT-101 | peso real: 4.0 kg | peso volumetrico: 1.6 kg | peso cobrable: 4.0 kg | valor: $500.0 | express: no
tipo: local
envio personal: no
costo total: $120.0

--- MENU PRINCIPAL ---
1. Emitir nueva guia de envio
2. Clonar guia activa con un nuevo paquete (mismo remitente y destinatario)
3. Clonar paquete de la guia activa para enviarlo a otro destinatario
4. Generar guia de retorno (devolucion al remitente)
5. Mostrar detalle y costo de la guia activa
0. Salir
Seleccione una opcion: 0
Saliendo del sistema postal...
```

Los números aleatorios de los folios cambian al ejecutar otra vez el programa.

## Preguntas de reflexion

### 1. ¿En qué se diferencia clonar un `Paquete` (`new Paquete(kitBase)`) de clonar una guía de `Envio` (`new Envio(guiaBase, nuevoPaquete)`) respecto a qué objetos se comparten y cuáles se duplican en memoria?

Al clonar un paquete se crea otro objeto independiente con los mismos datos mientras que al clonar una guía se conservan las referencias al remitente y destinatario pero se utiliza otro paquete y se genera un folio nuevo.

### 2. Para generar el `folioGuia` con un número consecutivo global y consultar cuántas guías se han emitido en total, ¿qué modificador tuviste que utilizar en ese atributo y en su método de consulta? ¿Por qué no funcionaría si el contador fuera un atributo normal de instancia?

Utilicé `static` en el contador y en su método de consulta para que todas las guías compartan el mismo total porque con un atributo de instancia cada objeto llevaría su propia cuenta.

### 3. Si una guía `envio1` se descarta (`envio1 = null;`), ¿qué ocurre en memoria con los objetos `Persona` (remitente/destinatario) y `Paquete` que estaban asociados a ella?

La variable deja de apuntar a la guía pero las personas y el paquete siguen existiendo si tienen otras referencias mientras que los objetos sin referencias pueden ser eliminados por el recolector de basura.
