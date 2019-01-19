package br.barretuino.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Repository {

	/**
	 * Gera a persist�ncia em arquivo texto
	 * @param path
	 * @throws IOException
	 */
	public static void escreverArquivo(String path, List<String> dados) throws IOException {
		File arquivo = new File(path);
		
		if(!arquivo.exists()) {
			//Criar novo arquivo
			arquivo.createNewFile();
		}
		
		FileWriter escrita = new FileWriter(path.toString());
	    PrintWriter gravarArq = new PrintWriter(escrita);
	 
	    gravarArq.println("+---Inicio da Escrita---+");
	    for (String linha : dados) {
	      gravarArq.println(linha);
	    }
	    gravarArq.println("+----Fim da Escrita-----+");
	 
	    escrita.close();
		
	}
	
	/**
	 * Retorna um List com todo conte�do do diret�rio
	 * @param diretorio
	 * @return
	 */
	public static List<String> retornarListDiretorio(Path diretorio){
		List<String> arquivos = new ArrayList<String>();
		File dir = new File("pasta");
		if( dir.isDirectory() ){
		    String[] arqs = dir.list();
		    for(String nome : arqs){
		    	arquivos.add(nome);
		    }
		}
		return arquivos;
	}
	
	public static void copiarArquivos(Path origem, Path destino) throws IOException {
		//Se � um diret�rio, tentamos criar. se j� existir, n�o tem problema.
		if(Files.isDirectory(origem)){
			Files.createDirectories(destino);

			//Listamos todas as entradas do diret�rio
			DirectoryStream<Path> entradas = Files.newDirectoryStream(origem);

			for (Path entrada : entradas) {
				//Para cada entrada, achamos o arquivo equivalente dentro de cada arvore
				Path novaOrigem = origem.resolve(entrada.getFileName());
				Path novoDestino = destino.resolve(entrada.getFileName());

				//Invoca o metodo de maneira recursiva
				copiarArquivos(novaOrigem, novoDestino);
			}
		} else {
			//Copiamos o arquivo
			Files.copy(origem, destino);
		}
	}
}
