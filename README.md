# Estimador académico de software

Aplicación de escritorio en Java Swing para el curso de Tópicos en Ingeniería de Software de la Universidad Nacional de Trujillo. Permite explorar cuatro métodos de estimación.

- **COCOMO intermedio:** esfuerzo, duración y costos a partir del tamaño del proyecto y los factores de costo.
- **COCOMO II postarquitectura:** esfuerzo, duración y costos con factores de escala.
- **Puntos de función:** conteo ponderado de entradas, salidas, consultas, archivos e interfaces, con una equivalencia aproximada en líneas de código.
- **Puntos de casos de uso:** conteo ponderado de actores y casos de uso, con factores técnicos y ambientales.

## Ejecutar

El código está configurado para Java 8. Usa un JDK con soporte para ese objetivo y un entorno de escritorio para abrir las ventanas.

### Desde Apache NetBeans

Abre la carpeta raíz con **File → Open Project** y ejecuta **Run Project**. Si NetBeans indica que falta la biblioteca `absolutelayout`, registra una biblioteca con ese nombre y agrega el JAR de AbsoluteLayout a su ruta de clases.

### Desde la terminal

Instala Apache Ant, configura `JAVA_HOME` y descarga [AbsoluteLayout RELEASE230](https://central.sonatype.com/artifact/org.netbeans.external/AbsoluteLayout/RELEASE230) desde Maven Central. Reemplaza la ruta del ejemplo por la ubicación del JAR descargado y ejecuta desde la raíz:

```powershell
ant "-Dlibs.absolutelayout.classpath=C:/ruta/AbsoluteLayout-RELEASE230.jar" clean jar
ant "-Dlibs.absolutelayout.classpath=C:/ruta/AbsoluteLayout-RELEASE230.jar" run
```

El primer comando genera `dist/ProyectoTopicos.jar`. El segundo ejecuta la aplicación con la dependencia en su ruta de clases.

## Ejemplos de verificación

| Módulo | Entradas | Resultado esperado |
| --- | --- | --- |
| Puntos de función | Una entrada de complejidad baja, otros conteos en cero, entorno 4GL | 3 puntos y 120 líneas equivalentes |
| COCOMO intermedio | Modo orgánico, factores nominales, 1000 LDC (o 1 KLDC), costo de 100 por persona-mes en cada etapa | 3,2 persona-mes de esfuerzo, 3,89 meses y costo total de 1280 |
| COCOMO II postarquitectura | 1000 LDC, conductores nominales y factores de escala iniciales | 2,94 persona-mes de esfuerzo y 5,17 meses |
| Puntos de casos de uso | Un actor simple, un caso de uso simple, factores técnicos y ambientales en cero, 20 horas por punto | 6 puntos sin ajustar, 5,04 puntos ajustados y 100,8 horas-persona |

En puntos de función y COCOMO intermedio, prueba también con un campo vacío o con texto. La aplicación debe mostrar qué campo necesita corregirse. COCOMO intermedio pide seleccionar la unidad de tamaño antes de estimar.

## Estructura

- `src/proyectotopicos/` contiene el código Java y los formularios editables en NetBeans.
- `src/img/` contiene las imágenes de la interfaz y las tablas de ayuda.
- `build.xml` y `nbproject/` contienen la configuración de Ant y NetBeans.

