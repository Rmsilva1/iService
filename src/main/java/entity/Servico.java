package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
	private Integer idServico;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ID_TECNICO")
	private Usuario tecnico;
	
	@Column(name = "ID_CATEGORIA", unique = true, nullable = false)
	private Integer idCategoria;
	
	@Column(name = "DESCRICAO", unique = true, nullable = false)
	private String descricao;

	@Column(name = "PRECO", unique = true, nullable = false)
	private Double preco;

	public Servico() {}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Integer getIdCategoria() {
		return idCategoria;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getDescricaoCategoriaEnum() {
		return CategoriaEnum.getCategoriaById(this.idCategoria);
	}

	public Usuario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}
}