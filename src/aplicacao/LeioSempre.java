/**
 * Classe da aplicação, com o controle de exibição dos menus
 * @author Christian Bruno
 * @author Diego Braga
 * @author Thássio Lucena
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
				System.out.println("Menu de assinantes ainda não foi implementado - Escolha a opção 2");
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
								System.out.println("Esta opção ainda não foi implementada - Escolha a opção 1");
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
