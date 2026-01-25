public class UberComfort extends Veiculos {

	private static final double TARIFA_MINIMA = 5.00;
    private static final double CUSTO_POR_KM = 1.50;
	private static final double ESPACO_EXTRA_TAXA = 2.00;
	private static final double AR_DUALZONE_TAXA = 1.20;
	private final boolean espacoExtra;
	private final boolean bancoReclinavel;
	private final boolean arDualZone;
	
	
	public UberComfort(String placa, String chassi, String cor, int capacidade, int ano, String marca, String modelo, boolean espacoExtra, boolean bancoReclinavel, boolean arDualZone) {
		super(placa, chassi, cor, capacidade, ano, marca, modelo);
		this.espacoExtra = espacoExtra;
		this.bancoReclinavel = bancoReclinavel;
		this.arDualZone = arDualZone;
	 }

	public boolean isEspacoExtra() {
		return espacoExtra;
	}
	
	public boolean isBancoReclinavel() {
		return bancoReclinavel;
	}

	public boolean isArDualZone() {
		return arDualZone;
	}
	
	public double txEspacoExtra() {
		if (espacoExtra == true) {
			return ESPACO_EXTRA_TAXA;
		} else {
			return 1.0;
		}
	}

	public double txArDualZone() {
		if (arDualZone == true) {
			return AR_DUALZONE_TAXA;
		} else {
			return 1.0;
		}
	}

	// @Override garante que este método está substituindo corretamente o da classe pai.
	@Override
	public double getTarifaMinima() {
		return TARIFA_MINIMA;
	}
	 
	@Override
	public double getCustoKm() {
		return CUSTO_POR_KM;
	}
	
	@Override
	public double calcularCustoViagem(double distanciaKm) {

	    return distanciaKm * CUSTO_POR_KM + TARIFA_MINIMA + ( txEspacoExtra() * txArDualZone());
	}
	 
	public void exibirDadosCF(){
	    exibirDadosV();
	    System.out.println("Espaço Extra: " + espacoExtra);
	    System.out.println("Banco Reclinavel: " + bancoReclinavel);
	    System.out.println("Ar Dual Zone: " + arDualZone);

	}
	 
}
