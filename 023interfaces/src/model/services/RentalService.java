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
		//teria que alterar muitas partes do c�digo. � por isso que vamos usar agora a interface,
		//ou seja, a classe RentalService ir� se comunicar com a interface, e n�o com as classes
		//espec�ficas diretamente. Se depois forem criadas novas classes que tamb�m implementam a
		//interface TaxService, tamb�m ir� funcionar aqui sem precisar de altera��es no c�digo!
		
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

			//Express�o condicional tern�ria:
			double basicPayment = (hours <= 12.0) ?
					(Math.ceil(hours)*pricePerHour) : 
					(Math.ceil(hours/24)*pricePerDay);
			//"Math.ceil()" -> arredonda o n�mero para cima
					
			double tax = taxService.tax(basicPayment);
					
			carRental.setInvoice(new Invoice(basicPayment, tax));
		}
		
		public String printInvoice(CarRental carRental) {
			return (carRental.getInvoice() != null) ?
					carRental.getInvoice().toString() : "N�o h� Invoice Processada!";
		}
}
