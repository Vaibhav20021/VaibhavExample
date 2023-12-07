package com.railworld;

import java.util.Scanner;

import com.railworld.Service.ModelService;
import com.railworld.model.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
//	ModelService employeeService;
//	private static EntityManager entityManager;
	private static final EntityManagerFactory entityManagerFactory =
			Persistence.createEntityManagerFactory("employeePU");
			private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
			private static final ModelService modelService = new ModelService(entityManager);
//	public static EntityManager getConnection() {
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeePU");
//
//		return emf.createEntityManager();
//		}
//	private static ModelService modelService;
	private static Scanner scanner= new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 while (true) {
		        // Same as before...

//		       
				int choice= scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
		            case 1:
		                addModel();
		                break;
		            case 2:
		                viewModel();
		                break;
		            case 3:
		                updateModelSalary();
		                break;
		            case 4:
		                deleteModel();
		                break;
		            // Same as before...
		        }
		    }
		}

		private static void addModel() {
		    System.out.print("Enter employee name: ");
		    String name = scanner.nextLine();

		    System.out.print("Enter employee salary: ");
		    double salary = scanner.nextDouble();
		    Model model= new Model();
		    model.setName(name);
		    model.setSalary(salary);
//		    ModelService modelService = new ModelService(null);
			modelService.addModel(model);
		}

		private static void viewModel() {
			modelService.viewModel();
		}

		private static void updateModelSalary() {
		    System.out.print("Enter employee ID to update salary: ");
		    Long employeeId = scanner.nextLong();
		    scanner.nextLine(); // Consume the newline character

		    System.out.print("Enter new salary: ");
		    double newSalary = scanner.nextDouble();
		    scanner.nextLine(); // Consume the newline character

		    modelService.updateModelSalary(employeeId, newSalary);
		}

		private static void deleteModel() {
		    System.out.print("Enter employee ID to delete: ");
		    Long employeeId = scanner.nextLong();
		    scanner.nextLine(); // Consume the newline character

		    modelService.deleteModel(employeeId);
		}
}
