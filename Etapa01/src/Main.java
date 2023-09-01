import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import com.opencsv.CSVWriter;

public class Main {

    public static void main(String[] args) {

        Document doc;
        List<String[]> data = new ArrayList<>();
       
        try (CSVWriter writer = new CSVWriter(new FileWriter("livros.csv"))) {
            writer.writeAll(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            doc = Jsoup.connect("https://www.livrosefuxicos.com/resenhas").get();
            Element table = doc;
            		
            Elements rows = table.select("tr");

            Elements ths = rows.select("th");

            String thstr = "";
            for (Element th : ths) {
                thstr += th.text() + " ";
            }
            System.out.println(thstr);

            for (Element row : rows) {
                Elements tds = row.select("td");
                for (Element td : tds) {
                    System.out.println(td.text());  // é o print
                                                    
                }
                System.out.println(tds.text()); // imprime tudo
                                                
            }
            System.out.println(table);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}