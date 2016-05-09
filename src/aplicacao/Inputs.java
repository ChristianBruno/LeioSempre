/**
 * Classe respons�vel pelo tratamento de erros de tipo de entrada de dados dos usu�rios
 * @author Christian Bruno
 * @author Diego Braga
 * @author Th�ssio Lucena
 */

package aplicacao;

import java.util.Scanner;

public class Inputs {
	
	private static Scanner input;
	
	/**
	 *  M�todo respons�vel por checar se o valor digitado � um inteiro e est� dentro do intervalo definido.
	 * @param inicio Valor inicial do intervalo de verifica��o
	 * @param fim Valor final do intervalo de verifica��o
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
					System.out.println("# Aten��o! Op��o ou formato inv�lido. Tente novamente!");
				}
			
			} catch (Exception e) {
				System.out.println("# Aten��o! Op��o ou formato inv�lido. Tente novamente!");
			}
		}
		
		return 0;
	}
	
	/**
	 *  M�todo respons�vel por checar se o valor digitado � real.
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
					System.out.println("# Aten��o! Op��o ou formato inv�lido. Tente novamente!");
				}
			}
			
			return 0;
		}

}
