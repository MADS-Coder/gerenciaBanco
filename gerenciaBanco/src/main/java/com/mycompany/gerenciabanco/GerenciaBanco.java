/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author Matheus Augusto Duarte Silva 
 * Desenvolvimento de Sistema Bancário
 */
class ContaBancaria {

    public String nome;
    public String sobrenome;
    public String cpf;
    public double saldo;

    public ContaBancaria(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Deposito de R$ + " + valor + " realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--------Menu--------");
            System.out.println("1. Constultar Saldo");
            System.out.println("2. Realizar Deposito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Encerrar\n");
            System.out.print("Escolha a opcao desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo: R$ " + consultarSaldo());
                    break;
                case 2:
                    System.out.println("Digite o valor a ser depositado");
                    double valorDeposito = scanner.nextDouble();
                    depositar(valorDeposito);
                    break;
                case 3:
                    System.out.println("Digite o valor a ser sacado");
                    double valorSaque = scanner.nextDouble();
                    sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 4);

        scanner.close();

    }

}

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Sistema Bancario");
        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite o seu CPF: ");
        String cpf = scanner.nextLine();
        
        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);
        
        conta.exibirMenu();
        
        System.out.println("Obrigado por utilizar o nosso servico!");
        scanner.close();
    }
}
