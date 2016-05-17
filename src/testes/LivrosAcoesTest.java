package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import acoes.LivrosAcoes;
import modelos.Livro;

public class LivrosAcoesTest {

	@Test
	//Verifica se é possível inserir um novo registro na base de dados
	//Retorna FALSE se já existe um livro com o ID inserido
	public void testVerifica() {
		LivrosAcoes livrosAcoes = new LivrosAcoes();		
		assertEquals(false, livrosAcoes.verifica(1));
	}
	
	@Test
	//Verifica se o array esperado é igual ao array resgatado do arquivo
	public void testRecupera() {
		LivrosAcoes livrosAcoes = new LivrosAcoes();
		
		ArrayList<Livro> livros = new ArrayList<>();
		Livro livro1 = new Livro(1, "Inteligência Artificial", 2);
		Livro livro2 = new Livro(2, "Javascript - O Guia Definitivo", 2);
		Livro livro3 = new Livro(3, "Java - Use a cabeça", 2);
		livros.add(livro1);
		livros.add(livro2);
		livros.add(livro3);
		
		ArrayList<String> livrosArray = new ArrayList<>();
		
		for (Livro livro : livros) {
			livrosArray.add(livro.getTitulo());
		}
		
		ArrayList<String> livrosDoArquivoArray = new ArrayList<>();
		
		ArrayList<Livro> livrosDoArquivo = livrosAcoes.recupera();
		for (Livro livro : livrosDoArquivo) {
			livrosDoArquivoArray.add(livro.getTitulo());
		}
		
		assertEquals(livrosArray, livrosDoArquivoArray);
	}
	
	@Test
	//Verifica se o array esperado é igual ao array resgatado do arquivo
	public void testSalvar() {
		LivrosAcoes livrosAcoes = new LivrosAcoes();
		
		ArrayList<Livro> livros = new ArrayList<>();
		Livro livro1 = new Livro(1, "Inteligência Artificial", 2);
		Livro livro2 = new Livro(2, "Javascript - O Guia Definitivo", 2);
		Livro livro3 = new Livro(3, "Java - Use a cabeça", 2);
		livros.add(livro1);
		livros.add(livro2);
		livros.add(livro3);
		
		livrosAcoes.salvar(livros);
		
		ArrayList<Livro> livrosDoArquivo = livrosAcoes.recupera();
		
		assertNotNull(livrosDoArquivo);
	}

}
