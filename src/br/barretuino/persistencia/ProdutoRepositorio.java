package br.barretuino.persistencia;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.barretuino.dao.ConnectionFactory;
import br.barretuino.modelagem.Produto;
import br.barretuino.modelagem.Tabela;

public class ProdutoRepositorio {
	Connection conn;

	public ProdutoRepositorio() throws SQLException {
		conn = ConnectionFactory.getConnection();
	}

	/**
	 * Método de Inserção
	 * @param produto
	 * @throws SQLException
	 */
	public void inserir(Produto produto) throws SQLException {
		PreparedStatement st = conn.prepareStatement(
				"insert into produto (codigo, descricao, quantidade) "
				+ "values (?, ?, ?)"
				);
		st.setInt(1, produto.getCodigo());
		st.setString(2, produto.getDescricao());
		st.setFloat(3, produto.getQuantidade());
		
		st.execute();
	}
	
	/**
	 * Seleção de dados pelo id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Produto find(int id) throws SQLException {
		PreparedStatement st = conn.prepareStatement(
				"select p.* from Produto p where codigo = " + id);
		
		ResultSet rs = st.executeQuery();
		Produto retorno = new Produto();
		while(rs.next()) {
			retorno.setCodigo(id);
			retorno.setDescricao(rs.getString("descricao"));
			retorno.setQuantidade(rs.getFloat(3));
		}
		return retorno;
	}
	
	public List<Object> findAll(Class<?> clazz, String...args){
		String classe = clazz.getSimpleName();
		if(clazz.isAnnotationPresent(Tabela.class)) {
			for(Annotation a: clazz.getAnnotations()) {
				classe += a.toString();
			}
		}
		
		String sql = "select o.* from " + classe;
		return null;
	}
	
	//findAll("codigo=1", "descricao like '%D%'", "quantidade>10");
	public List<Produto> findAll(String...args) throws SQLException{
		List<Produto> retorno = new ArrayList<Produto>();
		String sql = "select p.* from produto p ";
		if(args.length>0) {
			sql += " where ";
		}
		for(String a : args) {
			sql += a + " and ";
		}
		if(args.length>0) {
			sql = sql.substring(0, sql.length()-5);
		}
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			Produto produto = new Produto();
			
			produto.setCodigo(rs.getInt(1));
			produto.setDescricao(rs.getString("descricao"));
			produto.setQuantidade(rs.getFloat(3));
		
			retorno.add(produto);
		}
		return retorno;
	}
}