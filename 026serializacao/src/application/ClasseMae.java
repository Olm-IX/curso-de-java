package application;

import java.io.Serializable;

public class ClasseMae implements Serializable {
	
/**
	 * � boa pr�tica colocar o n�mero da vers�o da classe. Sempre que houver mudan�as
	 * na classe que sejam incompat�veis com os objetos j� salvos, deve-se mudar este
	 * n�mero para deixar claro que essa vers�o � incompat�vel com os objetos anteriores.
	 * Caso n�o se crie esse n�mero, o Java gera um n�mero de vers�o automaticamente.
	 * Este n�mero fica registrado nos objetos que foram serializados. 
	 */
	private static final long serialVersionUID = 1L;
	
	String nome;
	
	public ClasseMae(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}	
	
}
