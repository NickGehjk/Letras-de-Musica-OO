package models;

/**
 * Classe Pessoa é uma classe Abstrata que simula uma pessoa
 * 
 * @author Nicolas Bomfim Dias Bandeira
 * @author Pedro Henrique dos Santos Ferreira
 */

public abstract class Pessoa {
	
	protected String nome;
	protected int idade;
	protected String nacionalidade;

	public Pessoa() { 
		super();
	}
	
	public Pessoa(String nome, int idade, String nacionalidade) {
		this.nome = nome;
		this.idade = idade;
		this.nacionalidade = nacionalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", nacionalidade=" + nacionalidade + "]";
	}
	
}
