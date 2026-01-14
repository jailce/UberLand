public class UberBlack extends Veiculos {
	
	private static final double TARIFA_MINIMA = 7.00;
	private static final double CUSTO_POR_KM = 2.00;
	private final boolean rodasLigaLeve;
	private final boolean interiorPremium; 
	private int qtdsMalas;

	public UberBlack(String placa, String chassi, String cor, int capacidade, int ano, String marca, String modelo,
        	boolean rodasLigaLeve, boolean interiorPremium, int qtdsMalas) {
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
    	double custoTotal = super.calcularCustoViagem(distanciaKm);

        if (this.qtdsMalas > 0)// Regra Extra: Adiciona o valor da Tarifa Mínima para CADA mala
	            custoTotal += (getTarifaMinima() * getQtdsMalas());
	        
	        return custoTotal;
	    }
	 
	 
	 
	 // Método para exibir os dados dos veículos 
	    public void exibirDadosUB(){
	        exibirDadosV();
	        System.out.println("Rodas de Liga Leve: " + rodasLigaLeve);
	        System.out.println("Interior Premium: " + interiorPremium);
	        System.out.println("Capacidade de malas: " + qtdsMalas);
	    }
	 
}

