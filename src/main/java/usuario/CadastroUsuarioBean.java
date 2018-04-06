package usuario;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@ViewScoped
@ManagedBean
@Named("cadastroUsuarioBean")
public class CadastroUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String paginaIndex = "/pages/index.xhtml";
	
	private Boolean isTecnico = false;
	private String cpf;
	private String email;
	private String senha;
	private String senhaConfirma;
	private String nome;
	private String telefone;
	private String estado;
	private String cidade;
	private String bairro;
	

	@PostConstruct
	public void init() { }
	
	
	
	public void cadastrar() {
		//TODO
	}
	
	public void redirecionarPaginaIndex() throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaIndex);
	}

	/**
	 * @return the isTecnico
	 */
	public Boolean getIsTecnico() {
		return isTecnico;
	}

	/**
	 * @param isTecnico the isTecnico to set
	 */
	public void setIsTecnico(Boolean isTecnico) {
		this.isTecnico = isTecnico;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the senhaConfirma
	 */
	public String getSenhaConfirma() {
		return senhaConfirma;
	}

	/**
	 * @param senhaConfirma the senhaConfirma to set
	 */
	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
}