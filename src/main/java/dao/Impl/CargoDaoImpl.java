package dao.Impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ICargoDao;
import dao.JPAUtil;
import model.cargo;

public class CargoDaoImpl implements ICargoDao {

	private EntityManager em;
	
	public CargoDaoImpl()
	{
		 this.em=JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	

	@Override
	public cargo registrar(cargo c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return c;
	}

	@Override
	public cargo modificar(cargo c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		return c;
	}

	@Override
	public List<cargo> listar() {
		List<cargo> lista;
		Query query=em.createQuery("from cargo c");
		lista = query.getResultList();
		return lista;
	}


	@Override
	public cargo buscar(int id_cargo) {
		List<cargo> lista;
		Query query=em.createQuery("from cargo c where c.id_cargo=?1");
		query.setParameter(1,id_cargo);
		lista = query.getResultList();
		return lista != null && !lista.isEmpty() ? lista.get(0) : null;
	}

	
}
