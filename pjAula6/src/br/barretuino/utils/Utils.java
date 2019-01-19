package br.barretuino.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Utils {
	/**
	 * Método para clone de objetos
	 * @param objOrigem
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 */
	public static Object clone(Object objOrigem) 
				throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException{	
		Object objDestino = new Object();		
		objDestino = BeanUtils.cloneBean(objOrigem);			
		return objDestino; 
	}
	
	/**
	 * Método para popular objetos
	 * @return 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void populate(Object obj, Map<String, Object> properties) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.populate(obj, properties);
	}
	
	/**
	 * Método para realizar cópia das propriedades
	 * @param origem
	 * @param destino
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void copiarPropriedades(Object origem, Object destino) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties(origem, destino);
	}
}