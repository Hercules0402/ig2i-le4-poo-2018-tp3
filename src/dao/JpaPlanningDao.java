package dao;

import java.util.Collection;
import metier.Planning;

/**
 * Représente un DAO de type Planning utilisant comme source de données une bdd.
 * @author user
 */
public class JpaPlanningDao extends JpaDao<Planning> implements PlanningDao {

	/**
	 * Constrcuteur par défault.
	 */
	public JpaPlanningDao() {
		super(Planning.class);
	}

	@Override
	public boolean deleteAll() {
		return super.deleteAll();
	}

	@Override
	public Collection<Planning> findAll() {
		return super.findAll();
	}

	@Override
	public Planning find(Integer id) {
		return super.find(id);
	}

	@Override
	public void close() {
		super.close();
	}

	@Override
	public boolean delete(Planning obj) {
		return super.delete(obj);
	}

	@Override
	public boolean update(Planning obj) {
		return super.update(obj);
	}

	@Override
	public boolean create(Planning obj) {
		return super.create(obj);
	}

}
