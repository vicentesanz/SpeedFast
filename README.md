# SpeedFast

## Descripción

Proyecto desarrollado para la actividad formativa de la Semana 1 de Desarrollo Orientado a Objetos II.

SpeedFast es un sistema de reparto a domicilio que representa distintos tipos de pedidos mediante el uso de herencia y polimorfismo en Java.

El sistema considera tres tipos de pedidos:

- Pedido de comida.
- Pedido de encomienda.
- Pedido express.

Cada tipo de pedido implementa una lógica diferente para la asignación de repartidores.

## Conceptos aplicados

- Programación Orientada a Objetos.
- Encapsulamiento.
- Herencia.
- Polimorfismo.
- Sobreescritura de métodos.
- Sobrecarga de métodos.

## Estructura del proyecto

- `Pedido.java`: clase base del sistema.
- `PedidoComida.java`: representa pedidos de comida y verifica el uso de mochila térmica.
- `PedidoEncomienda.java`: representa pedidos de encomienda y valida peso y embalaje.
- `PedidoExpress.java`: representa pedidos express y busca un repartidor cercano con disponibilidad inmediata.
- `Main.java`: clase utilizada para probar el funcionamiento del sistema.

## Funcionamiento

La clase `Pedido` contiene los atributos generales de un pedido y define el método `asignarRepartidor()`.

Las clases `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` heredan de `Pedido` y sobrescriben el método `asignarRepartidor()` para implementar un comportamiento específico según el tipo de pedido.

También se utiliza la sobrecarga mediante el método:

`asignarRepartidor(String nombreRepartidor)`

Este método permite indicar el nombre del repartidor que fue asignado al pedido.

## Ejecución

El proyecto fue desarrollado utilizando Java e IntelliJ IDEA.

Para ejecutar el programa:

1. Abrir el proyecto en IntelliJ IDEA.
2. Abrir la clase `Main`.
3. Ejecutar el método `main`.
4. Revisar los resultados mostrados en la consola.

## Resultado esperado

El programa muestra por consola:

- La verificación de mochila térmica para pedidos de comida.
- La validación de peso y embalaje para pedidos de encomienda.
- La búsqueda de un repartidor cercano con disponibilidad inmediata para pedidos express.
- El nombre del repartidor asignado a cada pedido.

## Autor

Vicente Sanz