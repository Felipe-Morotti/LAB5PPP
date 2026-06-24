import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

    private final List<Item> itens = new ArrayList<>();
    private PagamentoStrategy pagamentoStrategy;
    private FreteStrategy freteStrategy;


    public void adicionaItem(Item item) {
        itens.add(item);
        System.out.println("  [+] " + item);
    }

    public void removeItem(Item item) {
        if (itens.remove(item)) {
            System.out.println("  [-] Removido: " + item.getNome());
        } else {
            System.out.println("  [!] Item não encontrado: " + item.getNome());
        }
    }

    public double calculaTotal() {
        return itens.stream().mapToDouble(Item::getPrecoTotal).sum();
    }

    public double calculaFrete() {
        if (freteStrategy == null)
            throw new IllegalStateException("Estratégia de frete não definida!");
        double pesoTotal = itens.stream().mapToDouble(Item::getPesoTotal).sum();
        double frete = freteStrategy.calcularFrete(pesoTotal);
        System.out.printf("  Frete (%s): R$%.2f  (peso total %.2f kg)%n",
                freteStrategy.getNome(), frete, pesoTotal);
        return frete;
    }

    public void realizaPagamento() {
        if (pagamentoStrategy == null)
            throw new IllegalStateException("Estratégia de pagamento não definida!");
        if (itens.isEmpty()) {
            System.out.println("  Carrinho vazio — nada a pagar.");
            return;
        }

        System.out.println("\n  === Resumo do Carrinho ===");
        itens.forEach(i -> System.out.println("  " + i));
        System.out.printf("  Subtotal : R$%.2f%n", calculaTotal());

        if (freteStrategy != null) {
            double frete = calculaFrete();
            System.out.printf("  Total    : R$%.2f%n", calculaTotal() + frete);
            pagamentoStrategy.realizarPagamento(calculaTotal() + frete);
        } else {
            System.out.printf("  Total    : R$%.2f%n", calculaTotal());
            pagamentoStrategy.realizarPagamento(calculaTotal());
        }
    }


    public void setPagamentoStrategy(PagamentoStrategy estrategia) {
        this.pagamentoStrategy = estrategia;
    }

    public void setFreteStrategy(FreteStrategy estrategia) {
        this.freteStrategy = estrategia;
    }
}