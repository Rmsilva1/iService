package login;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import entity.Usuario;
import usuario.UsuarioService;
import util.CryptoUtils;

/**
 * @author Rafael Mateus
 *
 *         5 de mai de 2018
 */
public class LoginService {
	private UsuarioService usuarioService;

	public LoginService() 
		{usuarioService = new UsuarioService();}

//	public Usuario isUsuarioReadyToLogin(String email, String senha) throws Exception {
//		try {
//			email = email.toLowerCase().trim();
//			List<Usuario> retorno = usuarioService.findByNamedQuery(Usuario.FIND_BY_EMAIL_SENHA,
//					new NamedParams("email", email.trim(), "senha", CryptoUtils.convertStringToMd5(senha)));
//
//			if (retorno.size() == 1) {
//				return (Usuario) retorno.get(0);
//			}
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}