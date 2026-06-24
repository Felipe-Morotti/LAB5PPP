public class PrefeituraUberlandia implements EstacaoObserver {

    private static final double LIMITE_ALERTA   = 30.0;  // %
    private static final double LIMITE_CRITICO  = 20.0;  // %

    @Override
    public void atualizar(double temperatura, double umidadeRelativa, double velocidadeVento) {
        System.out.println("  [Prefeitura de Uberlândia]");
        System.out.printf("    Umidade Relativa do Ar: %.1f%%%n", umidadeRelativa);

        if (umidadeRelativa <= LIMITE_CRITICO) {
            System.out.println("    !! ALERTA CRITICO - Defesa Civil: umidade extremamente baixa!" +
                    " Risco elevado de incêndios e problemas respiratórios.");
        } else if (umidadeRelativa <= LIMITE_ALERTA) {
            System.out.println("    ! ALERTA - Defesa Civil: umidade baixa." +
                    " Recomenda-se hidratação e evitar esforço físico ao ar livre.");
        } else {
            System.out.println("    Umidade dentro dos parâmetros normais. Nenhum alerta emitido.");
        }
    }
}