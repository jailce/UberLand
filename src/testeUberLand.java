public class testeUberLand {

	public static void main(String[] args) {
		

		Motorista m = new Motorista("sergio", "22169293876", "08091981", "Rua Brasil,10", "12345678901", "Sergio");
		
		//m.setStatus(false);
				
		if (m.getAtivo() == true) {
			m.exibirDadosMOTORISTA();
	}else
		System.out.println("Motorista inativo");

	
	}
}
