package AtividadeAula04;

class Pessoa {
	private String nome;
    private int idade;
    private String endereco;
    private String email;
    private String telefone;

    // Construtor
    public Pessoa(String nome, int idade, String endereco, String email, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    
    // Getters e Setters 

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	  @Override
	    public String toString() {
	        return "Nome: " + nome +
	                "\nIdade: " + idade +
	                "\nEndereço: " + endereco +
	                "\nEmail: " + email +
	                "\nTelefone: " + telefone;
	    }
}