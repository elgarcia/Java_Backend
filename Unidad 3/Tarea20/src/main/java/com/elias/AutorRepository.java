package com.elias;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AutorRepository implements IAutorRepository, Closeable {
    private MongoClient clienteMongo;
    private MongoCollection<Document> autores;

    public AutorRepository(String uri){
        if (uri == null)
            clienteMongo = new MongoClient("localhost", 27017);
        else{
            clienteMongo = new MongoClient(new MongoClientURI(uri));
        }
        var db = this.clienteMongo.getDatabase("AutoresDB");
        this.autores = db.getCollection("Autores");
    }

    public void close(){
        if (this.clienteMongo != null){
            clienteMongo.close();
        }
    }

    @Override
    public void insert(Autor autor) {
        this.autores.insertOne(new Document("_id", autor.getId())
                .append("nombre", autor.getNombre())
                .append("numeroLibros", autor.getNumeroLibros()));
    }

    @Override
    public void delete(Autor autor) {
        this.autores.deleteOne(new Document("_id", autor.getId()));
    }

    @Override
    public void update(Autor autor) {
        this.autores.updateOne(new Document("_id", autor.getId()),
                new Document("nombre", autor.getNombre()).append("numeroLibros", autor.getNumeroLibros()));
    }

    @Override
    public List<Autor> find(int count) {
        List<Autor> resultado = new ArrayList<>();
        Consumer<Document>  accion = aut -> resultado.add(new Autor(aut.getInteger("_id"),
                aut.getString("nombre"), aut.getInteger("numeroLibros")));
        this.autores.find(new Document("numeroLibros", new Document("$gt", count)))
                .forEach(accion);
        return (resultado);
    }

    public static void main(String[] args){
        try (var repo = new AutorRepository("mongodb+srv://elias16199:160199Eg@cluster0.zlzxo0j.mongodb.net/")){
            System.out.println(repo.find(3));
        }
    }
}

interface IAutorRepository{
    void insert(Autor autor);
    void delete(Autor autor);
    void update(Autor autor);

    List<Autor> find(int count);
}


