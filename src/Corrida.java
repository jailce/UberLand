import java.time.Duration; // Import novo (do segundo código) para calcular tempo
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Corrida extends RegrasUberLand { 

    // --- CONSTANTES (Mantidas e Organizadas) ---
    public static final int SOLICITADA = 0;
    public static final int EM_ANDAMENTO = 1;   
    public static final int FINALIZADA = 2;
    public static final int CANCELADA = 3;
    
  

    // --- ASSOCIAÇÕES ---
    private Cliente cliente;
    private Veiculos veiculo;
    private Motorista motorista;

    // --- VIAGEM ---
    private String origem;
    private String destino;
    private double distanciaRealKm;
    private String motivoCancelamento;
    
    
    // private int duracaoViagem; // em minutos
    // private boolean pagarValorExtra; // Se o cliente pediu algo a mais
    // private boolean canceladaPor; // true = cliente, false = motorista
    // private String formasPagamento;

    // --- TEMPOS ---
    private LocalDateTime dataHoraSolicitacao;
    private LocalDateTime dataHoraInicio; // chegada do motorista
    private LocalDateTime dataHoraFim;    // chegada ao destino final

    // --- PREÇOS E TAXAS ---
    private double valorTotal;
    private double valorMotorista;
    private double valorUberLand;
    
    private static final double VALOR_EXTRA = 5.00; 
    //private static final double PORCENTAGEM_APP = 0.40; 

    // --- STATUS ---
    private int statusCorrida; 

    // ==================================================================================
    // CONSTRUTOR (Mantive o SEU para funcionar com seu Main atual)
    // ==================================================================================
    public Corrida(Cliente cliente, Veiculos veiculo, Motorista motorista, String origem, String destino, LocalDateTime dataHoraSolicitacao) {
        setCliente(cliente);
        setVeiculo(veiculo);
        setMotorista(motorista);
        setOrigem(origem);
        setDestino(destino);
        setDataHoraSolicitacao(dataHoraSolicitacao);
        this.statusCorrida = SOLICITADA;
        
        
        // this.pagarValorExtra = false; 
    }

    // ==================================================================================
    // GETTERS E SETTERS
    // ==================================================================================

    // ---  Getters/Setters  ---
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Cliente getCliente() { return cliente; }

    public void setMotorista(Motorista motorista) { this.motorista = motorista; }
    public Motorista getMotorista() { return motorista; }

    public Veiculos getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculos veiculo) { this.veiculo = veiculo; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public LocalDateTime getDataHoraSolicitacao() { return dataHoraSolicitacao; }
    public void setDataHoraSolicitacao(LocalDateTime dataHoraSolicitacao) { this.dataHoraSolicitacao = dataHoraSolicitacao; }

    public void setStatusCorrida(int statusCorrida) { this.statusCorrida = statusCorrida; }

    // --- Getters e Setters Gabriel  ---
    /*
    public void setPagarValorExtra(boolean pagarValorExtra) {
        if (statusCorrida == SOLICITADA) {
            this.pagarValorExtra = pagarValorExtra;
        }
    }
    
    public boolean isPagarValorExtra() { return pagarValorExtra; }
    
    public int getDuracaoViagem() { return duracaoViagem; }
    
    public void setFormasPagamento(String formasPagamento) { this.formasPagamento = formasPagamento; }
    public String getFormasPagamento() { return formasPagamento; }
    */

    // Seu getStatusCorrida (String) mantido
    public String getStatusCorridaFormatado() { // Mudei o nome levemente para não dar conflito com o int getStatus
        switch (statusCorrida) {
            case SOLICITADA: return "Solicitada";
            case EM_ANDAMENTO: return "Em Andamento";
            case FINALIZADA: return "Finalizada";
            case CANCELADA: return "Cancelada";
            default: return "Status Desconhecido";
        }
      
   
    }
    
    // getter simples para o numero
    public int getStatusCorrida() { return statusCorrida; }

    // ==================================================================================
    // MÉTODOS DE LÓGICA
    // ==================================================================================

    public void iniciarCorrida() {
        if (this.statusCorrida == SOLICITADA) {
            this.statusCorrida = EM_ANDAMENTO;
            this.dataHoraInicio = LocalDateTime.now(); // Captura hora inicio
            System.out.println("Corrida iniciada com sucesso.");
        }
    }

    //A finalizarCorrida é calculado o valor total da corrida, o valor que o motorista irá receber e o valor que a UberLand irá reter.
    public void finalizarCorrida(double distanciaRealKm, double valorTotalFinal, double valorUberLandFinal) { 
        

        
        if (this.statusCorrida == EM_ANDAMENTO) {
            this.statusCorrida = FINALIZADA;
            distanciaRealKm * CUSTO_POR_KM + TARIFA_MINIMA + txArCondicionado
            
            
            
            // 1. Calcular Duração
        
            // 2. Calcular Custo usando o Veículo (Polimorfismo)
      
            
            // 3. Adicionar Extra
 
            
            // 4. Calcular Divisão (Exemplo chamando classe externa)
        
          

            System.out.println("Corrida finalizada com sucesso.");
        } else {
            System.out.println("A corrida nao esta em andamento.");
        }
    }

    public void cancelarCorrida(String motivoCancelamento) {
     
        if(this.statusCorrida != FINALIZADA){
               this.statusCorrida = CANCELADA; 
                this.motivoCancelamento = motivoCancelamento;
                System.out.println("Corrida cancelada pelo " + motivoCancelamento);    

        }

        System.out.println("Corrida cancelada");
        
       
    }

    // ==================================================================================
    // EXIBIÇÃO
    // ==================================================================================

    public void exibirDadosCorrida(){
        System.out.println("----- Viagem: -----");
        System.out.println("Origem: " + getOrigem());
        System.out.println("Destino: " + getDestino());
        System.out.println("Data Solicitada: " + getDataHoraSolicitacao());
        System.out.println("Status: " + getStatusCorridaFormatado()); // Usa o texto bonito
        
        System.out.println("----- Passageiro -----");      
        // Proteção contra NullPointerException (Sugestão do cód novo)
        if (cliente != null) System.out.println("Cliente: " + cliente.getNome());

        System.out.println("----- Motorista -----");   
        if (motorista != null) System.out.println("Condutor: " + motorista.getNomeSocial());
        
        if (veiculo != null) {
            System.out.println("Carro: " + veiculo.getMarca() + " " + veiculo.getModelo());
            System.out.println("Placa: " + veiculo.getPlaca());   
            // System.out.println("Categoria: " + veiculo.getClass().getSimpleName()); // Dica do código novo
        }
    }

    public void exibirDadosCorridaFinalizada(){
        System.out.println("----- RELATÓRIO FINAL -----");
        System.out.println("Origem: " + getOrigem());
        System.out.println("Destino: " + getDestino());
        System.out.println("Distancia percorrida: " + distanciaRealKm + " km");
        
        // System.out.println("Duração: " + duracaoViagem + " min"); // Novo recurso
        
        System.out.println("Valor Total: R$ " + valorTotal);
        System.out.println("Status: Finalizada");

        System.out.println("----- Taxas Detalhadas ----");
        if (veiculo != null) System.out.println("Categoria: " + veiculo.getClass().getSimpleName());
        
        System.out.println("Motorista ganha: R$ " + valorMotorista);
        System.out.println("UberLand retém: R$ " + valorUberLand);
    }

    public void exibirDadosCorridaCancelada(){
        System.out.println("----- CORRIDA CANCELADA -----");
        System.out.println("Origem: " + getOrigem());
        System.out.println("Destino: " + getDestino());
        System.out.println("Status: Cancelada");
        // if (canceladaPor) System.out.println("Cancelada pelo Cliente");
        // else System.out.println("Cancelada pelo Motorista");
    }



}