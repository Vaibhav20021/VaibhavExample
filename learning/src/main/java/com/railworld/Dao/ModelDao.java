package com.railworld.Dao;

import java.util.List;

import com.railworld.model.Model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ModelDao {
	private EntityManager entityManager;

	public ModelDao(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}

	public void addModel(Model employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.persist(employee);

		transaction.commit();
	}

	public List<Model> getAllEmployees() {
		TypedQuery<Model> query = entityManager.createQuery("SELECT e FROM Employee e", Model.class);
		return query.getResultList();
	}

	public Model getModelById(Long id) {
		return entityManager.find(Model.class, id);
	}

	public void updateModel(Model employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.merge(employee);

		transaction.commit();
	}

	public void deleteModel(Model employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.remove(employee);

		transaction.commit();
	}
}
