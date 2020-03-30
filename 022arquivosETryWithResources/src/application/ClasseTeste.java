package application;

public class ClasseTeste {

	private String funcionario;
	private Double salario;
	
	public ClasseTeste(String funcionario, Double salario) {
		this.funcionario = funcionario;
		this.salario = salario;
	}
	
	public String getFuncionario() {
		return funcionario;
	}

	public Double getSalario() {
		return salario;
	}
	
}
