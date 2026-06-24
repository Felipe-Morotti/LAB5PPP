import java.util.ArrayList;
import java.util.List;

public class CentralEstacaoTempo implements CentralEstacaoSubject {

    private final List<EstacaoObserver> observers = new ArrayList<>();

    private double temperatura;
    private double umidadeRelativa;
    private double velocidadeVento;
    @Override
    public void registrarObserver(EstacaoObserver observer) {
        observers.add(observer);
        System.out.println("[CET] Observer registrado: " + observer.getClass().getSimpleName());
    }

    @Override
    public void removerObserver(EstacaoObserver observer) {
        observers.remove(observer);
        System.out.println("[CET] Observer removido: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notificarObservers() {
        for (EstacaoObserver obs : observers) {
            obs.atualizar(temperatura, umidadeRelativa, velocidadeVento);
        }
    }

    public void setDados(double temperatura, double umidadeRelativa, double velocidadeVento) {
        this.temperatura      = temperatura;
        this.umidadeRelativa  = umidadeRelativa;
        this.velocidadeVento  = velocidadeVento;

        System.out.printf("%n[CET] Nova leitura: Temp=%.1f°C  Umidade=%.1f%%  Vento=%.1f km/h%n",
                temperatura, umidadeRelativa, velocidadeVento);

        notificarObservers();
    }
}