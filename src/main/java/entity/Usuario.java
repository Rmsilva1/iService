package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Rafael Mateus
 *	Classe de entidade que representara a model e também as tabelas
 *  para persistencia por JPA
 * 8 de abr de 2018
 */

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 4683554548002572431L;

	@Id
	@GeneratedValue(generator = "incrementor")
	@GenericGenerator(name = "incrementor", strategy = "increment")
	@Column(name = "ID_USUARIO", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "ISTECNICO", nullable = false)
	private Integer isTecnico;
	
	@Column(name = "CPF", nullable = false)
	private String cpf;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "SENHA", nullable = false)
	private String senha;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "TELEFONE", nullable = false)
	private String telefone;

	@Column(name = "ESTADO", nullable = false)
	private String estado;

	@Column(name = "CIDADE", nullable = false)
	private String cidade;
	
	@Column(name = "CEP")
	private String cep;

	@Column(name = "BAIRRO")
	private String bairro;

	@Column(name = "RUA")
	private String rua;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsTecnico() {
		return isTecnico;
	}

	public void setIsTecnico(Integer isTecnico) {
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
