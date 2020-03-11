package application;

/**
 * A classe filha herda o construtor da classe m�e, por isso � necess�rio
 * implementar a interface Serializable na classe m�e, se n�o a serializa��o n�o
 * funcionar�. A serializa��o funciona em cascata, ou seja, apenas a classe m�e
 * precisa implementar, n�o necessitando a implementa��o por todas as filhas
 */
public class ClasseFilha extends ClasseMae {
		
	/**
	 * � recomend�vel que a classe filha tamb�m implemente um n�mero de vers�o
	 */
	private static final long serialVersionUID = 1L;
	public ClasseCompostaDentroDaClasseFilha classeComposta;

	public ClasseFilha(String nome) {
		super(nome);
	}

	
	public ClasseCompostaDentroDaClasseFilha getClasseComposta() {
		return classeComposta;
	}

	public void setClasseComposta(ClasseCompostaDentroDaClasseFilha classeComposta) {
		this.classeComposta = classeComposta;
	}
	
	
}
