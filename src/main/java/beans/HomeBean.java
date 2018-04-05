package beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;


/**
 * @author Rafael Mateus
 *
 * 30 de mar de 2018
 */

@ViewScoped
@ManagedBean
@Named("homeBean")
public class HomeBean implements Serializable {

	private String paginaCadastrarTecnico = "pages/tecnico/cadastrarTecnico.xhtml";
	private String paginaCadastrarUsuario = "pages/usuario/cadastrarUsuario.xhtml";
	
	private String hello = "hello";
	
	/**
	 * 
	 */
	public HomeBean() {
		
	}

	@PostConstruct
	public void init() {
		this.hello = "Hello!";
	}
	
	public void redirecionarPaginaCadastroTecnico() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + paginaCadastrarTecnico);
        System.out.println("aa");
	}
	
	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

}
