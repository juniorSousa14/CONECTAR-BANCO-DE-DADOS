package extrair;

import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class InserirDados extends JFrame {
	private Connection con;
	private Statement st;

	public InserirDados() throws SQLException{
		String driver = "org.postgresql.Driver";
		String sUsuario = "postgres";
		String sSenha = "410199";
		String sFonte = "jdbc:postgresql://localhost:5432/DadosSiteCSV";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(sFonte, sUsuario, sSenha);
			JOptionPane.showMessageDialog(this,"Banco conectado com sucesso!","Mensagem", JOptionPane.WARNING_MESSAGE);
			
			if (con != null) {
                String csvFilePath = "dados_criptomoedas.csv";

                String insertQuery = "INSERT INTO dadosdosite (nome, preco) VALUES (?,?)";

                try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
                     PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {

                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        preparedStatement.setString(1, data[0]); 
                        preparedStatement.setString(2, data[1]);
                        preparedStatement.executeUpdate();
                    }

                    System.out.println("Dados importados com sucesso!");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
			
		}catch (Exception e) {
			// demais exceções
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conexão com o banco!\n" +"Mensagem: " + e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		
		try{
			//cria statement para consultar banco de dados
			st = con.createStatement();
			
			//Cadastro de valores pre-definidos
			//st.executeUpdate ("INSERT INTO DadosDoSite values(1,'Joao','1994');");
			
			
			
			
		}catch(SQLException eSQL){
			JOptionPane.showMessageDialog(this,"Erro na expressão do INSERT!\n" +"Mensagem: " + eSQL.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		try {
			st.close();
			con.close();
		}catch(Exception exception){
			exception.printStackTrace();
			System.exit(2);
		}
		
		Container P = getContentPane();
		P.setLayout(new FlowLayout());
		JLabel mensagem = new JLabel("Você acabou de testar um exemplo usando INSERT!");
		P.add(mensagem);
	}
	
	public static void main(String args[]) throws SQLException{
		InserirDados ex = new InserirDados();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ex.setVisible(true);
		ex.setTitle("USANDO INSERT");
		ex.setSize(400,200);
	}
	}