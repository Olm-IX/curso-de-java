package application;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT); // PARA PEGAR A DATA DE HOJE, new Date ()
		
		System.out.println(order);
		
		OrderStatus os1 = OrderStatus.DELIVERED; // D� PARA SER ASSIM
		
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED"); // OU ENT�O CONVERTER O VALOR DO STATUS DE STRING
		
		System.out.println(os1);
		System.out.println(os2);

	}

}
