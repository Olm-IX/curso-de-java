package model.services;

public interface TaxService {

	//"public abstract double tax (double amount)"; -> os m�todos em interfaces 
	//j� s�o por padr�o publicos e abstratos, por isso nem se costuma
	//escrever isso no c�digo
	double tax (double amount);
}
