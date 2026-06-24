public interface AcaoSubject {
    void registrarInvestidor(InvestidorObserver investidor);
    void removerInvestidor(InvestidorObserver investidor);
    void notificarInvestidores();
}