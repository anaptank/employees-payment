package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutSourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ArrayList<Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		Integer number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Employee #" + (i + 1) + " data:");
			
			System.out.print("Outsourced (y/n)?");
			char outsourced = sc.next().charAt(0);
			
			System.out.print("Enter the name of the employee: ");
			String name = sc.next();
			System.out.print("Enter the value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Enter the hours worked: ");
			Integer hours = sc.nextInt();
			
			if (outsourced == 'y') {
				System.out.println("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				
				OutSourcedEmployee outSourcedEmployee = new OutSourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(outSourcedEmployee);
			} else {
				Employee emp = new Employee(name, hours, valuePerHour);
				list.add(emp);
			}
		}
		
		System.out.println();
		System.out.println("PAYMENT:");
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}

}
