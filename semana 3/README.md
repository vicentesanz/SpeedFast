# SpeedFast

## Descripción

Proyecto desarrollado para las actividades de Desarrollo Orientado a Objetos II.

SpeedFast es un sistema de reparto a domicilio desarrollado en Java que permite representar y gestionar distintos tipos de pedidos utilizando Programación Orientada a Objetos.

Durante la Semana 3 el proyecto integra los contenidos trabajados anteriormente y agrega polimorfismo, abstracción e interfaces para representar las operaciones principales del sistema.

El sistema considera tres tipos de pedidos:

- Pedido de comida.
- Pedido de encomienda.
- Pedido express.

Cada tipo de pedido posee una lógica diferente para la asignación de repartidores y el cálculo del tiempo estimado de entrega.

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
- Colecciones `ArrayList`.
- Reutilización de código.
- Separación de responsabilidades.

## Estructura del proyecto

- `Pedido.java`: clase abstracta que contiene los atributos y comportamientos comunes de todos los pedidos.
- `PedidoComida.java`: representa pedidos de comida.
- `PedidoEncomienda.java`: representa pedidos de encomiendas.
- `PedidoExpress.java`: representa pedidos express.
- `Despachable.java`: interfaz que define la operación `despachar()`.
- `Cancelable.java`: interfaz que define la operación `cancelar()`.
- `Rastreable.java`: interfaz que define la operación `verHistorial()`.
- `ControladorDeEnvios.java`: administra y muestra el historial de entregas.
- `Main.java`: realiza la simulación completa del sistema.

## Clase abstracta Pedido

La clase `Pedido` funciona como clase base de la jerarquía.

Contiene los atributos comunes:

- `idPedido`
- `direccionEntrega`
- `distanciaKm`
- `repartidor`
- `estado`

Además, contiene comportamientos reutilizados por los distintos tipos de pedido, como:

- `mostrarResumen()`
- `reservar()`
- `despachar()`
- `cancelar()`
- `asignarRepartidor(String nombre)`

También declara los métodos abstractos:

- `asignarRepartidor()`
- `calcularTiempoEntrega()`

Estos métodos son implementados de manera diferente por las subclases.

## Polimorfismo

### Sobrescritura

Las clases:

- `PedidoComida`
- `PedidoEncomienda`
- `PedidoExpress`

sobrescriben el método:

`asignarRepartidor()`

permitiendo realizar una asignación automática diferente según el tipo de pedido.

También sobrescriben:

`calcularTiempoEntrega()`

para calcular el tiempo estimado según las características de cada tipo de entrega.

### Sobrecarga

La clase `Pedido` posee una segunda versión del método:

`asignarRepartidor(String nombre)`

Esta versión permite asignar manualmente un repartidor indicando su nombre.

De esta forma, el sistema permite utilizar asignación automática o manual.

## Cálculo de tiempos

### Pedido de comida

El tiempo se calcula utilizando:

`15 minutos + 2 minutos por kilómetro`

### Pedido de encomienda

El tiempo se calcula utilizando:

`20 minutos + 1.5 minutos por kilómetro`

El resultado se convierte a un valor entero.

### Pedido express

El tiempo base es:

`10 minutos`

Si la distancia supera los 5 kilómetros se agregan:

`5 minutos adicionales`

## Interfaces

El sistema utiliza tres interfaces para separar responsabilidades.

### Despachable

Define:

`despachar()`

Permite cambiar el estado de un pedido a despachado.

### Cancelable

Define:

`cancelar()`

Permite cancelar un pedido.

### Rastreable

Define:

`verHistorial()`

Es utilizada por `ControladorDeEnvios` para mostrar las entregas registradas.

## Historial de entregas

La clase `ControladorDeEnvios` utiliza:

`ArrayList<String>`

para almacenar las entregas realizadas.

Cada registro guarda:

- Tipo de pedido.
- ID del pedido.
- Nombre del repartidor.

Los pedidos cancelados no se agregan al historial de entregas realizadas.

## Diagrama de clases

```mermaid
classDiagram

class Pedido {
    <<abstract>>
    -int idPedido
    -String direccionEntrega
    -double distanciaKm
    -String repartidor
    -String estado
    +mostrarResumen()
    +reservar()
    +despachar()
    +cancelar()
    +asignarRepartidor()
    +asignarRepartidor(String nombre)
    +calcularTiempoEntrega()
}

class PedidoComida {
    +asignarRepartidor()
    +calcularTiempoEntrega()
}

class PedidoEncomienda {
    +asignarRepartidor()
    +calcularTiempoEntrega()
}

class PedidoExpress {
    +asignarRepartidor()
    +calcularTiempoEntrega()
}

class Despachable {
    <<interface>>
    +despachar()
}

class Cancelable {
    <<interface>>
    +cancelar()
}

class Rastreable {
    <<interface>>
    +verHistorial()
}

class ControladorDeEnvios {
    -ArrayList~String~ historial
    +registrarEntrega(Pedido pedido)
    +verHistorial()
}

Pedido <|-- PedidoComida
Pedido <|-- PedidoEncomienda
Pedido <|-- PedidoExpress

Pedido ..|> Despachable
Pedido ..|> Cancelable

ControladorDeEnvios ..|> Rastreable
ControladorDeEnvios --> Pedido : registra entregas
```

## Simulación realizada

La clase `Main` crea tres pedidos diferentes.

### Pedido de comida

- ID: 101
- Dirección: Av. Italia 456
- Distancia: 4 km
- Asignación automática de repartidor.
- Tiempo estimado: 23 minutos.
- Pedido despachado.

### Pedido de encomienda

- ID: 102
- Dirección: Av. Santa Rosa 567
- Distancia: 7 km
- Asignación manual de Daniela Tapia.
- Tiempo estimado: 30 minutos.
- Pedido despachado.

### Pedido express

- ID: 103
- Dirección: Av. Apoquindo 1500
- Distancia: 8 km
- Asignación automática de repartidor.
- Tiempo estimado: 15 minutos.
- Pedido cancelado.

Finalmente, el sistema muestra el historial de las entregas realizadas.

## Escalabilidad, reutilización y mantenibilidad

La utilización de una clase abstracta permite centralizar los atributos y comportamientos comunes de los pedidos, evitando repetir código en las subclases.

El polimorfismo permite trabajar con objetos de distintos tipos mediante referencias de la clase `Pedido`, mientras cada subclase mantiene su propio comportamiento.

Las interfaces permiten separar responsabilidades como despacho, cancelación y rastreo.

Esta estructura facilita agregar nuevos tipos de pedidos u otras funcionalidades sin modificar completamente las clases existentes, favoreciendo la escalabilidad y mantenibilidad del sistema.

## Ejecución

El proyecto fue desarrollado utilizando Java e IntelliJ IDEA.

Para ejecutarlo:

1. Abrir el proyecto SpeedFast.
2. Abrir `Main.java`.
3. Ejecutar el método `main`.
4. Revisar los resultados mostrados en consola.

## Autor

Vicente Sanz