package beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import usuario.CadastroUsuarioBean;


/**
 * @author Rafael Mateus
 *
 * 30 de mar de 2018
 */

@ViewScoped
@ManagedBean
@Named("homeBean")
public class HomeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String paginaCadastrarUsuario = "/pages/usuario/cadastrarUsuario.xhtml";
	private Boolean isTecnico = true;
	
	public HomeBean() { }

	@PostConstruct
	public void init() { }
	
	public void redirecionarPaginaCadastroTecnico() throws IOException {
		CadastroUsuarioBean cad = new CadastroUsuarioBean();
		cad.setIsTecnico(true);
		redirecionarPaginaCadastro();
	}
	
	public void redirecionarPaginaCadastro() throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaCadastrarUsuario);
	}

	public Boolean getIsTecnico() {
		return isTecnico;
	}
	
	public void setIsTecnico(Boolean isTecnico) {
		this.isTecnico = isTecnico;
	}

}
