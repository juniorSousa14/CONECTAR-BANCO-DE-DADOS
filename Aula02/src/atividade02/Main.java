package atividade02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {

	public static void main(String[] args) throws IOException {
		String url = "https://pt.wikipedia.org/wiki/Fórmula_1"; 
        String outputFile = "PaginaWeb.txt"; 

        try {
            Document doc = Jsoup.connect(url).get();
            String web = doc.title();
            

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(web);
            writer.close();

            System.out.println("Página extraída e salvo no arquivo (txt): " + outputFile);
            System.out.println(doc);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}