package acceso;
/*
PATRON SINGLETON: sólo existe un objeto de la clase y sea accesible desde cualquier parte de la APP
 */
import entidades.Cliente;

import java.util.ArrayList;
import java.util.List;

public class RespositorioClientes {
    private static RespositorioClientes repo = new RespositorioClientes();

    public static RespositorioClientes getInstance() {
        return repo;
    }

    private static List<Cliente> almacen = new ArrayList<>();

    private RespositorioClientes() {}

    public void insertar(Cliente cliente) {
        if (buscar(cliente.getCodigo()) != null) {
            throw new RuntimeException("Duplicidad de clave");
        }
        almacen.add(cliente);
    }
    public void eliminar(Cliente cliente) {
        eliminar(cliente.getCodigo());
    }
    public void eliminar(int codigo) {
        for(Cliente cliente : almacen) {
            if (cliente.getCodigo()==codigo) {
                almacen.remove(cliente);
                return;
            }
        }
    }
    public void actualizar(Cliente cliente) {
       Cliente c = buscar(cliente.getCodigo());
       if (c==null)
           return;
       c.setNombre(cliente.getNombre());
    }

    /**
     * Si el código no se encuentra retorna null.
     * @param codigo
     * @return
     */
    public Cliente buscar(int codigo) {
        for(Cliente cliente : almacen) {
            if (cliente.getCodigo()==codigo) {
                return cliente;
            }
        }
        return null;
    }
    public List<Cliente> buscarTodos()  {
       return new ArrayList<>(almacen);
    }
}
