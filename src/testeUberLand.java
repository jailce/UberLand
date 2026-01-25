import java.time.LocalDateTime;

public class testeUberLand {

	public static void main(String[] args) {
   	// --- PREPARAÇÃO DO AMBIENTE ---
        // 1. Criar Motorista e Veículos
		Motorista m = new Motorista("Sergio", "22169293876", "08091981", "Rua Brasil,10", "12345678901", true, "Sergim");
		UberX carroX = new UberX("ABC1234", "12345678901234567", "Preto", 4, 2020, "Toyota", "Corolla", true, true);
		UberBlack carroBlack = new UberBlack("DEF5678", "98765432109876543", "Branco", 4, 2021, "BMW", "Serie 5", true, true,  3);
		UberComfort carroComfort = new UberComfort("GHI9012", "19283746556473829", "Prata", 4, 2019, "Honda", "Civic", true, true, true);

	
		m.adicionarVeiculo(carroX);
		m.adicionarVeiculo(carroComfort);
		m.adicionarVeiculo(carroBlack);
	
		// 2. Criar Cliente
		
		Cliente passageiro = new Cliente("João", "12345678901", "01012000", null, null, 0);

		 System.out.println("=== INÍCIO DOS TESTES DE LÓGICA ===\n");

		// ====================== CENÁRIO 1: A CORRIDA PERFEITA (UBER X) =================================
		    System.out.println(">>> Teste 1: Corrida Finalizada com Sucesso (UberX com Ar)");

		Corrida corrida1 = new Corrida(passageiro, carroX, m, "UFU Campus Santa Mônica", "Dboche Pub Show", LocalDateTime.now());
		// Simula o fluxo
		corrida1.iniciarCorrida();
		
		//Finaliza a viagem passando km e minutos (aqui o cálculo acontece)

        corrida1.finalizarCorrida(10, 0.0); //10km, 20 minutos

		imprimirRelatorio(corrida1);

		// VERIFICAR NO CONSOLE: 

        // O valor total bate com a regra do UberX + Ar Condicionado?

        // O motorista recebeu 40%?
			   
		// ========================= CENÁRIO 2: CANCELAMENTO PELO MOTORISTA ================================



		// Motorista aceitou, mas teve imprevisto antes de iniciar

		// VERIFICAR NO CONSOLE:

        // Status está "Cancelada"?

        // Motivo/Autor está "Motorista"?

        // Valor deve ser 0.

		// ================================ CENÁRIO 3: PROMOÇÃO VIP ====================================

		// Simula várias corridas curtas para atingir a meta (ex: supondo que a meta seja 3)

        // Nota: O enunciado diz que a realização da corrida impacta na conversão [cite: 3240]


		// Agora faz uma corrida longa para ver o desconto


		// VERIFICAR NO CONSOLE:

        // O valor tem desconto comparado a uma corrida normal?

	}
		
    // ======================= MÉTODO AUXILIAR PARA O RELATÓRIO ================

	public static void imprimirRelatorio(Corrida c){
	System.out.println("Status: " + c.getStatusCorridaFormatado());
	System.out.println("Motorista: " + c.getMotorista().getNomeSocial());
	System.out.println("Cliente: " + c.getCliente().getNome());
	System.out.println("Veículo: " + c.getVeiculo().getModelo() +  " " + c.getVeiculo().getMarca() +  " " + c.getVeiculo().getCor());
	System.out.println("Origem: " + c.getOrigem());
	System.out.println("Destino: " + c.getDestino());
	System.out.println("Data/Hora Solicitação: " + c.getDataHoraSolicitacao());
	//System.out.println("Data/Hora Início: " + c.getDataHoraInicio());
	//System.out.println("Data/Hora Fim: " + c.getDataHoraFim());
	System.out.println("Distância Real Percorrida (km): " + c.getDistanciaRealKm());
	System.out.println("Valor Total da Corrida: " + c.getValorTotal());
	System.out.println("Valor para Motorista: " + c.getValorMotorista());
	System.out.println("Valor para UberLand: " + c.getValorUberLand());
	





	// 	if (m.getStatusMotorista() == true) {
	// 	//	m.exibirDadosMotorista();
	// 				System.out.println("-----------------------");
	// 		m.listarVeiculos();
	// 	System.out.println("-----------------------");
	// 	//	corrida1.exibirDadosCorrida();
	// }	else
	// 	System.out.println("Motorista inativo");
	}
}
