package it.alfasoft.andrea.dao;

import hibernateUtil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Rubrica;

public class RubricaDao {

	// 1a- Create

	public boolean creaRubrica(Rubrica r) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.persist(r);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}
	
	// 1b- Create

		public boolean creaRubrica(String nome) {
			boolean res = false;
			
			Rubrica r=new Rubrica();
			r.setNome(nome);

			Session session = HibernateUtil.openSession();
			Transaction tx = null;

			try {

				tx = session.getTransaction();
				tx.begin();

				session.persist(r);

				tx.commit();
				res = true;
			} catch (Exception ex) {

				tx.rollback();

			} finally {
				session.close();
			}

			return res;

		}

	// 2- Read ( con Id)

	public Rubrica leggiRubricaConId(long r_id) {

		Rubrica r = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			r = session.get(Rubrica.class, r_id);

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return r;

	}

	// 2- Read ( con nome )

	public Rubrica leggiRubricaConNome(String nome) {

		Rubrica r = null;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			Query query = session
					.createQuery("from Rubrica where nome=:nomeInserito ");
			query.setString("nomeInserito", nome);
			r = (Rubrica) query.uniqueResult();

			tx.commit();

		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return r;

	}

	// 3- Update

	public boolean aggiornaRubrica(Rubrica r) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.update(r);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}

	// 4- Delete

	public boolean eliminaRubrica(Rubrica r) {
		boolean res = false;

		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try {

			tx = session.getTransaction();
			tx.begin();

			session.delete(r);

			tx.commit();
			res = true;
		} catch (Exception ex) {

			tx.rollback();

		} finally {
			session.close();
		}

		return res;

	}

}
