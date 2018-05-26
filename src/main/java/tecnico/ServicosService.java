package tecnico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Categoria;
import entity.Servico;

/**
 * @author Rafael Mateus
 *	Classe responsavel pela persistencia dos dados do Usuario.
 *  24 de abr de 2018
 */

@Named
public class ServicosService implements Serializable {

	private static final long serialVersionUID = -7871739195466875089L;
	public ServicosService() { }
	
	
	public static Boolean cadastrarServico(Servico servico) throws Exception{
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(servico);
			em.getTransaction().commit();
			em.close();

			return true;
			 
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public static List<Servico> listarTodosServicos() throws Exception{
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();

			em.getTransaction().begin();
			Query query = em.createNamedQuery("SELECT s FROM Servicos s");
			List<Servico> listaServicos = query.getResultList();
			em.close();

			return listaServicos;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Transactional
	public static Integer consultarMaiorIdServico() throws Exception{
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MAX(idServico) FROM Servico S");

			Query query = em.createQuery(sql.toString());
			Integer maiorIdServico = (Integer) query.getSingleResult();
			em.close();

			if(maiorIdServico == null)
				maiorIdServico = 0;
		
			return ++maiorIdServico;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public static List<Categoria> listarTodasCategorias() throws Exception{
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();

			em.getTransaction().begin();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT c FROM Categoria c");
			
			Query query = em.createQuery(sql.toString());
			
			List<Categoria> listaCategorias = query.getResultList();
			em.close();
			return listaCategorias;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
