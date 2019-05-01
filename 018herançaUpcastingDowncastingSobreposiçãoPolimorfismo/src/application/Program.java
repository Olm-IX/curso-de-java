package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 1000.00);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING -------------------------------------------
		
		// INSTANCIAR UM OBJETO DA SUBCLASSE NUMA VARIAVEL DA SUPERCLASSE!
		// ESSA ASSOCIA��O � FEITA EM TEMPO DE EXECU��O, O COMPILADOR N�O ENTENDE
		// ISSO � POSS�VEL POIS O OBJETO SUBCLASSE � UMA SUPERCLASSE (EST� CONTIDO)
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 1000.0, 200.0); //	TER� NORMALMENTE OS M�TODOS DA BUSINESSACCOUNT!
		Account acc3 = new SavingsAccount(1004, "Anna", 1000.00, 0.01); //	TER� NORMALMENTE OS M�TODOS DA SAVINGSACCOUNT!
		
		
		// DOWNCASTING ---------------------------------------- 
		
		// INSTANCIAR UM OBJETO DA SUPERCLASSE NUMA VARIAVEL DA SUBCLASSE
		// ISSO N�O � POSS�VEL, SE ESCREVER ISSO "BusinessAccount acc4 = acc2;" VAI DAR ERRO 
		BusinessAccount acc4 = (BusinessAccount) acc2; // "FOR�AR" A CONVERS�O PARA N�O DAR ERRO. 
		acc4.loan(100.0);
		//acc2 ERA UM OBJETO TIPO ACCOUNT QUE FOI INSTANCIADO COMO BUSINESSACCOUNT, POR ISSO D� PARA USAR O M�TODO DO BUSINESSACCOUNT. 
		
			
		// BusinessAccount acc5 = (BusinessAccount)acc3; SE ESCREVER ISSO VAI DAR ERRO NA HORA DA COMPILA��O!
		// N�O TEM COMO CONVERTER UMA INSTANCIA DE BUSINESSACCOUNT PARA SAVINSACCOUNT!
		// USAR A PALAVRA "INSTANCEOF" PARA VER SE � POSS�VEL A CONVERS�O!
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		// SOBREPOSI��O DE M�TODOS (@OVERRIDE) ---------------------------------------
		// POLIMORFISMO --------------------------------------------------------------
			// TODAS S�O VARI�VEIS DO TIPO GEN�RICO ACCOUNT, MAS APONTAM PARA OBJETOS
			// DE TIPOS ESPEC�FICOS E POSSUEM COMPORTAMENTOS DIFERENTES!!
		Account acc6 = new SavingsAccount (1004, "Anna", 1000.00, 0.01);
		Account acc7 = new BusinessAccount (1003, "Bob", 1000.00, 200.0);
		acc.withdraw(200.00);  // ACC � S� UMA ACCOUNT, QUE POSSUI O M�TODO DE DESCONTAR 5 DE TAXA
		acc6.withdraw(200.00); // ACC3 � UMA ACCOUNT DO TIPO SAVINGSACCOUNT, QUE TEM O M�TODO SOBRESCRITO PARA N�O DEBITAR TAXAS!
		acc7.withdraw(200.00); // ACC2 � UMA ACCOUNT DO TIPO BUSINESSACCOUNT, QUE TEM O M�TODO SOBRESCRITO PARA DEBITAR MAIS 2 (7 NO TOTAL)!
		// OBS. O SALDO DAS TR�S CONTAS � 1000
		System.out.println(acc.getBalance());
		System.out.println(acc6.getBalance());
		System.out.println(acc7.getBalance());
	}
}