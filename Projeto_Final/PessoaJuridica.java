package br.com.projeto2.projeto2;

public class PessoaFisica extends Pessoa {

    private String cpf;

    // Outros atributos, construtores, getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Pessoa Fisica (%d) Cpf: %s - Nome: %s - Idade: %d", id,cpf,getNome(),getIdade());
    }
    // Implementações semelhantes para consultar, atualizar e excluir
}
