package br.barretuino.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.barretuino.modelagem.Endereco;
import br.barretuino.modelagem.Estado;
import br.barretuino.modelagem.Pessoa;
import br.barretuino.utils.Repository;
import br.barretuino.utils.Utils;

public class Teste {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		
		//Declarando objetos do tipo Pessoa
		Pessoa p1 = new Pessoa();		
		Pessoa p2 = new Pessoa();
		
		//Populando o objeto Pessoa
		Map<String, Object> propriedades = new HashMap<String, Object>();
		
		propriedades.put("codigo", 7894);
		propriedades.put("nome", "Nome Aleatório");
		propriedades.put("endereco", new Endereco());
		propriedades.put("endereco.logradouro", "R Natalino Silveira");
		propriedades.put("endereco.numero", 1236);
		propriedades.put("endereco.bairro", "Nova Esperança");
		propriedades.put("endereco.cidade", "Americana");
		propriedades.put("endereco.estado", Estado.SP);
		
		
		Utils.populate(p1, propriedades);
		
		//Realizando a clonagem de Objetos Pessoa
		p2 = (Pessoa) Utils.clone(p1);
		
		System.out.println("Código (P1): " + p1.getCodigo() + " End: " + p1.getEndereco().toString());
		System.out.println("Código (P2): " + p2.getCodigo() + " End: " + p2.getEndereco().toString());
		
		//Teste com escrita de Arquivo Texto
		List<String> dados = new ArrayList<String>();
		dados.add("Código (P1): " + p1.getCodigo() + " End: " + p1.getEndereco().toString());
		dados.add("Código (P2): " + p2.getCodigo() + " End: " + p2.getEndereco().toString());
		
		try {
			Repository.escreverArquivo("./arquivos/saida.txt", dados);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}