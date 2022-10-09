# Movies
Emovie App

### 1. ¿En qué consiste el principio de responsabilidad única?
R.- Consiste en que un módulo debe estar aislado del resto y solo cumplir con una sola tarea, también no debería ser modificada constantemente ya que podría romper el principio
   ### ¿Cuál es su propósito?
R.- Sería que nuestro código no sufra cambios, ya que como se explicó en la parte de arriba solo debe cumplir con tarea o acción
### 2. ¿Qué características tiene, según su opinión, un “buen” código o código limpio?
R.- En mi consideración debería tener lo siguiente:
    - No usar abreviaturas para métodos o variables
    - Deberíamos respetar el número de parámetros que se agrega en una función
    - Debe ser un código de fácil lectura sin necesidad de tener comentarios
    - Un código mantenible y escalable
### 3. Detalla cómo harías todo aquello que no hayas llegado a completar.
R.- En mi opinión sería lo siguiente: 
    - Buscaría integrar la api de Youtube en la parte del trailer, al tener mi módulo de trailer, debería ser sencillo anexarlo, para que todo quedebe dentro de la app, ya sea
agregando un api independiente para el consumo del servicio de youtube y posteriormente al tener la url correcta mostrar dentro de la app el reproductor de video
    - Integraría el borrado de la base datos por día para ir actualizando la información creando un usecase para la preferencia y que me guarde la fecha y simpre validando que si
la fecha es mayor a la que se tiene guardada que borre las tablas del listado y el detalle de peliculas
    - Agregaría pruebas de ViewModel y UI con la misma forma que cree las de repository por nombrar un ejemplo
    - Sería un mejor manejo de las peticiones, con validaciones tomando como referencia que si al entrar a la app ya se fue por el listado o detalle de la película ir a la base datos
y obtener la información necesaria, para esto tendría que crear 1 o 2 usecase adicionales para el manejo de esa lógica

