package com.br.mongo.Projeto03;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App 
{
	 private MongoClient mongoClient;
	    private MongoDatabase database;
	    private MongoCollection<Document> collection;

	    public App() {
	        // Configure a conexão com o MongoDB
	        mongoClient = MongoClients.create("mongodb://localhost:27017"); // URL de conexão do MongoDB

	        // Conecte-se ao banco de dados desejado (crie um se não existir)
	        database = mongoClient.getDatabase("livros");

	        // Acesse a coleção onde você deseja inserir os dados
	        collection = database.getCollection("resenhas");
	    }

	    public void inserirDadosSemiEstruturados(Document documento) {
	        // Insira o documento na coleção
	        collection.insertOne(documento);
	    }

	    public void fecharConexao() {
	        // Feche a conexão com o MongoDB quando terminar
	        mongoClient.close();
}}
