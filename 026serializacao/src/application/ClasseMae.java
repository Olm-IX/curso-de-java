package application;

import java.io.Serializable;

public class ClasseMae implements Serializable {
	
/**
	 * É boa prática colocar o número da versão da classe. Sempre que houver mudanças
	 * na classe que sejam incompatíveis com os objetos já salvos, deve-se mudar este
	 * número para deixar claro que essa versão é incompatível com os objetos anteriores.
	 * Caso não se crie esse número, o Java gera um número de versão automaticamente.
	 * Este número fica registrado nos objetos que foram serializados. 
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
