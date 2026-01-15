import java.util.*;

public class Motorista extends Pessoa {
	private String end;
	private String cnh;
	private String nomeSocial;
	private boolean statusMotorista;

	// O 'final' garante que a lista de veículos seja criada apenas uma vez (no construtor).
    // Isso impede que a lista inteira seja substituída por outra ou vire 'null' por acidente,
    // mas ainda permite adicionar e remover veículos normalmente.
    private final List<Veiculos> veiculos;

	
	public Motorista(String nome, String cpf, String datanasc, String end, String cnh, boolean statusMotorista, String nomeSocial) { 
		super (nome, cpf, datanasc);
		this.end = end;
		this.cnh = cnh;
		this.nomeSocial = nomeSocial;
		this.statusMotorista = statusMotorista;
		veiculos = new ArrayList<>();
	}
	
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		if (end != null && end.length() > 0)
			this.end = end;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		if(cnh != null && cnh.length() == 11)
			this.cnh = cnh;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}
	public void setNomeSocial(String nomeSocial) {
		if (nomeSocial != null && nomeSocial.length()>0)
			this.nomeSocial = nomeSocial;
	}

	public boolean getStatusMotorista() {
		return statusMotorista;
	}
	public void setStatusMotorista(boolean statusMotorista) {
		this.statusMotorista = statusMotorista;
	}

	public void ativar() {
		this.statusMotorista = true;
	}
	public void desativar() {
		this.statusMotorista = false;
				
		for (int i = 0; i < veiculos.size(); i++) {
			veiculos.get(i).desativar();
		}
	}
	public void adicionarVeiculo(Veiculos v) {
		veiculos.add(v);
	}
	
	public void removerVeiculo (Veiculos v) {
		veiculos.remove(v);
	}
	
	public void exibirDadosMotorista(){
		System.out.println("=== DADOS DO MOTORISTA ===");
		exibirDadosPESSOA();
		System.out.println("Nome social: " + nomeSocial);
		System.out.println("Endereço: " + end);
		System.out.println("CNH: " + cnh);
		System.out.println("Status: " + true);
	}

	public void listarVeiculos() {
		System.out.println("=== VEÍCULOS DO MOTORISTA ===");
		if (veiculos.isEmpty()) {
			System.out.println("Nenhum veículo cadastrado.");
		} else {
			for (Veiculos v : veiculos) {
				v.exibirDadosV();
				System.out.println("-----------------------");
			}
		}
	}
    
}
