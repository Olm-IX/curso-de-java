package model.exceptions;

public class PersonalizadoException extends RuntimeException {
	// CRIA��O DE UMA EXCE��O PERSONALIZADA. SUBCLASSE DA SUPERCLASSE RUNTIMEEXCEPTION
	// OBS. ISSO SIGNIFICA QUE O COMPILADOR N�O VEI TE OBRIGAR A TRATAR A EXCE��O
	// SE FOSSE SUPERCLASSE EXCEPTION, O COMPILADOR OBRIGARIA A TRATAR!
	private static final long serialVersionUID = 1L;

	public PersonalizadoException(String msg) { // CONSTRUTOR PARA PERMITIR ATRIBUIR UM STRING QUANDO DECLARAR A EXCE��O
		super(msg);
	}
}