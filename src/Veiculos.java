
public abstract class Veiculos {

	  // --- Definindo os Status como constantes ---
    public static final int DISPONIVEL = 1;
    public static final int NAO_DISPONIVEL = 2;
    public static final int EM_VIAGEM = 3;
    public static final int FINALIZANDO_VIAGEM = 4;

    private String placa;
    private String chassi;
    private String cor;
    private int capacidade;
    private int ano;
    private String marca;
    private String modelo;
    private int status; 
    private boolean ativo;    //carro inativo => ativo = false e deletado=false
	private boolean deletado; // carro ativo => ativo = true e deletado=false
                              // carro deletado=> ativo=false e deletado = true	
    
    public Veiculos(String placa, String chassi, String cor, int capacidade, int ano, String marca, String modelo) {
    	this.placa = placa;
    	this.chassi = chassi;
    	this.cor = cor;
    	this.capacidade = capacidade;
    	this.ano = ano;
    	this.marca = marca;
    	this.modelo = modelo;

		// Define direto aqui, sem pedir no main
    	this.status = DISPONIVEL;
    	this.ativo = true; // Pode usar 'this.ativo' se quiser manter o padrão
    	this.deletado = false;
	}
    
    // Getters:
    public int getStatus() {
        return status;
    }
    public String getPlaca() {
        return placa;
    }
    public String getChassi() {
        return chassi;
    }
    public String getCor() {
        return cor;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public int getAno() {
        return ano;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }

    //Setters:
    public void setPlaca(String placa) {
		if(placa != null && placa.length() == 7)
			this.placa = placa;
	}
	public void setChassi(String chassi) {
		if(chassi != null && chassi.length() == 17 )
			this.chassi = chassi;
	}
	public void setCor(String cor) {
		if(cor != null && cor.length() > 0)
			this.cor = cor;
	}
	public void setCapacidade(int capacidade) {
		if(capacidade >= 3)
			this.capacidade = capacidade;
	}
	public void setAno(int ano) {
		if (ano > 2016 && ano < 2026)
			this.ano = ano;
	}
	public void setMarca(String marca) {
		if(marca != null && marca.length() > 0)
			this.marca = marca;
	}
	public void setModelo(String modelo) {
		if (modelo != null && modelo.length() > 0)
			this.modelo = modelo;
	}
	public void setStatus(int status) {
		if (deletado == false)
	        this.status = status;
	    }
	
	public boolean isAtivo() {
		return ativo;
	}

	public void ativar() {
		if (deletado == false)
			ativo = true;
	}
	public void desativar() {
		ativo = false;
	}

	public boolean isDeletado() {
		return deletado;
	}

	public void deletar () {
		deletado = true;
		ativo = false;
	}
	
	protected double getTarifaMinima() {
		return 0.0;
	}
	protected double getCustoKm() {
		return 0.0;
	}
	
	public double calcularCustoViagem(double distanciaKm) {
		return  (getCustoKm() * distanciaKm) + getTarifaMinima();
	}
	
	  // Método base para exibir dados:
    public void exibirDadosV(){
        System.out.println("Placa: " + placa);
        System.out.println("Chassi: " + chassi);
        System.out.println("Cor: " + cor);
        System.out.println("Capacidade: " + capacidade);
        System.out.println("Ano: " + ano);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }

	public Object getMotorista() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getMotorista'");
	}
}
