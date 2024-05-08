import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        // Ejercicio 4 - Suma de dígitos
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese un número entero: ");
        int n = scanner.nextInt();
        int result = sumDigits(n);
        System.out.println("La suma de los dígitos de " + n + " es: " + result);
    }

    public static int sumDigits(int n) {
        // Caso base
        if (n < 10) {
            return n;
            // Caso recursivo
        } else {
            return n % 10 + sumDigits(n / 10);
        }
    }
}




//Para calcular de forma recursiva la suma de los digitos de un número se pude usar la recursividad de cola. La complejidad computacional del algoritmo es O(n).
