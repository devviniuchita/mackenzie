package br.mackenzie.modelo;

// Classe que representa um funcionário com encapsulamento
public class Funcionario {
    // Atributos privados, acessíveis apenas dentro da classe
    private String nome;
    private double salario;

    // Construtor público para inicializar os atributos
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Getter para o atributo nome
    public String getNome() {
        return nome;
    }

    // Setter para o atributo nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o atributo salario
    public double getSalario() {
        return salario;
    }

    // Setter para o atributo salario
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método protegido, acessível no mesmo pacote ou por subclasses
    protected double calcularBonus() {
        return salario * 0.10; // Retorna 10% do salário
    }

    // Método com acesso default (package-private), acessível apenas no mesmo pacote
    void exibirDetalhes() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: " + salario);
    }
}