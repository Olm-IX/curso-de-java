package entities;

public class PessoaJuridica extends Contribuinte {
	
	private int numeroFuncionaros;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double renda, int numeroFuncionaros) {
		super(nome, renda);
		this.numeroFuncionaros = numeroFuncionaros;
	}
	
	public int getNumeroFuncionaros() {
		return numeroFuncionaros;
	}

	public void setNumeroFuncionaros(int numeroFuncionaros) {
		this.numeroFuncionaros = numeroFuncionaros;
	}

	@Override
	public Double impostoPago() {
		if (numeroFuncionaros > 10) {
			return getRendaAnual() * 0.14;
			} else {
				return getRendaAnual() * 0.16;
		}
	}
	
}
