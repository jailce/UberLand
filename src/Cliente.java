public class Cliente extends Pessoa{
	private String cel;
	private String email;
	private int sexo;
	private String pagamento;
	private int nroCorridas;
	private boolean StatusVIP;
	

	public Cliente(String nome, String cpf, String datanasc, String cel, String email, int sexo, int nroCorridas) {
		super (nome, cpf, datanasc);
		this.cel = cel;
		this.email = email;
		this.sexo = sexo;
		this.pagamento = "Dinheiro";
		this.nroCorridas = nroCorridas;
		
	}

	public Cliente(String nome, String cpf) {
		super (nome, cpf);
	}
	
	public Cliente() { // construtor default
		super ();
		this.sexo = 'N';	
		this.pagamento = "CARTAO DE CREDITO";
	}

	public int getNroCorridas() {
		return nroCorridas;
	}
	public void setNroCorridas(int nroCorridas) {
		this.nroCorridas = nroCorridas;
	}

	public boolean isStatusVIP() {
		return StatusVIP;
	}
	public void setStatusVIP(boolean statusVIP) {
		StatusVIP = statusVIP;
	}

	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		if (cel != null && cel.length() == 11)
			this.cel = cel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
	    if (email != null) {
	        int primeira = email.indexOf('@');
	        int ultima = email.lastIndexOf('@');

	        if (primeira > 0 && primeira == ultima && primeira < email.length() - 1) {
	            this.email = email;
	        }
	    }
	}

	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		sexo = Character.toUpperCase(sexo);
		
		this.sexo = switch (sexo) {
   			case 1 -> 'M';
   			case 2 -> 'F';
   			default -> 'N';
		};
	}

	public boolean verificarVip() {
		if (nroCorridas >= 10) {
			this.StatusVIP = true;
		} else {
			this.StatusVIP = false;
		}
		return this.StatusVIP;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		if (pagamento == null) {
			this.pagamento = "CARTAO DE CREDITO";
			return;
		}
			
		pagamento = pagamento.toUpperCase();
		

		this.pagamento = switch (pagamento) {
			case "PIX" -> "PIX";
			case "DINHEIRO" -> "DINHEIRO";
			default -> "CARTAO DE CREDITO";
		};
			 
	}
	
		
}
