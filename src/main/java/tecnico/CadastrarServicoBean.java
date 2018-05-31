package tecnico;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entity.Categoria;
import entity.CategoriaEnum;
import entity.Servico;
import entity.Usuario;
import usuario.UsuarioService;

@ViewScoped
@ManagedBean(name="cadastrarServicoBean")
public class CadastrarServicoBean implements Serializable{

	private static final long serialVersionUID = -1408378481813093379L;
	
	private String paginaHomeTecnico = "/iService/pages/usuario/tecnico/homeTecnico.jsf";
	
	private Usuario usuarioLogado;
	private String descricao;
	private List<Categoria> listaCategorias;
	private Categoria categoria;
	private Double preco;
	private Boolean isAtivo = false;
	private List<Usuario> listaUsuarios;
	private Usuario usuarioTecnico;
	private UsuarioService usuarioService;
	private List<String> descricaoCategorias;
	private String categoriaSalvar;

	public CadastrarServicoBean(){}
	
	@PostConstruct
	public void init() throws Exception {
		usuarioLogado = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("keyUsuario");
		usuarioService = new UsuarioService();
		descricaoCategorias = new ArrayList<String>();
		listaCategorias = ServicosService.listarTodasCategorias();
		for(Categoria categoria : listaCategorias) {
			descricaoCategorias.add(categoria.getCategeoriaById(categoria.getIdCategoria()));
		}
	}
	
	public void validaCadastrarServico() throws Exception {
		Boolean sucessoValidacao = true;
		
		if(categoriaSalvar == null || categoriaSalvar == null) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "É necessario escolher uma categoria!"));
			sucessoValidacao = false;
		}
		
		if(preco == null) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Preço é obrigatorio!"));
			sucessoValidacao = false;
		}
		
		if(descricao.equals(null) || descricao.trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Descrição do servico é obrigatoria!"));
			sucessoValidacao = false;
		}
		
		if(sucessoValidacao)
			cadastrarServico();
	}

	public void cadastrarServico() throws Exception{
		Categoria categoriaEntity = new Categoria(CategoriaEnum.getIdByDescricao(categoriaSalvar), descricao);
		Servico servicoCadastrar = new Servico();
		
		servicoCadastrar.setIdServico(ServicosService.consultarMaiorIdServico());
		servicoCadastrar.setDescricao(descricao);
		servicoCadastrar.setIdCategoria(categoriaEntity.getIdCategoria());
		servicoCadastrar.setPreco(preco);
		servicoCadastrar.setTecnico(usuarioLogado);	
		
		if(ServicosService.cadastrarServico(servicoCadastrar)) {
			FacesContext.getCurrentInstance().addMessage
				(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO", "O Servico  " + descricao +" foi cadastrado com sucesso!"));
			limpaCampos();
		}
	}
	
	public void limpaCampos() {
		categoriaSalvar = null;
		preco = null;
		descricao = null;
	}
	
	public void redirecionarPaginaHomeTecnico() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect(paginaHomeTecnico);
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

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<String> getDescricaoCategorias() {
		return descricaoCategorias;
	}

	public void setDescricaoCategorias(List<String> descricaoCategorias) {
		this.descricaoCategorias = descricaoCategorias;
	}

	public String getCategoriaSalvar() {
		return categoriaSalvar;
	}

	public void setCategoriaSalvar(String categoriaSalvar) {
		this.categoriaSalvar = categoriaSalvar;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}