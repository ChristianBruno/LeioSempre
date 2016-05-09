/**
 * Classe da aplica��o, com o controle de exibi��o dos menus
 * @author Christian Bruno
 * @author Diego Braga
 * @author Th�ssio Lucena
 */

package aplicacao;

import java.io.IOException;

import acoes.LivrosAcoes;

public class LeioSempre {

	public static void main(String[] args) throws IOException {
		
		LivrosAcoes produtoAcao = new LivrosAcoes();
		int opcao = 0;
		boolean principal = true;
		
		while (principal) {
			
		opcao = Menu.MenuPrincipal();
		
		switch (opcao) {
			case 1:
				System.out.println("Menu de assinantes ainda n�o foi implementado - Escolha a op��o 2");
				break;
			case 2:
				opcao = Menu.menuAdministracao();
				switch (opcao) {
					case 1:
						opcao = Menu.MenuProduto();
						switch (opcao) {
							case 1:
								produtoAcao.adicionar();
								break;
							case 2:
								produtoAcao.exibir(produtoAcao.recupera());
								break;
							case 3:
								produtoAcao.excluir();
								break;
							default:
								System.out.println("Esta op��o ainda n�o foi implementada - Escolha a op��o 1");
								break;	
						}
						break;
					}
					break;
			case 6:
				System.out.println("############### SISTEMA ENCERRADO ################");
				principal = false;
				break;
			}
		}
	}
	
}
