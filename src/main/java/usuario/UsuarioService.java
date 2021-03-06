package usuario;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;

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
			em.close();
 		
		}catch (Exception e){
 			e.printStackTrace();
 			return null;
 		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodosUsuarios() throws Exception{
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();

			em.getTransaction().begin();
			
			Query query = em.createNamedQuery("SELECT u FROM Usuario U");
			List<Usuario> usuarios = query.getResultList();

			em.close(); 

			return usuarios;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public Integer consultarMaiorIdUsuario() throws Exception{
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT MAX(idUsuario) FROM Usuario U");

			Query query = em.createQuery(sql.toString());
			Integer maiorIdUsuario = (Integer) query.getSingleResult();
			em.close();

			if(maiorIdUsuario == null)
				maiorIdUsuario = 0;
		
			return ++maiorIdUsuario;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Usuario consultarUsuarioPorId(Integer id) throws Exception{
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();

			em.getTransaction().begin();
			
			Query query = em.createNamedQuery("SELECT u FROM Usuario U where idUsuario =: idUsuario");
			query.setParameter("idUsuario", id);
			Usuario usuario = (Usuario) query.getSingleResult();
			em.close();
			return usuario;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Usuario autenticaUsuario(String email, String senha) throws Exception{
		try{
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			
			Query query = em.createQuery("SELECT u FROM Usuario u where email =:email AND senha =:senha");
			query.setParameter("email", email);
			query.setParameter("senha", senha);

			Usuario usuario = (Usuario) query.getSingleResult();
			em.close();
			return usuario;
		}catch (Exception e){
			return null;
		}
	}
	
	public static void editarUsuarioCompleto(Usuario usuario) throws Exception{
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("UPDATE Usuario ");
			sql.append("SET cpf = :cpf, ");
			sql.append("email = :email, ");
			sql.append("nome = :nome,");
			sql.append("estado = :estado, ");
			sql.append("cidade = :cidade, ");
			sql.append("telefone = :telefone, ");
			sql.append("cep = :cep, ");
			sql.append("bairro = :bairro, ");
			sql.append("rua = :rua, ");
			sql.append("complemento = :complemento ");	
			sql.append("WHERE idUsuario = :idUsuario ");
			
			Query query = em.createQuery(sql.toString());
			
			query.setParameter("cpf", usuario.getCpf());
			query.setParameter("email", usuario.getEmail());
			query.setParameter("nome", usuario.getNome());
			query.setParameter("estado", usuario.getEstado());
			query.setParameter("cep", usuario.getCep());
			query.setParameter("cidade", usuario.getCidade());
			query.setParameter("telefone", usuario.getTelefone());
			query.setParameter("bairro", usuario.getBairro());
			query.setParameter("rua", usuario.getRua());
			query.setParameter("complemento", usuario.getComplemento());
			query.setParameter("idUsuario", usuario.getIdUsuario());
			query.executeUpdate();
			entityManagerFactory.close();
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static void apagarUsuario(Integer id) throws Exception{
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.iservice.jpa");
			EntityManager em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("DELETE FROM Usuario ");
			sql.append("WHERE idUsuario = :idUsuario ");
			
			Query query = em.createQuery(sql.toString());
			query.setParameter("idUsuario", id);
			query.executeUpdate();
			entityManagerFactory.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
