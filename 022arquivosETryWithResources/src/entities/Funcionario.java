package entities;

/**
 * Classe Teste para ser usada no application.TryWithResources.java
 */
public class Funcionario {

	private String funcionario;
	private Double salario;
	
	public Funcionario(String funcionario, Double salario) {
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
