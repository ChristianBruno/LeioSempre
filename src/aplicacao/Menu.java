/**
 * Classe respons�vel pela exibi��o dos menus e a captura das op��es inseridas pelos usu�rios
 * @author Christian Bruno
 * @author Diego Braga
 * @author Th�ssio Lucena
 */

package aplicacao;

public class Menu {
	
	private static Inputs opcao = new Inputs();
		
	/**
	 * Mostra o menu PRINCIPAL da aplica��o e retorna a op��o escolhida pelo usu�rio 
	 * @return int
	 */
	public static int MenuPrincipal() {
		System.out.println();
		System.out.println("########## LEIO SEMPRE - MENU PRINCIPAL ##########");
		System.out.println("# ---------------------------------------------- #");
		System.out.println("# 1. MENU DE ASSINANTES ------------------------ #");
		System.out.println("# 2. MENU DE ADMINISTRA��O --------------------- #");
		System.out.println("# 6. ENCERRAR PROGRAMA ------------------------- #");
		System.out.println("# ---------------------------------------------- #");
		System.out.println("##################################################");
		
		return opcao.getInt(1, 6);
	}
	
	
	/**
	 * Mostra o menu de ADMINISTRA��O da aplica��o e retorna a op��o escolhida pelo usu�rio 
	 * @return int
	 */
	public static int menuAdministracao() {
		System.out.println();
		System.out.println("########## LEIOSEMPRE ADMINISTRA��O ##############");
		System.out.println("# ---------------------------------------------- #");
		System.out.println("# 1. GERENCIAR LIVROS -------------------------- #");
		System.out.println("# 2. GERENCIAR ASSINANTES ---------------------- #");
		System.out.println("# 3. GERENCIAR USUARIOS DO SISTEMA ------------- #");
		System.out.println("# 4. EMPR�STIMOS ------------------------------- #");
		System.out.println("# 5. ASSINATURAS ------------------------------- #");
		System.out.println("# 6. ENCERRAR PROGRAMA ------------------------- #");
		System.out.println("# ---------------------------------------------- #");
		System.out.println("##################################################");
		
		return opcao.getInt(1, 6);
	}
	
	/**
	 * Mostra o menu LIVROS da aplica��o e retorna a op��o escolhida pelo usu�rio 
	 * @return int
	 */
	public static int MenuProduto() {
		System.out.println();
		System.out.println("##################### LIVROS# #####################");
		System.out.println("# ----------------------------------------------- #");
		System.out.println("# 1. ADICIONAR LIVRO ---------------------------- #");
		System.out.println("# 2. LISTAR LIVROS CADASTRADOS ------------------ #");
		System.out.println("# 3. EXCLUIR LIVRO CADASTRADO ------------------- #");
		System.out.println("# ----------------------------------------------- #");
		System.out.println("###################################################");

		return opcao.getInt(1, 3);
	}

}
