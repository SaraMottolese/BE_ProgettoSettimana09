package com.film.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.film.dao.FilmDao;
import com.film.model.Film;
import com.film.util.JpaUtil;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class FilmDaoImpl implements FilmDao {
	EntityManager em;

	public void save(Film f) {
		System.out.println("Metodo per salvare un nuovo film");
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		try {
			// Salviamo la entity Film
			String boxOfficeReceiptsCrypted = BCrypt.hashpw(f.getboxOfficeReceipts(), BCrypt.gensalt());
			String producerLowerCase = f.getProducer().toLowerCase();
			f.setBoxOfficeReceipts(boxOfficeReceiptsCrypted);
			f.setProducer(producerLowerCase);
			filmsList.add(f);
			entityTransaction.begin();
			em.persist(f);
			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			em.close();
		}
	}

	public List<Film> getByProducer(String producer) {
		System.out.println("Metodo ricercare il film dal nome del regista");
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Query q_byProducer = em.createQuery("SELECT f FROM Film f WHERE f.producer like LOWER(:producer)");
		q_byProducer.setParameter("producer", producer);
		List<Film> producerFilmsList = (ArrayList<Film>) q_byProducer.getResultList();
		return producerFilmsList;
	}

	public void deleteFilm(Long id) {
		System.out.println("Metodo per eliminare un film");
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		em.remove(em.find(Film.class, id));
		entityTransaction.commit();
		em.close();

	}

	public void updateFilm(Film f, Long id) {
		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		try {
			String boxOfficeReceiptsCrypted = BCrypt.hashpw(f.getboxOfficeReceipts(), BCrypt.gensalt());
			String producerLowerCase = f.getProducer().toLowerCase();
			f.setBoxOfficeReceipts(boxOfficeReceiptsCrypted);
			f.setProducer(producerLowerCase);
			entityTransaction.begin();
			em.persist(f);
			entityTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			em.close();
		}

	}

	public List<Film> getAllFilm() {
		List<Film> filmsList = new ArrayList<Film>();

		em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();

		try {
			entityTransaction.begin();
			Query q_getAll = em.createQuery("Select f from Film f");
			filmsList = q_getAll.getResultList();
			entityTransaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			entityTransaction.rollback();
		} finally {
			em.close();
		}
		return filmsList;
	}

}
