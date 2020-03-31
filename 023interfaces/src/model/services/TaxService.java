package model.services;

public interface TaxService {

	// "public abstract double tax (double amount)"; -> os métodos em interfaces
	// já são por padrão publicos e abstratos, por isso nem se costuma
	// escrever isso no código
	double tax(double amount);

	// OBS.: a partir do java 8, as interfaces podem implementar métodos usando a
	// palavra chave "default". Esse método poderá ser reutilizado por classes que implementam o
	// contrato, ou podem ser sobrescritos. UMA VANTAGEM, REUTILIZAÇÃO DE CÓDIGO! Que antes só
	// era possível através da herança.
	// Exemplo de como ficaria um método default para calcular o imposto:
	//
	// double getTaxPercentage();
	//
	// default double tax(double amount) {
	//		return amount*getTaxPercentage();
	//	}
	//
	// Seria possível, nas classes que assinam o contrato, criar um atributo com o valor do 
	// percentual de imposto de acordo com o país, e seu respectivo getter (com o @Override), e daí 
	// poderia utilizar esse método padrão da interface.
}
