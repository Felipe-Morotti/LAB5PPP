public class Investidor implements InvestidorObserver {

    private final String nome;
    private final AcaoBroker broker;
    private final double precoMinimo;
    private final double precoMaximo;
    private final int quantidadeAcoes;

    public Investidor(String nome, AcaoBroker broker,
                      double precoMinimo, double precoMaximo, int quantidadeAcoes) {
        this.nome            = nome;
        this.broker          = broker;
        this.precoMinimo     = precoMinimo;
        this.precoMaximo     = precoMaximo;
        this.quantidadeAcoes = quantidadeAcoes;
    }

    @Override
    public void notificar(String tickerAcao, double precoAtual) {
        System.out.printf("  [Investidor %s] %s = R$%.2f  " +
                        "(limite: min=R$%.2f / max=R$%.2f)%n",
                nome, tickerAcao, precoAtual, precoMinimo, precoMaximo);

        if (precoAtual >= precoMaximo) {
            System.out.printf("    -> Preco maximo atingido! Enviando ordem de VENDA ao broker %s.%n",
                    broker.getNome());
            broker.vender(tickerAcao, quantidadeAcoes, precoAtual);

        } else if (precoAtual <= precoMinimo) {
            System.out.printf("    -> Preco minimo atingido! Enviando ordem de COMPRA ao broker %s.%n",
                    broker.getNome());
            broker.comprar(tickerAcao, quantidadeAcoes, precoAtual);

        } else {
            System.out.println("    -> Preco dentro da faixa. Nenhuma acao tomada.");
        }
    }

    public String getNome() { return nome; }
}