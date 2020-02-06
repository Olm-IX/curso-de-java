package entities;

/**JAVADOC
 * Classe que representa um Cliente
 * @author Naila
 */

public class Cliente {
	
	private String nome;

	
	
	public Cliente(String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}

	@Override
		public String toString() {
			return this.nome;
		}

}
