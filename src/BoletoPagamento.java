public class BoletoPagamento implements PagamentoStrategy {
    @Override
    public void realizarPagamento(double valor) {
        System.out.printf("✔ Boleto bancário gerado no valor de R$%.2f. Vencimento em 3 dias úteis.%n", valor);
    }
}