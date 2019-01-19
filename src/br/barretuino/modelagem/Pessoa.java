package br.barretuino.modelagem;

import java.util.List;

public class Pessoa {
	//Atributos
	public static int sequencia = 1;
	
	@MetaPropriedade(descricao="Código")
	private int codigo;
	
	@MetaPropriedade(descricao="Nome")
	private String nome;
	
	@MetaPropriedade(descricao="Endereço")
	private Endereco endereco;
	
	@MetaPropriedade(descricao="Telefone")
	private List<Telefone> telefone;
	
	@MetaPropriedade(descricao="Email")
	private String email;
	
	@MetaPropriedade(descricao="Limite de Crédito")
	private double limiteCredito;
	
	@MetaPropriedade(descricao="Peso")
	private Float peso;
	
	@MetaPropriedade(descricao="Situação")
	private SituacaoCadastral situacaoCadastral;

	//Métodos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public SituacaoCadastral getSituacaoCadastral() {
		return situacaoCadastral;
	}
	public void setSituacaoCadastral(SituacaoCadastral situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}
	
	@Override
	public String toString() {	
		return getCodigo() + ";" 
				+ getNome() + ";" 
				+ getEmail() + ";"
				+ getEndereco() + ";" 
				+ getSituacaoCadastral().name() + ";"
				+ getPeso();
	}
}