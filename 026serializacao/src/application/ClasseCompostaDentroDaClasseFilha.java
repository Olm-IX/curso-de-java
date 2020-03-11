package application;

import java.io.Serializable;

/**
 * Classe utilizada para se declarar um atributo dentro da ClasseFilha. Para que
 * a ClasseFilha possa utilizar esta classe composta, � necess�rio tamb�m
 * implementar a interface Serializable dentro desta classe composta! Se n�o for
 * implementada a interface aqui, a ClasseFilha ser� serializada com "null"
 * nesta ClasseComposta. Se tentarmos utilizar algum m�todo desta
 * ClasseComposta, dar� a exce��o "NotSerializableException".
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
