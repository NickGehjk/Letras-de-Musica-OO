package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controller.*;
//import java.util.*;

public class TelaDetalhePessoa implements ActionListener, ListSelectionListener {

	String artistas[] = { "manoel gome", "top", "mc little popcorn"};
	//TelaPessoa.mostrarDados(d, 1);
	//objeto.get

	private JFrame janela;

	//private JLabel valorNome1 = new JLabel("");

	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelIda = new JLabel("Idade: ");
	private JTextField valorIda;
	private JLabel labelNac = new JLabel("Nacionalidade: ");
	private JTextField valorNac;
	private JLabel labelGen = new JLabel("Gênero musical: ");
	private JTextField valorGen;

	private JLabel labelNomM = new JLabel("Nome: ");
	private JTextField valorNomM;
	private JLabel labelAno = new JLabel("Ano: ");
	private JTextField valorAno;
	private JLabel labelDuracao = new JLabel("Duração: ");
	private JTextField valorDuracao;
	private JLabel labelArt = new JLabel("Artista: ");
	//private JComboBox<String> valorArt = new JComboBox<>(listaArtistasCadastrados);
	private JComboBox<String> valorArt = new JComboBox<>(artistas);

	private JLabel labelNomePlaylist = new JLabel("Nome: ");
	private JTextField valorNomePlaylist;
	private JLabel labelAnoPlaylist = new JLabel("Ano: ");
	private JTextField valorAnoPlaylist;

	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoEditar = new JButton("Editar");;
	
	private JList<String> listaMusicasCadastradosA;
	private JList<String> listaMusicasCadastradosP;
	private String[] listaNomes = new String[50];

	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	TelaPessoa p;

