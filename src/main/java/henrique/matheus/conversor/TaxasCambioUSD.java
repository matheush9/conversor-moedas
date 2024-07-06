package henrique.matheus.conversor;

public enum TaxasCambioUSD {
    USD(1F),
    BRL(0.1832F),
    EUR(1.0853F),
    JPY(0.006221F),
    GBP(1.2809F);

    public final Float valor;

    TaxasCambioUSD(Float valor) {
        this.valor = valor;
    }
}
