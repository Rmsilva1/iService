package usuario;

/**
 * @author Rafael Mateus
 *	Classe responsval pela transferencia dos dados de usuario.
 * 8 de abr de 2018
 */
public class UsuarioRetorno {
	
	private UsuarioService usuarioService;
	private Boolean isTecnico;
	private String cpf;
	private String email;
	private String senha;
	private String senhaConfirma;
	private String nome;
	private String telefone;
	private String estado;
	private String cidade;
	private String bairro;
	
	public UsuarioRetorno() {}
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenhaConfirma() {
		return senhaConfirma;
	}
	public void setSenhaConfirma(String senhaConfirma) {
		this.senhaConfirma = senhaConfirma;
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

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}
