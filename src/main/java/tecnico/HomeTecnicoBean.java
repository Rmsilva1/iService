package tecnico;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ViewScoped
@Named("homeTecnicoBean")
@ManagedBean
public class HomeTecnicoBean implements Serializable{

	private static final long serialVersionUID = 5560956621188613430L;
	
	private String paginaCadastrarServico = "/pages/usuario/tecnico/cadastrarServico.xhtml";
	private String paginaAlterarServico = "/pages/usuario/tecnico/alterarServico.xhtml";
	private String paginaExcluirServico = "/pages/usuario/tecnico/excluirServico.xhtml";
	private String paginaPerfil = "/pages/usuario/tecnico/editarPerfil.xhtml";

	public HomeTecnicoBean() { }
	
	@PostConstruct
	public void init() {}
	
	
	public void redirecionarPaginaCadastrarServico() throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaCadastrarServico);
	}
	
	public void redirecionarPaginaAlterarServico() throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaAlterarServico);
	}
	
	public void redirecionarPaginaExcluirServico() throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaExcluirServico);
	}
	
	public void redirecionarPaginaEditarMeuPerfil() throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaPerfil);
	}
	
}
