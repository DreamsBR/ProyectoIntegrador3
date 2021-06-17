package dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IChoferDao;
import dao.JPAUtil;
import model.chofer;

public class ChoferDaoImpl implements IChoferDao{

	private EntityManager em;

	public ChoferDaoImpl()
	{
		 this.em=JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	public chofer registrar(chofer f) {
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		return f;
	}

	@Override
	public chofer modificar(chofer f) {
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
		return f;
	}
	
	@Override
	public List<chofer> listar() {
		List<chofer> lista;
		Query query=em.createQuery("from chofer f");
		lista = query.getResultList();
		return lista;
	}

	@Override
	public chofer buscar(int id_chofer) {
		List<chofer> lista;
		Query query=em.createQuery("from chofer f where f.id_chofer=?1");
		query.setParameter(1,id_chofer);
		lista = query.getResultList();
		return lista != null && !lista.isEmpty() ? lista.get(0) : null;
	}


}
