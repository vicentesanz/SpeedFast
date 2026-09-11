# SpeedFast

## Descripción

Proyecto desarrollado para las actividades de Desarrollo Orientado a Objetos II.

SpeedFast es un sistema de reparto a domicilio desarrollado en Java que permite representar y gestionar distintos tipos de pedidos utilizando Programación Orientada a Objetos.

Durante la Semana 5 el proyecto incorpora mecanismos de sincronización para coordinar el acceso concurrente de varios repartidores a una zona de carga compartida.

El objetivo es evitar que dos repartidores retiren el mismo pedido y garantizar que cada pedido sea procesado una sola vez.

El sistema considera tres tipos de pedidos:

- Pedido de comida.
- Pedido de encomienda.
- Pedido express.

## Conceptos aplicados

- Programación Orientada a Objetos.
- Encapsulamiento.
- Herencia.
- Polimorfismo.
- Sobrecarga de métodos.
- Sobrescritura de métodos.
- Clases abstractas.
- Métodos abstractos.
- Interfaces.
- Enum.
- Colecciones `ArrayList`.
- Interfaz `Runnable`.
- Programación concurrente.
- Sincronización con `synchronized`.
- Recursos compartidos.
- `Thread.sleep()`.
- `ExecutorService`.
- Manejo de `InterruptedException`.
- Separación de responsabilidades.

## Estructura del proyecto

- `Pedido.java`: clase abstracta que contiene los atributos y comportamientos comunes de los pedidos.
- `PedidoComida.java`: representa pedidos de comida.
- `PedidoEncomienda.java`: representa pedidos de encomiendas.
- `PedidoExpress.java`: representa pedidos express.
- `EstadoPedido.java`: enum que define los estados de los pedidos.
- `ZonaDeCarga.java`: recurso compartido desde el cual los repartidores retiran los pedidos.
- `Repartidor.java`: implementa `Runnable` y procesa pedidos desde la zona de carga.
- `Despachable.java`: interfaz relacionada con el despacho de pedidos.
- `Cancelable.java`: interfaz relacionada con la cancelación.
- `Rastreable.java`: interfaz relacionada con el seguimiento.
- `ControladorDeEnvios.java`: mantiene funcionalidades desarrolladas en semanas anteriores.
- `Main.java`: ejecuta la simulación concurrente.

## Estados de los pedidos

El enum `EstadoPedido` contiene los siguientes valores:

- `PENDIENTE`
- `EN_REPARTO`
- `ENTREGADO`

El uso de un enum permite trabajar con estados definidos y evita errores por escritura de valores diferentes.

## Zona de carga compartida

La clase `ZonaDeCarga` representa el recurso compartido por los repartidores.

Internamente utiliza una colección:

```java
List<Pedido>
```

Los métodos:

```java
agregarPedido(Pedido pedido)
```

y:

```java
retirarPedido()
```

se encuentran definidos con `synchronized`.

De esta manera, solamente un hilo puede acceder al método sincronizado a la vez.

Cuando un repartidor retira un pedido, este se elimina inmediatamente de la colección de la zona de carga, evitando que otro repartidor pueda retirar el mismo pedido.

## Repartidores

La clase `Repartidor` implementa:

```java
Runnable
```

Cada repartidor posee:

- Un nombre.
- Una referencia a la misma `ZonaDeCarga`.

Dentro del método `run()` cada repartidor:

1. Solicita un pedido a la zona de carga.
2. Comprueba si existen pedidos disponibles.
3. Asigna su nombre al pedido.
4. Cambia el estado a `EN_REPARTO`.
5. Simula la entrega utilizando `Thread.sleep()`.
6. Cambia el estado a `ENTREGADO`.
7. Continúa solicitando pedidos hasta que la zona de carga queda vacía.

## Sincronización

Los tres repartidores trabajan de manera concurrente y comparten la misma instancia de `ZonaDeCarga`.

El acceso al retiro de pedidos está protegido mediante:

```java
public synchronized Pedido retirarPedido()
```

Esto evita condiciones de carrera durante el acceso a la colección compartida.

Cada pedido es retirado de la zona de carga una sola vez y queda asociado al repartidor que lo obtuvo.

## Ejecución concurrente

La clase `Main` utiliza:

```java
ExecutorService
```

con un pool de tres hilos:

```java
Executors.newFixedThreadPool(3)
```

Se crean seis pedidos y tres repartidores:

- Camila.
- Luis.
- Daniela.

Los tres repartidores reciben una referencia a la misma zona de carga.

Debido a la ejecución concurrente, los mensajes de los repartidores pueden aparecer intercalados en la consola.

Esto permite observar que varios hilos están trabajando durante el mismo período.

## Simulación de entrega

Cada pedido pasa por los siguientes estados:

```text
PENDIENTE
   ↓
EN_REPARTO
   ↓
ENTREGADO
```

La duración de cada entrega se simula mediante una pausa aleatoria utilizando:

```java
Thread.sleep()
```

Cuando un repartidor termina una entrega, vuelve a la zona de carga para intentar retirar otro pedido.

Cuando ya no existen pedidos disponibles, termina su ejecución.

## Finalización del sistema

Después de iniciar los tres repartidores, el `ExecutorService` deja de aceptar nuevas tareas mediante:

```java
shutdown()
```

El programa utiliza:

```java
awaitTermination()
```

para esperar que todos los hilos terminen.

Una vez finalizado el proceso se muestra:

```text
Todos los pedidos han sido entregados correctamente
```

## Control de errores

La simulación controla posibles interrupciones durante `Thread.sleep()` mediante:

```java
InterruptedException
```

En caso de interrupción se restaura el estado de interrupción del hilo mediante:

```java
Thread.currentThread().interrupt();
```

## Ejecución

El proyecto fue desarrollado utilizando Java e IntelliJ IDEA.

Para ejecutarlo:

1. Abrir el proyecto `SpeedFast` en IntelliJ IDEA.
2. Abrir `Main.java`.
3. Ejecutar el método `main`.
4. Observar en consola la ejecución concurrente de los tres repartidores.
5. Comprobar que cada pedido sea entregado una sola vez.

## Autor

Vicente Sanz