package com.elias;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Main 
{
    public static void main( String[] args ) {
        var uri = new MongoClientURI("mongodb+srv://elias16199:160199Eg@cluster0.zlzxo0j.mongodb.net/");
        var clienteMongo = new MongoClient(uri);

        var db = clienteMongo.getDatabase("Biblioteca");
        var autores = db.getCollection("Autores");
        System.out.println(autores.estimatedDocumentCount());

        clienteMongo.close();
    }
}
