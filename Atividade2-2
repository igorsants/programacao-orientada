import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escolha a direção da conversão (Celsius para Fahrenheit - 'C' / Fahrenheit para Celsius - 'F'): ");
        char direcao = scanner.next().charAt(0);

        double temperatura;
        double resultado;

        if (direcao == 'C' || direcao == 'c') {
            System.out.print("Digite a temperatura em Celsius: ");
            temperatura = scanner.nextDouble();
            resultado = (temperatura * 9/5) + 32;
            System.out.println("Temperatura em Fahrenheit: " + resultado);
        } else if (direcao == 'F' || direcao == 'f') {
            System.out.print("Digite a temperatura em Fahrenheit: ");
            temperatura = scanner.nextDouble();
            resultado = (temperatura - 32) * 5/9;
            System.out.println("Temperatura em Celsius: " + resultado);
        } else {
            System.out.println("Direção inválida.");
        }
    }
}
