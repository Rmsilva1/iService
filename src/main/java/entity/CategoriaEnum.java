package entity;

public enum CategoriaEnum{
	Chaveiro(1),
	Detetizador(2),
	Desentupidor(3),
	Eletricista(4),
	Encanador(5),
	Jardineiro(6),
	Pedreiro(7),
	Piscineiro(8),
	Vidraceiro(9),
	Terraplanagem(10);
	
	private final Integer categoria;
	
	private CategoriaEnum(Integer categoria) 
		{ this.categoria = categoria; }
	
	public Integer pegarCategoriaComoInteiro() 
		{ return categoria; }
	
	public static CategoriaEnum converterInteiroEmCategoria(Integer iCategoria){
		for(CategoriaEnum categoria: CategoriaEnum.values()){
			if(categoria.pegarCategoriaComoInteiro() == iCategoria){
				return categoria;
			}
		}
		return null;
	}
}