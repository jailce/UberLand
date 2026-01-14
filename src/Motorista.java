import java.util.*;

public class Motorista extends Pessoa {
	private String end;
	private String cnh;
	private String nomesocial;
	private boolean ativo;

	// O 'final' garante que a lista de veículos seja criada apenas uma vez (no construtor).
    // Isso impede que a lista inteira seja substituída por outra ou vire 'null' por acidente,
    // mas ainda permite adicionar e remover veículos normalmente.
    private final List<Veiculos> veiculos;

	
	public Motorista(String nome, String cpf, String datanasc, String end, String cnh, String nomesocial) {
		super (nome, cpf, datanasc);
		this.end = end;
		this.cnh = cnh;
		this.nomesocial = nomesocial;
		this.ativo = true;
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
	public String getNomesocial() {
		return nomesocial;
	}
	public void setNomesocial(String nomesocial) {
		if (nomesocial != null && nomesocial.length()>0)
			this.nomesocial = nomesocial;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void ativar() {
		this.ativo= true;
	}
	public void desativar() {
		this.ativo = false;
				
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
	
	public void exibirDadosMOTORISTA(){
		System.out.println("=== DADOS DO MOTORISTA ===");
		exibirDadosPESSOA();
		System.out.println("Nome social: " + nomesocial);
		System.out.println("Endereço: " + end);
		System.out.println("CNH: " + cnh);
		System.out.println("Status: " + ativo);
	}

    
}
