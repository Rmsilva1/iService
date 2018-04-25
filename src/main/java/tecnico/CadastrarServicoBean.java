package tecnico;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entity.Servico;
import entity.Usuario;
import usuario.UsuarioService;

@ViewScoped
@ManagedBean(name="cadastrarServicoBean")
public class CadastrarServicoBean implements Serializable{

	private static final long serialVersionUID = -1408378481813093379L;
	
	private String descricao;
	private Integer categoria;
	private Double preco;
	private Boolean isAtivo = false;
	private List<Usuario> listaUsuarios;
	private Usuario usuarioTecnico;
	private ServicosService servicoService;
	private UsuarioService usuarioService;
	
	public CadastrarServicoBean(){}
	
	@PostConstruct
	public void init() throws Exception {
		servicoService = new ServicosService();
		usuarioService = new UsuarioService();
		
		listaUsuarios = usuarioService.listarTodosUsuarios();
	}

	//TODO cadastrar servico para usuario especifico selecionado pelo cliente.
	public void cadastrarServico() throws Exception{
		Servico servicoCadastrar = new Servico();
		//servicoCadastrar.setUsuario(usuario);

		servicoService.cadastrarServico(servicoCadastrar);
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public Usuario getUsuarioTecnico() {
		return usuarioTecnico;
	}

	public ServicosService getServicoService() {
		return servicoService;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public void setUsuarioTecnico(Usuario usuarioTecnico) {
		this.usuarioTecnico = usuarioTecnico;
	}

	public void setServicoService(ServicosService servicoService) {
		this.servicoService = servicoService;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}