# -Caso-Final-de-los-Finales-Integrador-2023-2024

https://github.com/maridilo/-Caso-Final-de-los-Finales-Integrador-2023-2024.git

Ejercicio 1 
1)     En relación al estado de un objeto, para preservar el principio de encapsulación:
   b
   
3)     Los métodos de una clase no pueden devolver objetos:
   b
   
5)     ¿Cuál de las siguientes características de la programación orientada a objetos está relacionada con la reutilización de código?
   b
   
7)     El tiempo de acceso a un dato en una lista de tipo LinkedList es en el mejor de los casos de:
   b
   
9)     Un algoritmo de ordenación que implemente el método de inserción se basa en la idea de ir seleccionando el número correspondiente en la lista desordenada que se va a insertar en la posición última de la lista ordenada:
   a

Ejercicio 2
1)     Debemos diseñar un programa para un sistema de dispositivos portables aplicados  en  telemedicina  que  contienen  una  cantidad  de  memoria  muy limitada ( 4 KB). Tenemos diferentes alternativas que hacen diferente uso de la computación y la memoria.
    a)    La primera de ellas tiene un orden de complejidad computacional O( n) y va a ocupar un espacio S( 1 ).
    b)    La segunda de ellas tiene un orden de complejidad computacional O( 1 ) pero lo hace mediante una técnica denominada para guardar muchos datos en memoria, por lo que         ocupa   un espacio de S( N 2 ).
    c)    La tercera y última tiene una complejidad computacional de O( log 2 ( N)) y ocupa un poco más de espacio en memoria S( O( log 2 ( N))).
    Debemos analizar la eficiencia computacional de las mismas y justificar la elección. Teniendo en cuenta que el programa va a tener un tamaño de datos de entrada de 64 KB.

Respuesta: La segunda opcion ocuparia un espacion de memoria demasiado grande y la primera no podria almacenar el espacio suficiente, la tercera opcion tiene mayor comlejidad computacional y su espacio de memoria no supera a los 4kb de memoria asi que seria la mejor opcion.

2)     Explica las diferencias entre una tabla Hash y un árbol. ¿ Cuándo conviene utilizar cada una de estas estructuras? Justifique su respuesta y analice todas las posibles operaciones a realizar por las estructuras. No redacte el orden tal y como puede ver en los apuntes, razónelo con sus propias palabras y argumentos.

Una tabla hash es como un array estático de listas. Dado un elemento determinado que queremos buscar o insertar, tenemos una función h(elemento) que nos da
directamente la posición dónde está ese elemento dentro de la tabla, o donde debe insertarse(funcion hash).

Cuando el número de elementos es elevado comparado con el tamaño del array base de la tabla, inevitablemente habrá muchas colisiones. Los árboles pueden permitir encontrar (y borrar o insertar) elementos de un modo eficiente sin imponer restricciones en el número de elementos con el que trabajamos.

3)     Explica las diferencias entre un a pila y una cola. ¿ Cuándo conviene utilizar cada una de estas estructuras? ¿ Cuál es el orden de complejidad computacional de estas estructuras? No redacte el orden tal y como puede ver en los apuntes, razónelo con sus propias palabras y argumentos.

Una pila es una lista basada en el criterio LIFO (last in-first out, el último que entra es el primero que sale). Los elementos se añaden apilándose unos sobre otros y sólo se tiene acceso al que está en la parte superior. Son empleadas tanto por los compiladores como por los intérpretes para ejecutar programas. 

Una cola es una lista basada en el criterio FIFO (first in-first out, el primero que entra es el primero que sale). Los nuevos elementos se añaden en la parte de atrás y la extracción de elementos se realiza por la de delante.

4)     Explica el método de ordenación denominado inserción y describe  las iteraciones sobre el siguiente conjunto de datos:   50 20 84 13 22 16 89 85

Si queremos insertar un elemento en el  array, esta operación puede requerir desplazar "hacia atrás" todos los elementos posteriores al elemento borrado, o "hacia adelante" todos los elementos posteriores al elemento que vamos a insertar para hacer hueco para éste.

Comienza con una lista desordenada y, en cada paso, toma uno de los elementos no ordenados y lo inserta en su posición correcta dentro de la parte ordenada de la lista, desplazando los elementos mayores hacia la derecha según sea necesario.

Iteración 1: (50),Iteración 2: (20 50),Iteración 3: (20 50 84),Iteración 4: (13 20 50 84),Iteración 5: (13 20 22 50 84),Iteración 6: (13 16 20 22 50 84) e Iteración 7: (13 16 20 22 50 84 85).

