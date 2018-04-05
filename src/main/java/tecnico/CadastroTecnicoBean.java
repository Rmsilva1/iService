package tecnico;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@ViewScoped
@ManagedBean
@Named("cadastroTecnicoBean")
public class CadastroTecnicoBean implements Serializable{

	private static final long serialVersionUID = 5575777153302473377L;
	private String hello;
	private String nome;
	private String sobreNome;
	
	public String getHello() {
		return hello;
	}


	public void setHello(String hello) {
		this.hello = hello;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobreNome() {
		return sobreNome;
	}


	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	@PostConstruct
	public void init() {
		this.hello = "HELLO from " + this.getClass();
	}
	
}
