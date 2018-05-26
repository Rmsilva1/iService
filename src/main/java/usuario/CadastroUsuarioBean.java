package usuario;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entity.Usuario;
import util.CryptoUtils;

@ViewScoped
@ManagedBean(name="cadastroUsuarioBean")
public class CadastroUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String paginaCadastrarUsuario = "/pages/usuario/cadastrarUsuario.jsf";
	private String paginaHomeTecnico = "/iService/pages/usuario/tecnico/homeTecnico.jsf";
	private String paginaIndex = "/pages/index.jsf";
	
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
	private Integer numero;
	private String complemento;
	private Boolean flagHabilitaModal;

	
	public CadastroUsuarioBean() {}

	@PostConstruct
	public void init() { 
		flagHabilitaModal = false;
		usuarioService = new UsuarioService(); 
	}
	
	public void validarCadastro() throws Exception {
		if(senha.equals(senhaConfirma)) {
			cadastrar();
		}else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "As senhas devem ser iguais."));
		}
	}

	public void cadastrar() throws Exception {
		Usuario usuarioPersistir = montarUsuario();
		if(usuarioService.cadastrarUsuario(usuarioPersistir));
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuarioPersistir);
			redirecionarPaginaHomeTecnico();
	}
	
	public Usuario montarUsuario() throws Exception {
		Usuario usuario = new Usuario();
 		usuario.setIdUsuario(usuarioService.consultarMaiorIdUsuario());
 		usuario.setPermissionLevel(1);
		usuario.setIsTecnico(isTecnico.equals(Boolean.TRUE) ? 1 : 0);
		usuario.setCpf(cpf);
		usuario.setEmail(email.toLowerCase()); 
		usuario.setSenha(CryptoUtils.convertStringToMd5(senha));
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
		usuario.setEstado(estado);
		usuario.setCidade(cidade);
		usuario.setCep(cep);
		usuario.setBairro(bairro);
		usuario.setRua(rua);
		usuario.setComplemento(complemento);
		return usuario;
	}
	
	public void abrirModal() { 
		flagHabilitaModal = true; 
	}
	
	public void fecharModal() { 
		flagHabilitaModal = false; 
	}
	
	public void redirecionarPaginaCadastro() throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaCadastrarUsuario);
	}
	
	public void redirecionarPaginaHomeTecnico() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().redirect(paginaHomeTecnico);
	}
	
	public void redirecionarIndex() throws Exception{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaIndex);
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getflagHabilitaModal() {
		return flagHabilitaModal;
	}

	public void setflagHabilitaModal(Boolean flagHabilitaModal) {
		this.flagHabilitaModal = flagHabilitaModal;
	}
}