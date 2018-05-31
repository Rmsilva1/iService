package tecnico;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entity.Servico;
import entity.Usuario;


@ViewScoped
@ManagedBean(name="meusServicosBean")
public class MeusServicosBean implements Serializable {

	private static final long serialVersionUID = 6579612387254430258L;
	private String paginaHome = "/pages/usuario/tecnico/homeTecnico.jsf";


	private List<Servico> listaServicos;
	private Usuario usuario;

	private ServicosService servicosService;
	
	public MeusServicosBean(){}
	
	@PostConstruct
	public void init() throws Exception {
		usuario = (Usuario) 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("keyUsuario");
		listaServicos = ServicosService.listarTodosServicosPorUsuario(usuario.getIdUsuario());
	}

	public List<Servico> getListaServicos() {
		return listaServicos;
	}

	public ServicosService getServicosService() {
		return servicosService;
	}

	public void setListaServicos(List<Servico> listaServicos) {
		this.listaServicos = listaServicos;
	}

	public void setServicosService(ServicosService servicosService) {
		this.servicosService = servicosService;
	}
	
	public void redirecionarPaginaHomeTecnico() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuario);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaHome);
	}
}