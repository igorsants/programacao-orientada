import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<ContaBancaria> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    public void listarContas() {
        System.out.println("Contas do Banco " + nome + ":");
        for (ContaBancaria conta : contas) {
            System.out.println("Número da Conta: " + conta.getNumeroConta());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println("----------------------");
        }
    }
}
