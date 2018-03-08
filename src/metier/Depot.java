package metier;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entité représentant un point.
 * @author seb
 */
@Entity
@Table(name = "DEPOT")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Depot.findAll", query = "SELECT d FROM Depot d")
	, @NamedQuery(name = "Depot.findByNpoint", query = "SELECT d FROM Depot d WHERE d.npoint = :npoint")})

public class Depot extends Point implements Serializable{
	/**
	 * Constructeur par défault.
	 */
	public Depot() {
		super();
	}

	/**
	 * Constructeur par données.
	 * @param id TODO
	 * @param x TODO
	 * @param y TODO
	 */
	public Depot(Integer id,double x, double y) {
		super(id, x, y);
	}

	@Override
	public String toString() {
		return "Depot n°" + super.getId() + " [{\n\t" + super.toString() +"\n\t}]";
	}

}