	public void inserirEditar(int op, ControleDados d, 
			TelaPessoa p, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Adicionar Artista";
		if (op == 2) s = "Adicionar Música";
		if (op == 3) s = "Adicionar Playlist";
		if (op == 4) s = "Detalhe de Artista";
		if (op == 5) s = "Detalhe de Música";
		if (op == 6) s = "Detalhe da Playlist";

		janela = new JFrame(s);

		//Preenche dados com dados do Artista clicado
		if (op == 4) {
			valorNome = new JTextField(dados.getArtistas()[pos].getNome(), 200);
			valorIda = new JTextField(String.valueOf(dados.getArtistas()[pos].getIdade()), 200);
            valorNac = new JTextField(dados.getArtistas()[pos].getNacionalidade(), 200);
			valorGen = new JTextField(dados.getArtistas()[pos].getGenero(), 200);

			valorNome.setEditable(false);
			valorIda.setEditable(false);
			valorNac.setEditable(false);
			valorGen.setEditable(false);

			janela.setSize(525, 600);
			//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setLocationRelativeTo(null);
			janela.getContentPane().setBackground(new Color(33,33,33,255));

			labelNome.setForeground(new Color(160, 75, 209, 255));
			labelIda.setForeground(new Color(160, 75, 209, 255));
			labelNac.setForeground(new Color(160, 75, 209, 255));
			labelGen.setForeground(new Color(160, 75, 209, 255));

			listaNomes = new ControleMusica(dados).getNomM();
			listaMusicasCadastradosA = new JList<String>(listaNomes);

			listaMusicasCadastradosA.setBackground(new Color(255, 255, 255, 255));
		}
        else if (op == 5) { //Preenche dados com dados do professor clicado
			valorNomM = new JTextField(dados.getMusicas()[pos].getNomM(), 200);
			valorAno = new JTextField(String.valueOf(dados.getMusicas()[pos].getAno()), 200);
            valorDuracao = new JTextField(dados.getMusicas()[pos].getDuracao(), 200);

			valorNomM.setEditable(false);
			valorAno.setEditable(false);
			valorDuracao.setEditable(false);

			janela.setSize(525, 600);
			//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setLocationRelativeTo(null);
			janela.getContentPane().setBackground(new Color(33,33,33,255));

			labelNomM.setForeground(new Color(160, 75, 209, 255));
			labelAno.setForeground(new Color(160, 75, 209, 255));
			labelDuracao.setForeground(new Color(160, 75, 209, 255));
			labelArt.setForeground(new Color(160, 75, 209, 255));
		}
		else if (op == 6) { //Preenche dados com dados do professor clicado
			valorNomePlaylist = new JTextField(dados.getPlaylists()[pos].getNomePlaylist(), 200);
			valorAnoPlaylist = new JTextField(String.valueOf(dados.getPlaylists()[pos].getAnoPlaylist()), 200);

			valorNomePlaylist.setEditable(false);
			valorAnoPlaylist.setEditable(false);

			janela.setSize(525, 600);
			//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setLocationRelativeTo(null);
			janela.getContentPane().setBackground(new Color(33,33,33,255));

			labelNomePlaylist.setForeground(new Color(160, 75, 209, 255));
			labelAnoPlaylist.setForeground(new Color(160, 75, 209, 255));

			listaNomes = new ControleMusica(dados).getNomM();
			listaMusicasCadastradosP = new JList<String>(listaNomes);

			listaMusicasCadastradosP.setBackground(new Color(255, 255, 255, 255));
		}
        else { //Não preenche com dados

			valorNome = new JTextField(200);
			valorIda = new JTextField(200);
			valorNac = new JTextField(200);
			valorGen = new JTextField(200);
			valorNomM = new JTextField(200);
			valorAno = new JTextField(200);
			valorDuracao = new JTextField(200);
			valorNomePlaylist = new JTextField(200);
			valorAnoPlaylist = new JTextField(200);

			labelNome.setForeground(new Color(160, 75, 209, 255));
			labelIda.setForeground(new Color(160, 75, 209, 255));
			labelNac.setForeground(new Color(160, 75, 209, 255));
			labelGen.setForeground(new Color(160, 75, 209, 255));
			labelNomM.setForeground(new Color(160, 75, 209, 255));
			labelAno.setForeground(new Color(160, 75, 209, 255));
			labelDuracao.setForeground(new Color(160, 75, 209, 255));
			labelNomePlaylist.setForeground(new Color(160, 75, 209, 255));
			labelAnoPlaylist.setForeground(new Color(160, 75, 209, 255));
			labelArt.setForeground(new Color(160, 75, 209, 255));

			janela.setSize(525, 600);
			//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.setLocationRelativeTo(null);
			janela.getContentPane().setBackground(new java.awt.Color(33,33,33,255));

			botaoSalvar.setBounds(170, 175, 115, 30);

			listaNomes = new ControleMusica(dados).getNomM();
			listaMusicasCadastradosA = new JList<String>(listaNomes);
			listaMusicasCadastradosP = new JList<String>(listaNomes);
		}

		//Coloca os campos relacionados a etc se Artista
		if (op == 1) {
			labelNome.setBounds(30, 20, 150, 25);
			valorNome.setBounds(180, 20, 180, 25);
			labelIda.setBounds(30, 50, 180, 25);
			valorIda.setBounds(180, 50, 180, 25);
        	labelNac.setBounds(30, 80, 150, 25);
			valorNac.setBounds(180, 80, 180, 25);
			labelGen.setBounds(30, 110, 150, 25);
			valorGen.setBounds(180, 110, 180, 25);

			this.janela.add(labelNome);
			this.janela.add(valorNome);
        	this.janela.add(labelIda);
			this.janela.add(valorIda);
        	this.janela.add(labelNac);
			this.janela.add(valorNac);
			this.janela.add(labelGen);
			this.janela.add(valorGen);
		}

		if (op == 4) {
			labelNome.setBounds(30, 20, 150, 25);
			valorNome.setBounds(180, 20, 180, 25);
			labelIda.setBounds(30, 50, 180, 25);
			valorIda.setBounds(180, 50, 180, 25);
        	labelNac.setBounds(30, 80, 150, 25);
			valorNac.setBounds(180, 80, 180, 25);
			labelGen.setBounds(30, 110, 150, 25);
			valorGen.setBounds(180, 110, 180, 25);

			this.janela.add(labelNome);
			this.janela.add(valorNome);
        	this.janela.add(labelIda);
			this.janela.add(valorIda);
        	this.janela.add(labelNac);
			this.janela.add(valorNac);
			this.janela.add(labelGen);
			this.janela.add(valorGen);

			listaMusicasCadastradosA.setBounds(20, 150, 470, 300);
			listaMusicasCadastradosA.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaMusicasCadastradosA.setVisibleRowCount(10);

			this.janela.add(listaMusicasCadastradosA);
		}

		//Coloca campos relacionados a etc se musica
		if (op == 2) {

			labelNomM.setBounds(30, 20, 150, 25);
			valorNomM.setBounds(180, 20, 180, 25);
			labelAno.setBounds(30, 50, 180, 25);
			valorAno.setBounds(180, 50, 180, 25);
        	labelDuracao.setBounds(30, 80, 150, 25);
			valorDuracao.setBounds(180, 80, 180, 25);
			labelArt.setBounds(30, 110, 150, 25);
			valorArt.setBounds(180, 110, 180, 25);

			this.janela.add(labelNomM);
			this.janela.add(valorNomM);
        	this.janela.add(labelAno);
			this.janela.add(valorAno);
        	this.janela.add(labelDuracao);
			this.janela.add(valorDuracao);
			this.janela.add(labelArt);
			this.janela.add(valorArt);
		}

		if (op == 5) {

			labelNomM.setBounds(30, 20, 150, 25);
			valorNomM.setBounds(180, 20, 180, 25);
			labelAno.setBounds(30, 50, 180, 25);
			valorAno.setBounds(180, 50, 180, 25);
        	labelDuracao.setBounds(30, 80, 150, 25);
			valorDuracao.setBounds(180, 80, 180, 25);
			labelArt.setBounds(30, 110, 150, 25);
			valorArt.setBounds(180, 110, 180, 25);

			this.janela.add(labelNomM);
			this.janela.add(valorNomM);
        	this.janela.add(labelAno);
			this.janela.add(valorAno);
        	this.janela.add(labelDuracao);
			this.janela.add(valorDuracao);
			this.janela.add(labelArt);
			this.janela.add(valorArt);
		}

		//Coloca campos relacionados a etc se playlist
		if (op == 3) {
			labelNomePlaylist.setBounds(30, 20, 150, 25);
			valorNomePlaylist.setBounds(180, 20, 180, 25);
			labelAnoPlaylist.setBounds(30, 50, 180, 25);
			valorAnoPlaylist.setBounds(180, 50, 180, 25);

			this.janela.add(labelNomePlaylist);
			this.janela.add(valorNomePlaylist);
        	this.janela.add(labelAnoPlaylist);
			this.janela.add(valorAnoPlaylist);
		}

		if (op == 6) {
			labelNomePlaylist.setBounds(30, 20, 150, 25);
			valorNomePlaylist.setBounds(180, 20, 180, 25);
			labelAnoPlaylist.setBounds(30, 50, 180, 25);
			valorAnoPlaylist.setBounds(180, 50, 180, 25);

			this.janela.add(labelNomePlaylist);
			this.janela.add(valorNomePlaylist);
        	this.janela.add(labelAnoPlaylist);
			this.janela.add(valorAnoPlaylist);

			listaMusicasCadastradosP.setBounds(20, 120, 470, 300);
			listaMusicasCadastradosP.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaMusicasCadastradosP.setVisibleRowCount(10);

			this.janela.add(listaMusicasCadastradosP);
		}

		//Coloca botoes de excluir, editar e salvar
		if (op == 4 || op == 5 || op == 6) {
			botaoSalvar.setBounds(150, 460, 115, 30);
			botaoExcluir.setBounds(280, 460, 115, 30);
			botaoExcluir.setBackground(new Color(160, 75, 209, 255));
			this.janela.add(botaoExcluir);

			botaoEditar.setBounds(20, 460, 115, 30);
			botaoEditar.setBackground(new Color(160,75,209,255));
			botaoEditar.addActionListener(this);
			this.janela.add(botaoEditar);
		}

		botaoSalvar.setBackground(new Color(160, 75, 209, 255));

		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(525, 600);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) //Adicionar novo Artista
					novoDado[0] = Integer.toString(dados.getQtdArtistas());
				else if (opcao == 2) // Adicionar nova musica
					novoDado[0] = Integer.toString(dados.getQtdMusicas());
				else if (opcao == 3) // Adicionar nova playlist
					novoDado[0] = Integer.toString(dados.getQtdPlaylists());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);

				if (opcao == 1 || opcao == 4) {
					novoDado[1] =  valorNome.getText();
                	novoDado[2] =  valorIda.getText();
                	novoDado[3] =  valorNac.getText();
					novoDado[4] =  valorGen.getText();
					res = dados.inserirEditarArtista(novoDado);
				} else if (opcao == 2 || opcao == 5) {
					novoDado[1] =  valorNomM.getText();
                	novoDado[2] =  valorAno.getText();
                	novoDado[3] =  valorDuracao.getText();
					res = dados.inserirEditarMusica(novoDado);
				} else{
					novoDado[1] =  valorNomePlaylist.getText();
                	novoDado[2] =  valorAnoPlaylist.getText();
					res = dados.inserirEditarPlaylist(novoDado);
				}

				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			}catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
			//finally{	}
		}

		if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 4) {//exclui Artista
				res = dados.removerArtista(posicao);
				if (res) mensagemSucessoExclusao(); 
				//else mensagemErroExclusaoArtista(); 
			}
				
			if (opcao == 5){ //exclui musica
				res = dados.removerMusica(posicao);
				if (res) mensagemSucessoExclusao(); 
				//else mensagemErroExclusaoMusica();
			}

			if (opcao == 6){ //exclui playlist
				res = dados.removerPlaylist(posicao);
				if (res) mensagemSucessoExclusao(); 
				//else mensagemErroExclusaoPlaylist();
			}
		}

		if(src == botaoEditar) {
			if (opcao == 4) {//exclui Artista
				valorNome.setEditable(true);
				valorIda.setEditable(true);
				valorNac.setEditable(true);
				valorGen.setEditable(true);
			}
				
			if (opcao == 5){ //exclui musica
				valorNomM.setEditable(true);
				valorAno.setEditable(true);
				valorDuracao.setEditable(true);
			}

			if (opcao == 6){ //exclui playlist
				valorNomePlaylist.setEditable(true);
				valorAnoPlaylist.setEditable(true);
			}
		}
		/*else if (ae.getActionCommand().equals("salvar letra")){
			letra.setEditable(false);
		}*/
	}

	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		//TelaPessoa p;

		if(e.getValueIsAdjusting() && src == listaMusicasCadastradosP) {
			//TelaPessoa p;
			//janela.dispose();
			new TelaDetalhePessoa().inserirEditar(5, dados, p,
					listaMusicasCadastradosP.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaMusicasCadastradosA) {
			//TelaPessoa p;
			//janela.dispose();
			new TelaDetalhePessoa().inserirEditar(5, dados, p,
					listaMusicasCadastradosA.getSelectedIndex());
		}
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}