package usuario;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entity.Usuario;


@ViewScoped
@ManagedBean
@Named("cadastroUsuarioBean")
public class CadastroUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String paginaCadastrarUsuario = "/pages/usuario/cadastrarUsuario.xhtml";
	
	private UsuarioRetorno usuarioRetorno;
	
	private UsuarioService usuarioService;

	private Boolean isTecnico = false;
	private String cpf;
	private String email;
	private String senha;
	private String senhaConfirma;
	private String nome;
	private String telefone;
	private String estado;
	private String cidade;
	private String cep;
	private String bairro;
	private String rua;
	private String complemento;

	@PostConstruct
	public void init() {
		usuarioService = new UsuarioService();
	}
	
	public String validarCadastro() throws Exception {
		if(senha.equals(senhaConfirma)) {
			cadastrar();
			return null;
		}else {
			return paginaCadastrarUsuario;
		}
	}

	public void cadastrar() throws Exception {
 		Usuario usuarioPersistir = new Usuario();
 		usuarioPersistir.setId(1);
		usuarioPersistir.setIsTecnico(isTecnico == true ? 1 : 0);
		usuarioPersistir.setCpf("05810184944");
		usuarioPersistir.setEmail("email"); 
		usuarioPersistir.setSenha("senha");
		usuarioPersistir.setNome("nome");
		usuarioPersistir.setTelefone("995779430");
		usuarioPersistir.setEstado("estado");
		usuarioPersistir.setCidade("cidade");
		usuarioPersistir.setCep("81630070");
		usuarioPersistir.setBairro("bairro");
		usuarioPersistir.setRua("rua");
		usuarioPersistir.setComplemento("complemento");
		
		usuarioService.cadastrarUsuario(usuarioPersistir);
			
	
	}
	
	public String voltar() {
		return "/pages/index.xhtml";
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getSenhaConfirma() {
		return senhaConfirma;
	}

	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public UsuarioRetorno getUsuarioRetorno() {
		return usuarioRetorno;
	}

	public void setUsuarioRetorno(UsuarioRetorno usuarioRetorno) {
		this.usuarioRetorno = usuarioRetorno;
	}

	public String getPaginaCadastrarUsuario() {
		return paginaCadastrarUsuario;
	}

	public void setPaginaCadastrarUsuario(String paginaCadastrarUsuario) {
		this.paginaCadastrarUsuario = paginaCadastrarUsuario;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}