public class CartaoPagamento implements PagamentoStrategy {
    private final int parcelas;

    public CartaoPagamento(int parcelas) {
        if (parcelas < 1) throw new IllegalArgumentException("Parcelas deve ser >= 1.");
        this.parcelas = parcelas;
    }

    @Override
    public void realizarPagamento(double valor) {
        System.out.printf("✔ Pagamento via Cartão de Crédito em %dx de R$%.2f realizado com sucesso!%n",
                parcelas, valor / parcelas);
    }
}