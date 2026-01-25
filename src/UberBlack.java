public class UberBlack extends Veiculos {
	
	private static final double TARIFA_MINIMA = 7.00;
	private static final double CUSTO_POR_KM = 2.00;
	private static final double TAXA_POR_MALA  = 1.20;
	private final boolean rodasLigaLeve;
	private final boolean interiorPremium; 
	private int qtdsMalas;
	private double txMalas = 1.00; // taxa por mala

	public UberBlack(String placa, String chassi, String cor, int capacidade, int ano, String marca, String modelo,  	boolean rodasLigaLeve, boolean interiorPremium, int qtdsMalas) {
		super(placa, chassi, cor, capacidade, ano, marca, modelo);

		this.rodasLigaLeve = rodasLigaLeve;
		this.interiorPremium = interiorPremium;
		this.qtdsMalas = qtdsMalas;
	}
	 
	public int getQtdsMalas() {
		return qtdsMalas;
	}

	public void setQtdsMalas(int qtdsMalas) {
		if (qtdsMalas >= 0)
			this.qtdsMalas = qtdsMalas;
	}

	public boolean isRodasLigaLeve() {
		return rodasLigaLeve;
	}

	public boolean isInteriorPremium() {
		return interiorPremium;
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
    	         
	        return (distanciaKm * CUSTO_POR_KM) + TARIFA_MINIMA + (qtdsMalas * TAXA_POR_MALA);
	    }
	 
	 
	 
	 // Método para exibir os dados dos veículos 
	    public void exibirDadosUB(){
	        exibirDadosV();
	        System.out.println("Rodas de Liga Leve: " + rodasLigaLeve);
	        System.out.println("Interior Premium: " + interiorPremium);
	        System.out.println("Capacidade de malas: " + qtdsMalas);
	    }
	 
}

