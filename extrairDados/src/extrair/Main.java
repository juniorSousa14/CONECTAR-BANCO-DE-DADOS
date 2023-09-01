package extrair;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		String url = "https://coinmarketcap.com/";
		//https://coinmarketcap.com/
		
		try {
			 Class.forName("org.postgresql.Driver");
			 System.out.println("Driver carregado com sucesso!");
			 
		}catch (Exception ex) {
			 System.out.println("Driver nao pode ser carregado!");
			 }
		 
	      
	        try {
	            Document document = Jsoup.connect(url).ignoreContentType(true).get();
	            String jsonData = document.text();

	          
	            System.out.println(jsonData);

	            // Criar um arquivo CSV para escrever os dados
	            String csvFilePath = "dados_criptomoedas.csv";
	            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));
	            writer.write(jsonData);

	            writer.close();
	            System.out.println("Dados extraídos e armazenados em " + csvFilePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
