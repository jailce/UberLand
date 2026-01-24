public class MainTeste {
    public static void main(String[] args) {
        // --- PREPARAÇÃO DO AMBIENTE ---
        // 1. Criar Motorista e Veículos
        Motorista mot1 = new Motorista("João", "111.111.111-11", ...);
        Veiculo carroX = new UberX("ABC-1234", ..., true); // Tem Ar Condicionado (Taxa extra!)
        Veiculo carroBlack = new UberBlack(); // Tem 3 malas (Taxa extra!)
        
        mot1.adicionarVeiculo(carroX);
        mot1.adicionarVeiculo(carroBlack);

        // 2. Criar Cliente
        Cliente cli = new Cliente("Maria", "222.222.222-22", ...);

        System.out.println("=== INÍCIO DOS TESTES DE LÓGICA ===\n");

        // --- CENÁRIO 1: A CORRIDA PERFEITA (UBER X) ---
        System.out.println(">>> Teste 1: Corrida Finalizada com Sucesso (UberX com Ar)");
        
        Corrida corrida1 = new Corrida(cli, carroX, "Centro", "Shopping", new Date());
        // Simula o fluxo
        corrida1.iniciarViagem();
        
        // Finaliza a viagem passando km e minutos (aqui o cálculo acontece)
        // Digamos: 10km, 20 minutos
        corrida1.finalizarViagem(10.0, 20.0); 
        
        imprimirRelatorio(corrida1); 
        // VERIFICAR NO CONSOLE: 
        // O valor total bate com a regra do UberX + Ar Condicionado?
        // O motorista recebeu 40%?

        
        // --- CENÁRIO 2: CANCELAMENTO PELO MOTORISTA ---
        System.out.println("\n>>> Teste 2: Corrida Cancelada pelo Motorista");
        
        Corrida corrida2 = new Corrida(cli, carroBlack, "Shopping", "Casa", new Date());
        
        // Motorista aceitou, mas teve imprevisto antes de iniciar
        corrida2.cancelarViagem(mot1); // Passa o objeto motorista
        
        imprimirRelatorio(corrida2);
        // VERIFICAR NO CONSOLE:
        // Status está "Cancelada"?
        // Motivo/Autor está "Motorista"?
        // Valor deve ser 0.

        
        // --- CENÁRIO 3: PROMOÇÃO VIP ---
        System.out.println("\n>>> Teste 3: Evolução para VIP");
        
        // Simula várias corridas curtas para atingir a meta (ex: supondo que a meta seja 3)
        // Nota: O enunciado diz que a realização da corrida impacta na conversão [cite: 3240]
        for(int i=0; i < 5; i++) {
             Corrida cRapida = new Corrida(cli, carroX, "A", "B", new Date());
             cRapida.finalizarViagem(2.0, 5.0);
             System.out.println("Corrida " + (i+1) + " finalizada. Cliente é VIP? " + cli.isVip());
        }
        
        // Agora faz uma corrida longa para ver o desconto
        System.out.println("\n>>> Teste 4: Corrida com Desconto VIP");
        Corrida corridaVip = new Corrida(cli, carroBlack, "Aeroporto", "Hotel", new Date());
        corridaVip.finalizarViagem(50.0, 60.0);
        
        imprimirRelatorio(corridaVip);
        // VERIFICAR NO CONSOLE:
        // O valor tem desconto comparado a uma corrida normal?
    }

    // --- MÉTODO AUXILIAR PARA O RELATÓRIO ---
    public static void imprimirRelatorio(Corrida c) {
        System.out.println("------------------------------------------------");
        System.out.println("Status: " + c.getStatus());
        if (c.getStatus().equals("CANCELADA")) {
            System.out.println("Cancelado por: " + c.getCanceladoPor());
        } else {
            System.out.println("Veículo: " + c.getVeiculo().getPlaca() + " (" + c.getVeiculo().getClass().getSimpleName() + ")");
            System.out.println("Distância: " + c.getDistanciaReal() + " km");
            System.out.printf("Valor Total: R$ %.2f\n", c.getValorTotal());
            System.out.printf("  -> UberLand (60%%): R$ %.2f\n", c.getValorEmpresa());
            System.out.printf("  -> Motorista (40%%): R$ %.2f\n", c.getValorMotorista());
        }
        System.out.println("------------------------------------------------");
     
    }
}