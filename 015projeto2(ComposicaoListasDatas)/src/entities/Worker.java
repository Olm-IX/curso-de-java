package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private List<HourContract> contracts = new ArrayList<>();
	private Department department;
	
	// CONSTRUTOR
	public Worker(String name, Double baseSalary, Department department, WorkerLevel level) {
		this.name = name;
		this.level = level;
		this.department = department;
		this.baseSalary = baseSalary;
	}
	
	// GETTERS AND SETTERS
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	// MÉTODOS
	public void addContract (HourContract contract) {
		contracts.add(contract);
	}
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	public double income (int month, int year) {
		Calendar cal = Calendar.getInstance();
		double soma = 0;
		for (HourContract item : contracts) {
			cal.setTime(item.getDate());
			if (month == ( 1 + cal.get(Calendar.MONTH)) && year == cal.get(Calendar.YEAR)) {
				soma += (item.getHours() * item.getValuePerHour());
			}
		}
		return (soma + baseSalary);
	}
	
}
