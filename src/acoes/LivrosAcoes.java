/**
 * Classe responsável pelas ações de Livros
 * @author Christian Bruno
 * @author Diego Braga
 * @author Thássio Lucena
 */

package acoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import aplicacao.Inputs;
import modelos.Livro;

public class LivrosAcoes {
	
	private Path path = Paths.get("BaseLeioSempre/livros.txt");
	private Charset utf8 = java.nio.charset.StandardCharsets.UTF_8;
	private Scanner input;
	private Inputs opcao = new Inputs();
	
	private ArrayList<Livro> livros;
	
	/**
	 * Cria um array de LIVROS e adiciona ao arquivo de dados
	 */
	
	public void adicionar() {
		
		ArrayList<Livro> livros = new ArrayList<>();
		livros = recupera();
		
		int adicionar = 1;
		
		while (adicionar == 1) {
			
			System.out.println("Digite o código do LIVRO:");
			int codigo = opcao.getInt(1, 9999999);
			
			while (verifica(codigo) == false) {
				System.out.println("Código já cadastrado. Digite outro:");
				codigo = opcao.getInt(1, 9999999);
			}
			
			System.out.println("Digite o nome do LIVRO:");
			input = new Scanner(System.in);
			String nome = input.nextLine();
			
			System.out.println("Digite o tipo do LIVRO: 1 - DIGITAL | 2 - FÍSICO");
			int tipo = opcao.getInt(1, 2);
			
			Livro livro = new Livro(codigo, nome, tipo);
			livros.add(livro);
			
			salvar(livros);
			
			System.out.println("CONTINUAR COM A INCLUSÃO DE LIVROS? 1 - SIM / 2 - NÃO");
			input = new Scanner(System.in);
			adicionar = input.nextInt();

		} 
	}
	
	/**
	 * Salva um ArrayList de Livros no arquivo de texto
	 * @param livros ArrayList de Livros 
	 * @see Livro
	 */
	
	public void salvar(ArrayList<Livro> livros) {
		
		try (BufferedWriter writer = Files.newBufferedWriter(path, utf8)) {
			for (Livro livro : livros) {
				writer.write(livro.getCodigo() + ";" + livro.getTitulo() + ";" + livro.getTipo() + "\n");
			}
			System.out.println("O registro foi atualizado com sucesso!");
		} catch (IOException e) {
			System.out.println("Atenção! Não foi possível salvar. Arquivo de dados não encontrado!");
			System.exit(0);
		}	
	}
	
	/**
	 * Varre o arquivo de texto e retorna os dados com um Array de Livros
	 * @return ArrayList
	 */
	
	public ArrayList<Livro> recupera() {
		
		ArrayList<Livro> livros = new ArrayList<>();
		
		try (BufferedReader reader = Files.newBufferedReader(path, utf8)) {
			String retorno = null;
			while ((retorno = reader.readLine()) != null) {
				String[] t = retorno.split(";");
				Livro Livro = new Livro(Integer.parseInt(t[0]), t[1], Integer.parseInt(t[2]));
				livros.add(Livro);
			}
		} catch (IOException e) {
			System.out.println("Atenção! Não foi possível salvar. Arquivo de dados não encontrado!");
			System.exit(0);
		}
		
		return livros;
	}
	
	/**
	 * Mostra as informações de um Array de Livros
	 * @param livros ArrayList de Livro
	 * @see Livro
	 */
	
	public void exibir(ArrayList<Livro> livros)  {
		
		System.out.println();
		System.out.println("############## LIVROS CADASTRADOS: ############# \n");
		for (Livro livro : livros) {
			int tipo = livro.getTipo();
			String tipoString = "Digital";
			
			if(tipo == 2) {
				tipoString = "Físico";
			}
			
			System.out.println(livro.getCodigo() + " - " + livro.getTitulo() + " TIPO: " + tipoString);
		}
	}
	
	/**
	 * Remove um livro do arquivo de texto
	 */
	
	public void excluir() {
		
		ArrayList<Livro> livrosNovo = new ArrayList<>();
		
		System.out.println("Digite o código do LIVRO:");
		input = new Scanner(System.in);
		int codigo = input.nextInt();
		
		int sair = 1;
		
		while (verifica(codigo) == true && sair == 1) {
			System.out.println("Código não encontrado. Digite outro ou tecle 0 para sair!");
			codigo = opcao.getInt(0, 9999999);
			if (codigo == 0 ) {
				sair = 0;
			}
		}
		
		this.livros = recupera();
		
		for (Livro livro : livros) {
			if (livro.getCodigo() != codigo) {
				livrosNovo.add(livro);
			} 
		}
		salvar(livrosNovo);
	}
	
	/**
	 * Verifica a existencia do códido de um livro no arquivo de dados
	 * @param codigo Código do LIVRO a ser verificado
	 * @return boolean
	 */
	
	public boolean verifica(int codigo) {
		
		livros = recupera();

		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo) {
				return false;
			}
		}
		return true;
	}
	

	/**
	 * Verifica se o código do LIVRO está no arquivo de dados e retorna o livro associado
	 * @param codigo Código do produto a ser visualizado
	 * @return Produto
	 */
	
	public Livro infoLivro(int codigo) {
		
		Livro p = null;
		livros = recupera();
		
		for (Livro livro : livros) {
			if (livro.getCodigo() == codigo) {
				p = livro;
			}
		}
		return p;
	}

}
