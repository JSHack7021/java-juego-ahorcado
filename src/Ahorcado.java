import java.util.*;
public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner vm = new Scanner(System.in);

        //Declaraciones y asignaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglos
        //Las letras adivinadas debe de ser el total de la palabra secreta
        //quiere decir el tamano de cuantas letras tiene, y donde almacenaremos
        //las letras si son correctas o no para validar la palabra
        //este es un array de chars
        char[] letrasAdivinadas = new char[palabraSecreta.length()];


        //Estructura de control, Bucle, para imprimir la cantidad
        //de letras que debe de adivinar
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        //Estructura de control While
        while (!palabraAdivinada && intentos < intentosMaximos) {
            //Aqui concatenamos, String con ValueOf: es decir es que se forma una palabra
            //ya que char solo permite una letra pero en este caso es un array 
            //con esto es decir que el char lo tomamos en cuenta como si fuera una cadena de texto String
            System.out.println("palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " " + palabraSecreta.length() + " letras");

            System.out.println("Introduce una letra, porfavor");

            //Usando la clase scanner para pedir una letra
            //con un metodo de charAt(0), este metodo es de String
            //Que se refiere a que nos va a devolver solo la primera letra que nos ponga la persona
            //osea en su primera posicion 0
            char letra = Character.toLowerCase(vm.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                //Estructura de control condicional, Utilizando charAt, que es la "letra en", es como 
                //decir el indice se encuentra en
                if(palabraSecreta.charAt(i) == letra){
                    //una vez encontrada la letra y la posicion en la que este
                    //Asignamos a la variabe letras adivinadas en el indice que se encuentre,
                    //le colocamos la letra si es correcta y en la variable letra correcta 
                    //le pasamos a true
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            //CAso contrario de ser incorrecta la letra aumentamos los intentos
            //y mostramos cuantos intentos quedan
            if (!letraCorrecta) {
                intentos++;
                System.out.println("!Incorrecto, Te quedan " + (intentosMaximos - intentos) + " intentos");
            }
            //Este String valueOf, de etras adivinas se va completando
            //y si es igual a la palabra secreata con equals validamos eso
            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                //para salir del while
                palabraAdivinada = true;
                System.out.println("Felicidades, has adivinado la palabra secreta: " + palabraSecreta);

            }
        }
        if(!palabraAdivinada){
            System.out.println("Te quedaste sin intentos: GAME OVER");
        }

        vm.close();

    }
}
