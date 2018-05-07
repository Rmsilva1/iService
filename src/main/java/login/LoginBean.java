package login;

import java.io.Serializable;

/**
 * @author Rafael Mateus
 * 5 de mai de 2018
 */
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1094801825228386363L;
	
	private String email;
	private String senha;
	
	public LoginBean() { } 
	
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
}