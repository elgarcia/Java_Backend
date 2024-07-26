package entidades;

import lombok.*;

import java.util.Arrays;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cliente {
    private final static double cantidadMaxGasto = 1000;
    @EqualsAndHashCode.Include  private  int codigo;
    private String nombre;
    private String[] telefonos;
    @ToString.Exclude   private final boolean joven;
    public Cliente() {
        this(0, "", null, false);
    }


    public static Cliente of(int codigo, String nombre, boolean joven) {
        return new Cliente(codigo, nombre, null,  joven);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Cliente cliente = new Cliente();
        public Builder addNombre(String nombre) {
            cliente.setNombre(nombre);
            return this;
        }
        public Builder addCodigo(int codigo) {
            cliente.setCodigo(codigo);
            return this;
        }
        public Builder addTelefono(String telefono) {
            if (cliente.telefonos==null) {
                cliente.telefonos = new String[] {telefono};
            } else {
                cliente.telefonos = Arrays.copyOf(cliente.telefonos, cliente.telefonos.length+1);
                cliente.telefonos[cliente.telefonos.length] = telefono;
            }
            return this;
        }
        public Cliente build() {
            return cliente;
        }
    }
}

/*
  - PATRON JAVABEAN: si tiene un constructor sin argumentos y utilliza métodos accesores.
  - Clases de entidad
       - campos privados
       - crear métodos públicos accesores: métodos get/is y set

public class Cliente {
    private final static double cantidadMaxGasto ;
    private  int codigo;
    private String nombre;
    private final boolean joven;

    static {
        cantidadMaxGasto = 1000;
    }

    {
        // Bloque anónimo: se ejecuta cada vez que se crea un objeto.

    }

    public Cliente() {
       this(0, "", false);
    }

    public Cliente(int codigo, String nombre, boolean joven) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.joven = joven;
    }

    public Cliente(int codigo, String nombre) {
        this(codigo, nombre, false);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(final int codigo) {
        if (codigo < 0)
            throw new RuntimeException("no se admiten códigos negativos");
        else
            this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isJoven() {
        return joven;
    }

    public static double getCantidadMaxGasto() {
        return cantidadMaxGasto;
    }

    @Override
    public int hashCode() {
        return this.codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof  Cliente)) {
            return false;
        }
        Cliente c = (Cliente) obj;
        return this.codigo == c.codigo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", joven=" + joven +
                '}';
    }
}
*/