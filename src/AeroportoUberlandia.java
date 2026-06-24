public class AeroportoUberlandia implements EstacaoObserver {

    private static final double LIMITE_ATENCAO  = 50.0;  // km/h
    private static final double LIMITE_CRITICO  = 80.0;  // km/h

    @Override
    public void atualizar(double temperatura, double umidadeRelativa, double velocidadeVento) {
        System.out.println("  [Aeroporto de Uberlândia]");
        System.out.printf("    Velocidade das Rajadas de Vento: %.1f km/h%n", velocidadeVento);

        if (velocidadeVento >= LIMITE_CRITICO) {
            System.out.println("    !! OPERACOES SUSPENSAS - Ventos extremamente fortes." +
                    " Pousos e decolagens interrompidos.");
        } else if (velocidadeVento >= LIMITE_ATENCAO) {
            System.out.println("    ! ATENCAO - Ventos fortes. Pilotos devem verificar NOTAM" +
                    " e adotar procedimentos de vento cruzado.");
        } else {
            System.out.println("    Condicoes de vento normais. Operacoes liberadas.");
        }
    }
}