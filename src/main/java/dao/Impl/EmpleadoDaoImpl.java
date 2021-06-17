package dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.IEmpleadoDao;
import dao.JPAUtil;
import model.empleado;


public class EmpleadoDaoImpl implements IEmpleadoDao{
	
	private EntityManager em;
	public EmpleadoDaoImpl()
	{
		 this.em=JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	public empleado registrar(empleado emp) {
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		return emp;
	}

	@Override
	public empleado modificar(empleado emp) {
		em.getTransaction().begin();
		em.merge(emp);
		em.getTransaction().commit();
		return emp;
	}

	@Override
	public List<empleado> listar() {
		List<empleado> lista;
		Query query=em.createQuery("from empleado emp");
		lista = query.getResultList();
		return lista;
	}

	@Override
	public empleado buscar(int id_emp) {
		List<empleado> lista;
		Query query=em.createQuery("from empleado emp where emp.id_emp=?1");
		query.setParameter(1,id_emp);
		lista = query.getResultList();
		return lista != null && !lista.isEmpty() ? lista.get(0) : null;
	}

}
