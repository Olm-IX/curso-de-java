package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

		private Double pricePerDay;
		private Double pricePerHour;
		
		private TaxService taxService;
		//private BrazilTaxService taxService;
		//Essa classe estava muito dependente do BrazilTaxService, acessava diretamente
		//essa outra classe. E se no futuro ela fosse alterada para, por exemplo, UsaTaxService? 
		//teria que alterar muitas partes do código. É por isso que vamos usar agora a interface,
		//ou seja, a classe RentalService irá se comunicar com a interface, e não com as classes
		//específicas diretamente. Se depois forem criadas novas classes que também implementam a
		//interface TaxService, também irá funcionar aqui sem precisar de alterações no código!
		
		public RentalService(Double pricePerDay, 
				Double pricePerHour, TaxService taxService) {
			this.pricePerDay = pricePerDay;
			this.pricePerHour = pricePerHour;
			this.taxService = taxService;
		}
		
		public void processInvoice(CarRental carRental) {
			long t1 = carRental.getStart().getTime(); 
			//getTime() retorna o valor da data em milisegundos
			long t2 = carRental.getFinish().getTime();
			double hours = (double) (t2 - t1) / 1000 / 60 / 60;
			//milisegundos/1000 = segundos/60 = minutos/60 = horas

			//Expressão condicional ternária:
			double basicPayment = (hours <= 12.0) ?
					(Math.ceil(hours)*pricePerHour) : 
					(Math.ceil(hours/24)*pricePerDay);
			//"Math.ceil()" -> arredonda o número para cima
					
			double tax = taxService.tax(basicPayment);
					
			carRental.setInvoice(new Invoice(basicPayment, tax));
		}
		
		public String printInvoice(CarRental carRental) {
			return (carRental.getInvoice() != null) ?
					carRental.getInvoice().toString() : "Não há Invoice Processada!";
		}
}
