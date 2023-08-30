package AtividadeAula04;

import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30, "Rua A, 123", "123-456-7890", "joao@example.com");

        // Imprimir no console
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Endereço: " + pessoa.getEndereco());
        System.out.println("Telefone: " + pessoa.getTelefone());
        System.out.println("Email: " + pessoa.getEmail());

        // Salvar em um arquivo JSON
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nome", pessoa.getNome());
        jsonObject.put("idade", pessoa.getIdade());
        jsonObject.put("endereco", pessoa.getEndereco());
        jsonObject.put("telefone", pessoa.getTelefone());
        jsonObject.put("email", pessoa.getEmail());

        try (FileWriter file = new FileWriter("salvarPessoa.json")) {
            file.write(jsonObject.toJSONString());
            System.out.println("Dados salvos em salvarPessoa.json");
        } catch (IOException e) {
            e.getMessage();
        }
    }
}