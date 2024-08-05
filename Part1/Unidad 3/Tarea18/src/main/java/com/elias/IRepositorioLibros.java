package com.elias;

import java.util.List;

public interface IRepositorioLibros {
    // Persiste un libro
    public void add(Libro libro);
    // Elimina el libro con el isbn dado, si existe
    public void remove(String isbn);
    // retorna los libros de un autor dado
    public List<Libro> librosDe(String autor);
}