5)     Dadas dos funciones y su número de operaciones:   A = 1024 n    B = 16 n 3     Calcular a partir de qué tamaño de entrada n A es más eficiente que B.

1024n<16n3
1024<16n2
64<n2
8<n
A partir de n=8 la función A es más eficiente que la función B.


Ejercicio 3
Dado el siguiente algoritmo recursivo:

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int a=recursive(1,-2);
        System.out.println(a);
        public static int recursive(int a, int b){
            if (b==0)
            {
                return 1;
            }
            else if (a==0){
                return 0;
            }
            else{
                return a * recursive(a,b-1);
            }
        }
    }

Preguntas:
a)    ¿Qué imprime el código? En caso de que no compile indique el motivo y arregle el programa como considere conveniente. Explique su solución de manera concisa.
El código dado tiene un error de compilación. El método recursive está definido dentro del método main, lo cual no es permitido en Java. Además, el método recursive debería ser estático, ya que se invoca desde un contexto estático (el método main). Por lo tanto, se debe definir el método recursive fuera del método main y marcarlo como estático.

import java.util.*;

public class Main {
   public static void main(String[] args) {
        int a = recursive(1, -2);
        System.out.println(a);
    }

   public static int recursive(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (a == 0) {
            return 0;
        } else {
            return a * recursive(a, b - 1);
        }
    }
}

b)    Explica brevemente qué cálculo está haciendo y qué tipo de recursividad está empleando.
 El código imprime el resultado de la función recursive(1, -2). Este algoritmo implementa una recursividad directa. La función recursive toma dos argumentos a y b, y devuelve el resultado de elevar a a la potencia b. Si b es igual a 0, devuelve 1. Si a es igual a 0, devuelve 0. De lo contrario, llama recursivamente a la función recursive con el mismo a y b - 1, multiplicando a por el resultado de la llamada recursiva. En resumen, está calculando la potencia de un número a elevado a la potencia b.



Ejercicio 4 
Calcular de forma recursiva la suma de los dígitos de un número siendo un ejemplo el número 102 -> 1 + 0 + 2 = 3. Recuerde que puede realizar los cambios de tipo que crea necesarios para facilitar la resolución:
¿ Qué tipo de recursividad se está empleando? ¿ Qué complejidad computacional tiene el algoritmo?

Para calcular de forma recursiva la suma de los digitos de un número se pude usar la recursividad de cola. La complejidad computacional del algoritmo es O(n).

Ejercicio 5

1)    En la red social Twitter, cada usuario es propietario de una cuenta (UserAccount) en la que, básicamente, se especifica un alias (que cumple las funciones de identificador único) y un email de contacto. En la cuenta, además, se incluye el conjunto de tweets que el propietario va publicando a lo largo del tiempo.

Como la cantidad de mensajes que maneja la red es inmensa, una característica original de Twitter es que cada usuario puede seleccionar la información que le interesa recibir. De esta manera, el propietario de una UserAccount puede convertirse en seguidor (follower) de otros usuarios, mostrando su interés en los tweets que ellos publiquen. Así, cada vez que un usuario publica un tweet, éste es incluido en el timeline de la UserAccount de cada uno de sus followers (es decir, el timeline se corresponde con el conjunto de tweets recibidos). Un usuario tiene también una lista de personas a las que sigue (following).

En base a estas especificaciones se solicita que:

a)     Programe la clase UserAccount y sus constructores. Incluya todos sus atributos. Al iniciar una cuenta el usuario no sigue a nadie, no tiene ningún tweet y el timeline está vacío. Establezca la visibilidad adecuada. Indica el tipo de datos de todos los atributos y parámetros del constructor y suponga que ya tiene implementadas correctamente las clases Tweet y Email.

Justifique, brevemente, porqué ha seleccionado cada estructura de datos para los atributos. Se debe comprobar que el email contiene el carácter (@) y que el alias solo contiene números y/o letras. Programe una clase Utils que contenga funciones independientes para comprobar si el email es válido y si el alias es válido. En caso contrario, se deberá gestionar de forma adecuada la casuística.

b)    Implemente, en UserAccount, un método que permita a un usuario seguir a otro. El método no debe devolver nada.

·        Al ejecutar “user.follow(user2)”, el usuario user se convertirá en follower de user2.

·        Añada, si lo necesita, métodos auxiliares (por ejemplo, para manejar los followers de user2).

·        Gestione adecuadamente que un usuario no pueda seguir dos veces al mismo usuario. Si esto ocurre, se gestionará adecuadamente.

c)     Implemente, en UserAccount, un método que permita a un usuario publicar un Tweet:

