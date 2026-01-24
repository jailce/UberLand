import java.time.LocalDateTime;

public class testeUberLand {

	public static void main(String[] args) {
   	// --- PREPARAÇÃO DO AMBIENTE ---
        // 1. Criar Motorista e Veículos
		Motorista m = new Motorista("Sergio", "22169293876", "08091981", "Rua Brasil,10", "12345678901", "Sergio");
		UberX carroX = new UberX("ABC-1234", "999999", "Prata", 4, 2023, "Fiat", "Mobi");
	
		Corrida corrida1 = new Corrida(carroX, "UFU Campus Santa Mônica", "Dboche Pub Show", LocalDateTime.now());
	
	
		// 2. Criar Cliente
		
		Cliente passageiro = new Cliente("João", "12345678901", "01012000", null, null, 0);

		// ====================== CENÁRIO 1: A CORRIDA PERFEITA (UBER X) =================================


		// Simula o fluxo


		//Finaliza a viagem passando km e minutos (aqui o cálculo acontece)

        // Digamos: 10km, 20 minutos

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


		
    // ======================= MÉTODO AUXILIAR PARA O RELATÓRIO ================





		if (m.getStatusMotorista() == true) {
			m.exibirDadosMotorista();
			corrida1.exibirDadosCorrida();
	}	else
		System.out.println("Motorista inativo");
	}
}
