public class PixPagamento implements PagamentoStrategy {
    @Override
    public void realizarPagamento(double valor) {
        System.out.printf("✔ Pagamento via PIX no valor de R$%.2f realizado com sucesso!%n", valor);
    }
}