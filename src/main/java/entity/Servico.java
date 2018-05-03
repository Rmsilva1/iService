package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Rafael Mateus
 *	Classe de entidade que representara a model e também as tabelas
 *  para persistencia por JPA de Servicos
 *  24 de abr de 2018
 */

@Entity
@Table(name = "SERVICOS")
public class Servico implements Serializable {

	private static final long serialVersionUID = -1259534850732841932L;

	@Id
	@Column(name = "ID_SERVICO", unique = true, nullable = false)
	private Integer idServico;
	
	@OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Usuario> idUsuario;
	
	@Column(name = "id_Categoria", unique = true, nullable = false)
	private Categoria idCategoria;
	
	@Column(name = "DESCRICAO", unique = true, nullable = false)
	private String descricao;

	@Column(name = "PRECO", unique = true, nullable = false)
	private String preco;

	public Servico() {}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Set<Usuario> getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Set<Usuario> idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

}