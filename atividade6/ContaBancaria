public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private Cliente cliente;

    public ContaBancaria(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado na conta " + numeroConta);
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado na conta " + numeroConta);
        } else {
            System.out.println("Saldo insuficiente na conta " + numeroConta);
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo da conta " + numeroConta + ": " + saldo);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
