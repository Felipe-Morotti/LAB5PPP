public class Main3 {

    public static void main(String[] args) {

        CentralEstacaoTempo cet = new CentralEstacaoTempo();

        PrefeituraUberlandia prefeitura = new PrefeituraUberlandia();
        AeroportoUberlandia  aeroporto  = new AeroportoUberlandia();

        System.out.println("=== Registrando observers na CET ===");
        cet.registrarObserver(prefeitura);
        cet.registrarObserver(aeroporto);

        System.out.println("\n=== Leitura 1: Condições normais ===");
        cet.setDados(25.0, 55.0, 30.0);

        System.out.println("\n=== Leitura 2: Seca moderada ===");
        cet.setDados(32.0, 28.0, 40.0);

        System.out.println("\n=== Leitura 3: Situação crítica ===");
        cet.setDados(38.0, 15.0, 85.0);

        System.out.println("\n=== Removendo Aeroporto da CET ===");
        cet.removerObserver(aeroporto);

        System.out.println("\n=== Leitura 4: Apenas Prefeitura recebe ===");
        cet.setDados(30.0, 25.0, 90.0);
    }
}