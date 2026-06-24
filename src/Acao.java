import java.util.ArrayList;
import java.util.List;

public class Acao implements AcaoSubject {

    private final String ticker;
    private double preco;
    private final List<InvestidorObserver> investidores = new ArrayList<>();

    public Acao(String ticker, double precoInicial) {
        this.ticker = ticker;
        this.preco  = precoInicial;
        System.out.printf("[Acao %s] Criada com preco inicial R$%.2f%n", ticker, precoInicial);
    }


    @Override
    public void registrarInvestidor(InvestidorObserver investidor) {
        investidores.add(investidor);
    }

    @Override
    public void removerInvestidor(InvestidorObserver investidor) {
        investidores.remove(investidor);
    }

    @Override
    public void notificarInvestidores() {
        for (InvestidorObserver inv : investidores) {
            inv.notificar(ticker, preco);
        }
    }

    public void setPreco(double novoPreco) {
        double variacao = novoPreco - this.preco;
        double percentual = (variacao / this.preco) * 100;
        this.preco = novoPreco;

        System.out.printf("%n[Acao %s] Novo preco: R$%.2f  (%+.2f | %+.1f%%)%n",
                ticker, novoPreco, variacao, percentual);

        notificarInvestidores();
    }

    public String getTicker() { return ticker; }
    public double getPreco()  { return preco; }
}