package application;

/**
 * A classe filha herda o construtor da classe mãe, por isso é necessário
 * implementar a interface Serializable na classe mãe, se não a serialização não
 * funcionará. A serialização funciona em cascata, ou seja, apenas a classe mãe
 * precisa implementar, não necessitando a implementação por todas as filhas
 */
public class ClasseFilha extends ClasseMae {
		
	/**
	 * É recomendável que a classe filha também implemente um número de versão
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
