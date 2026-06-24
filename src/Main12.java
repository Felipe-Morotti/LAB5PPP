public class Main12 {

    public static void main(String[] args) {

        Item notebook  = new Item("Notebook Dell",   3500.00, 1, 2.5);
        Item mouse     = new Item("Mouse Sem Fio",     89.90, 2, 0.2);
        Item teclado   = new Item("Teclado Mecânico", 249.90, 1, 0.8);

        CarrinhoCompras carrinho = new CarrinhoCompras();

        System.out.println("=== Adicionando itens ===");
        carrinho.adicionaItem(notebook);
        carrinho.adicionaItem(mouse);
        carrinho.adicionaItem(teclado);

        System.out.println("\n--- Q1: Pagamento via PIX ---");
        carrinho.setPagamentoStrategy(new PixPagamento());
        carrinho.realizaPagamento();

        System.out.println("\n--- Q1: Pagamento via Cartão (3x) ---");
        carrinho.setPagamentoStrategy(new CartaoPagamento(3));
        carrinho.realizaPagamento();

        System.out.println("\n--- Q1: Pagamento via Boleto ---");
        carrinho.setPagamentoStrategy(new BoletoPagamento());
        carrinho.realizaPagamento();

        System.out.println("\n--- Q2: Frete Sedex + Boleto ---");
        carrinho.setFreteStrategy(new SedexFrete());
        carrinho.setPagamentoStrategy(new BoletoPagamento());
        carrinho.realizaPagamento();

        System.out.println("\n--- Q2: Frete Normal + PIX ---");
        carrinho.setFreteStrategy(new NormalFrete());
        carrinho.setPagamentoStrategy(new PixPagamento());
        carrinho.realizaPagamento();

        System.out.println("\n--- Removendo item e pagando no cartão (2x) ---");
        carrinho.removeItem(notebook);
        carrinho.setPagamentoStrategy(new CartaoPagamento(2));
        carrinho.setFreteStrategy(null); // sem frete
        carrinho.realizaPagamento();
    }
}