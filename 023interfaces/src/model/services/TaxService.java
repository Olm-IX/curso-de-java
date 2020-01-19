package model.services;

public interface TaxService {

	//"public abstract double tax (double amount)"; -> os métodos em interfaces 
	//já são por padrão publicos e abstratos, por isso nem se costuma
	//escrever isso no código
	double tax (double amount);
}
