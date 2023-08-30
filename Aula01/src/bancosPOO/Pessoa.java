package bancosPOO;

import java.io.Serializable;

public class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nome;
	int idade;
	
	public Pessoa(String nome, int idade){
		this.nome = nome;
		this.idade = idade;
	}

}
