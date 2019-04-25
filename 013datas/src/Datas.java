import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Datas {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); // CRIA UM OBJETO COM A FORMATAÇÃO DA DATA
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT")); // USAR ESSE PARA EVITAR A CONVERSÃO AUTOMÁTICA PARA O HORÁRIO DO PC!
		
		Date y1 = sdf1.parse("24/05/1991"); // .PARSE CONVERTE O TEXTO EM UMA DATA RESPEITANDO O FORMATO
		Date y2 = sdf2.parse("22/09/1989 02:45:33"); // TEM QUE COLOCAR AQUELE ParseException NO INICIO, DEPOIS SABEREI O PQ!
		
		System.out.println("Datas impressas no padrão do java:");
		System.out.println(y1); 
		System.out.println(y2);
		System.out.println();
		System.out.println("Datas impressas utilizando a formatação do SimpleDateFormat:");
		System.out.println(sdf1.format(y1));
		System.out.println(sdf2.format(y2));
		
		Date x1 = new Date (); // CRIAR UMA DATA COM O HORÁRIO ATUAL!
		System.out.println();
		System.out.println("Data atual: ");
		System.out.println(x1);
		
		Date x2 = new Date (System.currentTimeMillis()); // DATA ATUAL EM MILISEGUNDOS!
		System.out.println();
		System.out.println("Data atual usando milisegundos: ");
		System.out.println(x2);
		
		Date x3 = new Date (0L); // DÁ PARA SE CRIAR UMA DATA DEFININDO OS MILISEGUNDOS QUE VOCÊ QUISER!
		System.out.println();
		System.out.println("Data com 0 milisegundos: "); // VAI DAR 31/12/1969 21:00:00
		System.out.println(x3);
		// COMO O JAVA ARMAZENA A DATA EM MILISEGUNDOS A PARTIR DE 01/01/1970 (PADRÃO UTC), 0MS VAI SER ESSA DATA!
		// PORÉM COMO MEU PC ESTÁ NO HORÁRIO DO BRASIL, 3 HORAS ATRASADO EM RELAÇÃO AO UTC, ELE CONVERTE PARA O HORÁRIO DA MÁQUINA!
		
		Date x4 = new Date (1000L * 60L * 60L * 5L); // COMO EXPRESSAR 5 HORAS EM MS. 1 SEGUNDO = 1000 MS
		System.out.println();
		System.out.println("Data com mais 5 horas em milisegundos: ");
		System.out.println(x4);
		
		//IMPRIMINDO DATAS NO FORMATO UTC DO ISO 8601 (Formato: yyyy-MM-ddTHH:mm:ssZ) A LETRA Z DO FINAL INDICA UTC
		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println();
		System.out.println("Imprimindo 25/06/2018 15:45:07 usando o padrão UTC ISO 8601: ");
		System.out.println(sdf2.format(y3)); // VAI IMPRIMIR COM 3 HORAS DE ATRASO! PORQUE VAI CONVERTER DO UTC PARA O HORÁRIO BR
		System.out.println("Agora sem converter automaticamente para o horário da máquina: ");
		System.out.println(sdf3.format(y3));
		
		// IMPRIMINDO AS DATAS NO FORMATO UTC SEM A CONVERSÃO AUTOMÁTICA PARA O HORÁRIO DO PC
		System.out.println();
		System.out.println("Fora do UTC: ");
		System.out.println(sdf2.format(y2));
		System.out.println("No UTC: ");
		System.out.println(sdf3.format(y2));
		
		// LENDO DATA INPUTADA PELO USUÁRIO
		System.out.println();
		System.out.print("Digite uma data (DD/MM/YYYY): ");
		Date data = sdf1.parse(sc.next());
		System.out.println(data);		
		// TESTE
		
		sc.close();
	}

}
