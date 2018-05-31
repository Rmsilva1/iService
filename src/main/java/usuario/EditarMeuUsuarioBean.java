package usuario;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entity.Usuario;

/**
 * @author Rafael Mateus
 *
 * 6 de mai de 2018
 */

@ViewScoped
@ManagedBean(name="editarMeuUsuarioBean")
public class EditarMeuUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = -2636562746931768094L;
	
	private Usuario usuario;
	private Boolean flagHabilitaModal;
	private String paginaHome = "/pages/usuario/tecnico/homeTecnico.jsf";
	private String paginaIndex = "/pages/index.jsf";


	
	public EditarMeuUsuarioBean() {}
	
	@PostConstruct
	public void init() {
		usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("keyUsuario");
//		this.usuario = usuarioService.consultarUsuarioPorId();
	}
	
	public void salvarEdicaoUsuario() throws Exception {
		if(validarCamposObrigatorios())
			UsuarioService.editarUsuarioCompleto(usuario);
	}
	
	public Boolean validarCamposObrigatorios() {
		Boolean sucessoValidacao = true;
		
		if(usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Nome � obrigatorio!"));
			sucessoValidacao = false;
		}
		
		if(usuario.getCpf() == null || usuario.getCpf().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "CPF � obrigatorio!"));
			sucessoValidacao = false;
		}
		
		if(usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Email � obrigatorio!"));
			sucessoValidacao = false;
		}
		
		if(usuario.getTelefone() == null || usuario.getTelefone().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Telefone � obrigatorio!"));
			sucessoValidacao = false;
		}
		
		if(usuario.getCep() == null || usuario.getCep().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "CEP � obrigatorio!"));
			sucessoValidacao = false;
		}
		
		if(usuario.getEstado() == null || usuario.getEstado().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Estado � obrigatorio!"));
			sucessoValidacao = false;
		}
		
		if(usuario.getCidade() == null || usuario.getCidade().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Cidade � obrigatoria!"));
			sucessoValidacao = false;
		}
		
		if(usuario.getBairro() == null || usuario.getBairro().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Bairro � obrigatorio!"));
			sucessoValidacao = false;

		}
		return sucessoValidacao;
	}
	
	public void redirecionarPaginaHomeTecnico() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("keyUsuario", usuario);
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaHome);
	}
	
	public void excluirMeuUsuario() throws Exception {
		UsuarioService.apagarUsuario(usuario.getIdUsuario());
		redirecionarIndex();
	}
	
	public void redirecionarIndex() throws Exception{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + paginaIndex);
	}
	
	public void flagHabilitaModal() { 
		flagHabilitaModal = true; 
	}

	public void fecharModal() { 
		flagHabilitaModal = false; 
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getFlagHabilitaModal() {
		return flagHabilitaModal;
	}

	public void setFlagHabilitaModal(Boolean flagHabilitaModal) {
		this.flagHabilitaModal = flagHabilitaModal;
	}
}
