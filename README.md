Práctica 1 - Juego de la guerra
===============================

Juego de cartas de la guerra, uso de pilas y colas

Detalles
========

La realización de esta práctica está previsto que ocupe tres sesiones.

Las partes de la asignatura con las que está directamente relacionada son las siguientes:
  - especificación de tipos de datos
  - orientación a objetos y tipos de datos
  - diseño basado en objetos

Además se hará uso de la definición de clases genéricas o parametrizadas en Java.

Parte 1. Pilas de enteros.

Escribid una especificación del tipo de datos "pila de enteros".
Dar una clase Java que implemente el tipo correspondiente.

Parte 2. Colas genéricas.

Escribid una especificación del tipo de datos "cola".
Dar una clase Java que represente “colas genéricas”, (elementos son objetos de cualquier clase).

Parte 3. Un juego de cartas sencillo.

Se propone simular el juego de cartas conocido como "La Guerra".
A continuación, se explica brevemente la dinámica del juego:

Repartir todas las cartas entre los jugadores.
Una jugada consiste en que cada jugador (que no haya sido previamente eliminado) arroja su primera carta sobre la mesa.El ganador de la jugada es el que ha echado la carta más alta (en caso de empate, los jugadores que han arrojado las cartas de mayor valor siguen jugando hasta deshacer el empate). El ganador de la jugada recoge todas las cartas que se han arrojado en ella y las incorpora como últimas cartas de su mazo. Un jugador queda eliminado cuando, siendo su turno para echar carta, su mazo está vacío. El final del juego se produce cuando queda un único jugador sin eliminar.
Para programar el juego siguiendo una "metodología orientada a objetos", se recomienda:
Desarrollad una clase en Java cuyos objetos representen a "jugadores de guerra". Pensad
en cómo gestiona un jugador la recogida y la eliminación (echar sobre la mesa) de cartas.
Desarrollad una clase Java cuyos objetos representen a "mesas del juego de la guerra".
Desarrollad una pequeña clase cuyos objetos representen a las "barajas españolas".
Desarrollad una clase Java cuyas instancias sean “partidas del juego de la guerra”. En ella colaborarán las clases anteriores.

Parte 4. Un paso de abstracción.

Con las clases anteriores la práctica estaría terminada, pero si quisiéramos implementar otros juegos de cartas diferentes podríamos dar un paso más y reflexionar sobre las posibilidades que nos ofrece el diseño orientado objetos. Por ejemplo, parece que se puede generalizar la idea de juego de cartas (mediante clases abstractas), quedando por concretar la forma en la que se desarrolla una jugada, el valor de las cartas en cada juego, la forma en que gestionan sus cartas los jugadores, etc. Así, sería factible realizar software bastante general, que luego se concretara para juegos particulares. Se anima a pensar en pequeñas generalizaciones: barajas abstractas, jugadores abstractos, etc. Como asunto relacionado, se recomienda reflexionar sobre cómo diseñar algunos solitarios sencillos, y se anima a que se pase de la reflexión al papel (y del papel al ordenador).
