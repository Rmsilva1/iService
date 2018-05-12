package usuario;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
	
	public EditarMeuUsuarioBean() {}
	
	@PostConstruct
	public void init() {
		usuario = (Usuario) 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("keyUsuario");
//		this.usuario = usuarioService.consultarUsuarioPorId();
	}
	
	public void salvarEdicaoUsuario() throws Exception {	
		UsuarioService.editarUsuarioCompleto(usuario);
	}
	
	public void flagHabilitaModal() 
		{ flagHabilitaModal = true; }

	public void fecharModal() 
		{ flagHabilitaModal = false; }

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
