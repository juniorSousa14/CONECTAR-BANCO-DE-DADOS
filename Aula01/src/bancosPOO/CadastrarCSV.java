package bancosPOO;

public class CadastrarCSV {

	public static void main(String[] args) {
		
		 PersistenciaCSV cadastrar = new PersistenciaCSV();
	        String url = "C:\\Users\\junio\\eclipse-workspace\\AulaBancos\\config.csv";

	        cadastrar.CadastrarNomes("Junior", "Sousa", url);
	      

	        System.out.println("Arquivo foi gerado com sucesso!");

	}

}
