
public class ClienteVip extends Cliente{

	private float descontovip;

	public ClienteVip (Cliente cliente) {
		super(cliente.getNome(),cliente.getCpf(),cliente.getDataNasc(),cliente.getCel(),cliente.getEmail(), cliente.getSexo());
		setPagamento(cliente.getPagamento());
		this.descontovip = RegrasUberLand.regraDescontovip(this);
	}

	public float getDescontovip() {
		return descontovip;
	}

		
}

//acho melhoror criar um metodo pra cliente vip em cliente
