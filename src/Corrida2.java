import java.time.Duration;
import java.time.LocalDateTime; 

public class Corrida extends RegrasUberLand {

    // Constantes
    public static final int SOLICITADA = 0;
    public static final int EM_ANDAMENTO = 1;
    public static final int FINALIZADA = 2;
    public static final int CANCELADA = 3;
    public static final double VALOR_EXTRA = 5.00; // Constantes costumam ser UPPERCASE
    
    // Atributos
    // private Cliente cliente;
    private Veiculos veiculo;
    private String origem;
    private String destino;
    private LocalDateTime dataHoraSolicitacao;
    private LocalDateTime dataHoraOrigem;
    private LocalDateTime dataHoraDestino;
    private int duracaoViagem; // em minutos
    private double distanciaRealKm;
    private double valorTotal;
    private boolean pagarValorExtra;
    private double valorMotorista;
    private double valorUberLand;
    private int statusCorrida; // 0 - solicitada, 1 - em andamento, 2 - finalizada, 3 - cancelada
    private boolean canceladaPor; // true = cliente, false = motorista
    private String formasPagamento;

    // --- Construtor ---
    public Corrida(Cliente cliente, Veiculos veiculo, String origem, String destino, String formasPagamento) {
        // Inicializa com segurança
        // this.cliente = cliente;
        this.veiculo = veiculo;
        this.origem = origem;
        this.destino = destino;
        this.formasPagamento = formasPagamento;
        
        this.dataHoraSolicitacao = LocalDateTime.now();
        this.statusCorrida = SOLICITADA;
    }

    // --- Getters e Setters ---

    public Corrida(Cliente p1, UberX carro, Motorista m, String string, String string2, LocalDateTime now) {
        //TODO Auto-generated constructor stub
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
        } else {
            System.out.println("AVISO: Tentativa de definir Cliente NULO na corrida.");
        }
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        if (veiculo != null) {
            this.veiculo = veiculo;
        } else {
            System.out.println("AVISO: Tentativa de definir Veículo NULO na corrida.");
        }
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        if (origem != null && !origem.isEmpty()) {
            this.origem = origem;
        }
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        if (destino != null && !destino.isEmpty()) {
            this.destino = destino;
        }
    }

    public LocalDateTime getDataHoraSolicitacao() {
        return dataHoraSolicitacao;
    }

    public int getStatusCorrida() {
        return statusCorrida;
    }

    public int getDuracaoViagem() {
        return duracaoViagem;
    }

    public double getDistaciaRealKm() {
        return distanciaRealKm;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean isPagarValorExtra() {
        return pagarValorExtra;
    }

    public void setPagarValorExtra(boolean pagarValorExtra) {
        // Só permite alterar a regra de valor extra se a corrida ainda não começou
        if (statusCorrida == SOLICITADA) {
            this.pagarValorExtra = pagarValorExtra;
        }
    }

    public double getValorMotorista() {
        return valorMotorista;
    }

    public void setValorMotorista(double valorMotorista) {
        this.valorMotorista = valorMotorista;
    }

    public double getValorUberLand() {
        return valorUberLand;
    }

    public void setValorUberLand(double valorUberLand) {
        this.valorUberLand = valorUberLand;
    }

    public String getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(String formasPagamento) {
        if (formasPagamento != null && !formasPagamento.isEmpty()) {
            this.formasPagamento = formasPagamento;
        }
    }

    public void setCanceladaPor(boolean canceladaPor) {
        this.canceladaPor = canceladaPor; // Lógica simplificada
    }

    public boolean isCanceladaPorCliente() {
        return statusCorrida == CANCELADA && canceladaPor;
    }

    public boolean isCanceladaPorMotorista() {
        return statusCorrida == CANCELADA && !canceladaPor;
    }

    // --- Métodos de Regra de Negócio ---

    public void iniciarCorrida() {
        if (statusCorrida == SOLICITADA) {
            this.statusCorrida = EM_ANDAMENTO;
            this.dataHoraOrigem = LocalDateTime.now();
        }
    }

    public void finalizarCorrida(double distanciaRealKm, double d, double e) {
        // Validação de segurança: Não finaliza se não tiver veículo ou se a distância for inválida
        if (statusCorrida != EM_ANDAMENTO || distanciaRealKm <= 0) {
            System.out.println("Erro ao finalizar: Corrida não iniciada ou distância inválida.");
            return;
        }
        
        if (veiculo == null) {
            System.out.println("ERRO FATAL: Veículo não atribuído. Não é possível calcular custos.");
            return;
        }

        this.statusCorrida = FINALIZADA;
        this.dataHoraDestino = LocalDateTime.now();
        this.duracaoViagem = calcularDuracaoViagem();
        this.distanciaRealKm = distanciaRealKm;
        
        calcularValorViagem();
        
        // Assume que RegrasUberLand tem um método estático (static)
        RegrasUberLand.calcularDivisaoCorrida(this);
    }

    private int calcularDuracaoViagem() {
        if (dataHoraOrigem != null && dataHoraDestino != null) {
            return (int) Duration.between(dataHoraOrigem, dataHoraDestino).toMinutes();
        }
        return 0;
    }

    public void cancelarCorrida(boolean canceladaPor) {
        if (statusCorrida == SOLICITADA || statusCorrida == EM_ANDAMENTO) {
            this.statusCorrida = CANCELADA;
            setCanceladaPor(canceladaPor);
        }
    }

    private void calcularValorViagem() {
        // Proteção extra caso chamem esse método manualmente sem ter veículo
        if (veiculo == null) {
            System.out.println("Erro: Não há veículo para calcular o custo.");
            return;
        }

        double custoBase = veiculo.calcularCustoViagem(distanciaRealKm);

        if (pagarValorExtra) {
            this.valorTotal = custoBase + VALOR_EXTRA;
        } else {
            this.valorTotal = custoBase;
        }
    }

    public void exibirDadosCorrida() {
        System.out.println("----- Dados da Corrida -----");
        System.out.println("Origem: " + getOrigem());
        System.out.println("Destino: " + getDestino());
        
        String statusTexto = switch (statusCorrida) {
            case SOLICITADA -> "Solicitada";
            case EM_ANDAMENTO -> "Em Andamento";
            case FINALIZADA -> "Finalizada";
            case CANCELADA -> "Cancelada";
            default -> "Desconhecido";
        };
		
        System.out.println("Status da Corrida: " + statusTexto);

        if (veiculo != null) {
            System.out.println("Veículo: " + veiculo.getPlaca() + " (" + veiculo.getModelo() + ")");
        } else {
            System.out.println("Veículo: Não atribuído!");
        }
        
        if (cliente != null) {
            // Supondo que Cliente tem getNome(), se não tiver, ajuste aqui
             System.out.println("Cliente: " + cliente.getNome()); 
        }
        
        System.out.println("Valor Total: R$ " + String.format("%.2f", valorTotal));
    }
}
ignorar