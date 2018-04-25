package tecnico;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import entity.Servicos;

/**
 * @author Rafael Mateus
 *	Classe responsavel pela persistencia dos dados do Usuario.
 *  24 de abr de 2018
 */

@Named
public class ServicosService implements Serializable {

	private static final long serialVersionUID = -7871739195466875089L;
	
	@SuppressWarnings("unchecked")
	@Transactional
		public List<Servicos> listarTodosServicos() throws Exception{
		
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();

			em.getTransaction().begin();
			Query query = em.createNamedQuery("SELECT s FROM Servicos s");
			List<Servicos> listaServicos = query.getResultList();
			em.close();

			return listaServicos;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
