package hibernate_Employee.controller;

import hibernate_Employee.dao.Employee_dao;
import hibernate_Employee.dto.Employee;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
	public static void main(String[] args) {
		System.out.println("*****Welcome*****");

		for (;;) {
			System.out.println(
					"1. Add Employee\n2. Display All Employee\n3. Get Employee By Id\n4. Get Employee By name\n5. Get Employee By salary\n6. Get Employee By designation\n7. Get Employee By email\n8. Get Employee By phone number\n9. Delete Employee\n10. Update Employee\n11. Edit Employee Profile\n12. Exit");
			System.out.println("Enter the option");
			Scanner scanner = new Scanner(System.in);

			Employee employee = new Employee();
			Employee_dao dao = new Employee_dao();

			try {
				switch (scanner.nextInt()) {
				case 1: {

					System.out.println("Enter id:");
					employee.setId(scanner.nextInt());
					System.out.println("Enter name:");
					scanner.nextLine();
					employee.setName((scanner.nextLine()).toLowerCase());
					System.out.println("Enter Salary:");
					employee.setSalary(scanner.nextDouble());
					System.out.println("Enter Designation:");
					employee.setDesignation((scanner.next()).toLowerCase());
					System.out.println("Enter Email:");
					employee.setEmail(scanner.next());
					System.out.println("Enter Phone Number:");
					employee.setPhone(scanner.nextLong());

					try {
						dao.addEmployee(employee);
					} catch (Exception e) {
						System.out.println("Employee is already exist!");
					}
					break;
				}
				case 2: {
					List<Employee> list = dao.fetchAllEmployee();
					if (list.isEmpty()) {
						System.out.println("No data found");
					} else {
						System.out.println(list);
					}
					break;
				}
				case 3: {
					System.out.println("Enter the id");
					Employee employee2 = dao.getById(scanner.nextInt());
					if (employee2 != null) {
						System.out.println(employee2);
					} else {
						System.out.println("Employee with given id not found");
					}
					break;
				}
				case 4: {
					System.out.println("Enter the name");
					scanner.nextLine();
					List<Employee> list = dao.getByName(scanner.nextLine());
					if (list.isEmpty()) {
						System.out.println("No data found with this name.");
					} else {
						System.out.println(list);
					}
					break;
				}
				case 5: {
					System.out.println("Enter the salary");
					List<Employee> list = dao.getBySalary(scanner.nextDouble());
					if (list.isEmpty()) {
						System.out.println("No data found with this salary.");
					} else {
						System.out.println(list);
					}
					break;
				}
				case 6: {
					System.out.println("Enter the designation");
					List<Employee> list = dao.getByDesignation(scanner.next());
					if (list.isEmpty()) {
						System.out.println("No data found with this designation.");
					} else {
						System.out.println(list);
					}
					break;
				}
				case 7: {
					System.out.println("Enter the email");
					try {
						Employee employee2 = dao.getByEmail(scanner.next());
						System.out.println(employee2);
					} catch (Exception e) {
						System.out.println("Employee with given email not found");
					}

					break;
				}
				case 8: {
					System.out.println("Enter the phone number");
					try {
						Employee employee2 = dao.getByPhone(scanner.nextLong());
						System.out.println(employee2);
					} catch (Exception e) {
						System.out.println("Employee with given phone number not found");
					}
					break;
				}
				case 9: {
					System.out.println("Enter the id");
					dao.deleteEmployee(scanner.nextInt());
					break;
				}
				case 10: {
					for (;;) {

						System.out.println(
								"1. Update name\n2. Update Designation\n3. Update Email\n4. Update Phone Number\n5. exit");
						System.out.println("Enter the option");
						int i = scanner.nextInt();
						if (i == 5) {
							break;
						}
						switch (i) {
						case 1: {
							System.out.println("Enter your id:");
							int id = scanner.nextInt();
							System.out.println("Enter new name:");
							scanner.nextLine();
							String name = scanner.nextLine();

							dao.updateName(id, name);

							break;
						}
						case 2: {
							System.out.println("Enter your id:");
							int id = scanner.nextInt();
							System.out.println("Enter new designation:");

							dao.updateDesignation(id, scanner.next());

							break;
						}

						case 3: {
							System.out.println("Enter your id:");
							int id = scanner.nextInt();
							System.out.println("Enter new email:");

							dao.updateEmail(id, scanner.next());

							break;
						}
						case 4: {
							System.out.println("Enter your id:");
							int id = scanner.nextInt();
							System.out.println("Enter new phone number:");

							dao.updatePhone(id, scanner.nextLong());
							break;
						}
						}
					}
					break;
				}
				case 11: {
					System.out.println("Enter id:");
					int id = scanner.nextInt();
					employee.setId(id);
					System.out.println("Enter name:");
					scanner.nextLine();
					employee.setName((scanner.nextLine()).toLowerCase());
					System.out.println("Enter Salary:");
					employee.setSalary(scanner.nextDouble());
					System.out.println("Enter Designation:");
					employee.setDesignation((scanner.next()).toLowerCase());
					System.out.println("Enter Email:");
					employee.setEmail(scanner.next());
					System.out.println("Enter Phone Number:");
					employee.setPhone(scanner.nextLong());

					dao.editEmployee(id, employee);

					break;
				}
				default:
					System.exit(0);
				}
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}

	}
}
