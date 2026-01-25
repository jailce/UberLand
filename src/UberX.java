public class UberX extends Veiculos {
	
	public static final double TARIFA_MINIMA = 4.00;
    public static final double CUSTO_POR_KM = 1.20;
	private final boolean arCondicionado;
	private final boolean confortoBasico;
	
	
	public UberX(String placa, String chassi, String cor, int capacidade, int ano, String marca, String modelo, boolean arCondicionado,boolean confortoBasico) {
        super(placa, chassi, cor, capacidade, ano, marca, modelo);
        this.arCondicionado = arCondicionado = true;
        this.confortoBasico = confortoBasico;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public boolean isConfortoBasico() {
		return confortoBasico;
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
	    
	    if (arCondicionado == true || confortoBasico == true)// Regra Extra: Ar OU Conforto Basico = +1 Tarifas Mínimas
	    	custoTotal += getTarifaMinima();
	    
	   	return custoTotal;
	}
	
    public void exibirDadosUX(){
        exibirDadosV();
        System.out.println("Ar Condicionado: " + arCondicionado);
        System.out.println("Conforto Básico: " + confortoBasico);
    }

}
