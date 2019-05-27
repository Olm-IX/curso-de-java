package model.exceptions;

public class PersonalizadoException extends Exception {
	// CRIAÇÃO DE UMA EXCEÇÃO PERSONALIZADA. SUBCLASSE DA SUPERCLASSE EXCEPTION
	// OBS. ISSO SIGNIFICA QUE O COMPILADOR VAITE OBRIGAR A TRATAR A EXCEÇÃO
	// SE FOSSE SUPERCLASSE RUNTIMEEXCEPTION, O COMPILADOR NÃO OBRIGARIA A TRATAR!
	private static final long serialVersionUID = 1L;

	public PersonalizadoException(String msg) { // CONSTRUTOR PARA PERMITIR ATRIBUIR UM STRING QUANDO DECLARAR A EXCEÇÃO
		super(msg);
	}
}