/**
 * Classe responsável pelo tratamento de erros de tipo de entrada de dados dos usuários
 * @author Christian Bruno
 * @author Diego Braga
 * @author Thássio Lucena
 */

package aplicacao;

import java.util.Scanner;

public class Inputs {
	
	private static Scanner input;
	
	/**
	 *  Método responsável por checar se o valor digitado é um inteiro e está dentro do intervalo definido.
	 * @param inicio Valor inicial do intervalo de verificação
	 * @param fim Valor final do intervalo de verificação
	 * @return int
	 */
	public int getInt(int inicio, int fim) {
		
		boolean continua = true;
		
		while (continua) {
			try {
				input = new Scanner(System.in);
				int opcao = input.nextInt();
			
				if ((opcao > inicio - 1) && (opcao < fim + 1)) {
					continua = false;
					return opcao;
				} else {
					System.out.println("# Atenção! Opção ou formato inválido. Tente novamente!");
				}
			
			} catch (Exception e) {
				System.out.println("# Atenção! Opção ou formato inválido. Tente novamente!");
			}
		}
		
		return 0;
	}
	
	/**
	 *  Método responsável por checar se o valor digitado é real.
	 * @return double
	 */
		public double getDouble() {
			
			boolean continua = true;
			
			while (continua) {
				try {
					input = new Scanner(System.in);
					double opcao = input.nextDouble();
					return opcao;
				} catch (Exception e) {
					System.out.println("# Atenção! Opção ou formato inválido. Tente novamente!");
				}
			}
			
			return 0;
		}

}
