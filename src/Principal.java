import java.time.LocalDateTime;

public class Principal {

	public static void main(String[] args) {

		Motorista m = new Motorista("Sergio", "09876543210", "01011985", "Rua A, 123", "98765432100", true, "Serginho");
		UberX carroX = new UberX("ABC-1234", "999999", "Prata", 4, 2023, "Fiat", "Mobi", true , true);
		//UberBlack carroBlack = new UberBlack("PRE-9999", "888888", "Preto", 4, 2022, "Chevrolet", "Onix", 2);
		//UberComfort	carroComfort = new UberComfort("XYZ-5678", "777777", "Azul", 4, 2024, "Toyota", "Corolla", true , 3);
	
		Cliente p1 = new Cliente("Nanda", "12345678900", "15081990", "9999999999", "nanda@gmail.com", 'f');
		Cliente p2 = new Cliente("Ana", "123132132132", "12081990", "1111111", "anaflavia@gmail.com", 'F');
		Corrida corrida1 = new Corrida( p1, carroX, m, "UFU Sabta Mônica", "DBoche Pub Show", LocalDateTime.now());
		Corrida corrida2 = new Corrida( p1, carroX, m, "Uberlândia Shopping", "Parque Sabiá", LocalDateTime.now());
		//m.adicionarVeiculo(carroX);
	

		if (m.getStatusMotorista() == true) {
			m.exibirDadosMotorista();
			System.out.println("--- CORRIDA 1 ---");
			corrida1.exibirDadosCorrida();	
			System.out.println("--- CORRIDA 2 ---");
			corrida2.exibirDadosCorrida();
			System.out.println("\n--- FINALIZANDO CORRIDA 1 ---");
			//corrida1.finalizarCorrida(4.0, 25.0, 15.0);
			// System.out.println("\n--- CANCELANDO CORRIDA 2 ---");
			// corrida2.cancelarCorrida();	

			//corrida2.exibirDadosCorridaCancelada(true);
	}	else
		System.out.println("Motorista inativo");
	}
}
