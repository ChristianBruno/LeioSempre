/**
 * Representa um LIVRO e define o método construtor, getters e setters
 * @author Christian Bruno
 * @author Diego Braga
 * @author Thássio Lucena
 */


package modelos;

public class Livro {
	
	private int codigo;
	private String titulo;
	private int tipo;
	
	/**
	 * Construtor  
	 * @param codigo Código do LIVRO
	 * @param titulo Título do LIVRO
	 * @param tipo Tipo do LIVRO: 1 - DIGITAL | 2 - FÍSICO
	 */
	public Livro(int codigo, String nome, int tipo) {
		this.codigo = codigo;
		this.titulo = nome;
		this.tipo = tipo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
