public interface CentralEstacaoSubject {
    void registrarObserver(EstacaoObserver observer);
    void removerObserver(EstacaoObserver observer);
    void notificarObservers();
}