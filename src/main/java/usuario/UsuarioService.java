package usuario;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Usuario;

/**
 * @author Rafael Mateus
 *	Classe responsavel pela persistencia dos dados do Usuario.
 *  8 de abr de 2018
 */

@Named
public class UsuarioService {
	public UsuarioService() {}
	
	@Transactional
	public Boolean cadastrarUsuario(Usuario usuario) {
		try{
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			entityManagerFactory.close();
 		
		}catch (Exception e){
 			e.printStackTrace();
 			return null;
 		}
		return true;
	}
	
	public List<Usuario> listarTodosUsuarios() throws Exception{
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			Query query = em.createNamedQuery("SELECT U FROM USUARIO U");
			List<Usuario> usuarios = query.getResultList();

			entityManagerFactory.close();

			return usuarios;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void apagarUsuario(Integer id) throws Exception{
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("DELETE FROM USUARIOS");
			sql.append("WHERE ID_USUARIO =: idUsuario");

			
			Query query = em.createQuery(sql.toString());
			
			query.setParameter("idUsuario", id);
			
			

			entityManagerFactory.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
