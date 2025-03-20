import java.util.Scanner;

// Início da seção com a definição da classe Celular ///////////////////////
class Celular {
    String modelo;
    String marca;
    long imei;
    String numero;
    String cor;
    int anoFabricacao;

    String verificaGarantia() {
        int anoAtual = 2025; // Considerando o ano atual como 2025 (data do sistema: 19/03/2025)
        if (anoAtual - anoFabricacao <= 2) {
            return "Dentro da garantia";
        }
        return "Fora da garantia";
    }

    boolean checaImei(long nro) {
        return imei == nro;
    }

    String exibeNumeroFormatado() {
        String ddd = numero.substring(0, 2);
        String parte1 = numero.substring(2, 7);
        String parte2 = numero.substring(7);
        return "(" + ddd + ") " + parte1 + "-" + parte2;
    }
}
// Fim da seção com a definição da classe Celular ///////////////////////

public class Celulares {  // Alterado de Main para Celulares
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Celular c = new Celular();
        c.modelo = input.next();
        c.marca = input.next();
        c.imei = input.nextLong();
        c.numero = input.next();
        c.cor = input.next();
        c.anoFabricacao = input.nextInt();

        System.out.print(fichaTecnica(c) + "\n" + "Imei: " + ((c.checaImei(input.nextLong())) ? "válido" : "inválido"));
        input.close();
    }

    static String fichaTecnica(Celular c) {
        return "Modelo: " + c.modelo + "\n" +
                "Marca: " + c.marca + "\n" +
                "Imei: " + c.imei + "\n" +
                "Número: " + c.exibeNumeroFormatado() + "\n" +
                "Cor: " + c.cor + "\n" +
                "Ano de Fabricação: " + c.anoFabricacao + "\n" +
                "Garantia: " + c.verificaGarantia();
    }
}