package br.barretuino.persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.barretuino.modelagem.Endereco;
import br.barretuino.modelagem.Estado;
import br.barretuino.modelagem.Pessoa;
import br.barretuino.modelagem.SituacaoCadastral;
import br.barretuino.utils.Utils;

public class PessoaService {
	public static List<Pessoa> popular(String url) {
		List<Pessoa> listPessoa = new ArrayList<Pessoa>();
		try {
			List<String> dados = Repositorio.ler(url);
			List<String[]> lista = Utils.popular(dados, ";");
			
			for(String[] conteudo : lista) {
				Pessoa entidade = new Pessoa();
				entidade.setCodigo(Integer.parseInt(conteudo[0]));
				entidade.setNome(conteudo[1]);
				entidade.setEmail(conteudo[2]);
				
				Endereco endereco = new Endereco();
				endereco.setLogradouro(conteudo[3]);
				endereco.setNumero(Integer.parseInt(conteudo[4]));
				endereco.setBairro(conteudo[5]);
				endereco.setCep(conteudo[6]);
				endereco.setCaixaPostal(conteudo[7]);
				endereco.setCidade(conteudo[8]);
				endereco.setEstado(Estado.valueOf(conteudo[9]));
				endereco.setPais(conteudo[10]);
				entidade.setEndereco(endereco);
				
				entidade.setSituacaoCadastral(SituacaoCadastral.valueOf(conteudo[11]));
				entidade.setPeso(Float.parseFloat(conteudo[12]));
				
				listPessoa.add(entidade);
			}			
		} catch (IOException erro) {
			JOptionPane.showMessageDialog(null, "Falha ao carregar dados do arquivo " + url,
					"Falha no Repositório", 
					JOptionPane.ERROR_MESSAGE);
		}
		return listPessoa;
	}
}
