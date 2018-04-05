package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


/**
 * @author Rafael Mateus
 *
 * 30 de mar de 2018
 */

@ViewScoped
@ManagedBean
@Named("homeBean")
public class HomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6554617830638102855L;
	
	private String hello = "hello";
	
	/**
	 * 
	 */
	public HomeBean() {
		
	}

	@PostConstruct
	public void init() {
		this.hello = "Hello!";
	}

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

}
