package login;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entity.Usuario;
import usuario.UsuarioService;
import util.CryptoUtils;

/**
 * @author Rafael Mateus
 * 5 de mai de 2018
 */

@ViewScoped
@ManagedBean(name="loginBean")
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1094801825228386363L;
	
	private String email;
	private String senha;
	private UsuarioService usuarioService;
	private Usuario usuarioLogado;
	
	private String paginaHomeTecnico = "/iService/pages/usuario/tecnico/homeTecnico.jsf";
	
	public LoginBean() { }
	
	public Usuario autenticarLogin() throws Exception {
		usuarioService = new UsuarioService();
		usuarioLogado = usuarioService.autenticaUsuario(email, CryptoUtils.convertStringToMd5(senha));
		
		if(usuarioLogado != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "Seja Bem vindo " + usuarioLogado.getNome() + " !"));
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioLogado);
			redirecionarPaginaHomeTecnico();
		}else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Login ou senha invalidos!."));
		}
		return null;
	}
	
	public void redirecionarPaginaHomeTecnico() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect(paginaHomeTecnico);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}