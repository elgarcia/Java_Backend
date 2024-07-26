package com.elias;

import top.jfunc.json.impl.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepositorioLibros implements IRepositorioLibros{
    private Path        ruta;
    private List<Libro> libros;

    public RepositorioLibros(Path ruta){
        this.ruta = ruta;
        readContent();
    }

    private void   readContent(){
        try{
            String  content = Files.readString(this.ruta);
            var     json = new JSONObject();
            List<Map<String, Object>> old = json.deserialize(content, List.class);
            if (this.libros != null){
                this.libros = new ArrayList<>();
            }
            old.forEach(mapa -> this.libros.add(json.deserialize( new JSONObject(mapa).toString(), Libro.class)));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void    saveContent(){
        String content = new JSONObject().serialize(libros);
        try{
            Files.writeString(this.ruta, content);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Libro libro) {
        this.libros.add(libro);
        this.saveContent();
    }

    @Override
    public void remove(String isbn) {
        if (this.libros.removeIf(libro -> libro.getIsbn().equals(isbn))){
            this.saveContent();
        }
    }

    @Override
    public List<Libro> librosDe(String autor) {
        List<Libro> book = new ArrayList<>();
        this.libros.forEach(libro -> {if (libro.getAutor().equals(autor)); book.add(libro);});
        return (book);
    }
}
