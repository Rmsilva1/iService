package tecnico;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.Servico;


@ViewScoped
@ManagedBean(name="meusServicosBean")
public class MeusServicosBean implements Serializable {

	private static final long serialVersionUID = 6579612387254430258L;

	private List<Servico> listaServicos;
	
	private ServicosService servicosService;
	
	public MeusServicosBean(){}
	
	@PostConstruct
	public void init() throws Exception { 
		servicosService = new ServicosService();
		listaServicos = servicosService.listarTodosServicos();
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

}
