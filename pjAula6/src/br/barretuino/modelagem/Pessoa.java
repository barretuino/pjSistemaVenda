package br.barretuino.modelagem;

import java.util.List;

public class Pessoa {
	//Atributos
	public static int sequencia = 1;
	
	private int codigo;
	private Endereco endereco;
	private List<Telefone> telefone;
	private String email;
	private double limiteCredito;
	private SituacaoCadastral situacaoCadastral;

	//Métodos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public SituacaoCadastral getSituacaoCadastral() {
		return situacaoCadastral;
	}
	public void setSituacaoCadastral(SituacaoCadastral situacaoCadastral) {
		this.situacaoCadastral = situacaoCadastral;
	}
}