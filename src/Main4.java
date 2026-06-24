public class Main4 {

    public static void main(String[] args) {

        AcaoBroker brokerAlpha = new AcaoBroker("Alpha Investimentos");
        AcaoBroker brokerBeta  = new AcaoBroker("Beta Corretora");

        Acao petr4 = new Acao("PETR4", 35.00);
        Acao vale3 = new Acao("VALE3", 68.00);

        Investidor ana = new Investidor("Ana",   brokerAlpha, 30.00, 40.00, 100);

        Investidor bruno = new Investidor("Bruno", brokerBeta,  32.00, 38.00, 200);

        Investidor carlos = new Investidor("Carlos", brokerAlpha, 60.00, 75.00, 50);

        System.out.println("\n=== Registrando investidores nas acoes ===");
        petr4.registrarInvestidor(ana);
        petr4.registrarInvestidor(bruno);
        vale3.registrarInvestidor(carlos);


        System.out.println("\n=== Simulacao de mercado ===");

        petr4.setPreco(36.50);
        petr4.setPreco(38.20);
        petr4.setPreco(41.00);
        petr4.setPreco(29.50);
        vale3.setPreco(70.00);
        vale3.setPreco(76.50);
        vale3.setPreco(58.00);

        System.out.println("\n=== Carlos se desregistra de VALE3 ===");
        vale3.removerInvestidor(carlos);
        vale3.setPreco(55.00);
    }
}