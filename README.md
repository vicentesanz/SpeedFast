# SpeedFast

## Descripción

Proyecto desarrollado para las actividades formativas de Desarrollo Orientado a Objetos II.

SpeedFast es un sistema de reparto a domicilio que representa distintos tipos de pedidos mediante el uso de programación orientada a objetos en Java.

En la Semana 2 el proyecto fue actualizado para utilizar una clase abstracta `Pedido` y calcular tiempos estimados de entrega según el tipo de pedido.

El sistema considera tres tipos de pedidos:

- Pedido de comida.
- Pedido de encomienda.
- Pedido express.

## Conceptos aplicados

- Programación Orientada a Objetos.
- Encapsulamiento.
- Herencia.
- Clases abstractas.
- Métodos abstractos.
- Polimorfismo.
- Sobreescritura de métodos.
- Reutilización de código.

## Estructura del proyecto

- `Pedido.java`: clase abstracta que contiene los atributos y métodos comunes de los pedidos.
- `PedidoComida.java`: calcula el tiempo de entrega considerando 15 minutos base más 2 minutos por kilómetro.
- `PedidoEncomienda.java`: calcula el tiempo de entrega considerando 20 minutos base más 1.5 minutos por kilómetro.
- `PedidoExpress.java`: calcula 10 minutos de entrega y agrega 5 minutos adicionales cuando la distancia supera los 5 kilómetros.
- `Main.java`: crea los distintos tipos de pedidos y muestra su información y tiempo estimado de entrega.

## Funcionamiento

La clase abstracta `Pedido` contiene los atributos:

- `idPedido`
- `direccionEntrega`
- `distanciaKm`

También implementa el método:

`mostrarResumen()`

Este método muestra los datos básicos del pedido.

Además, declara el método abstracto:

`calcularTiempoEntrega()`

Cada subclase implementa este método con una lógica distinta según el tipo de pedido.

## Cálculo de tiempos

### Pedido de comida

Tiempo de entrega:

`15 minutos + 2 minutos por kilómetro`

### Pedido de encomienda

Tiempo de entrega:

`20 minutos + 1.5 minutos por kilómetro`

El resultado se ajusta a un valor entero.

### Pedido express

Tiempo base:

`10 minutos`

Si la distancia es mayor a 5 kilómetros, se agregan 5 minutos adicionales.

## Ejecución

El proyecto fue desarrollado utilizando Java e IntelliJ IDEA.

Para ejecutar el programa:

1. Abrir el proyecto en IntelliJ IDEA.
2. Abrir la clase `Main`.
3. Ejecutar el método `main`.
4. Revisar los resultados mostrados en la consola.

## Resultado esperado

Con los datos utilizados en `Main`, el programa muestra:

- Pedido de comida a 4 km: 23 minutos.
- Pedido de encomienda a 6 km: 29 minutos.
- Pedido express a 7 km: 15 minutos.

## Autor

Vicente Sanz