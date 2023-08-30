
package bancosPOO;

import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Properties;


public class PersistenciaPropriedades {

	public static void main(String[] args) {
		Properties propriedaddes = new Properties();
		propriedaddes.setProperty("usuario","joão");
		propriedaddes.setProperty("senha","secreta");
		
		try {
			FileOutputStream arquivo = new FileOutputStream("config.properties");
			propriedaddes.store(arquivo, "Configurações de usuario");
			
			arquivo.close();
			System.out.println("Propriedades gravadas com sucesso! ");
			
		} catch (IOException e) {
			System.err.println("Erro ao gravar propriedades " + e.getMessage());
		}

	}

}
