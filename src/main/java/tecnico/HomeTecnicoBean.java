package tecnico;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entity.Usuario;

@ViewScoped
@ManagedBean(name="homeTecnicoBean")
public class HomeTecnicoBean implements Serializable{

	private static final long serialVersionUID = 5560956621188613430L;
	
	private String paginaCadastrarServico = "/pages/usuario/tecnico/cadastrarServico.jsf";
	private String paginaAlterarServico = "/pages/usuario/tecnico/alterarServico.jsf";
	private String paginaExcluirServico = "/pages/usuario/tecnico/excluirServico.jsf";
	private String paginaPerfil = "/pages/usuario/tecnico/editarPerfil.jsf";
	private String paginaMeusServicos = "/pages/usuario/tecnico/meusServicos.jsf";
	private String paginaEditarMeuUsuario = "/pages/usuario/editarMeuUsuario.jsf";
	private String paginaListarTodosServicos = "/pages/usuario/listarTodosServicos.jsf";
	private Usuario usuarioLogado;

	public HomeTecnicoBean() {}
	
	@PostConstruct
	public void init() {
		usuarioLogado = (Usuario) 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("keyUsuario");
	}
	
	public void redirecionarPaginaListarTodosServicos() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioLogado);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaListarTodosServicos);
	}
	
	public void redirecionarPaginaMeusServicos() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioLogado);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaMeusServicos);
	}
	
	public void redirecionarPaginaEditarMeuUsuario() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioLogado);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaEditarMeuUsuario);
	}
	
	public void redirecionarPaginaCadastrarServico() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioLogado);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaCadastrarServico);
	}
	
	public void redirecionarPaginaAlterarServico() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioLogado);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaAlterarServico);
	}
	
	public void redirecionarPaginaExcluirServico() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioLogado);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaExcluirServico);
	}
	
	public void redirecionarPaginaEditarMeuPerfil() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioLogado);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaPerfil);
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}