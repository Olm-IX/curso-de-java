package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 1000.00);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING -------------------------------------------
		
		//Instanciar um objeto da subclasse numa variavel da superclasse (referência da superclasse) 
		//Essa associação é feita em tempo de execução, o compilador não entende
		//Isso é possível pois o objeto subclasse é uma superclasse (está contido)
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 1000.0, 200.0); //	acc2 não poderá acessar os métodos declarados APENAS na BusinessAccount!
		Account acc3 = new SavingsAccount(1004, "Anna", 1000.00, 0.01); //	acc3 não poderá acessar os métodos declarados APENAS na BusinessAccount!
		
		
		// DOWNCASTING ---------------------------------------- 
		
		//Instanciar um objeto da superclasse numa variável da subclasse 
		//Isso não é possível. "BusinessAccount acc = new Account ()" -> Erro. 
		//"BusinessAccount acc4 = acc2;" -> Erro 
		BusinessAccount acc4 = (BusinessAccount) acc2; // Força a conversão para não dar erro. 
		acc4.loan(100.0);
		//acc2 era um objeto tipo Account que foi instanciado como BusinessAccount. por isso dá para usar o método do BusinessAccount 
			
		//"BusinessAccount acc5 = (BusinessAccount)acc3;" -> Erro na compilação
		//Não tem como converter uma instância de BusinessAccount para SavingsAccount
		//Usar a palavra "InstanceOf" para ver se é possível a conversão!
		
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
		
		// SOBREPOSIÇÃO DE MÉTODOS (@OVERRIDE) ---------------------------------------
		// POLIMORFISMO --------------------------------------------------------------
			// TODAS SÃO VARIÁVEIS DO TIPO GENÉRICO ACCOUNT, MAS APONTAM PARA OBJETOS
			// DE TIPOS ESPECÍFICOS E POSSUEM COMPORTAMENTOS DIFERENTES!!
		Account acc6 = new SavingsAccount (1004, "Anna", 1000.00, 0.01);
		Account acc7 = new BusinessAccount (1003, "Bob", 1000.00, 200.0);
		acc.withdraw(200.00);  // ACC É SÓ UMA ACCOUNT, QUE POSSUI O MÉTODO DE DESCONTAR 5 DE TAXA
		acc6.withdraw(200.00); // ACC3 É UMA ACCOUNT DO TIPO SAVINGSACCOUNT, QUE TEM O MÉTODO SOBRESCRITO PARA NÃO DEBITAR TAXAS!
		acc7.withdraw(200.00); // ACC2 É UMA ACCOUNT DO TIPO BUSINESSACCOUNT, QUE TEM O MÉTODO SOBRESCRITO PARA DEBITAR MAIS 2 (7 NO TOTAL)!
		// OBS. O SALDO DAS TRÊS CONTAS É 1000
		System.out.println(acc.getBalance());
		System.out.println(acc6.getBalance());
		System.out.println(acc7.getBalance());
	}
}