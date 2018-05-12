package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rafael Mateus
 *
 * 12 de mai de 2018
 */
@Entity
@Table(name = "PEDIDOS")
public class Pedido implements Serializable {
	private static final long serialVersionUID = -2428605692768604124L;

	@Id
	@Column(name = "ID_PEDIDO", unique = true, nullable = false)
	private Integer idPedido;

	@Column(name = "ID_USUARIO_SOLICITANTE", unique = true, nullable = false)
	private Integer idUsuarioSolicitante;

	@Column(name = "ID_TECNICO", unique = true, nullable = false)
	private Integer idTecnico;

	@Column(name = "ID_SERVICO", unique = true, nullable = false)
	private Integer idServico;
	
	@Column(name = "DATA_SOLICITACAO", unique = true, nullable = false)
	private Date dataSolicitacao;

	@Column(name = "DATA_FINALIZACAO", unique = true, nullable = false)
	private Date dataFinalizacao;
	
	@Column(name = "NOTA")
	private Integer nota;
	
	public Pedido() {}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdUsuarioSolicitante() {
		return idUsuarioSolicitante;
	}

	public void setIdUsuarioSolicitante(Integer idUsuarioSolicitante) {
		this.idUsuarioSolicitante = idUsuarioSolicitante;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
}
