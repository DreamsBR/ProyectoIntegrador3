package dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ITarifarioDao;
import dao.JPAUtil;
import model.tarifario;

public class TarifarioDaoImpl implements ITarifarioDao{
	
	private EntityManager em;
	public TarifarioDaoImpl()
	{
		 this.em=JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	public tarifario registrar(tarifario t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		return t;
	}

	@Override
	public tarifario modificar(tarifario t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		return t;
	}

	@Override
	public List<tarifario> listar() {
		List<tarifario> lista;
		Query query=em.createQuery("from tarifario t");
		lista = query.getResultList();
		return lista;
	}

	@Override
	public tarifario buscar(int id_tarifario) {
		List<tarifario> lista;
		Query query=em.createQuery("from tarifario t where t.id_tarifario=?1");
		query.setParameter(1,id_tarifario);
		lista = query.getResultList();
		return lista != null && !lista.isEmpty() ? lista.get(0) : null;
	}
}
