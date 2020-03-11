package application;

import java.io.Serializable;

/**
 * Classe utilizada para se declarar um atributo dentro da ClasseFilha. Para que
 * a ClasseFilha possa utilizar esta classe composta, é necessário também
 * implementar a interface Serializable dentro desta classe composta! Se não for
 * implementada a interface aqui, a ClasseFilha será serializada com "null"
 * nesta ClasseComposta. Se tentarmos utilizar algum método desta
 * ClasseComposta, dará a exceção "NotSerializableException".
 */
public class ClasseCompostaDentroDaClasseFilha implements Serializable{

	private static final long serialVersionUID = 1L;
	Integer numero;

	public ClasseCompostaDentroDaClasseFilha(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

}
