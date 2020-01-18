package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 1000.00);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING -------------------------------------------
		
		//Instanciar um objeto da subclasse numa variavel da superclasse (refer�ncia da superclasse) 
		//Essa associa��o � feita em tempo de execu��o, o compilador n�o entende
		//Isso � poss�vel pois o objeto subclasse � uma superclasse (est� contido)
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 1000.0, 200.0); //	acc2 n�o poder� acessar os m�todos declarados APENAS na BusinessAccount!
		Account acc3 = new SavingsAccount(1004, "Anna", 1000.00, 0.01); //	acc3 n�o poder� acessar os m�todos declarados APENAS na BusinessAccount!
		
		
		// DOWNCASTING ---------------------------------------- 
		
		//Instanciar um objeto da superclasse numa vari�vel da subclasse 
		//Isso n�o � poss�vel. "BusinessAccount acc = new Account ()" -> Erro. 
		//"BusinessAccount acc4 = acc2;" -> Erro 
		BusinessAccount acc4 = (BusinessAccount) acc2; // For�a a convers�o para n�o dar erro. 
		acc4.loan(100.0);
		//acc2 era um objeto tipo Account que foi instanciado como BusinessAccount. por isso d� para usar o m�todo do BusinessAccount 
			
		//"BusinessAccount acc5 = (BusinessAccount)acc3;" -> Erro na compila��o
		//N�o tem como converter uma inst�ncia de BusinessAccount para SavingsAccount
		//Usar a palavra "InstanceOf" para ver se � poss�vel a convers�o!
		
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