import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n1, n2, n3, media;
        
        System.out.println("Digite a primeira nota: ");
        n1 = input.nextDouble();
        System.out.println("Digite a segunda nota: ");
        n2 = input.nextDouble();
        System.out.println("Digite a terceira nota: ");
        n3 = input.nextDouble();
        
        media = (n1 + n2 + n3) / 3;
        System.out.println("A média é: " + media);

        if (media < 3) {
            System.out.println("Reprovado");
        } else if (media < 7) {
            System.out.println("Exame");
        } else {
            System.out.println("Aprovado");
        }
        
        input.close(); // Fechar o scanner para evitar vazamento de recursos
    }
}
