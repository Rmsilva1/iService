package entity;

public enum CategoriaEnum{
	CHAVEIRO(1,"Chaveiro"),
	DESENVOLVEDOR(2, "Desenvolvedor"),
	ELETRICISTA(3, "Eletricista" ),
	DESENTUPIDOR(4, "Desentupidor"),
	DETETIZADOR(5, "Detetizador"),
	ENCANADOR(6, "Encanador"),
	JARDINEIRO(7, "Jardineiro"),
	PEDREIRO(8, "Pedreiro"),
	PISCINEIRO(9, "Piscineiro"),
	VIDRACEIRO(10, "Vidraceiro"),
	TERRAPLANISTA(11, "Terraplanista");
	
	private final Integer idCategoria;
	private final String descricaoCategoria;
	
	private CategoriaEnum(Integer idCategoria, String descricaoCategoria) { 
		this.idCategoria = idCategoria;
		this.descricaoCategoria = descricaoCategoria;
	}
	
	public static String getCategoriaById(Integer idCategoria){
		for(CategoriaEnum categoria: CategoriaEnum.values()){
			if(categoria.getIdCategoria() == idCategoria){
				return categoria.descricaoCategoria;
			}
		}
		return null;
	}
	
	public static Integer getIdByDescricao(String descricao){
		for(CategoriaEnum categoria: CategoriaEnum.values()){
			if(categoria.getDescricao().equals(descricao)){
				return categoria.idCategoria;
			}
		}
		return null;
	}
	
	public Integer getIdCategoria() { 
		return idCategoria; 
	}
	
	public String getDescricao() {
		return descricaoCategoria;
	}
}