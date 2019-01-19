package br.barretuino.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.barretuino.modelagem.Pessoa;
import br.barretuino.persistencia.PessoaService;

public class frmMenu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private static final String url = "./arquivos/saida.txt";

	//1º Passo Declarando Objetos Visuais
	private JMenuBar menuBar;
	private JMenu menuCadastro, menuPesquisa;
	private JMenuItem mnItemPessoa, mnItemPesquisa;
	private JDesktopPane desktopPane;

	public frmMenu(){
		setTitle("Sistema de Vendas Barretuino");
		setSize(800, 600);
		
		//2º Passo Instanciar os objetos visuais
		desktopPane = new JDesktopPane();
		setContentPane(desktopPane);

		// Cria uma barra de menu para o JFrame
		menuBar = new JMenuBar();

		// Adiciona a barra de menu ao  frame
		setJMenuBar(menuBar);

		menuCadastro = new JMenu("Cadastro");
		menuCadastro.setMnemonic('C');

		menuPesquisa = new JMenu("Pesquisa");
		menuPesquisa.setMnemonic('P');

		mnItemPessoa = new JMenuItem("Pessoa");
		mnItemPessoa.addActionListener(this);
		
		mnItemPesquisa = new JMenuItem("Pesquisa Genérica");
		mnItemPesquisa.addActionListener(this);

		menuCadastro.add(mnItemPessoa);
		menuPesquisa.add(mnItemPesquisa);

		menuBar.add(menuCadastro);
		menuBar.add(menuPesquisa);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mnItemPessoa) {
			frmPessoa form = new frmPessoa();		
			form.setVisible(true);
			desktopPane.add(form);
		}
		if(e.getSource() == mnItemPesquisa) {			
			frmPesquisa<Pessoa> form = new frmPesquisa(new Pessoa(), PessoaService.popular(url));		
			form.setVisible(true);
			desktopPane.add(form);
		}
	}

	public static void main(String[] args) {
		frmMenu aplicacao = new frmMenu();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}