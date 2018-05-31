package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Rafael Mateus Classe de entidade que representara a model e também as
 *         tabelas para persistencia por JPA de Usuarios 8 de abr de 2018
 */

@NamedQueries(value = { @NamedQuery(name = "Usuario.findByEmailSenha",
	query = "SELECT c FROM Usuario c " 
		  + "WHERE c.email = :email AND c.senha = :senha")})


@Entity
@Table(name = "USUARIOS") 
public class Usuario implements Serializable {

	private static final long serialVersionUID = 4683554548002572431L;

	public static final String FIND_BY_EMAIL_SENHA = null;

	@Id
	@Column(name = "ID_USUARIO", unique = true, nullable = false)
//	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name = "permissionLevel", nullable = false)
	private Integer permissionLevel;

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

	public Usuario() { }

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer id) {
		this.idUsuario = id;
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

	public Integer getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(Integer permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((isTecnico == null) ? 0 : isTecnico.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((permissionLevel == null) ? 0 : permissionLevel.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (isTecnico == null) {
			if (other.isTecnico != null)
				return false;
		} else if (!isTecnico.equals(other.isTecnico))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissionLevel == null) {
			if (other.permissionLevel != null)
				return false;
		} else if (!permissionLevel.equals(other.permissionLevel))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

//	public Servico getServico() {
//		return servico;
//	}
//
//	public void setServicos(Servico servico) {
//		this.servico = servico;
//	}
}
