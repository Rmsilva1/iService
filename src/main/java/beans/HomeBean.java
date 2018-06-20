package beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Rafael Mateus
 *
 * 30 de mar de 2018
 */

@ViewScoped
@ManagedBean(name ="homeBean")
public class HomeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String paginaCadastrarUsuario = "/pages/usuario/cadastrarUsuario.jsf";
	private String paginaLogin = "/pages/Login.jsf";


	public HomeBean() {}

	@PostConstruct
	public void init() {}
	
	public void redirecionarPaginaCadastro() throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaCadastrarUsuario);
	}
	
	public void redirecionarPaginaLogin() throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaLogin);
	}
}
