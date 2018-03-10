package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Représente un DAO utilisant comme source de données une bdd.
 * @author user
 * @param <T> TODO
 */
public abstract class JpaDao<T> implements DAO<T>{

	protected EntityManagerFactory emf;

	protected EntityManager em;

    protected final static String PERSISTENCE_UNIT = "ig2i-le4-poo-2018-tp3PU";

	/**
	 * Constructeur par défaut.
	 */
	public JpaDao() {
		this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		this.em = this.emf.createEntityManager();
	}

	@Override
	public boolean create(T obj) {
		EntityTransaction et = this.em.getTransaction();

		try {
            et.begin();
            em.persist(obj);
            et.commit();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

		return true;
	}

	@Override
	public boolean update(T obj) {
		EntityTransaction et = this.em.getTransaction();

		try {
            et.begin();
            em.merge(obj);
            et.commit();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

		return true;
	}

	@Override
	public boolean delete(T obj) {
		EntityTransaction et = this.em.getTransaction();

		try {
            et.begin();
            em.remove(obj);
            et.commit();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

		return true;
	}

	@Override
	public void close() {
		if(this.emf != null) {
			this.emf.close();
		}

		if(this.em != null) {
			this.em.close();
		}
	}

}
