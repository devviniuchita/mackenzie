package br.mackenzie.aplicacao;

import br.mackenzie.modelo.Funcionario;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario func = new Funcionario("João", 5000.0);
        System.out.println("Nome: " + func.getNome());
        System.out.println("Salário: " + func.getSalario());

        // Tentativa de acessar atributos privados diretamente - NÃO PERMITIDO
        // System.out.println(func.nome); // Erro: nome tem acesso private
        // System.out.println(func.salario); // Erro: salario tem acesso private
        // Motivo: Atributos privados só são acessíveis dentro da própria classe

        // Tentativa de acessar método protegido - NÃO PERMITIDO
        // double bonus = func.calcularBonus(); // Erro: calcularBonus() é protected
        // Motivo: Métodos protected só são acessíveis no mesmo pacote ou por subclasses
        // e TesteFuncionario está em pacote diferente e não é subclasse

        // Tentativa de acessar método default - NÃO PERMITIDO
        // func.exibirDetalhes(); // Erro: exibirDetalhes() tem acesso default
        // Motivo: Métodos default só são acessíveis no mesmo pacote
    }
}