package tecnico;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.Servicos;

@ViewScoped
@ManagedBean(name="meusServicosBean")
public class MeusServicosBean implements Serializable {

	private static final long serialVersionUID = 6579612387254430258L;

	private List<Servicos> listaServicos;
	
	private ServicosService servicosService;
	
	public MeusServicosBean(){}
	
	@PostConstruct
	public void init() throws Exception { 
		servicosService = new ServicosService();
		listaServicos = servicosService.listarTodosServicos();
	}

	public List<Servicos> getListaServicos() {
		return listaServicos;
	}

	public void setListaServicos(List<Servicos> listaServicos) {
		this.listaServicos = listaServicos;
	}
}
