package main;

public class Cliente {
    public int codigo;
    public String nombre;

    public Cliente(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public static void getClient(Cliente[] cartera, int codigo){
        for (Cliente a : cartera)
        {
            if (a.codigo > codigo)
                System.out.println(a.nombre);
        }
    }
}
