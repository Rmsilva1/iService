package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rafael Mateus
 *	Classe de entidade que representara a model e também as tabelas
 *  para persistencia por JPA de Servicos
 *  24 de abr de 2018
 */

@Entity
@Table(name = "SERVICOS")
public class Servicos implements Serializable {

	private static final long serialVersionUID = -1259534850732841932L;

	@Id
	@Column(name = "ID_SERVICO", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "FK_TECNICO", unique = true, nullable = false)
	private Integer fkTecnico;
	
	@Column(name = "FK_CATEGORIA", unique = true, nullable = false)
	private Integer fkCategoria;
	
	@Column(name = "ISATIVO", unique = true, nullable = false)
	private Integer isAtivo;
	
	@Column(name = "DESCRICAO", unique = true, nullable = false)
	private String descricao;

	@Column(name = "PRECO", unique = true, nullable = false)
	private String preco;

	public Servicos() {}
	
	public Integer getId() {
		return id;
	}

	public Integer getFkTecnico() {
		return fkTecnico;
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

	public void setFkTecnico(Integer fkTecnico) {
		this.fkTecnico = fkTecnico;
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
}