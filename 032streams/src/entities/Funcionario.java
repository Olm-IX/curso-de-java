package entities;

public class Funcionario {

	private String nome;
	private String email;
	private Double salary;
	
	public Funcionario(String nome, String email, Double salary) {
		this.nome = nome;
		this.email = email;
		this.salary = salary;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Double getSalario() {
		return salary;
	}
	

	
}
