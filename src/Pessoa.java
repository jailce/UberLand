public class Pessoa {
	private String nome;
	private String cpf;
	private String datanasc;
	protected int qtdecorridas;
	protected float avaliacao;
	
	public Pessoa (String nome, String cpf, String datanasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.datanasc = datanasc;
		this.qtdecorridas = 0;
		this.avaliacao = 0;
	}
	
	public Pessoa (String nome, String cpf) {
		this(nome, cpf, null);
	}
	
	public Pessoa() {}; // construtor default
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome != null && nome.length()>0)
			this.nome = nome;
	}	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if (validaCpf(cpf))
			this.cpf = cpf;
	}
	public String getDataNasc() {
		return datanasc;
	}
	public void setDataNasc(String datanasc) {
		if (validaDataNasc(datanasc))
			this.datanasc = datanasc;
	}
	
	private boolean validaCpf(String cpf) {
	    if (cpf == null || cpf.length() != 11) { // Verifica se cpf tem 11 digitos 
	        return false;
	    }
	    
	    for (int i = 0; i < cpf.length(); i++) {  // Verifica se cpf so tem numeros
	        if (!Character.isDigit(cpf.charAt(i)))
	            return false;
	    }
	    
	    boolean todosIguais = true; // Verifica se todos os dígitos são iguais
	    for ( int i = 1; i < cpf.length(); i++) {
	        if (cpf.charAt(i) != cpf.charAt(0)) {
	            todosIguais = false;
	        }
	    }
	    if (todosIguais) {
	        return false;
	    }

	    // Cálculo do primeiro dígito verificador
	    int soma = 0;
	    int peso = 10;

	    for (int i = 0; i < 9; i++) {
	        int num = cpf.charAt(i) - '0'; // transforma o char em int
	        soma += num * peso;
	        peso--;
	    }
	    int resto = soma % 11;
	    int digito1 = (resto < 2) ? 0 : 11 - resto;

	    if (digito1 != (cpf.charAt(9) - '0')) { //compara 1DV com 1DV do cpf digitado 
	        return false;
	    }

	    // Cálculo do segundo dígito verificador
	    soma = 0;
	    peso = 11;

	    for (int i = 0; i < 10; i++) {
	        int num = cpf.charAt(i) - '0';
	        soma += num * peso;
	        peso--;
	    }

	    resto = soma % 11;
	    int digito2 = (resto < 2) ? 0 : 11 - resto;

	    if (digito2 != (cpf.charAt(10) - '0')) { //compara 2DV com 2DV do cpf digitado
	        return false;
	    }

	    return true;
	}	


	private boolean validaDataNasc(String data) {
		if (data == null || data.length() != 8)
			return false;
		
		for (int i = 0; i < data.length(); i++) {
		    if (!Character.isDigit(data.charAt(i)))
		        return false;
		}
		    
		int dia = Integer.parseInt(data.substring(0, 2));
		if (dia < 1 || dia > 31) return false;
		
		int mes = Integer.parseInt(data.substring(2, 4));
		if (mes < 1 || mes > 12) return false;
		
		int ano = Integer.parseInt(data.substring(4, 8));
		if (ano < 1900 || ano > 2026) return false;
		
		return true;
	}

	public int getQtdecorridas() {
		return qtdecorridas;
	}

	public void incrementaQtdecorridas() {	
		this.qtdecorridas ++;
	}

	public float getAvaliacao() {
		return avaliacao;
	}

	public void calculaAvalicao(float nota) {
		if (nota >= 0 && nota <=10)
			avaliacao = (avaliacao * qtdecorridas + nota)/(qtdecorridas + 1);
		
	}
	public void exibirDadosPESSOA(){
		System.out.println("Nome: " + nome);			
		System.out.println("CPF: " + cpf);
		System.out.println("Data nasc.: " + datanasc);
	}
	
}	