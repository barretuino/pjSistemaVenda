package br.barretuino.modelagem;

public enum SituacaoCadastral {
	ATIVO("Ativo"),
	ENCERRADO("Encerrado"),
	EXCLUIDO("Excluido"),
	FALECIDO("Falecido"),
	FALENCIA("Falencia"),
	SUSPENSO("Suspenso");
	
	private String descricao;
	
	SituacaoCadastral(String descricao){
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
