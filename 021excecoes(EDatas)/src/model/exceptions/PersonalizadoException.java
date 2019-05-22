package model.exceptions;

public class PersonalizadoException extends RuntimeException {
	// CRIAÇÃO DE UMA EXCEÇÃO PERSONALIZADA. SUBCLASSE DA SUPERCLASSE RUNTIMEEXCEPTION
	// OBS. ISSO SIGNIFICA QUE O COMPILADOR NÃO VEI TE OBRIGAR A TRATAR A EXCEÇÃO
	// SE FOSSE SUPERCLASSE EXCEPTION, O COMPILADOR OBRIGARIA A TRATAR!
	private static final long serialVersionUID = 1L;

	public PersonalizadoException(String msg) { // CONSTRUTOR PARA PERMITIR ATRIBUIR UM STRING QUANDO DECLARAR A EXCEÇÃO
		super(msg);
	}
}