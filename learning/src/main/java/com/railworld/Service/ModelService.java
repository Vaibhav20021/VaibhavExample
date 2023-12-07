package com.railworld.Service;

import java.util.List;

import com.railworld.Dao.ModelDao;
import com.railworld.model.Model;

import jakarta.persistence.EntityManager;

public class ModelService {
	private ModelDao employeeDAO;

	public ModelService(EntityManager entityManager) {
        this.employeeDAO = new ModelDao(entityManager);
    }

	public void addModel(Model model) {
//		Model employee = new Model();
//		employee.setName(name);
//		employee.setSalary(salary);

		employeeDAO.addModel(model);
		System.out.println("Employee added successfully!");
	}

	public void viewModel() {
		List<Model> employees = employeeDAO.getAllEmployees();

		if (employees.isEmpty()) {
			System.out.println("No employees found.");
		} else {
			System.out.println("List of Employees:");
			for (Model employee : employees) {
				System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Salary: "
						+ employee.getSalary());
			}
		}
	}

	public void updateModelSalary(Long employeeId, double newSalary) {
		Model employee = employeeDAO.getModelById(employeeId);

		if (employee == null) {
			System.out.println("Employee not found with ID: " + employeeId);
		} else {
			employee.setSalary(newSalary);
			employeeDAO.updateModel(employee);
			System.out.println("Salary updated successfully for " + employee.getName());
		}
	}

	public void deleteModel(Long employeeId) {
		Model employee = employeeDAO.getModelById(employeeId);

		if (employee == null) {
			System.out.println("Employee not found with ID: " + employeeId);
		} else {
			employeeDAO.deleteModel(employee);
			System.out.println("Employee deleted successfully: " + employee.getName());
		}
	}
}
