package br.com.projeto2.projeto2;

import br.com.projeto2.projeto2.conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Pessoa {

    int id;
    private String nome;
    private int idade;

    // Construtores, getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void cadastrar(int tipoPessoa, String cnpjCpf, String nome, int idade) {
        try (Connection conexao = ConexaoBanco.conectar()) {
            String sql = "INSERT INTO pessoa (tipo,cnpj_cpf,nome,idade) VALUES (?,?,?,?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, tipoPessoa);
                stmt.setString(2, cnpjCpf);
                stmt.setString(3, nome);
                stmt.setInt(4, idade);
                stmt.executeUpdate();
                if (tipoPessoa == 1) {
                    System.out.println("Cadastro de Pessoa Física realizado com sucesso.");
                } else {
                    System.out.println("Cadastro de Pessoa Juridica realizado com sucesso.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }

    public static void consultar(int id) {
        try (Connection conexao = ConexaoBanco.conectar()) {
            String sql = "SELECT * FROM pessoa WHERE idpessoa = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    // Obter os dados da pessoa física
                    String cnpjCpf = rs.getString("cnpj_cpf");
                    String nome = rs.getString("nome");
                    int tipoPessoa = rs.getInt("tipo");
                    if (tipoPessoa == 1) {
                        System.out.println("Pessoa Fisica CPF:." + cnpjCpf);
                    } else {
                        System.out.println("Pessoa Juridica CNPJ:." + cnpjCpf);
                    }
                    System.out.println("Nome: " + nome);
                } else {
                    System.out.println("Pessoa Física não encontrada.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }

    public static void atualizar(int id, String cnpjCpf) {
        try (Connection conexao = ConexaoBanco.conectar()) {
            String sql = "UPDATE pessoa SET cnpj_cpf = ? WHERE idpessoa = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, cnpjCpf);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println("Atualização de Pessoa realizada com sucesso.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }

    public static void excluir(int id) {
        try (Connection conexao = ConexaoBanco.conectar()) {
            String sql = "DELETE FROM pessoa WHERE idpessoa = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Exclusão de Pessoa realizada com sucesso.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }

    public static ArrayList<Pessoa> listar() {
        ArrayList<Pessoa> result = new ArrayList<Pessoa>();
        try (Connection conexao = ConexaoBanco.conectar()) {
            String sql = "SELECT * FROM pessoa";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    // Obter os dados da pessoa física
                    String cnpjCpf = rs.getString("cnpj_cpf");
                    String nome = rs.getString("nome");
                    int tipoPessoa = rs.getInt("tipo");
                    int idade = rs.getInt("idade");
                    int idpessoa = rs.getInt("idpessoa");
                    Pessoa pessoa;
                    if (tipoPessoa == 1) {
                        PessoaFisica pessoaFisica = new PessoaFisica();
                        pessoaFisica.setCpf(cnpjCpf);
                        pessoa = pessoaFisica;
                    } else {
                        PessoaJuridica pessoaJuridica = new PessoaJuridica();
                        pessoaJuridica.setCnpj(cnpjCpf);
                        pessoa = pessoaJuridica;
                    }
                    pessoa.setNome(nome);
                    pessoa.setIdade(idade);
                    pessoa.setId(idpessoa);
                    result.add(pessoa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
        return result;
    }
}
