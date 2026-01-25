public class UberX extends Veiculos {
	
	public static final double TARIFA_MINIMA = 4.00;
    public static final double CUSTO_POR_KM = 1.20;
	private final boolean arCondicionado;
	private final boolean confortoBasico;
	
	
	public UberX(String placa, String chassi, String cor, int capacidade, int ano, String marca, String modelo, boolean confortoBasico, boolean arCondicionado) {
        super(placa, chassi, cor, capacidade, ano, marca, modelo);
		this.confortoBasico = confortoBasico;
        this.arCondicionado = arCondicionado;

	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public boolean isConfortoBasico() {
		return confortoBasico;
	}

	public double txArCondicionado() {
		if (arCondicionado == true) {
			return 1.2;
		} else {
			return 0.0;
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
		return distanciaKm * CUSTO_POR_KM + TARIFA_MINIMA + txArCondicionado();
	    
	}
	
    public void exibirDadosUX(){
        exibirDadosV();
        System.out.println("Ar Condicionado: " + arCondicionado);
        System.out.println("Conforto Básico: " + confortoBasico);
    }

}
