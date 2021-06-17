package dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IVehiculoDao;
import dao.JPAUtil;
import model.vehiculo;

public class VehiculoDaoImpl implements IVehiculoDao {

	private EntityManager em;

	public VehiculoDaoImpl()
	{
		 this.em=JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public vehiculo registrar(vehiculo v) {
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		return v;
	}

	@Override
	public vehiculo modificar(vehiculo v) {
		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
		return v;
	}

	@Override
	public List<vehiculo> listar() {
		List<vehiculo> lista;
		Query query=em.createQuery("from vehiculo v");
		lista = query.getResultList();
		return lista;
	}

	@Override
	public vehiculo buscar(int id_vehiculo) {
		List<vehiculo> lista;
		Query query=em.createQuery("from vehiculo v where v.id_vehiculo=?1");
		query.setParameter(1,id_vehiculo);
		lista = query.getResultList();
		return lista != null && !lista.isEmpty() ? lista.get(0) : null;
	}

}
