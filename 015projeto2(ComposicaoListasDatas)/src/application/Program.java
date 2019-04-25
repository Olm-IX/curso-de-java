package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Worker;
import entities.Department;
import entities.HourContract;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		// PROJETO ESTÁ EM SLIDE 7 - ENUMERAÇÕES - COMPOSIÇÃO

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");

		System.out.print("Enter deparment's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		System.out.println("How many contracts to this worker: ");
		int contractNumber = sc.nextInt();
		Worker worker = new Worker(workerName, baseSalary, 
				new Department(departmentName),
				WorkerLevel.valueOf(workerLevel));
		
		for (int i = 1; i<=contractNumber; i++) {
			System.out.println();
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours  = sc.nextInt();
			worker.addContract(new HourContract (contractDate, valuePerHour, hours));
		}
		
		// OUTRO MÉTODO PARA PEGAR O MÊS E O ANO DE UMA VARIÁVEL TIPO "DATE"!
		// OUTROS MÉTODOS AQUI https://stackoverflow.com/questions/7182996/java-get-month-integer-from-date
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		Date monthAndYear = sdf2.parse(sc.next());
		LocalDate localdate = monthAndYear.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localdate.getMonthValue(); // DIFERENTE DO MÉTODO COM O CALENDAR, AQUI NÃO PRECISA ADICIONAR MAIS UM!
		int year = localdate.getYear();
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + sdf2.format(monthAndYear) + ": " + worker.income(month, year));
		
	
		sc.close();
	}

}
