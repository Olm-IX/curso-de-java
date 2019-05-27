package model.exceptions;

public class PersonalizadoException extends Exception {
	// CRIA��O DE UMA EXCE��O PERSONALIZADA. SUBCLASSE DA SUPERCLASSE EXCEPTION
	// OBS. ISSO SIGNIFICA QUE O COMPILADOR VAITE OBRIGAR A TRATAR A EXCE��O
	// SE FOSSE SUPERCLASSE RUNTIMEEXCEPTION, O COMPILADOR N�O OBRIGARIA A TRATAR!
	private static final long serialVersionUID = 1L;

	public PersonalizadoException(String msg) { // CONSTRUTOR PARA PERMITIR ATRIBUIR UM STRING QUANDO DECLARAR A EXCE��O
		super(msg);
	}
}