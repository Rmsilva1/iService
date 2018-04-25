package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Rafael Mateus
 *	Classe de entidade que representara a model e tamb�m as tabelas
 *  para persistencia por JPA de Servicos
 *  24 de abr de 2018
 */

@Entity
@Table(name = "SERVICOS")
public class Servico implements Serializable {

	private static final long serialVersionUID = -1259534850732841932L;

	@Id
	@Column(name = "ID_SERVICO", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="FK_TECNICO", nullable = false)
	private Usuario usuario;
	
	@Column(name = "FK_CATEGORIA", unique = true, nullable = false)
	private Integer fkCategoria;
	
	@Column(name = "ISATIVO", unique = true, nullable = false)
	private Integer isAtivo;
	
	@Column(name = "DESCRICAO", unique = true, nullable = false)
	private String descricao;

	@Column(name = "PRECO", unique = true, nullable = false)
	private String preco;

	public Servico() {}
	
	public Integer getId() {
		return id;
	}

	public Integer getFkCategoria() {
		return fkCategoria;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public void setFkCategoria(Integer fkCategoria) {
		this.fkCategoria = fkCategoria;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}