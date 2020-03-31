package model.services;

public interface TaxService {

	// "public abstract double tax (double amount)"; -> os m�todos em interfaces
	// j� s�o por padr�o publicos e abstratos, por isso nem se costuma
	// escrever isso no c�digo
	double tax(double amount);

	// OBS.: a partir do java 8, as interfaces podem implementar m�todos usando a
	// palavra chave "default". Esse m�todo poder� ser reutilizado por classes que implementam o
	// contrato, ou podem ser sobrescritos. UMA VANTAGEM, REUTILIZA��O DE C�DIGO! Que antes s�
	// era poss�vel atrav�s da heran�a.
	// Exemplo de como ficaria um m�todo default para calcular o imposto:
	//
	// double getTaxPercentage();
	//
	// default double tax(double amount) {
	//		return amount*getTaxPercentage();
	//	}
	//
	// Seria poss�vel, nas classes que assinam o contrato, criar um atributo com o valor do 
	// percentual de imposto de acordo com o pa�s, e seu respectivo getter (com o @Override), e da� 
	// poderia utilizar esse m�todo padr�o da interface.
}
