package br.com.projeto2.projeto2;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de pessoa (1 - Física, 2 - Jurídica): ");
        int tipoPessoa = scanner.nextInt();
        Pessoa pessoa;
        if (tipoPessoa == 1) {
            pessoa = new PessoaFisica();
        } else {
            pessoa = new PessoaJuridica();
        }

        System.out.println("Escolha a operação (1 - Cadastrar, 2 - Consultar, 3 - Atualizar, 4 - Excluir, 5 - Listar): ");
        int operacao = scanner.nextInt();

        switch (operacao) {
            case 1:{
                if (tipoPessoa == 1) {
                    System.out.println("(Insira o cpf): ");
                } else {
                    System.out.println("(Insira o cnpj): ");
                } 
                String cnpjCpf = scanner.next();
                System.out.println("(Insira o Nome): ");
                String nome = scanner.next();
                System.out.println("(Insira a Idade): ");
                int idade = scanner.nextInt();
                pessoa.cadastrar(tipoPessoa, cnpjCpf, nome, idade);
                break;
                }
            case 2:{
                System.out.println("(Insira o id da pessoa): ");
                int pessoaId = scanner.nextInt();
                Pessoa.consultar(pessoaId);
                break;
                }
            case 3: {
                System.out.println("Informe o id da pessoa: ");
                int id = scanner.nextInt();
                if (tipoPessoa == 1) {
                    System.out.println("(Insira o cpf): ");
                } else {
                    System.out.println("(Insira o cnpj): ");
                } 
                String cnpjCpf = scanner.next();
                Pessoa.atualizar(id,cnpjCpf);
                break;
                }
            case 4:{
                System.out.println("Informe o id da pessoa: ");
                int id = scanner.nextInt();
                Pessoa.excluir(id);
                break;
                }
            case 5:{
                ArrayList<Pessoa> pessoas = Pessoa.listar();
                for (Pessoa p : pessoas) {
                    System.out.println(p);
                }
                break;
                }
            default:
                System.out.println("Operação inválida");
        }
    }
}
