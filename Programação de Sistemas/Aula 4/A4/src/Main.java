import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o código do teste (1, 2 ou 3):");
        byte code = input.nextByte();

        switch (code) {
            case 1:
                Celular celular1 = new Celular();
                System.out.println(celular1.hashCode());
                break;
            case 2:
                System.out.println("Digite o IMEI (long):");
                long imei = input.nextLong();
                System.out.println("Digite o número de telefone:");
                String numero = input.next();
                Celular celular2 = new Celular(imei, numero);
                System.out.println(celular2.hashCode());
                break;
            case 3:
                System.out.println("Digite o modelo:");
                String modelo = input.next();
                System.out.println("Digite a marca:");
                String marca = input.next();
                Celular celular3 = new Celular(modelo, marca);
                System.out.println(celular3.hashCode());
                break;
            default:
                throw new IllegalArgumentException("Código inválido");
        }

        input.close();
    }
}