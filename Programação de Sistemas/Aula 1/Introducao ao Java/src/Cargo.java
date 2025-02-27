import java.util.Scanner;

public class Cargo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cod;
        double sal, aumento = 0, novoSal;
        String cargo = "";

        System.out.print("Digite o código do cargo: ");
        cod = input.nextInt();
        System.out.print("Digite o salário atual: ");
        sal = input.nextDouble();

        switch (cod) {
            case 1:
                cargo = "Escriturário";
                aumento = 0.5;
                break;
            case 2:
                cargo = "Secretário";
                aumento = 0.35;
                break;
            case 3:
                cargo = "Caixa";
                aumento = 0.2;
                break;
            case 4:
                cargo = "Gerente";
                aumento = 0.1;
                break;
            case 5:
                cargo = "Diretor";
                aumento = 0;
                break;
            default:
                System.out.println("Código inválido!");
                input.close();
                return; // Sai do programa se o código for inválido
        }

        aumento = sal * aumento;
        novoSal = sal + aumento;

        // Correção: usando printf para formatar os valores numéricos
        System.out.printf("Cargo: %s\n", cargo);
        System.out.printf("Salário: R$ %.2f\n", sal);
        System.out.printf("Aumento: R$ %.2f\n", aumento);
        System.out.printf("Novo salário: R$ %.2f\n", novoSal);

        input.close(); // Fecha o scanner para evitar vazamento de recursos
    }
}