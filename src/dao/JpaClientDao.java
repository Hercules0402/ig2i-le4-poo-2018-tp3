package dao;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import metier.Client;

/**
 * Représente un DAO de type Clinet utilisant comme source de données une bdd.
 * @author user
 */
public class JpaClientDao extends JpaDao<Client> implements ClientDao {

	/**
	 * Constructeur par données
	 * @param entite 
	 */
	public JpaClientDao(Class<Client> entite) {
		super(entite);
	}

	@Override
	public boolean deleteAll() {
		return super.deleteAll();
	}

	@Override
	public Collection<Client> findAll() {
		return super.findAll();
	}

	@Override
	public Client find(Integer id) {
		return super.find(id);
	}

	@Override
	public void close() {
		super.close();
	}

	@Override
	public boolean delete(Client obj) {
		return super.delete(obj);
	}

	@Override
	public boolean update(Client obj) {
		return super.update(obj);
	}

	@Override
	public boolean create(Client obj) {
		return super.create(obj);
	}

	@Override
	public Collection<Client> findNotServed() {
		CriteriaBuilder cb = super.em.getCriteriaBuilder();
		CriteriaQuery<Client> cq = cb.createQuery(Client.class);
		Root<Client> tasks = cq.from(Client.class);
		cq.select(tasks).where(cb.or(cb.isNotNull(tasks.get("NVEHICULE")),cb.isNotEmpty(tasks.get("NVEHICULE"))));
		return super.em.createQuery(cq).getResultList();
	}
	
}
