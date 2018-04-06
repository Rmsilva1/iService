package usuario;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@ViewScoped
@ManagedBean
@Named("cadastroUsuarioBean")
public class CadastroUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String paginaIndex = "/pages/index.xhtml";
	
	private Boolean isTecnico;
	private String cpf;
	private String email;
	private String senha;
	private String senhaConfirma;
	private String nome;
	private String telefone;
	private String estado;
	private String cidade;
	private String bairro;

//	@PostConstruct
//	public void init() {
//		
//		System.out.println(isTecnico);
//		//DEPRECATED?
//		//isTecnico = (Boolean) WebResources.getFlashContext().get(CODIGO_IS_TECNICO);
//		
//		/**
//		 * TODO Pegar os valores da sess�o
//		 * 		booleano de se � para cadastrar usuario normal ou tecnico.
//		 * 		Popular a tela para personalizada conforme a decis�o do usuario.
//		 */
//	}
	
	public void cadastrar() {
		//TODO
	}
	
	public void redirecionarPaginaIndex() throws IOException {
	    FacesContext.getCurrentInstance().getExternalContext().dispatch(paginaIndex);
	}
	
	public String voltar() {
		return "/pages/index.xhtml";
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
}