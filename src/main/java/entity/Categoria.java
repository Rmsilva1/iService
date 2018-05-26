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
 *  02 de maio de 2018
 */

@Entity
@Table(name = "CATEGORIAS_SERVICOS")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 5577520425157566585L;
	
	@Id
	@Column(name = "ID_CATEGORIA", unique = true, nullable = false)
	private Integer idCategoria;
	
	@Column(name = "DESCRICAO", unique = true, nullable = false)
	private String descricao;
	
	public Categoria() {}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public Categoria(Integer idCategoria, String descricao) {
		super();
		this.idCategoria = idCategoria;
		this.descricao = descricao;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCategeoriaById(Integer idCategoria) {
		return CategoriaEnum.getCategoriaById(idCategoria);
	}
}
