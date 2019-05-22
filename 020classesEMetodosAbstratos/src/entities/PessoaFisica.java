package entities;

public class PessoaFisica extends Contribuinte {
	// ESCREVENDO ISSO DA UM ERRO, CLICAR NELE PARA O JAVA CRIAR UM MÉTODO
	// OVERRIDE DO MÉTODO ABSTRATO DA SUPERCLASSE AUTOMATICAMENTE!
	
	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double renda, Double gastosSaude) {
		super(nome, renda);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	//É OBRIGATÓRIO SOBRESCREVER O MÉTODO ABSTRATO DA SUPERCLASSE!
	@Override
	public Double impostoPago() {
		if (getRendaAnual()<20000.0) {
			return getRendaAnual() * 0.15 - gastosSaude/2;
		} else {
			return getRendaAnual()*0.25 - gastosSaude/2;
		}
	}
}
