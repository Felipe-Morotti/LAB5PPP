public class NormalFrete implements FreteStrategy {
    private static final double TAXA_POR_KG = 5.0;

    @Override
    public double calcularFrete(double pesoTotalKg) {
        return pesoTotalKg * TAXA_POR_KG;
    }

    @Override
    public String getNome() {
        return "Normal";
    }
}