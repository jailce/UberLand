public class RegrasUberLand {

	private static final int CORRIDAS_CLIENTE_VIP = 10;
	
	
	public static Cliente verificarClientevip (Cliente cliente) {
		if (cliente.getQtdecorridas() >= CORRIDAS_CLIENTE_VIP) {
			return new ClienteVip (cliente);
		}
		return cliente;
		
	}
	

	public static float regraDescontovip(ClienteVip clientevip) {
		if (clientevip.getQtdecorridas() >= 50) {
			return  0.2f;
		}else if (clientevip.getQtdecorridas() >= 30) {
			return  0.15f;
		}else {
			return  0.1f;
		}
		
	}

	// Define que o UberLand fica com 20% do valor (0.20)
    private static final double PORCENTAGEM_APP = 0.20;

    public static void calcularDivisaoCorrida(Corrida corrida) {
        
        double valorTotal = corrida.getValorTotal();

        // Calcula a parte do aplicativo
        double parteUberLand = valorTotal * PORCENTAGEM_APP;
        
        // Calcula a parte do motorista (Total - parte do app)
        double parteMotorista = valorTotal - parteUberLand;

        // Salva os valores de volta na corrida
        corrida.setValorUberLand(parteUberLand);
        corrida.setValorMotorista(parteMotorista);
    }
}
	

