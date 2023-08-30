package atividade03;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
import java.io.IOException;

public class ExtrairXMLDados {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		 try {
	         
			 // Nota: Desse jeito nao funciona nao sei o porque. 
			 //File inputFile = new File("passageiros.xml");
			 
			 	File inputFile = new File("C:\\Users\\junio\\eclipse-workspace\\Aula_03\\src\\aula03\\passageiros.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(inputFile);
	            doc.getDocumentElement().normalize();
	            
	            NodeList passengerList = doc.getElementsByTagName("passageiro");
	            
	            int numPassengers = passengerList.getLength();
	            System.out.println("Número de passageiros: " + numPassengers);
	            
	            System.out.println("Origens e destinos: ");
	            for (int i = 0; i < numPassengers; i++) {
	                Node passengerNode = passengerList.item(i);
	                if (passengerNode.getNodeType() == Node.ELEMENT_NODE) {
	                    Element passengerElement = (Element) passengerNode;
	                    String origem = passengerElement.getElementsByTagName("origem").item(0).getTextContent();
	                    String destino = passengerElement.getElementsByTagName("destino").item(0).getTextContent();
	                    System.out.println("Passageiro " + (i + 1) + ": Origem = " + origem + ", Destino = " + destino);
	                }
	            }
	        } catch (IOException e) {
	        	System.err.println("Erro ao gravar objeto" + e.getMessage());
	        }
	    }
	}
	