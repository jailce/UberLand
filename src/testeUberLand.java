import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		
		Cliente passageiro = new Cliente("Nanda", "12345678901", "01012000", null, null, 0, 0);
		Cliente passageiroVip = new Cliente("Nanda", "12345678901", "01012000", null, null, 0, 12);

		 System.out.println("=== INÍCIO DOS TESTES DE LÓGICA ===\n");

		// ====================== CENÁRIO 1: A CORRIDA PERFEITA (UBER X) =================================
		    System.out.println(">>> Teste 1: Corrida Finalizada com Sucesso (UberX com Ar)");

		Corrida corridaX = new Corrida(passageiro, carroComfort, m, "UFU Campus Santa Mônica", "Dboche Pub Show", LocalDateTime.now());
		Corrida corridaC = new Corrida(passageiro, carroComfort, m, "UFU Campus Santa Mônica", "Dboche Pub Show", LocalDateTime.now());
		Corrida corridaB = new Corrida(passageiro, carroComfort, m, "UFU Campus Santa Mônica", "Dboche Pub Show", LocalDateTime.now());
		// Simula o fluxo
		corridaX.iniciarCorrida();
		corridaC.iniciarCorrida();
		corridaB.iniciarCorrida();
		
		
		//Finaliza a viagem passando km e minutos (aqui o cálculo acontece)

        corridaX.finalizarCorrida(10, 1.0); //10km
		corridaC.finalizarCorrida(10, 0.0); //10km
		corridaB.finalizarCorrida(10, 2.5); //10km
		System.out.println("\n--- RELATÓRIO DA CORRIDA UBER X ---");
		imprimirRelatorio(corridaX);
		System.out.println("\n--- RELATÓRIO DA CORRIDA UBER COMFORT ---");
		imprimirRelatorio(corridaC);
		System.out.println("\n--- RELATÓRIO DA CORRIDA UBER BLACK ---");
		imprimirRelatorio(corridaB);

		// VERIFICAR NO CONSOLE: 

        // O valor total bate com a regra do UberX + Ar Condicionado?

        // O motorista recebeu 40%?
			   
		// ========================= CENÁRIO 2: CANCELAMENTO PELO MOTORISTA ================================



		// Motorista aceitou, mas teve imprevisto antes de iniciar
		System.out.println("\n--- RELATÓRIO DA CORRIDA CANCELADA ---");
		Corrida corridaCancelada = new Corrida(passageiro, carroX, m, "UFU Campus Santa Mônica", "Dboche Pub Show", LocalDateTime.now());
		corridaCancelada.iniciarCorrida();
		corridaCancelada.cancelarCorrida("Motorista");

		// VERIFICAR NO CONSOLE:

        // Status está "Cancelada"?

        // Motivo/Autor está "Motorista"?

       

		// ================================ CENÁRIO 3: PROMOÇÃO VIP ====================================
		System.out.println("\n>>> Teste 2: Corrida com Desconto para Cliente VIP <<<");

		Corrida corridaVip = new Corrida(passageiroVip, carroX, m, "UFU Campus Santa Mônica", "Dboche Pub Show", LocalDateTime.now());
		corridaVip.iniciarCorrida();
		corridaVip.finalizarCorrida(10, 3.0); //10km
		System.out.println("\n--- RELATÓRIO DA CORRIDA VIP ---");
		imprimirRelatorio(corridaVip);
		// Tornar o cliente VIP

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
	System.out.println("Data/Hora Solicitação: " + c.getDataHoraSolicitacao().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));

	System.out.println("Data/Hora Início: " + c.getDataHoraInicio().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
	System.out.println("Data/Hora Fim: " + c.getDataHoraFim().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));

	System.out.println("Distância Real Percorrida: " + c.getDistanciaRealKm() + " km");
	System.out.println("Valor Total da Corrida: R$ " + String.format("%.2f", c.getValorTotal()));
	System.out.println("Valor para Motorista: R$ " + String.format("%.2f", c.getValorMotorista()));
	System.out.println("Valor para UberLand: R$ " + String.format("%.2f", c.getValorUberLand()));
	System.out.println("Forma de Pagamento: " + c.getCliente().getPagamento());



	
if (c.getValorDescontoVip() > 0) {
    System.out.println("Cliente VIPs: [Sim]");
    System.out.println("Desconto VIP Aplicado: -R$ " + String.format("%.2f", c.getValorDescontoVip()));
} else {
    System.out.println("Cliente VIP: [Não]");
   
}
	
	if(c.getValorExtra() > 0) {
		System.out.println("Valor Extra Aplicado: [Sim] R$ " + String.format("%.2f", c.getValorExtra()));
	} else {
		System.out.println("Valor Extra Aplicado: [Não] " );
	}
	





	}
}
