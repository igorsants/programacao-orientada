public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, double saldoInicial, double limiteChequeEspecial) {
        super(numeroConta, saldoInicial);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= (getSaldo() + limiteChequeEspecial)) {
            super.sacar(valor);
        } else {
            System.out.println("Saldo e limite de cheque especial insuficientes na conta " + getNumeroConta());
        }
    }
}
