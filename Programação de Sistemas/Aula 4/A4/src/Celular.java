import java.util.Objects;

public class Celular {
    String modelo;
    String marca;
    long imei;
    String numero;
    String cor;
    int anoFabricacao;

    // Construtor Padrão (Default)
    public Celular() {
    }

    // Construtor com IMEI e Número de Telefone
    public Celular(long imei, String numero) {
        this.imei = imei;
        this.numero = numero;
    }

    // Construtor com Modelo e Marca
    public Celular(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    // Método que apresenta na tela o estado do objeto
    public void mostraDados() {
        System.out.println("Modelo : " + modelo);
        System.out.println("Marca : " + marca);
        System.out.println("IMEI : " + imei);
        System.out.println("Número de Telefone : " + numero);
        System.out.println("Cor : " + cor);
        System.out.println("Ano de Fabricação : " + anoFabricacao);
    }

    // Método hashCode
    public int hashCode() {
        return Objects.hash(modelo, marca, imei, numero, cor, anoFabricacao);
    }
}