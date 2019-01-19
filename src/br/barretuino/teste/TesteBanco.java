package br.barretuino.teste;

import java.sql.SQLException;
import java.util.List;

import br.barretuino.modelagem.Produto;
import br.barretuino.persistencia.ProdutoRepositorio;

public class TesteBanco {

	public static void main(String[] args) throws InterruptedException {
		Produto produto = new Produto();
		produto.setCodigo(123);
		produto.setDescricao("Biscoito");
		produto.setQuantidade((float) 3.5);
		
		ProdutoRepositorio repositorio;
		try {
			//Inserção
			repositorio = new ProdutoRepositorio();
			repositorio.inserir(produto);
			//repositorio.getConn().close();
			
			//Pesquisar Unico
			produto = repositorio.find(123);
			System.out.println("Código " + produto.getCodigo());
			System.out.println("Descrição " + produto.getDescricao());
			System.out.println("Quantidade " + produto.getQuantidade());
			
			System.out.println("Pesquisar em Lista");
			
			//Pesquisar Lista
			List<Produto> lista = repositorio.findAll();
			for(Produto p : lista) {
				System.out.println("Código " + p.getCodigo());
				System.out.println("Descrição " + p.getDescricao());
				System.out.println("Quantidade " + p.getQuantidade());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
