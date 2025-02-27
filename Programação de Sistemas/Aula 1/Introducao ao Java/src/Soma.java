import java.util.Scanner;

public class Soma {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;
        char resp;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Digite 2 números: ");
            n1 = sc.nextInt();
            System.out.print("Digite o segundo número: ");
            n2 = sc.nextInt();
            System.out.println("Soma dos números = "+ (n1 + n2));
            System.out.println("Deseja continuar (s/n)?: ");
            resp = input.next () .charAt (0);
        } while (resp== 's');
    
    }
}
