package CrudAssignment;

import java.util.*;

public class CrudOperationsTester {

	static ArrayList<Employee> employees = new ArrayList<>();

	static void insertEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee number: ");
		int empNo = sc.nextInt();
		System.out.print("Enter employee name: ");
		String name = sc.next();
		System.out.print("Enter employee salary: ");
		int salary = sc.nextInt();
		employees.add(new Employee(empNo, name, salary));
	}

	static void displayEmployees() {
		for (Employee e : employees) {
			System.out.println("Employee number: " + e.empno);
			System.out.println("Employee name: " + e.name);
			System.out.println("Employee salary: " + e.salary);
			System.out.println("--------------------");
		}
	}

	static void searchEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee number to search: ");
		int empNo = sc.nextInt();
		boolean found = false;
		for (Employee e : employees) {
			if (e.getEmpno() == empNo) {
				System.out.println("Employee found!");
				System.out.println("Employee number: " + e.empno);
				System.out.println("Employee name: " + e.name);
				System.out.println("Employee salary: " + e.salary);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Employee not found.");
		}
	}

	static void deleteEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee number to delete: ");
		int empNo = sc.nextInt();
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getEmpno() == empNo) {
				employees.remove(i);
				System.out.println("Employee deleted.");
				break;
			}
		}
	}

	static void updateEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee number to update: ");
		int empNo = sc.nextInt();
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getEmpno() == empNo) {
				System.out.print("Enter updated name: ");
				String name = sc.next();
				System.out.print("Enter updated salary: ");
				int salary = sc.nextInt();
				employees.get(i).name = name;
				employees.get(i).salary = salary;
				System.out.println("Employee updated.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println();
			System.out.println("Enter 1 to insert an employee.");
			System.out.println("Enter 2 to display all employees.");
			System.out.println("Enter 3 to search an employee.");
			System.out.println("Enter 4 to delete an employee.");
			System.out.println("Enter 5 to update an employee.");
			System.out.println("Enter 0 to exit.");
			System.out.print("Enter your option: ");
			option = sc.nextInt();
			switch (option) {
			case 1:
				insertEmployee();
				break;
			case 2:
				displayEmployees();
				break;
			case 3:
				searchEmployee();
				break;
			case 4:
				deleteEmployee();
				break;
			case 5:
				updateEmployee();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid option.");
			}
		} while (option != 0);
	}
}
