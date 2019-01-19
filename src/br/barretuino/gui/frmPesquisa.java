package br.barretuino.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.barretuino.modelagem.MetaPropriedade;
import br.barretuino.modelagem.Pessoa;
import br.barretuino.utils.Utils;

public class frmPesquisa<T> extends JInternalFrame implements ActionListener {

	private String [] colunas;
	private JTable tabela;
	private JButton btAtualizar;
	private JPanel pnFundo, pnBotoes;
	private JScrollPane scroll;

	public frmPesquisa(Object entidade, List<Pessoa> lista) {
		//2º Passo Instanciar os objetos visuais
		super("Pesquisa de " + entidade.getClass().getSimpleName(),
				false, //resizable
				true,  //closable
				false, //maximizable
				true); //iconifiable
		setSize(600,480);
		setLayout(new BorderLayout());
		
		colunas = new String [Utils.retornarFields(entidade).length];
		int i=0;
		for(Field s : Utils.retornarFields(entidade)) {
			MetaPropriedade titulo = s.getAnnotation(MetaPropriedade.class);
			if(titulo != null) {
				colunas[i++] = s.getAnnotation(MetaPropriedade.class).descricao();
			}else {
				colunas[i++] = s.getName().substring(0, 1).toUpperCase() + "" + s.getName().substring(1, s.getName().length());
			}			
		}		
		Object [][] dados = Utils.retornarValores(lista);
		tabela = new JTable(dados, colunas);

		pnFundo = new JPanel(new GridLayout(1, 1));
		pnBotoes = new JPanel(new GridLayout(1, 1));
        
		btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(this);
		
		tabela = new JTable(dados, colunas);
        scroll = new JScrollPane(tabela);
        pnFundo.add(scroll);
        
        pnBotoes.add(btAtualizar);
         
        add(pnFundo, BorderLayout.CENTER);
        add(pnBotoes, BorderLayout.SOUTH);
                
        setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}