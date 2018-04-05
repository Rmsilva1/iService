package usuario;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


@ViewScoped
@ManagedBean
@Named("cadastroUsuarioBean")
public class CadastroUsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3442147548000808550L;
	private Boolean isTecnico = true;
	private String cpf;
	private String email;
	private String senha;
	private String nome;
	private String telefone;
	private String estado;
	private String cidade;

	@PostConstruct
	public void init() { }
	
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

	public String getPassword() {
		return senha;
	}

	public void setPassword(String password) {
		this.senha = password;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getPhone() {
		return telefone;
	}

	public void setPhone(String phone) {
		this.telefone = phone;
	}

	public String getState() {
		return estado;
	}

	public void setState(String state) {
		this.estado = state;
	}

	public String getCity() {
		return cidade;
	}

	public void setCity(String city) {
		this.cidade = city;
	}
}