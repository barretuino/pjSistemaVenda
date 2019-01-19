package br.barretuino.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.barretuino.modelagem.Pessoa;

public class Utils {

	/**
	 * Método para ler uma String e retornar Array com colunas
	 * @param conteudo
	 * @param separador
	 * @return
	 */
	public static String[] popular(String conteudo, String separador) {
		return conteudo.split(separador);
	}
	
	/**
	 * Método para ler uma List de String e retornar uma List de Array com colunas
	 * @param conteudo
	 * @param separador
	 * @return
	 */
	public static List<String[]> popular(List<String> conteudo, String separador) {
		List<String[]> lista = new ArrayList<String[]>();
		
		for(String linha : conteudo) {
			lista.add(linha.split(separador));
		}		
		return lista;
	}
	
	/**
	 * Método de Reflection para retornar Fiels de um Object
	 * @param objeto
	 * @return
	 */
	public static Field[] retornarFields(Object objeto) {
		return objeto.getClass().getDeclaredFields();		
	}
	
	public static Object[][] retornarValores(List<Pessoa> lista){
		int linhas = lista.size();
		int colunas = ((Pessoa) lista.get(0)).getClass().getDeclaredFields().length;
		Object[][] retorno = new Object[linhas][colunas];
		
		int linha=0;		
		for(Object item : lista) {
			Class<?> classe = item.getClass();      
	        Field[] campos = classe.getDeclaredFields();        
	        
	        Object valorAtributo = null;  
	        int coluna = 0;
	        for (Field campo : campos) {            
	            try {               
	                campo.setAccessible(true); //Necessário por conta do encapsulamento das variáveis (private)
	                valorAtributo = campo.get(item);   
	                retorno[linha][coluna++] = valorAtributo;
	            } catch (Exception e) {
	                e.printStackTrace();
	            }           
	        }    
	        linha++;
		}	
		return retorno;	
	}
}