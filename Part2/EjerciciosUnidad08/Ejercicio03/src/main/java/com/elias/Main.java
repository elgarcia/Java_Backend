package com.elias;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		final EntityManagerFactory  entityMF = Persistence. createEntityManagerFactory("negocioPU");
		final EntityManager         entityManager = entityMF.createEntityManager();

		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente();

		c1.setNombre("Dennys");
		c2.setNombre("Fred");

		Venta   v1 = new Venta();
		Venta   v2 = new Venta();
		v1.setClienteid(1);
		v2.setClienteid(2);
		v2.setPrecio(20.2);
		v1.setPrecio(9.99);
		v2.setFecha(LocalDate.parse("2014//1/1"));
		v1.setFecha(LocalDate.now());

		entityManager.getTransaction().begin();
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(v1);
		entityManager.persist(v2);
		entityManager.getTransaction().commit();
	}
}