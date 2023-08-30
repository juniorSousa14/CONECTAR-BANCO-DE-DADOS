package bancosPOO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class PersistenciaCSV {

	public void CadastrarNomes(String nome, String sobrenome, String url) {
        
		CriarArquivo(url);

        try {
            List<String> existentes = LinhaExistentes(url);
            String linha = nome + ";" + sobrenome + ";";
            existentes.add(linha);

            // adicionar no csv
            String todasLinhas = UnicaLinha(existentes);
            FileWriter arquivo = new FileWriter(url);
            arquivo.write(todasLinhas);
            arquivo.close();

        } catch (IOException e) {
        	System.err.println("Erro ao gravar propriedades " + e.getMessage());
        }
    }

    public String UnicaLinha(List<String> existentes) {

        String unicaLinha = "";
        for (String linha : existentes) {
            unicaLinha += linha + " \n";
        }
        return unicaLinha;
    }

    public void CriarArquivo(String url) {

        try {
            File arquivo = new File(url);
            arquivo.createNewFile();
        } catch (IOException e) {
        	System.err.println("Erro ao gravar propriedades " + e.getMessage());
        }
    }

    public List<String> LinhaExistentes(String url) {

        List<String> result = new ArrayList<String>();

        try {
            Path path = Paths.get(url);
            result = Files.readAllLines(path);
        } catch (IOException e) {
        	System.err.println("Erro ao gravar propriedades " + e.getMessage());
        }

        return result;

}
    }
