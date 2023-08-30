package aula02;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Document doc = Jsoup.connect("https://pt.wikipedia.org/wiki/Fórmula_1").get();

		//System.out.println(doc);

		System.out.println(doc.getElementsByTag("p"));

		// Pegar tudo 

		//System.out.println(doc);

		// Pegar os Paragrafos

		//System.out.println(doc.getElementsByTag("p"));

		// Pegar um unico  paragrafo 

		System.out.println(doc.getElementsContainingOwnText(" o verde para as equipes inglesas,  "));
}

}
