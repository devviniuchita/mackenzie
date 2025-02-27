import java.util.Scanner; // Importação necessária

public class Main { // Começar sempre com o nome de uma classe. A classe define o nome do arquivo
    public static void main(String[] args) { //Assinatura do metodo função principal
        int op; // Declaração da variável
        Scanner entrada = new Scanner(System.in); // Necessario para ser escaneado e feito a leitura, armazena na entrada1
        System.out.println("1-Somar\n2-Subtrair\n3-Sair"); //print do Java
        op =entrada.nextInt();
    }
}