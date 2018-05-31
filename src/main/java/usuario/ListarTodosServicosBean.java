package usuario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entity.Servico;
import entity.Usuario;
import tecnico.ServicosService;

/**
 * @author Rafael Mateus
 * 31 de mai de 2018
 */

@ViewScoped
@ManagedBean(name="listarTodosServicosBean")
public class ListarTodosServicosBean implements Serializable {


	private static final long serialVersionUID = -7409417142506331696L;
	private List<Servico> servicos;
	private Usuario usuarioLogado;
	
	public ListarTodosServicosBean() {}
	
	@PostConstruct
	public void init() throws Exception {
		usuarioLogado =  (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("keyUsuario");
		servicos = ServicosService.listarTodosServicos();
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
