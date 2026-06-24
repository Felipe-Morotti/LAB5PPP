public class AcaoBroker {

    private final String nome;

    public AcaoBroker(String nome) {
        this.nome = nome;
    }

    public void comprar(String tickerAcao, int quantidade, double precoAtual) {
        System.out.printf("    [Broker %s] COMPRANDO %d acoes de %s a R$%.2f  " +
                        "(custo total: R$%.2f)%n",
                nome, quantidade, tickerAcao, precoAtual, quantidade * precoAtual);
    }

    public void vender(String tickerAcao, int quantidade, double precoAtual) {
        System.out.printf("    [Broker %s] VENDENDO %d acoes de %s a R$%.2f  " +
                        "(receita total: R$%.2f)%n",
                nome, quantidade, tickerAcao, precoAtual, quantidade * precoAtual);
    }

    public String getNome() { return nome; }
}