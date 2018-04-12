package usuario;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
}
