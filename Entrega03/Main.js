const { MongoClient } = require("mongodb");

async function connectAndInsert() {
  const uri = "mongodb://localhost:27017";
  const client = new MongoClient(uri);

  try {
    await client.connect();

    const database = client.db("livros");
    const collection = database.collection("resenhas");

    const data = {
      title: "Livro A",
      author: "Autor A",
      review: "Uma resenha do Livro A...",
    };
 
    await collection.insertOne(data);

    console.log("Dados inseridos com sucesso.");
  } finally {
    client.close();
  }
}

connectAndInsert().catch(console.error);