·        Después de ejecutar el método “user.tweet(tweet1)”, se deberá actualizar adecuadamente el atributo tweets de user. Además, todos los followers de user habrán recibido el tweet1 en su timeline.

·        Añada, si lo necesita, métodos auxiliares (por ejemplo, para manejar el timeline de los followers).

d)    Implemente el método toString que únicamente muestre el nombre de usuario y el correo electrónico.

2)   En la red social Twitter, la unidad básica de información se denomina Tweet. Un Tweet es creado en un instante de tiempo concreto (time), contiene un mensaje (message) con un máximo de 140 caracteres de longitud y es publicado por un

usuario (conocido como sender). Además, existen dos tipos de Tweet especiales:

·       DirectMessage: Los mensajes directos son Tweets que permiten comunicarse, de manera privada, a dos usuarios dentro de la red. Estos DirectMessage son como Tweets ya que contienen un mensaje (message), son publicados por un emisor (sender) y son creados en un instante de tiempo determinado (time); la única diferencia es que incluyen a otro usuario como receptor (receiver) del tweet.

·       Retweet: Cuando un usuario lee un tweet interesante que le ha llegado a su timeline, y quiere reenviarlo a su lista de followers, crea un retweet. Este Retweet es como un Tweet, es decir, el usuario que lo publica (sender) puede poner un mensaje (message) y lo crea en un tiempo determinado (time); la única diferencia es que el Retweet incluye una referencia al Tweet que se reenvía.

En base a estas especificaciones se solicita que:

a)   Implemente las clases Tweet, Retweet y DirectMessage escogiendo la jerarquía más adecuada. Añada los atributos que se especifican en el enunciado y establezca su visibilidad.

·       Reutilice todo el código que pueda. Para el atributo time, se recomienda utilizar la clase LocalDate de Java.

·       Suponga que ya tiene implementada correctamente la clase UserAccount.

b) Implemente los constructores de las clases reutilizando al máximo todo el código disponible.

·       Además, compruebe las restricciones de datos (por ejemplo, el constructor debería lanzar una excepción si el mensaje que se le pasa, contuviese más de 140 caracteres).

·       Recuerde que la librería estándar tiene una función que permite calcular la longitud de una cadena de caracteres.

c)  Implemente el método toString en las tres clases, reutilizando al máximo todo el código disponible. Suponga que las clases LocalDate y UserAccount ya tiene este método implementado correctamente.

d)  Responda a las siguiente preguntas:

·       ¿Deberá modificar los atributos timeline y tweets de la clase UserAccount (definida en el ejercicio 1) para que contenga elementos de la clase hija Retweet? Justifique su razonamiento y, si cree que hay que modificarlos, explique también cómo lo haría.

·       ¿Deberá modificar el método tweet(Tweet tweet1) de la clase UserAccount (definida en el ejercicio 1) para que pueda enviar también objetos de tipo Retweet? Justifique su razonamiento y, si cree que hay que modificarlo, explique también cómo lo haría.

3)    Suponga que la clase Utils contiene los métodos: leerCadena, leerEntero, leerFloat y leerDouble correctamente implementados. Utilícelos para leer por consola como lo hace en los ejercicios de clase.

Implemente una clase main que permita al iniciarse Cargue una lista de usuarios de un fichero. Utilice las estructuras de datos que considere más adecuadas y justifique su uso. Puede crear las funciones y métodos que considere convenientes o necesarias en las clases correspondientes previamente solicitadas. Sólo debe especificar qué clases son en caso de que lo haga, no debe redifinir la clase completa. Posteriormente habrá un menú que permita:

a)  Cargar un usuario en memoria realizando una búsqueda secuencial con centinela sobre el conjunto de datos previamente cargado. Puede crear las funciones y métodos que considere convenientes o necesarias en las clases correspondientes previamente solicitadas. Sólo debe especificar qué clases son en caso de que lo haga, no debe redifinir la clase completa.

b)   Publicar un tweet por el usuario cargado previamente en memoria. Puede asumir que siempre habrá un usuario cargado en memoria. Debe gestionar que si el tweet sobrepasa los 140 caracteres se debe mostrar un error al usuario. Para ello, utilice la gestión de excepciones adecuada y no haga comprobaciones extra de entrada/salida. Puede crear las clases, funciones y métodos que considere convenientes o necesarias. Sólo debe especificar qué clases son en caso de que las modifique, no debe redifinir la clase completa. Utilice las estructuras de datos que considere más adecuadas y justifique su uso.

c)  Ordenar los diferentes usuarios en base a 2 criterios diferentes:

1.  El email de forma ascendente
