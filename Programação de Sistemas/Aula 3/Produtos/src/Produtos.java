import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

class Pedido {
    int id;
    String nomeProduto;
    int quantidade;
    double precoUnitario;

    public Pedido(int id, String nomeProduto, int quantidade, double precoUnitario) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double calcularTotal() {
        return quantidade * precoUnitario;
    }

    public void exibirDetalhes() {
        System.out.println("Pedido #" + id);
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço Unitário: " + precoUnitario);
        System.out.println("Total: " + calcularTotal());
        // Removido o separador "====================="
    }
}

public class Produtos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        int qtdPedidos = sc.nextInt();
        List<Pedido> pedidos = new ArrayList<>();

        for (int i = 0; i < qtdPedidos; i++) {
            int id = sc.nextInt();
            String nomeProduto = sc.next();
            int quantidade = sc.nextInt();
            double precoUnitario = sc.nextDouble();

            pedidos.add(new Pedido(id, nomeProduto, quantidade, precoUnitario));
        }

        System.out.println("Resumo dos Pedidos:");
        double totalGeral = 0;
        for (Pedido pedido : pedidos) {
            pedido.exibirDetalhes();
            totalGeral += pedido.calcularTotal();
        }
        System.out.println("Total Geral: " + totalGeral);

        sc.close();
    }
}